package org.usfirst.frc.team486.robot.triggers;

import org.usfirst.frc.team486.robot.Robot;

import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 *
 */
public class SpitTrigger extends Trigger {
    
    public boolean get() {
    	return (Robot.oi.opstick.getX() > 0.6);
    }
}
