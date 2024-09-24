package frc.robot.commands;

public class Drive {
    private final Drivetrain drivetrain;
    private final Supplier<ChassisSpeeds> speedsSupplier;

    public Drive(Drivetrain drivetrain, Supplier<ChassisSpeeds> speedsSupplier) {
        this.drivetrain = drivetrain;
        this.speedsSupplier = speedsSupplier;
        addRequirements(drivetrain);
    }

    public void execute() {
        drivetrain.setSpeeds(speedsSupplier.get());
    }
}