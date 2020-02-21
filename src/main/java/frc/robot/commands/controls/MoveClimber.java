package frc.robot.commands.controls;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Controller;
import frc.robot.subsystems.Climber;

public class MoveClimber extends CommandBase {

    private Controller controller;
    private Climber climber;
    private double power;
    private int direction;
    private boolean isLeft; 
    
    public MoveClimber(Controller controller, Climber climber, double power, int direction, boolean isLeft) {
        this.controller = controller;
        this.climber = climber; 
        this.power = power;
        this.direction = direction;
        this.isLeft = isLeft; 

        addRequirements(climber); 
    }
    
    public void initialize() {

    }
    
    public void execute() {
        if (isLeft) {
            climber.move(Constants.SPEED_CLIMBER);
        }
    }

    @Override
    public void end(boolean interrupted) {
        climber.move(0.0);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

}
