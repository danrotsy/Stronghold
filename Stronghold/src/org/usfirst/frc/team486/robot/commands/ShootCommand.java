package org.usfirst.frc.team486.robot.commands;

import org.usfirst.frc.team486.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShootCommand extends Command {

	boolean state;
    public ShootCommand(boolean state) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.shoot);
    	requires(Robot.brush);
    	this.state = state;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if (state) {
    		Robot.shoot.spin();
    		Robot.brush.spin();
    	} else {
    		Robot.shoot.stop();
    		Robot.brush.stop();
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
