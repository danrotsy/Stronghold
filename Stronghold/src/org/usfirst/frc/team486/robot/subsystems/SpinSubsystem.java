package org.usfirst.frc.team486.robot.subsystems;

import org.usfirst.frc.team486.robot.RobotMap;
import org.usfirst.frc.team486.robot.commands.TeleopCommand;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class SpinSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	Talon shooter = new Talon(RobotMap.shootController);
	Talon spin = new Talon(RobotMap.spinController);
	double shootmax = 1.00;
	double spinmax = 1.00;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new TeleopCommand());
    }
    
    public void shoot(double k){
    	shooter.set(k*shootmax);
    }
    
    public void spin(double k){
    	spin.set(k*spinmax);
    }
}

