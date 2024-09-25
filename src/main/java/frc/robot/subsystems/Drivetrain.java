package frc.robot.subsystems;

import frc.robot.Constants.DrivetrainConstants;
import frc.robot.RobotMap;

import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
    SwerveModule frontRightSwerveModule = new SwerveModule(RobotMap.FrontRightDrive, RobotMap.FrontRightTurn, RobotMap.FrontRightEncoder, DrivetrainConstants.FrontRightOffset);
    SwerveModule frontLeftSwerveModule = new SwerveModule(RobotMap.FrontLeftDrive, RobotMap.FrontLeftTurn, RobotMap.FrontLeftEncoder, DrivetrainConstants.FrontLeftOffset);
    SwerveModule backRightSwerveModule = new SwerveModule(RobotMap.BackRightDrive, RobotMap.BackRightDrive, RobotMap.BackRightEncoder, DrivetrainConstants.BackRightOffset);
    SwerveModule backLeftSwerveModule = new SwerveModule(RobotMap.BackLeftDrive, RobotMap.BackLeftTurn, RobotMap.BackLeftEncoder, DrivetrainConstants.BackLeftOffset);

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
    }
}
