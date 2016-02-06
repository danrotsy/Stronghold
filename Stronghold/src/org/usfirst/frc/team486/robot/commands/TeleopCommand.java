package org.usfirst.frc.team486.robot.commands;

import org.usfirst.frc.team486.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TeleopCommand extends Command {
	
    public TeleopCommand() {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.drivechain);
    	//Do I need a second?
    	requires(Robot.pneumatics);
    	requires(Robot.spin);
    	requires(Robot.lift);
    	requires(Robot.extend);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivechain.initdrive();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivechain.drive(Robot.oi.leftstick, Robot.oi.rightstick);
    	Robot.pneumatics.setCompressor();
    	
    	if(Robot.oi.extendButton.get()){
    		Robot.extend.set(true);
    	}else{
    		Robot.extend.set(false);
    	}
    	
    	if(Robot.oi.liftButton.get()){
    		Robot.lift.set(true);
    	}else{
    		Robot.lift.set(false);
    	}
    	
    	if(Robot.oi.shootButton.get()){
    		Robot.spin.shoot(Robot.oi.opstick.getY());
    	}else{
    		Robot.spin.shoot(0);
    	}
    	
    	if(Robot.oi.spinButton.get()){
    		Robot.spin.spin(Robot.oi.opstick.getY());
    	}else{
    		Robot.spin.spin(0);
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
