// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.armCommands;

import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.networktables.DoubleArrayEntry;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.ArmConstants;
import frc.robot.subsystems.ArmSubsystem;

public class MakeArmStillCommand extends CommandBase {
  /** Creates a new MakeArmStill. */
  ArmSubsystem armSubsystem;
  ArmFeedforward feedforward;

  public MakeArmStillCommand(ArmSubsystem ArmSubsystem) {
    this.armSubsystem = armSubsystem;
    feedforward = new ArmFeedforward(ArmConstants.kS, ArmConstants.kG, ArmConstants.kV, ArmConstants.kA);
  }

  @Override
    public void initialize() {
      System.out.println("MakeArmStillCommand runs");
    }


  // Called every time the scheduler runs while the commansd is scheduled.
  @Override
  public void execute() {
    double speed = feedforward.calculate(armSubsystem.getCurrentAngle()*2*Math.PI, armSubsystem.getCurrentMotorSpeed());
    armSubsystem.setMotor(speed);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
