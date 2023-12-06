package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;

public class IntakeSubsystem extends SubsystemBase {

    private final WPI_TalonFX intakeMotor;

    public IntakeSubsystem() {
        intakeMotor = new WPI_TalonFX(IntakeConstants.INTAKE_MOTOR_PORT);
        intakeMotor.setInverted(true);
    }

    public void intakeRollIn(){
        intakeMotor.set(ControlMode.PercentOutput, IntakeConstants.INTAKE_SPEED);
    }

    public void intakeRollOut(){
        intakeMotor.set(ControlMode.PercentOutput, -IntakeConstants.INTAKE_SPEED);
    }

    public void intakeStop(){
        intakeMotor.stopMotor();
    }
}