package xbot.edubot.subsystems.drive;

import xbot.common.controls.*;
import xbot.common.controls.actuators.XSpeedController;
import xbot.common.controls.sensors.DistanceSensor;
import xbot.common.injection.wpi_factories.WPIFactory;
import xbot.edubot.rotation.MockHeadingSensor;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import edu.wpi.first.wpilibj.MockDistanceSensor;
import edu.wpi.first.wpilibj.SpeedController;

@Singleton
public class DriveSubsystem {

	public MockDistanceSensor distanceSensor;
	public MockHeadingSensor gyro;
	
	XSpeedController frontLeft;
	XSpeedController frontRight;
	XSpeedController rearLeft;
	XSpeedController rearRight;
		
	@Inject
	public DriveSubsystem(WPIFactory factory) {
		// instantiate speed controllers and sensors here, save them as class members
		distanceSensor = new MockDistanceSensor();
		gyro = new MockHeadingSensor();
		
		frontLeft = factory.getSpeedController(1);
		rearLeft = factory.getSpeedController(3);
		frontRight = factory.getSpeedController(2);
		rearRight = factory.getSpeedController(4);
	}
	
	public void tankDrive(double leftPower, double rightPower) {
		frontLeft.set(leftPower);
		rearLeft.set(leftPower);
		frontRight.set(rightPower);
		rearRight.set(rightPower);
	}
	
}
