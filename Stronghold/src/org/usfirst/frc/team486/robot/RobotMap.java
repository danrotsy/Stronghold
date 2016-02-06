package org.usfirst.frc.team486.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
	
	//Motors
    public static int leftController = 1;
    public static int rightController = 0;
    public static int spinController = 2;
    
    //Pneumatics
    public static int compressorPin = 0;
    public static int extendSolenoid = 0;
    public static int liftSolenoid = 1;
    
    //Inputs
    public static int compressorSwitch = 0;
    
    //OI
    public static int extendButton = 2;
    public static int liftButton = 5;
    public static int spinButton = 1;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}
