package frc.robot;

import frc.robot.Constants.DrivetrainConstants;
import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Drive;
import frc.robot.subsystems.Drivetrain;

import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

import com.ctre.phoenix6.hardware.Pigeon2;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;

public class RobotContainer {
  Pigeon2 gyro = new Pigeon2(10);

  private final Drivetrain drivetrain = new Drivetrain();
  private final CommandXboxController driverController = new CommandXboxController(OperatorConstants.DriverControllerPort);

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    drivetrain.setDefaultCommand(
      new Drive(
        drivetrain,
        () -> new ChassisSpeeds(
          -driverController.getLeftX() * DrivetrainConstants.ForwardSpeed,
          -driverController.getLeftY() * DrivetrainConstants.ForwardSpeed,
          -driverController.getRightX() * DrivetrainConstants.AngularSpeed
        ),
        () -> Math.toRadians(gyro.getAngle())
      )
    );
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
