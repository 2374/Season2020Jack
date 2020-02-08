package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
    
    private TalonSRX frontLeft;
    private TalonSRX frontRight;
    private TalonSRX backLeft;
    private TalonSRX backRight;

    public Drivetrain () {
        this.frontLeft = new TalonSRX(Constants.DRIVETRAIN_FRONT_LEFT_PORT);
        this.frontRight = new TalonSRX(Constants.DRIVETRAIN_FRONT_RIGHT_PORT);
        this.backLeft = new TalonSRX(Constants.DRIVETRAIN_BACK_LEFT_PORT);
        this.backRight = new TalonSRX(Constants.DRIVETRAIN_BACK_RIGHT_PORT);

        this.frontLeft.setNeutralMode(NeutralMode.Brake);
        this.frontRight.setNeutralMode(NeutralMode.Brake);
        this.backLeft.setNeutralMode(NeutralMode.Brake);
        this.backRight.setNeutralMode(NeutralMode.Brake);

       //frontLeft.setInverted(true);
        //frontRight.setInverted(true);

        backLeft.follow(frontLeft);
        backRight.follow(frontRight);
    }

    public void tankDrive(double leftValue, double rightValue) {
        frontLeft.set(ControlMode.PercentOutput, leftValue);
        frontRight.set(ControlMode.PercentOutput, rightValue);
    }

    public void arcadeDrive(double throttleValue, double turnValue) {
        double leftMotor = -throttleValue + turnValue;
        double rightMotor = -throttleValue - turnValue;
        System.out.println("Left Motor: " + leftMotor);
        System.out.println("Right Motor: " + rightMotor);
        tankDrive(leftMotor, -rightMotor);
    }

    
}