package org.usfirst.frc.team486.robot.commands;

import org.usfirst.frc.team486.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class TeleopCommand extends Command {
	
    public TeleopCommand() {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.drivechain);
    	requires(Robot.pneumatics);
    	requires(Robot.camera);
    	requires(Robot.gate);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivechain.initdrive(); //does this cause a problem after auto?
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivechain.drive(Robot.oi.leftstick, Robot.oi.rightstick);
    	Robot.pneumatics.setCompressor();
    	if (Robot.oi.raiseGateButton.get()) {
    		Robot.gate.setPower(0.5);
    	} else if (Robot.oi.lowerGateButton.get()) {
    		Robot.gate.setPower(-0.5);
    	} else {
    		Robot.gate.setPower(0);	
    	}
    	if (Robot.oi.raiseCameraButton.get()){
    		Robot.camera.raiseCamera();
    	} else if (Robot.oi.lowerCameraButton.get()) {
    		Robot.camera.lowerCamera();
    	} else {
    		Robot.camera.defaultCamera();
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
