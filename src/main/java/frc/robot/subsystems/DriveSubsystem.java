// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.sensors.CANCoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;




//change the name of the class to "DriveSubsystem"
//pay attention that the class extends SubsystemBase
public class DriveSubsystem extends SubsystemBase {
  
  private CANSparkMax leftMotor1;
  private CANSparkMax leftMotor2;
  private CANSparkMax rightMotor1;
  private CANSparkMax rightMotor2;
  private double kDegToMeters = 0.076 * Math.PI ;
  private MotorControllerGroup m_left;
  private MotorControllerGroup m_right;
  private DifferentialDrive m_driver;

  public DriveSubsystem() {
    leftMotor1 = new CANSparkMax(1, MotorType.kBrushless);
    leftMotor2 = new CANSparkMax(2, MotorType.kBrushless);
    rightMotor1 = new CANSparkMax(3, MotorType.kBrushless);
    rightMotor2 = new CANSparkMax(4, MotorType.kBrushless);
    m_left = new MotorControllerGroup(leftMotor1, leftMotor2);
    m_right = new MotorControllerGroup(rightMotor1, rightMotor2);
    m_driver = new DifferentialDrive(m_left, m_right);

    rightMotor1 .setInverted(true);
    rightMotor2.setInverted(true);
    
    
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    //SmartDashboard.putNumber("left Drive encoder value", getLeftEncoderValue());
   // SmartDashboard.putNumber("right drive encoder value", getRightEncoderValue());
  }
  public void arcadeDrive(double xSpped, double zSpeed) {
    m_driver.arcadeDrive(xSpped, zSpeed);
}
}