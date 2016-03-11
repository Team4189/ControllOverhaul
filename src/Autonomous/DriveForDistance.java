package Autonomous;

import org.usfirst.frc.team4189.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveForDistance extends Command {
    final static double CURVE_SEVERITY = 1.3;

    public DriveForDistance() {
	// Use requires() here to declare subsystem dependencies
	// eg. requires(chassis);

    }

    // Called just before this Command runs the first time
    double inchesInit = Robot.chassis.convert();
    double setSpeed;
    
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
	Robot.chassis.setSpeed(autoOut(), autoOut());
    }

    public double autoOut(){
	if(Robot.chassis.convert() < 12){
	    return 0.25;
	}

	return -(Math.pow(CURVE_SEVERITY, (Robot.chassis.convert()-24.42)))/40;//the -1 sets the curve to cross speed = 0 when distance = 0



	/*double output = inchesInit - Robot.bigBlackMotor.convert();
    	if (output < 30){
    		return setSpeed = 1;
    	}

    	else{
    		return setSpeed = 0;
    	}
	 */

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
