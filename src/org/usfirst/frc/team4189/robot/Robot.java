
package org.usfirst.frc.team4189.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.AxisCamera;
import org.usfirst.frc.team4189.robot.commands.DriveWithJoysticks;
import org.usfirst.frc.team4189.robot.commands.ExampleCommand;
import org.usfirst.frc.team4189.robot.commands.PortcullisLifter;
import org.usfirst.frc.team4189.robot.commands.ShooterCommand;
import org.usfirst.frc.team4189.robot.subsystems.Chassis;
import org.usfirst.frc.team4189.robot.subsystems.Cheval;
import org.usfirst.frc.team4189.robot.subsystems.ExampleSubsystem;
import org.usfirst.frc.team4189.robot.subsystems.Lifter;
import org.usfirst.frc.team4189.robot.subsystems.Shooter;

import Autonomous.DriveForAccel;
import Autonomous.DriveForDistance;
import Autonomous.DriveForSquare;
import Autonomous.DriveOverRampart;

import Autonomous.GoStraight;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static OI oi;
	public static Chassis chassis = new Chassis();
	public static Lifter lifter = new Lifter();
	public static Shooter shooter = new Shooter();
	public static Cheval cheval = new Cheval();
	DriveWithJoysticks driveWithJoysticks;
	public String currentAutonomous;

	CameraServer server;

	public Robot() {
		server = CameraServer.getInstance();
		server.setQuality(50);
		// the camera name (ex "cam0") can be found through the roborio web
		// interface
		server.startAutomaticCapture("cam0");
	}

	Command autonomousCommand;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		oi = new OI();
		// instantiate the command used for the autonomous period

		driveWithJoysticks = new DriveWithJoysticks();
		currentAutonomous = new String();
		SmartDashboard.putNumber("Which Autonomous", 0);
		// SmartDashboard.putBoolean("Drive over Ramparts", false);
		// SmartDashboard.putBoolean("Go Straight", false);
		// SmartDashboard.putBoolean("Drive for Distance" , false);

		chassis.dashData();
		System.out.println("Version 1.1");
		System.out.println("The Robot has initialized");
	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		chassis.dashData();

		if (SmartDashboard.getNumber("Which Autonomous") == 1) {
			currentAutonomous = "Drive Over Ramparts";

		} else if (SmartDashboard.getNumber("Which Autonomous") == 2) {
			currentAutonomous = "Go Straight";
		} else if (SmartDashboard.getNumber("Which Autonomous") == 3) {
			currentAutonomous = "Drive For Distance";
		} else {
			currentAutonomous = "Nonexestant/Invalid Autonomous";
		}

		SmartDashboard.putString("Current Autonomous", currentAutonomous);
	}

	public void autonomousInit() {

		if (SmartDashboard.getNumber("Which Autonomous") == 1) {
			autonomousCommand = new DriveOverRampart();
		} else if (SmartDashboard.getNumber("Which Autonomous") == 2) {
			autonomousCommand = new GoStraight();
		} else if (SmartDashboard.getNumber("Which Autonomous") == 3) {
			autonomousCommand = new DriveForDistance();
		} else {
			autonomousCommand = null;
		}

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
		chassis.dashData();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		chassis.dashData();
	}

	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		chassis.dashData();
		// Scheduler.getInstance().add(new PortcullisLifter());
		Scheduler.getInstance().add(new ShooterCommand());
		Scheduler.getInstance().add(new PortcullisLifter());
		// Scheduler.getInstance().add(new *command*());

	}

	/**
	 * This function is called when the disabled button is hit. You can use it
	 * to reset subsystems before shutting down.
	 */
	public void disabledInit() {
		chassis.dashData();

	}

	/**
	 * This function is called periodically during operator control
	 */

	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		chassis.dashData();
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
		chassis.dashData();
	}
}
