/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

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
    }

    public void move(double power, int direction) {
        leftMotor.set(ControlMode.PercentOutput, power * direction);
        rightMotor.set(ControlMode.PercentOutput, power * direction);
    }

}