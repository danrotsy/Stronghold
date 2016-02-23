package org.usfirst.frc.team486.robot.subsystems;

import org.usfirst.frc.team486.robot.RobotMap;
import org.usfirst.frc.team486.robot.commands.TeleopCommand;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class CameraSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	Servo cameraServo = new Servo(RobotMap.cameraController);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new TeleopCommand());
    }
    
    public void raiseCamera(){
    	cameraServo.setAngle(110);
    	//cameraServo.set(0.5);
    	//SmartDashboard.putNumber("Camera Angle", cameraServo.getAngle());
    }
    
    public void defaultCamera() {
    	cameraServo.setAngle(130);
    	//cameraServo.set(0.6);
    	//SmartDashboard.putNumber("Camera Angle", cameraServo.getAngle());
    }
    
    public void lowerCamera() {
    	cameraServo.setAngle(170);
    	//cameraServo.set(0.3);
    	//SmartDashboard.putNumber("Camera Angle", cameraServo.getAngle());
    }
}

