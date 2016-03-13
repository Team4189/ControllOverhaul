package Autonomous;

import org.usfirst.frc.team4189.robot.OI;
import org.usfirst.frc.team4189.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveOverRampart extends Command {

	Timer timer;
	Timer timer2;

	public DriveOverRampart() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		OI.gyro.reset();
		timer = new Timer();
		timer2 = new Timer();
		timer.start();

	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		
		
		if (timer2.get() < 15) {
			if (Robot.chassis.gyroConvert() > 2.5) {
				timer.start();
				if (timer.get() <= .5) {
					Robot.chassis.setSpeed(-.4, -.1);
				} else if (timer.get() > .5 && timer.get() <= 1.5) {
					Robot.chassis.setSpeed(-.10, -.40);
				} else if (timer.get() <= 2) {
					Robot.chassis.setSpeed(-.4, -.1);
				}
			} else {
				Robot.chassis.setSpeed(-.20, -.20);

			}
			if (Robot.chassis.gyroConvert() < -2.5) {
				SmartDashboard.putNumber("timer value", timer.get());
				if (timer.get() == 0) {
					timer.start();
				}
				if (timer.get() <= .5) {
					Robot.chassis.setSpeed(-.1, -.4);

				} else if (timer.get() > .5 && timer.get() <= 1.5) {
					Robot.chassis.setSpeed(-.4, -.1);
				} else if (timer.get() <= 2) {
					Robot.chassis.setSpeed(-.1, -.4);
				}
			} else {
				Robot.chassis.setSpeed(-.20, -.20);
			}
			
		}else{
			Robot.chassis.setSpeed(0, 0);
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
