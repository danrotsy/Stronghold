package org.usfirst.frc.team486.robot.subsystems;

import org.usfirst.frc.team486.robot.RobotMap;
import org.usfirst.frc.team486.robot.commands.ShootCommand;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ShootSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	Talon shooter = new Talon(RobotMap.shootController);
	Encoder encoder = new Encoder(RobotMap.encoderPin1, RobotMap.encoderPin2);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new ShootCommand());
    }
    
    public void spin(double power){
    	shooter.set(power);
    }
    
    public boolean ready(double rate) {
    	double currentPeriod = encoder.getRate();
    	SmartDashboard.putNumber("Encoder Period", currentPeriod);
    	if (currentPeriod > rate) {
    		SmartDashboard.putBoolean("Over Rate", true);
    		return true;
    	} else {
    		SmartDashboard.putBoolean("Over Rate", false);
    		return false;
    	}
    }
    
    public double getRate() {
    	return encoder.getRate();
    }
    
    public void stop(){
    	shooter.set(0);
    }
}

