package org.usfirst.frc.team4189.robot;

import edu.wpi.first.wpilibj.AnalogInput;
//import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team4189.robot.commands.ChevalDown;
import org.usfirst.frc.team4189.robot.commands.ChevalUp;
import org.usfirst.frc.team4189.robot.commands.ExampleCommand;

import org.usfirst.frc.team4189.robot.commands.LifterDown;
import org.usfirst.frc.team4189.robot.commands.ResetGyro;
import org.usfirst.frc.team4189.robot.commands.SetLifter;
import org.usfirst.frc.team4189.robot.commands.SquareUp;



/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	//Joysticks
	public static Joystick leftStick = new Joystick(RobotMap.leftStick);
	public static Joystick rightStick = new Joystick(RobotMap.rightStick);
	public static Joystick accStick = new Joystick(RobotMap.accStick);
	// comment

	
	//Analog Inputs
	public static AnalogInput rangeFinder1 = new AnalogInput(0);
	public static AnalogInput rangeFinder2 = new AnalogInput(1);
	//public static AnalogGyro gyro = new AnalogGyro(2);
	//public static AnalogGyro gyro = new AnalogGyro(3);
	
	//Buttons
	public static Button resetGyro = new JoystickButton(OI.rightStick , 2);
	public static Button shooterUp = new JoystickButton(OI.accStick , 7);
	public static Button shooterDown = new JoystickButton(OI.accStick , 9);
	public static Button portDown = new JoystickButton(OI.accStick , 12);
	public static Button portUp = new JoystickButton(OI.accStick , 10);
	public static Button shooterScoop = new JoystickButton(OI.rightStick , 1);
	public static Button lifterUp = new JoystickButton(OI.accStick , 5);
	public static Button lifterDown = new JoystickButton(OI.accStick , 3);
	public static Button winchUp = new JoystickButton(OI.leftStick , 3);
	public static Button winchDown = new JoystickButton(OI.leftStick , 2);
	public static Button shooterShoot = new JoystickButton(OI.accStick , 1);
	public static Button squareUp = new JoystickButton(OI.leftStick , 3);
	public static Button introBall = new JoystickButton(OI.accStick , 2);
	public static Button shooterParked = new JoystickButton(OI.accStick , 8);
	public static Button portParked = new JoystickButton(OI.accStick , 11);
	public static Button safty = new JoystickButton(OI.leftStick , 8);
	public static Button resetEnc = new JoystickButton(OI.rightStick , 11);

	
	//public static Button resetIntroBall = new JoystickButton(OI.leftStick , 6);
	

    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    // button.whenPressed(new ExampleCommand());
    // button.whileHeld(new ExampleCommand());
    // button.whenReleased(new ExampleCommand());
	 
	public OI(){
			resetGyro.whenPressed(new ResetGyro());
			squareUp.whenPressed(new SquareUp());
			lifterUp.whileHeld(new SetLifter());
			lifterDown.whileHeld(new LifterDown());
			//winchUp.whileHeld(new WinchUp());
			//winchDown.whileHeld(new WinchDown());
			
			//chevalDown.whileHeld(new ChevalDown());
			//chevalUp.whileHeld(new ChevalUp());
			
			//CameraServer.getInstance().startAutomaticCapture(Robot.chassis.pixyCam);
	 }
}


