package org.usfirst.frc.team486.robot.commands;

import org.usfirst.frc.team486.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShootCommand extends Command {

	double powerShoot;
	double powerBrush;

    public ShootCommand(double powerShoot, double powerBrush) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.shoot);
    	requires(Robot.brush);
    	this.powerShoot = powerShoot;
    	this.powerBrush = powerBrush;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.shoot.spin(powerShoot);
    	Robot.brush.spin(powerBrush);
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
