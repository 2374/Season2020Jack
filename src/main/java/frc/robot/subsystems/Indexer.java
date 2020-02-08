package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Indexer extends SubsystemBase {
    
    private VictorSPX stage1Left;
    private VictorSPX stage1Right;
    private VictorSPX stage2LeftBack; 
    private VictorSPX stage2LeftFront;

    public Indexer() {
        this.stage1Left = new VictorSPX(Constants.INDEXER_STAGE_1_LEFT_PORT);
        this.stage1Right = new VictorSPX(Constants.INDEXER_STAGE_1_RIGHT_PORT);
        this.stage2LeftBack = new VictorSPX(Constants.INDEXER_STAGE_2_LEFT_BACK_PORT);
        this.stage2LeftFront = new VictorSPX(Constants.INDEXER_STAGE_2_LEFT_FRONT_PORT);

        stage1Left.setInverted(true);
        stage2LeftFront.setInverted(true);
        

        
    }

    public void move(int stage, double power, int direction) {
        if (stage == 1) {
            stage1Left.set(ControlMode.PercentOutput, power * direction);
            stage1Right.set(ControlMode.PercentOutput, power * direction);
        } else if (stage == 2) {
            stage2LeftBack.set(ControlMode.PercentOutput, power * direction); 
            stage2LeftFront.set(ControlMode.PercentOutput, power * direction);
        }
    }

}