package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkPIDController;
import com.revrobotics.CANSparkBase.ControlType;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.AnalogEncoder;
import frc.robot.Constants.DrivetrainConstants;

public class SwerveModule {
    private CANSparkMax driveMotor;
    private CANSparkMax turnMotor;

    private SparkPIDController drivePID;
    private SparkPIDController turnPID;

    private RelativeEncoder driveEncoder;
    private RelativeEncoder turnEncoder;

    private AnalogEncoder absEncoder;

    public SwerveModule(int driveMotorId, int turnMotorId, int encoderId, double offset) {
        driveMotor = new CANSparkMax(driveMotorId, MotorType.kBrushless);
        driveMotor.setIdleMode(IdleMode.kCoast);
        drivePID = driveMotor.getPIDController();
        driveEncoder = driveMotor.getEncoder();
        driveEncoder.setPositionConversionFactor(DrivetrainConstants.DrivePositionConversionFactor);
        driveEncoder.setVelocityConversionFactor(DrivetrainConstants.DriveVelocityConversionFactor);

        turnMotor = new CANSparkMax(turnMotorId, MotorType.kBrushless);
        turnMotor.setIdleMode(IdleMode.kCoast);
        turnPID = turnMotor.getPIDController();
        turnEncoder = turnMotor.getEncoder();
        turnEncoder.setPositionConversionFactor(DrivetrainConstants.TurnPositionConversionFactor);
        turnEncoder.setVelocityConversionFactor(DrivetrainConstants.TurnVelocityConversionFactor);

        absEncoder = new AnalogEncoder(encoderId);
        turnEncoder.setPosition((absEncoder.getAbsolutePosition() - offset) * 2.0 * Math.PI);
    }

    public void setState(SwerveModuleState state) {
        SwerveModuleState optimizedState = SwerveModuleState.optimize(state, Rotation2d.fromRadians(turnEncoder.getPosition() % (2.0 * Math.PI)));
        drivePID.setReference(optimizedState.speedMetersPerSecond * DrivetrainConstants.ForwardSpeed, ControlType.kVelocity);
        turnPID.setReference(optimizedState.angle.getRadians(), ControlType.kPosition);
    }
}