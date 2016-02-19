package org.usfirst.frc.team486.robot.subsystems;

import org.usfirst.frc.team486.robot.RobotMap;
import org.usfirst.frc.team486.robot.commands.TeleopCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class TankSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	Talon left = new Talon(RobotMap.leftController);
	Talon right = new Talon(RobotMap.rightController);
	RobotDrive drive = new RobotDrive(left,right);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new TeleopCommand());
    }
    public void drive(Joystick leftStick, Joystick rightStick) {
    	drive.tankDrive(leftStick, rightStick);
    }
    public void driveDouble(double left, double right) {
    	drive.setLeftRightMotorOutputs(left, right);
    }
    public void initdrive() {
    	//may need to change inversions
    	drive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
    	drive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
    }
}

