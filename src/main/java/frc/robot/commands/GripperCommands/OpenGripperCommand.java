// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.GripperCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.GripperConstants;
import frc.robot.subsystems.GripperSubsystem;

public class OpenGripperCommand extends CommandBase {

  private GripperSubsystem gripperSubsystem;
  /** Creates a new OpenGripperCommand. */
  public OpenGripperCommand(GripperSubsystem gripperSubsystem) {
    this.gripperSubsystem = gripperSubsystem;
  }

  // Called when the command is initially scheduled.
  @Override
    public void initialize() {
    System.out.println("OpenGripperCommand runs");
    }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    gripperSubsystem.set_speed(GripperConstants.OPEN_SPEED);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
