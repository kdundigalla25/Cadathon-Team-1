package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShooterSubsystem;

public class ToggleShooterCommand extends CommandBase {

    private final ShooterSubsystem shooterSubsystem;

    public ToggleShooterCommand(ShooterSubsystem shooterSubsystem) {
        // Use addRequirements() here to declare subsystem dependencies.
        this.shooterSubsystem = shooterSubsystem;
        addRequirements(shooterSubsystem);
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
        if (ShooterSubsystem.getStatus() == ShooterSubsystem.shooterStatus.OFF) {
            shooterSubsystem.shootBall();
        } else {
            shooterSubsystem.stopShooting();
        }
    }

    public boolean isFinished(){
        return true;
    }
}