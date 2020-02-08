/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.controls;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Controller;
import frc.robot.subsystems.Climber;

/**
 * Add your docs here.
 */
public class MoveClimber extends CommandBase { 
    private Controller controller;
    private Climber climber; 
    private double powerValue; 
    private int direction;
    private boolean isLeft; 
    
    public MoveClimber(Controller controller, Climber climber, double powerValue, int direction, boolean isLeft) {
        this.controller = controller;
        this.climber = climber; 
        this.powerValue = powerValue;
        this.direction = direction;
        this.isLeft = isLeft; 

        addRequirements(climber); 
    }
    
    public void initialize() {

    }
    
    public void execute() {
        if (isLeft) {
            climber.move(controller.getXboxControllerLeftTrigger(), direction);
        } else {
            climber.move(controller.getXboxControllerRightTrigger(), direction);

        }

         
    }

    @Override
    public void end(boolean interrupted) {
        climber.move(0.0,0);
    }
    @Override
    public boolean isFinished() {
        return false;
    }


}
