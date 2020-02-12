package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Outtake extends SubsystemBase {
    
    private VictorSPX outtakeRight; 
    private VictorSPX outtakeLeft; 

    public Outtake() {
        this.outtakeLeft = new VictorSPX(Constants.OUTTAKE_LEFT_PORT);
        this.outtakeRight = new VictorSPX(Constants.OUTTAKE_RIGHT_PORT);

        this.outtakeRight.setInverted(true);
    }

    public void move(double power) {
        outtakeRight.set(ControlMode.PercentOutput, power);
        outtakeLeft.set(ControlMode.PercentOutput, power);
    }
}
