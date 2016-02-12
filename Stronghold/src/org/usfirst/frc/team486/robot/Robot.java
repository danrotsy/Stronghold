
package org.usfirst.frc.team486.robot;

import org.usfirst.frc.team486.robot.commands.AutoCommand;
import org.usfirst.frc.team486.robot.commands.BrushCommand;
import org.usfirst.frc.team486.robot.commands.ExtendCommand;
import org.usfirst.frc.team486.robot.subsystems.BrushSubsystem;
import org.usfirst.frc.team486.robot.subsystems.ExtendSubsystem;
import org.usfirst.frc.team486.robot.subsystems.LiftSubsystem;
import org.usfirst.frc.team486.robot.subsystems.PneumaticSubsystem;
import org.usfirst.frc.team486.robot.subsystems.ShootSubsystem;
import org.usfirst.frc.team486.robot.subsystems.TankSubsystem;
import org.usfirst.frc.team486.robot.triggers.ExtendTrigger;
import org.usfirst.frc.team486.robot.triggers.NullTrigger;
import org.usfirst.frc.team486.robot.triggers.RetractTrigger;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final TankSubsystem drivechain = new TankSubsystem();
	public static final PneumaticSubsystem pneumatics = new PneumaticSubsystem();
	public static final ExtendSubsystem extend = new ExtendSubsystem();
	public static final LiftSubsystem lift = new LiftSubsystem();
	public static final BrushSubsystem brush = new BrushSubsystem();
	public static final ShootSubsystem shoot = new ShootSubsystem();
	public static OI oi;
	
	private final ExtendTrigger extendTrigger = new ExtendTrigger();
	private final RetractTrigger retractTrigger = new RetractTrigger();
	private final NullTrigger nullTrigger = new NullTrigger();

    Command autonomousCommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
        // instantiate the command used for the autonomous period
        autonomousCommand = new AutoCommand();
        
        retractTrigger.whileActive(new ExtendCommand(1));
        extendTrigger.whileActive(new ExtendCommand(-1));
        nullTrigger.whileActive(new ExtendCommand(0));
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
