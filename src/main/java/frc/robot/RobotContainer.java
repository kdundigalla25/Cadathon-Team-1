package frc.robot;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.intake.IntakeInCommand;
import frc.robot.commands.intake.IntakeOutCommand;
import frc.robot.commands.shooter.ToggleShooterCommand;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;


public class RobotContainer
{
    public Joystick driverStationJoystick;
    public ShooterSubsystem shooterSubsystem;
    public IntakeSubsystem intakeSubsystem;

    public RobotContainer()
    {
        shooterSubsystem = new ShooterSubsystem();
        intakeSubsystem = new IntakeSubsystem();

        configureBindings();
    }



    private void configureBindings()
    {
        driverStationJoystick = new Joystick(9);
        setJoystickButtonWhenPressed(driverStationJoystick, 1, new ToggleShooterCommand(shooterSubsystem));
        setJoystickButtonWhenPressed(driverStationJoystick, 2, new IntakeInCommand(intakeSubsystem));
        setJoystickButtonWhenPressed(driverStationJoystick, 3, new IntakeOutCommand(intakeSubsystem));
    }

    private void setJoystickButtonWhenPressed(Joystick joystick, int button, CommandBase command) {
        new JoystickButton(joystick, button).onTrue(command);
    }
}
