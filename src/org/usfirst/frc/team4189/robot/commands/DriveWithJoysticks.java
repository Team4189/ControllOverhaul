package org.usfirst.frc.team4189.robot.commands;

import org.usfirst.frc.team4189.robot.OI;
import org.usfirst.frc.team4189.robot.Robot;
import org.usfirst.frc.team4189.robot.subsystems.Cheval;
import org.usfirst.frc.team4189.robot.subsystems.Lifter;
import org.usfirst.frc.team4189.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveWithJoysticks extends Command {
	
	

    public DriveWithJoysticks() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.chassis.setSpeed(OI.leftStick.getY() , OI.rightStick.getY());
    	
    	if(OI.winchUp.get() == false || OI.winchDown.get() == false){
    		Robot.lifter.setWinch(0);
    	}
    	if(OI.portDown.get() == false || OI.portUp.get() == false){
    		Cheval.chevalMotor.set(0);
    	}
    	if(OI.lifterUp.get() == false || OI.lifterDown.get() == false){
    		Lifter.scissorMotor.set(0);
    	}
    	if(OI.shooterDown.get() == false || OI.shooterUp.get() == false){
    		Shooter.shooterAngleMotor.set(0);
    	}
    	if(OI.shooterShoot.get() == false || OI.shooterShoot.get() == false){
    		Shooter.shooterOperation.set(0);
    	}
    	
    }
    
    
    void setLifter(){
    	

    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	//Robot.chassis.setSpeed(0, 0);
    	return false;
        
    }

    // Called once after isFinished returns true
    protected void end() {
    	//Robot.chassis.setSpeed(0, 0);
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	//Robot.chassis.setSpeed(0, 0);
    }
}
