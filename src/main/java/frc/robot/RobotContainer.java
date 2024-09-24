package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;

public class RobotContainer {
  private final Drivetrain drivetrain = new Drivetrain(gyro);
  private final CommandJoystick driverController = new CommandJoystick(OperatorContstants.DriverControllerPort)

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    drivetrain.setDefaultCommand(
      new Drive (
        drivetrain,
        () -> new ChassisSpeeds(
          -driverController.getAxis(),
          0,
          -driverController.getAxis()
        )
      )
    )
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
