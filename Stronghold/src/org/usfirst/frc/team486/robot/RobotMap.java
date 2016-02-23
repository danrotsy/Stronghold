package org.usfirst.frc.team486.robot;

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
    public static int brushController = 2;
    public static int shootController = 3;
    public static int cameraController = 4;
    public static int gateController = 5;
    
    //Pneumatics
    public static int compressorPin = 0;
    public static int extendSolenoid = 0;
    public static int liftSolenoid = 1;
    
    //Inputs
    public static int compressorSwitch = 0;
    public static int encoderPin1 = 1;
    public static int encoderPin2 = 2;
    
    //OI
    public static int shootButton = 1;
    public static int liftButton = 2; 
    public static int suckButton = 3;
    public static int cameraButton = 3;
    public static int raiseGate = 3;
    public static int lowerGate = 2;
    
    public static double BRUSH_SPEED = 0.6;
    public static double SUCK_POWER = 0.6;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}
