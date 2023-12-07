package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShooterConstants;

public class ShooterSubsystem extends SubsystemBase {

    private final WPI_TalonFX shooterRightMotor;
    private final WPI_TalonFX shooterLeftMotor;

    public static ShooterStatus shooterStatus;
    public enum ShooterStatus {
        ON, OFF
    }

    public ShooterSubsystem() {
        shooterRightMotor = new WPI_TalonFX(ShooterConstants.RIGHT_FLYWHEEL_ID);
        shooterLeftMotor = new WPI_TalonFX(ShooterConstants.LEFT_FLYWHEEL_ID);

        shooterRightMotor.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, 0, 0);
        shooterLeftMotor.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, 0, 0);

        shooterRightMotor.follow(shooterLeftMotor);
        shooterRightMotor.setInverted(InvertType.OpposeMaster);

        shooterLeftMotor.setNeutralMode(NeutralMode.Coast);
        shooterRightMotor.setNeutralMode(NeutralMode.Coast);

        shooterStatus = ShooterStatus.OFF;
    }

    public void shootBall(){
        shooterLeftMotor.set(ControlMode.PercentOutput, ShooterConstants.SHOOTER_SPEED);
        shooterStatus = shooterStatus.ON;
    }

    public void stopShooting(){
        shooterLeftMotor.set(ControlMode.PercentOutput, 0.0);
        shooterStatus = shooterStatus.OFF;
    }

    public static ShooterStatus getStatus(){
        return shooterStatus;
    }
}
