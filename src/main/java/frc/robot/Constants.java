package frc.robot;

import edu.wpi.first.math.geometry.Translation2d;

public final class Constants {
    public static class OperatorConstants {
        public static final int DriverControllerPort = 0;
    }
    public static class DrivetrainConstants {
        public static final double ForwardSpeed = 0.5;
        public static final double AngularSpeed = 5.0;

        public static final Translation2d FrontLeftLocation = new Translation2d(0.1, 0.1);
        public static final Translation2d FrontRightLocation = new Translation2d(0.1, -0.1);
        public static final Translation2d BackLeftLocation = new Translation2d(-0.1, 0.1);
        public static final Translation2d BackRightLocation = new Translation2d(-0.1, -0.1);

        public static final double DriveP = 0;
        public static final double DriveI = 0;
        public static final double DriveD = 0;
        public static final double DriveFF = 1.0 / ForwardSpeed;

        public static final double TurnP = 0.1;
        public static final double TurnI = 0;
        public static final double TurnD = 0;
        public static final double TurnFF = 0;

        public static final double FrontLeftOffset = 0.283;
        public static final double FrontRightOffset = 0.524-0.125;
        public static final double BackLeftOffset = 0.782;
        public static final double BackRightOffset = 0.802;

        public static final double DriveGearRatio = 5.36;
        public static final double TurnGearRatio = 21.43;
        
        public static final double WheelDiameter = 0.1;

        public static final double DrivePositionConversionFactor = WheelDiameter * Math.PI / DriveGearRatio;
        public static final double DriveVelocityConversionFactor = DrivePositionConversionFactor / 60.0;

        public static final double TurnPositionConversionFactor = 2.0 * Math.PI / TurnGearRatio;
        public static final double TurnVelocityConversionFactor = TurnPositionConversionFactor / 60.0;
    }
}
