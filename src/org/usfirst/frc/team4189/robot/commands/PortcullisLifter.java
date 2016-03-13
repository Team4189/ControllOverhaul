package org.usfirst.frc.team4189.robot.commands;

import org.usfirst.frc.team4189.robot.OI;
import org.usfirst.frc.team4189.robot.Robot;
import org.usfirst.frc.team4189.robot.subsystems.Cheval;
import org.usfirst.frc.team4189.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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

	public enum State {
		SCOOPING_POS, TRAVELING_POS, SHOOTING_POS
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		state = 2;
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {

		SmartDashboard.putNumber("Port Enc Value", Robot.cheval.encGet());
		SmartDashboard.putNumber("State", state);

		if (OI.portUp.get()) {
			state = 3;
		} else if (OI.portDown.get()) {
			state = 1;
		} else if (OI.portParked.get()) {
			state = 2;
		}

		switch (state) {
		case 2:

			if (Robot.cheval.encGet() < 18 && OI.safty.get() == false) {
				Cheval.chevalMotor.set(-.25);
			} else if (Robot.cheval.encGet() > 22 && OI.safty.get() == false) {
				Cheval.chevalMotor.set(.25);
			} else if (Robot.cheval.encGet() > 18 && Robot.cheval.encGet() < 22 && OI.safty.get() == false) {
				Cheval.chevalMotor.set(0);
			}

			break;

		case 1:
			if (Robot.cheval.encGet() < -247 && OI.safty.get() == false) {
				Cheval.chevalMotor.set(-.25);
			} else if (Robot.cheval.encGet() > -243 && OI.safty.get() == false) {
				Cheval.chevalMotor.set(.25);
			} else if (Robot.cheval.encGet() > -247 && Robot.cheval.encGet() < -243 && OI.safty.get() == false) {
				Cheval.chevalMotor.set(0);
			}

			break;

		case 3:
			if (Robot.cheval.encGet() > 2 && OI.safty.get() == false) {
				Cheval.chevalMotor.set(.25);
			} else if (Robot.cheval.encGet() < -2 && OI.safty.get() == false) {
				Cheval.chevalMotor.set(-.25);
			} else if (Robot.cheval.encGet() < 2 && Robot.cheval.encGet() > -2 && OI.safty.get() == false){
				Cheval.chevalMotor.set(0);
			}

			break;

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
