package org.usfirst.frc.team486.robot.subsystems;

import org.usfirst.frc.team486.robot.Robot;
import org.usfirst.frc.team486.robot.RobotMap;
import org.usfirst.frc.team486.robot.commands.TeleopCommand;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class PneumaticSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	Relay compressorRelay = new Relay(RobotMap.compressorPin);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new TeleopCommand());
    }
    public void setCompressor(Value value) {
    	compressorRelay.set(value);
    }
    public void setCompressor() {
    	if (!Robot.oi.compressorSwitch.get()) {
    		setCompressor(Value.kForward);
    		//System.out.println("Compressor turned on!");
    	} else {
    		setCompressor(Value.kOff);
    		//System.out.println("Compressor turned off!");
    	}
    }
}

