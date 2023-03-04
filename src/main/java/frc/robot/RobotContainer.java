// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.armCommands.ArmTest;
import frc.robot.commands.driveCommands.ArcadeDriveCmd;

import java.util.zip.GZIPOutputStream;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.GripperSubsystem;


public class RobotContainer {
  // subsystems
  ArmSubsystem armSubsystem;
  GripperSubsystem gripperSubsystem;
  DriveSubsystem driveSubsystem;
  
  // ui contorllers
  private final GenericHID driverController = new GenericHID(0);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    this.armSubsystem = new ArmSubsystem();
    this.gripperSubsystem = new GripperSubsystem();
    this.driveSubsystem = new DriveSubsystem();
    configureBindings();
  }


  private void configureBindings() {

    driveSubsystem.setDefaultCommand(new ArcadeDriveCmd(driveSubsystem, () -> driverController.getRawAxis(0), () ->  driverController.getRawAxis(1)));
  }

  
   public Command getAutonomousCommand() {
    return Autos.exampleAuto();
    
  }
}
