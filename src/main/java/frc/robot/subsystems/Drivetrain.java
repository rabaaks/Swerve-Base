package frc.robot.subsystems;

public class Drivetrain {
    SwerveModule frontRightSwerveModule = new SwerveModule(RobotMap.FrontRightDrive, RobotMap.FrontRightTurn);
    SwerveModule frontLeftSwerveModule = new SwerveModule(RobotMap.FrontLeftDrive, RobotMap.FrontLeftTurn);
    SwerveModule backRightSwerveModule = new SwerveModule(RobotMap.BackRightDrive, RobotMap.BackRightDrive);
    SwerveModule backLeftSwerveModule = new SwerveModule(RobotMap.BackLeftDrive, RobotMap.BackLeftTurn);

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
