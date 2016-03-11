package Autonomous;

import org.usfirst.frc.team4189.robot.OI;
import org.usfirst.frc.team4189.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GoStraight extends Command {

    public GoStraight() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.chassis.gyroConvert() < -5){
    		Robot.chassis.setSpeed(.75, 1);
    	}
    	else{
    		Robot.chassis.setSpeed(.75, .75);
    	}
    	if(Robot.chassis.gyroConvert() > 5){
    		Robot.chassis.setSpeed(1, .75);
    	}
    	else{
    		Robot.chassis.setSpeed(.75, .75);
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
