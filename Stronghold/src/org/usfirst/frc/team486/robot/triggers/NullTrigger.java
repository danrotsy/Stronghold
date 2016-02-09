package org.usfirst.frc.team486.robot.triggers;

import org.usfirst.frc.team486.robot.Robot;

import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 *
 */
public class NullTrigger extends Trigger {
    
    public boolean get() {
        return !((Robot.oi.opstick.getY() < -0.6) | (Robot.oi.opstick.getY() > 0.6) | (Robot.oi.shootButton.get()));
    }
}
