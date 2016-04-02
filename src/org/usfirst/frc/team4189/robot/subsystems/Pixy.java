package org.usfirst.frc.team4189.robot.subsystems;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Pixy extends Subsystem {
	public SerialPort pixy = new SerialPort(19200, SerialPort.Port.kOnboard);
	
	public void bufferSize(){
		pixy.setReadBufferSize(10);
	}
	
	public void setTimeout(double timeout) {
		timeout = 3;
	}
	
	
	
	
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
	
	
}

