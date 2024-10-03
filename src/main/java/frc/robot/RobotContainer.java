package frc.robot;

import frc.robot.Constants.DrivetrainConstants;
import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Drive;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;

import com.ctre.phoenix6.hardware.Pigeon2;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.RunCommand;

public class RobotContainer {
  Pigeon2 gyro = new Pigeon2(10);

  private final Drivetrain drivetrain = new Drivetrain();
  private final CommandJoystick driverController = new CommandJoystick(OperatorConstants.DriverControllerPort);

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    drivetrain.setDefaultCommand(
      new Drive(
        drivetrain,
        () -> new ChassisSpeeds(
          -MathUtil.applyDeadband(driverController.getRawAxis(1), 0.1) * DrivetrainConstants.ForwardSpeed,
          -MathUtil.applyDeadband(driverController.getRawAxis(0), 0.1) * DrivetrainConstants.ForwardSpeed,
          -MathUtil.applyDeadband(driverController.getRawAxis(4), 0.1) * DrivetrainConstants.AngularSpeed
        ),
        () -> Math.toRadians(gyro.getAngle())
      )
    );
    driverController.button(1).onTrue(new RunCommand(() -> gyro.reset()));
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
