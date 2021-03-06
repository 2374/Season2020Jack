package frc.robot.commands.controls;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Intake;

public class MoveIntake extends CommandBase {

    private Intake intake;
    private Indexer indexer; 
    private double power; 
    private int direction; 

    public MoveIntake(Intake intake, double power, int direction, Indexer indexer) {
        this.intake = intake;
        this.power = power;
        this.direction = direction;
        this.indexer = indexer;
        
        addRequirements(intake);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        intake.move(power, direction);
        indexer.move(1, Constants.SPEED_INDEXER_STAGE_1, 1);
         
        
    }

    @Override
    public void end(boolean interrupted) {
        intake.move(0.0, 0);
    }

    @Override
    public boolean isFinished() {
        return false; 
    }

}
