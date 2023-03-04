// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import java.util.function.Supplier;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.ArmConstants;
import frc.robot.commands.armCommands.ArmJoystickCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmSubsystem extends SubsystemBase {
  private final CANSparkMax m_motor;
  private RelativeEncoder  m_encoder;
  /** Creates a new NewArmSubsystem. */
  public ArmSubsystem() {
    m_motor = new CANSparkMax(ArmConstants.ARM_MOTORS_PORT , MotorType.kBrushless);
    m_encoder = m_motor.getEncoder();
    m_encoder.setPosition(ArmConstants.START_ANGLE);
    m_encoder.setPositionConversionFactor(ArmConstants.GEARS_RATIO);

  }

  


  public double getCurrentAngle()
  {
    return m_encoder.getPosition();
  }

  public double angleToArc( double angle)
  {
    return angle * ArmConstants.ARM_RADIOS;
  }

  public double getCurrentMotorSpeed()
  {
    return m_motor.get();
  }

  public void setMotor(double speed){
    m_motor.set(speed);

  }

  public void initDefaultCommand(Supplier<Double> sup) {
    // Set the default command for a subsystem here.
    setDefaultCommand(new ArmJoystickCommand(this, sup));
}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
