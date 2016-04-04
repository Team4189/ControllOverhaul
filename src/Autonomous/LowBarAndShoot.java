package Autonomous;

import org.usfirst.frc.team4189.robot.OI;
import org.usfirst.frc.team4189.robot.Robot;
import org.usfirst.frc.team4189.robot.commands.IntroBall;
import org.usfirst.frc.team4189.robot.commands.ShooterCommand;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class LowBarAndShoot extends Command {

	Timer timer;
	Timer timer2;

	public LowBarAndShoot() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		OI.gyro.reset();
		timer = new Timer();
		timer2 = new Timer();
		timer.reset();
		timer.start();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (timer.get() < 3) {
			if (Robot.chassis.gyroConvert() > 5) {
				Robot.chassis.setSpeed(-.5, -.2);
			} else {
				Robot.chassis.setSpeed(-.30, -.30);
			}
			
			if (Robot.chassis.gyroConvert() < -5) {
				Robot.chassis.setSpeed(-.2, -.5);
			} else {
				Robot.chassis.setSpeed(-.30, -.30);
			}
		} else if (timer.get() > 3 && timer.get() < 6 && Robot.chassis.gyroConvert() > -45) {
			Robot.chassis.setSpeed(-.3, .3);
		} else if (Robot.chassis.gyroConvert() < -45 && Robot.shooter.encGet() < 1028) {
			Robot.shooter.changeAngle(.5);
		} else if (Robot.shooter.encGet() > 1028) {
			Robot.shooter.changeAngle(0);
			Robot.shooter.fireShooter(1);
			if (timer.get() < 7.55) {
				Robot.shooter.introBall(.5);
				// System.out.println(timer.get());
			} else if (timer.get() > 7.65 && timer.get() < 8.0) {
				Robot.shooter.introBall(-.5);
				// System.out.println(timer.get());
			} else if (timer.get() > 8.0) {
				Robot.shooter.introBall(0);
				// System.out.println(timer.get());
				timer.stop();
				this.cancel();
			}
		}
		SmartDashboard.putNumber("Shooter Enc Val", Robot.shooter.encGet());
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
