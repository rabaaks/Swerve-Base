package frc.robot;

import java.util.Map;

import edu.wpi.first.math.geometry.Translation2d;

public final class Constants {
    public static class OperatorConstants {
        public static final int DriverControllerPort = 0;
    }
    public static class DrivetrainConstants {
        public static final double WheelDiameter = 0.1;
        public static final double Width = 0.2;
        public static final double Apothem = Width / 2.0; // Don't ask

        public static final double ForwardSpeed = 1.0;
        public static final double AngularSpeed = 0.8 * Math.PI;

        public static enum Module {
            FrontLeft,
            FrontRight,
            BackLeft,
            BackRight
        }

        public static final Map<Module, Translation2d> Location = Map.of(
            Module.FrontLeft, new Translation2d(Apothem, Apothem),
            Module.FrontRight, new Translation2d(Apothem, -Apothem),
            Module.BackLeft, new Translation2d(-Apothem, Apothem),
            Module.BackRight, new Translation2d(-Apothem, -Apothem)
        );

        public static final Map<Module, Double> Offset = Map.of(
            Module.FrontLeft, 0.283,
            Module.FrontRight, 0.524,
            Module.BackLeft, 0.782,
            Module.BackRight, 0.802
        );

        public static class Drive {
            public static final double P = 0.0;
            public static final double I = 0.0;
            public static final double D = 0.0;
            public static final double FF = 1.0 / ForwardSpeed;
            public static final double GearRatio = 5.36;
            public static final double PositionConversionFactor = WheelDiameter * Math.PI / GearRatio;
            public static final double VelocityConversionFactor = PositionConversionFactor / 60;
        }

        public static class Turn {
            public static final double P = 0.1;
            public static final double I = 0.0;
            public static final double D = 0.0;
            public static final double FF = 0.0;
            public static final double GearRatio = 5.36;
            public static final double PositionConversionFactor = 2 * Math.PI / GearRatio;
            public static final double VelocityConversionFactor = PositionConversionFactor / 60;
        }
    }
}
