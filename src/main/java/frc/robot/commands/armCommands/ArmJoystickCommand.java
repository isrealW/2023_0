// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.armCommands;
import java.util.function.Supplier;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.ArmConstants;
import frc.robot.subsystems.ArmSubsystem;

public class ArmJoystickCommand extends CommandBase {


  private ArmSubsystem armSubsystem ; 
  private Supplier<Double> joystickSupplier;
  /** Creates a new ArmJoystickCommand. */
  public ArmJoystickCommand(ArmSubsystem armSubsystem, Supplier<Double> joystickSupplier) {
    this.armSubsystem = armSubsystem;
    this.joystickSupplier = joystickSupplier;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("ArmJoystickCommand runs");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double joystickoutInput = joystickSupplier.get(); 
    if(armSubsystem.getCurrentAngle() <= ArmConstants.START_ANGLE && joystickoutInput < 0)
    {
      armSubsystem.setMotor(0);
      return;
    }
    armSubsystem.setMotor(joystickoutInput);
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
