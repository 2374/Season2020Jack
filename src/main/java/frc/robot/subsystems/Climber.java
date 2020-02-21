package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Climber extends SubsystemBase {
    
    private TalonFX leftMotor;
    private TalonFX rightMotor;

    public Climber() {
        this.leftMotor = new TalonFX(Constants.CLIMBER_LEFT_PORT);
        this.rightMotor = new TalonFX(Constants.CLIMBER_RIGHT_PORT);

        leftMotor.setInverted(true);
        //rightMotor.setInverted(true);

        // rightMotor.follow(leftMotor);
    }

    public void move(double power) {
        leftMotor.set(ControlMode.PercentOutput, -power);
        rightMotor.set(ControlMode.PercentOutput, power);
    }

}