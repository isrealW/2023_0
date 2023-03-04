// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.GripperConstants;

public class GripperSubsystem extends SubsystemBase {

  private final CANSparkMax m_motor;

  /** Creates a new GripperSubsystem. */
  public GripperSubsystem() {
    m_motor = new CANSparkMax(GripperConstants.GRIPPER_MOTORS_PORT, MotorType.kBrushless);
  }

  public void set_speed(double speed)
  {
    m_motor.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
