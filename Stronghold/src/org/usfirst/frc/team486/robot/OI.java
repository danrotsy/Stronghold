package org.usfirst.frc.team486.robot;

import org.usfirst.frc.team486.robot.commands.BrushCommand;
import org.usfirst.frc.team486.robot.commands.ExtendCommand;
import org.usfirst.frc.team486.robot.commands.LiftCommand;
import org.usfirst.frc.team486.robot.commands.ShootCommand;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	public Joystick leftstick = new Joystick(0);
	public Joystick rightstick = new Joystick(1);
	public Joystick opstick = new Joystick(2);
	public JoystickButton extendButton = new JoystickButton(opstick, RobotMap.extendButton);
	public JoystickButton liftButton = new JoystickButton(opstick, RobotMap.liftButton);
	public JoystickButton brushButton = new JoystickButton(opstick, RobotMap.brushButton);
	public JoystickButton shootButton = new JoystickButton(opstick, RobotMap.shootController);
	public DigitalInput compressorSwitch = new DigitalInput(RobotMap.compressorSwitch);
	
	public OI() {
		//spinButton.whenPressed(new SpinCommand());
		brushButton.whileHeld(new BrushCommand());
		shootButton.whileHeld(new ShootCommand());
		liftButton.whenPressed(new LiftCommand());
		extendButton.whenPressed(new ExtendCommand());
		
	}
}

