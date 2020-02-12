package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Climber extends SubsystemBase {
    
    private TalonSRX leftMotor;
    private TalonSRX rightMotor;

    public Climber() {
        this.leftMotor = new TalonSRX(Constants.CLIMBER_LEFT_PORT);
        this.rightMotor = new TalonSRX(Constants.CLIMBER_RIGHT_PORT);

        leftMotor.setInverted(true);
        rightMotor.setInverted(true);

        rightMotor.follow(leftMotor);
    }

    public void move(double power) {
        leftMotor.set(ControlMode.PercentOutput, power);
    }

}