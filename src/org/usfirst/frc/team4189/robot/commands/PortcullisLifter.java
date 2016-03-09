package org.usfirst.frc.team4189.robot.commands;

import org.usfirst.frc.team4189.robot.OI;
import org.usfirst.frc.team4189.robot.Robot;
import org.usfirst.frc.team4189.robot.commands.ShooterCommand.State;
import org.usfirst.frc.team4189.robot.subsystems.Cheval;
import org.usfirst.frc.team4189.robot.subsystems.Lifter;
import org.usfirst.frc.team4189.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PortcullisLifter extends Command {
	private State currentState;
	int state;
    public PortcullisLifter() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }
    
    public enum State{
		DOWN , UP , PARKED;
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	state = 2;
    }

    double changeState(){
    	if(OI.lifterUp.get() == true){
    		state = state + 1;
    		System.out.println(state);
    	}
    	else if(OI.lifterDown.get() == true){
    		state = state - 1;
    		System.out.println(state);
    	}
    	
    	System.out.println(state);
    	return state;
    	
    }
    void stateIs(double changeState){
    	if(changeState == 1){
    		currentState = State.UP;
    		System.out.println(state);
    	}
    	else if(changeState == 2){
    		currentState = State.PARKED;
    		System.out.println(state);
    	}
    	else if(changeState == 3){
    		currentState = State.DOWN;
    		System.out.println(state);
    	}
    	
    }
    
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	switch(currentState){
    	case PARKED:
    	{
    		if (Robot.lifter.encGet() > 0){
    			Cheval.chevalMotor.set(-1);
    			System.out.println(Robot.lifter.encGet());
    		}
    		else if (Robot.lifter.encGet() < 0){
    			Cheval.chevalMotor.set(1);
    			System.out.println(Robot.lifter.encGet());
    		}
    		else if (Robot.lifter.encGet() == 0){
    			Cheval.chevalMotor.set(0);
    			System.out.println(Robot.lifter.encGet());
    		}
    		break;
    	}
    	case DOWN:
    	{
    		if (Robot.shooter.encGet() > -20){
    			Cheval.chevalMotor.set(-1);
    			System.out.println(Robot.lifter.encGet());
    		}
    		else if (Robot.shooter.encGet() < -20){
    			Cheval.chevalMotor.set(1);
    			System.out.println(Robot.lifter.encGet());
    		}
    		else if (Robot.shooter.encGet() == 0){
    			Cheval.chevalMotor.set(0);
    			System.out.println(Robot.lifter.encGet());
    		}
    		break;
    	}
    		
    	case UP:
    	{
    		if (Robot.lifter.encGet() < 45){
    			Cheval.chevalMotor.set(1);
    			System.out.println(Robot.lifter.encGet());
    		}
    		else if(Robot.lifter.encGet() == 0){
    			Cheval.chevalMotor.set(0);
    			System.out.println(Robot.lifter.encGet());
    		}
    		break;
    	}
    		
    	}

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
