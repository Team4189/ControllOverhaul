package org.usfirst.frc.team4189.robot.commands;

import org.usfirst.frc.team4189.robot.OI;
import org.usfirst.frc.team4189.robot.Robot;
import org.usfirst.frc.team4189.robot.subsystems.PortcullisSubsystem;
import org.usfirst.frc.team4189.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class PortcullisLifter extends Command {
	//private State currentState;
	int state;

	public PortcullisLifter() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

//	public enum State {
//		SCOOPING_POS, TRAVELING_POS, SHOOTING_POS
//	}

	// Called just before this Command runs the first time
	protected void initialize() {
		state = 2;
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {

		SmartDashboard.putNumber("Port Enc Value", Robot.cheval.encGet());
//		System.out.println(Robot.cheval.encGet());
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

			if (Robot.cheval.encGet() > 2 && OI.safety.get() == false) {
				PortcullisSubsystem.chevalMotor.set(-.25);
			} else if (Robot.cheval.encGet() < -2 && OI.safety.get() == false) {
				PortcullisSubsystem.chevalMotor.set(.25);
			} else if (Robot.cheval.encGet() > -2 && Robot.cheval.encGet() < 2 && OI.safety.get() == false) {
				PortcullisSubsystem.chevalMotor.set(0);
			}

			break;

		case 1:
			if (Robot.cheval.encGet() < 283 && OI.safety.get() == false) {
				PortcullisSubsystem.chevalMotor.set(.25);
			} else if (Robot.cheval.encGet() > 287 && OI.safety.get() == false) {
				PortcullisSubsystem.chevalMotor.set(-.25);
			} else if (Robot.cheval.encGet() > 283 && Robot.cheval.encGet() < 287 && OI.safety.get() == false) {
				PortcullisSubsystem.chevalMotor.set(0);
			}

			break;

		case 3:
			if (Robot.cheval.encGet() > 60 && OI.safety.get() == false) {
				PortcullisSubsystem.chevalMotor.set(-.75);
			} else if (Robot.cheval.encGet() < 56 && OI.safety.get() == false) {
				PortcullisSubsystem.chevalMotor.set(.25);
			} else if (Robot.cheval.encGet() < 60 && Robot.cheval.encGet() > 56 && OI.safety.get() == false){
				PortcullisSubsystem.chevalMotor.set(0);
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
