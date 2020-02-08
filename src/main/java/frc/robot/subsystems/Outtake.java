package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Outtake extends SubsystemBase {
    
    private VictorSPX outtake; 

    public Outtake() {
        this.outtake = new VictorSPX(Constants.OUTTAKE_PORT); 
    }

    public void move(double power) {
        outtake.set(ControlMode.PercentOutput, power);
    }
}
