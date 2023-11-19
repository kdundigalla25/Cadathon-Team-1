package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class TemplateDrivetrainSubsystem extends SubsystemBase {

    /**
     * The Singleton instance of this TemplateArmSubsystem. Code should use
     * the {@link #getInstance()} method to get the single instance (rather
     * than trying to construct an instance of this class.)
     */
    private static final TemplateDrivetrainSubsystem INSTANCE = new TemplateDrivetrainSubsystem();
    WPI_TalonFX leftMotor1, leftMotor2;
    WPI_TalonFX rightMotor1, rightMotor2;
    DifferentialDrive drive;

    /**
     * Returns the Singleton instance of this TemplateDrivetrainSubsystem. This static method
     * should be used, rather than the constructor, to get the single instance
     * of this class. For example: {@code TemplateDrivetrainSubsystem.getInstance();}
     */
    public static TemplateDrivetrainSubsystem getInstance() {
        return INSTANCE;
    }

    private TemplateDrivetrainSubsystem() {
        leftMotor1 = new WPI_TalonFX(Constants.LEFT_DRIVE_TALON_1);
        leftMotor2 = new WPI_TalonFX(Constants.LEFT_DRIVE_TALON_2);
        rightMotor1 = new WPI_TalonFX(Constants.RIGHT_DRIVE_TALON_1);
        rightMotor2 = new WPI_TalonFX(Constants.RIGHT_DRIVE_TALON_2);

        MotorControllerGroup leftMotors = new MotorControllerGroup(leftMotor1, leftMotor2);
        MotorControllerGroup rightMotors = new MotorControllerGroup(rightMotor1, rightMotor2);

        drive = new DifferentialDrive(leftMotors, rightMotors);
    }

    public void tankDrive(double leftPower, double rightPower) {
        drive.tankDrive(leftPower, rightPower);
    }

    public void stop() {
        drive.stopMotor();
    }
}

