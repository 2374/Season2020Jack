/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.controls;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

/**
 * Add your docs here.
 */
public class MoveIntake extends CommandBase {
    private Intake intake; 
    private double powerValue; 
    private int direction; 

    public MoveIntake(Intake intake, double powerValue, int direction) {
        this.intake = intake; 
        this.powerValue = powerValue;
        this.direction = direction;  
        addRequirements(intake);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        intake.move(powerValue, direction); 
    }

    @Override
    public void end(boolean interrupted) {

    }

    public boolean isFinished() {
        return true; 
    }


}
