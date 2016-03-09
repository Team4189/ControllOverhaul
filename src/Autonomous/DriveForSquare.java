package Autonomous;

import org.usfirst.frc.team4189.robot.OI;
import org.usfirst.frc.team4189.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveForSquare extends Command {

	Timer timer = new Timer();


	public DriveForSquare() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		timer.start();
	}


	// Called repeatedly when this Command is scheduled to run
	protected void execute() {

		if(timer.get() < 5){
			Robot.chassis.setSpeed(.25, .35);

		}
		else{
			Robot.chassis.setSpeed(0, 0);
		}
		if(timer.get() < 10 && timer.get() >= 5){

			if(Robot.chassis.gyroConvert() < 90 && Robot.chassis.gyroConvert() > -90){
				Robot.chassis.setSpeed(-.30 , .30);
			}
			else{
				Robot.chassis.setSpeed(0, 0);
				timer.reset();
			}
		}
		SmartDashboard.putNumber("Timer", timer.get());


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
