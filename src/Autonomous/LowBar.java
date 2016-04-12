package Autonomous;

import org.usfirst.frc.team4189.robot.OI;
import org.usfirst.frc.team4189.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class LowBar extends Command {

	Timer timer;

	public LowBar() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		OI.gyro.reset();
		timer = new Timer();
		timer.start();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (timer.get() < 6) {
			System.out.println("less than three");
			if (Robot.chassis.gyroConvert() > 5) {
				Robot.chassis.setSpeed(-.5, -.2);
			} else {
				Robot.chassis.setSpeed(-.40, -.40);
			}
			if (Robot.chassis.gyroConvert() < -5) {
				Robot.chassis.setSpeed(-.2, -.5);
			} else {
				Robot.chassis.setSpeed(-.40, -.40);
			}
		} else if(timer.get() > 6 && timer.get() < 12){
			System.out.println("greater than three");
			if (Robot.chassis.gyroConvert() > 5) {
				Robot.chassis.setSpeed(.5, .2);
			} else {
				Robot.chassis.setSpeed(.40, .40);
			}
			if (Robot.chassis.gyroConvert() < -5) {
				Robot.chassis.setSpeed(.2, .5);
			} else {
				Robot.chassis.setSpeed(.40, .40);
			}
		}else{ 
			System.out.println("Done");
			this.cancel();
		}
	SmartDashboard.putNumber("Autonomous Timer", timer.get());
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
