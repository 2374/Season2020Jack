/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.controls;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;

public class MoveArm extends CommandBase {

    private Arm arm; 
    private double power; 
    
    public MoveArm(Arm arm, double power) {
        this.arm = arm;
        this.power = power; 

        addRequirements(arm);
    }

    public void intialize() {

    }

    public void execute() {
        arm.move(power);
    }

    @Override
    public void end(boolean interrupted) {
        arm.move(0.0);
    }
    
    @Override
    public boolean isFinished() {
        return false; 
    }

}
