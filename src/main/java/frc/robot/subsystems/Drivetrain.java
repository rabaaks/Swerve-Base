package frc.robot.subsystems;

import frc.robot.Constants.DrivetrainConstants;
import frc.robot.RobotMap;

import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
    SwerveModule frontLeftSwerveModule = new SwerveModule(RobotMap.FrontLeftDrive, RobotMap.FrontLeftTurn, RobotMap.FrontLeftEncoder, DrivetrainConstants.FrontLeftOffset);
    SwerveModule frontRightSwerveModule = new SwerveModule(RobotMap.FrontRightDrive, RobotMap.FrontRightTurn, RobotMap.FrontRightEncoder, DrivetrainConstants.FrontRightOffset);
    SwerveModule backLeftSwerveModule = new SwerveModule(RobotMap.BackLeftDrive, RobotMap.BackLeftTurn, RobotMap.BackLeftEncoder, DrivetrainConstants.BackLeftOffset);
    SwerveModule backRightSwerveModule = new SwerveModule(RobotMap.BackRightDrive, RobotMap.BackRightTurn, RobotMap.BackRightEncoder, DrivetrainConstants.BackRightOffset);

    private SwerveDriveKinematics swerveDriveKinematics = new SwerveDriveKinematics(
        DrivetrainConstants.FrontLeftLocation,
        DrivetrainConstants.FrontRightLocation,
        DrivetrainConstants.BackLeftLocation,
        DrivetrainConstants.BackRightLocation
    );

    public void setSpeeds(ChassisSpeeds speeds) {
        SwerveModuleState[] moduleStates = swerveDriveKinematics.toSwerveModuleStates(speeds);

        frontLeftSwerveModule.setState(moduleStates[0]);
        frontRightSwerveModule.setState(moduleStates[1]);
        backLeftSwerveModule.setState(moduleStates[2]);
        backRightSwerveModule.setState(moduleStates[3]);

        SmartDashboard.putNumber("Front Left Speed", moduleStates[0].speedMetersPerSecond);
        SmartDashboard.putNumber("Front Left Angle", moduleStates[0].angle.getDegrees());

        SmartDashboard.putNumber("Front Right Speed", moduleStates[1].speedMetersPerSecond);
        SmartDashboard.putNumber("Front Right Angle", moduleStates[1].angle.getDegrees());

        SmartDashboard.putNumber("Back Left Speed", moduleStates[2].speedMetersPerSecond);
        SmartDashboard.putNumber("Back Left Angle", moduleStates[2].angle.getDegrees());
        
        SmartDashboard.putNumber("Back Right Speed", moduleStates[3].speedMetersPerSecond);
        SmartDashboard.putNumber("Back Right Angle", moduleStates[3].angle.getDegrees());
    }
}
