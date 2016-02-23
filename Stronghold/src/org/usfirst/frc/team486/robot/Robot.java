
package org.usfirst.frc.team486.robot;

import org.usfirst.frc.team486.robot.commands.ExtendCommand;
import org.usfirst.frc.team486.robot.commands.GateCommand;
import org.usfirst.frc.team486.robot.commands.ShootCommand;
import org.usfirst.frc.team486.robot.subsystems.BrushSubsystem;
import org.usfirst.frc.team486.robot.subsystems.CameraSubsystem;
import org.usfirst.frc.team486.robot.subsystems.ExtendSubsystem;
import org.usfirst.frc.team486.robot.subsystems.GateSubsystem;
import org.usfirst.frc.team486.robot.subsystems.LiftSubsystem;
import org.usfirst.frc.team486.robot.subsystems.PneumaticSubsystem;
import org.usfirst.frc.team486.robot.subsystems.ShootSubsystem;
import org.usfirst.frc.team486.robot.subsystems.TankSubsystem;
import org.usfirst.frc.team486.robot.triggers.ExtendTrigger;
import org.usfirst.frc.team486.robot.triggers.NullGateTrigger;
import org.usfirst.frc.team486.robot.triggers.NullTrigger;
import org.usfirst.frc.team486.robot.triggers.RetractTrigger;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
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
	public static final CameraSubsystem camera = new CameraSubsystem();
	public static final GateSubsystem gate = new GateSubsystem();
	public static OI oi;
	
	private final ExtendTrigger extendTrigger = new ExtendTrigger();
	private final RetractTrigger retractTrigger = new RetractTrigger();
	private final NullTrigger nullTrigger = new NullTrigger();
	private final NullGateTrigger nullGateTrigger = new NullGateTrigger();

    //Command autonomousCommand;
    CameraServer486 server;
    int tick;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
        // instantiate the command used for the autonomous period
		//autonomousCommand = new AutoShootCommand();
        retractTrigger.whileActive(new ExtendCommand(-1));
        extendTrigger.whileActive(new ExtendCommand(1));
        nullTrigger.whileActive(new ExtendCommand(0));
        nullGateTrigger.whileActive(new GateCommand(0));
        
        server = CameraServer486.getInstance();
        server.setQuality(50);
        server.startAutomaticCapture("cam0");
        server.captureSingleImage();
        server.saveImage();
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
        //if (autonomousCommand != null) 
    	//autonomousCommand.start();
    	tick = 0;
    	Robot.pneumatics.initDefaultCommand();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        //Scheduler.getInstance().run();
    	Robot.pneumatics.setCompressor();
    	tick++;
    	//if(autoLoopCounter < 150) {
			//Robot.drivechain.driveDouble(1,1);	// drive forwards half speed
		//} else {
			//Robot.drivechain.driveDouble(0,0); 	// stop robot
		//}
    	autoShoot(tick, 200);
    	drive(0,0.5,0.5,50,tick);
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        //if (autonomousCommand != null) 
    	//autonomousCommand.cancel();
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
    
    public void cameraPeriodic() {
    	while (isOperatorControl() && isEnabled()) {
            /** robot code here! **/
            Timer.delay(0.005);		// wait for a motor update time
    	}
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }

    private void autoShoot(int tick, int shotTick){
    	//starts revving shooter 50 ticks before (approximately 1 second)
    	//brings down the actuator at shot tick 
    	//lifts actuator and slows shooter 25 ticks after shot tick (approximately 0.5 seconds)
    	if (((shotTick - tick) < 50) && (tick < (shotTick + 25))) {
    		Robot.shoot.spin(1);
    		Robot.brush.spin(1);
    	} else {
    		Robot.shoot.spin(0);
    		Robot.brush.spin(0);
    	}
    	if ((tick > shotTick) && (tick < shotTick + 25)) {
    		Robot.lift.actuate(true);
    	} else {
    		Robot.lift.actuate(false);
    	}
    }
    
    private void driveForward(int startTick, double distance, int tick) { // in feet
    	double speed = 5; //in feet/second
    	
    }
    
    private void rotate(int startTick, double angle, int tick) { //in degrees
    	double angularspeed = 5; //in degrees per second
    	
    }
    
    private void drive(int startTick, double speedleft, double speedright, int duration, int tick) {
    	if ((tick > startTick) && (tick < (startTick + duration))) {
    		Robot.drivechain.driveDouble(speedleft, speedright);
    	} else {
    		Robot.drivechain.driveDouble(0, 0);
    	}
    }
}
