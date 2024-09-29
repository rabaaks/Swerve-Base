package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;

import java.util.function.Supplier;

public class Drive extends Command {
    private final Drivetrain drivetrain;
    private final Supplier<ChassisSpeeds> speedsSupplier;
    private final Supplier<Double> angleSupplier;

    public Drive(Drivetrain drivetrain, Supplier<ChassisSpeeds> speedsSupplier, Supplier<Double> angleSupplier) {
        this.drivetrain = drivetrain;
        this.speedsSupplier = speedsSupplier;
        this.angleSupplier = angleSupplier;
        addRequirements(drivetrain);
    }

    public void execute() {
        ChassisSpeeds speeds = speedsSupplier.get();
        ChassisSpeeds newSpeeds = ChassisSpeeds.fromFieldRelativeSpeeds(speeds, Rotation2d.fromRadians(angleSupplier.get()));
        drivetrain.setSpeeds(newSpeeds);

        SmartDashboard.putNumber("Gyro", angleSupplier.get());
        SmartDashboard.putNumber("X Speed", newSpeeds.vxMetersPerSecond);
        SmartDashboard.putNumber("Y Speed", newSpeeds.vyMetersPerSecond);
        SmartDashboard.putNumber("Angular Speed", newSpeeds.omegaRadiansPerSecond);
    }
}