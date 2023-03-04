// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.armCommands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.ArmConstants;
import frc.robot.subsystems.ArmSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class MoveArmToAngle extends PIDCommand {
  private ArmSubsystem armSystem;
  /** Creates a new MoveArmToAngle. */
  public MoveArmToAngle(ArmSubsystem armSystem, double wanted_angle) {
    super(
        // The controller that the command will use
        new PIDController(ArmConstants.kp, ArmConstants.ki, ArmConstants.kd),
        
        // get subsystem current angel        
        () -> armSystem.getCurrentAngle() * ArmConstants.GEARS_RATIO,
        
        // set wanted angle
        () -> wanted_angle * ArmConstants.GEARS_RATIO,
        
        // use motors
        output -> {
          armSystem.setMotor(output);
        });
  }

  @Override
  public void initialize() {
    System.out.println("MoveArmToAngle runs");
  }

  @Override
  public boolean isFinished() {
    return getController().atSetpoint();
  }
}
