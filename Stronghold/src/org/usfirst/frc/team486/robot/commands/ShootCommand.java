package org.usfirst.frc.team486.robot.commands;

import org.usfirst.frc.team486.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShootCommand extends Command {

	boolean triggered = false;
	double shootpower = 0;
	double target = 85000;
	double adjustment = (target/90000)*0.005;
	boolean ready = false;

    public ShootCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.shoot);
    	requires(Robot.lift);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (Robot.oi.shootButton.get()){
    		Robot.shoot.spin(shootpower);
    		Robot.brush.spin(shootpower);
    		triggered = true;
    	} else {
    		if (triggered){
    			Robot.shoot.spin(0);
    			Robot.brush.spin(0);
    			triggered = false;
    		}
    	}
    	if (Robot.shoot.ready(target)) {
    		if (shootpower > 0) {
    			shootpower -= adjustment;
    		}
    	} else {
    		if (shootpower < 1) {
    			shootpower += adjustment;
    		}
    	}
    	if (Robot.oi.liftButton.get()) {
    		if (triggered) {
    			if (Robot.shoot.ready(target)) { //ready was in here 
    				Robot.lift.actuate(true);
    			}
    		} else {
    			Robot.lift.actuate(true);
    		}
    	} else {
    		Robot.lift.actuate(false);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
