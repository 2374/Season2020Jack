package frc.robot.commands.controls;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Indexer;

public class MoveIndexer extends CommandBase {

    private Indexer indexer;
    private int stage;
    private double power;  
    private int direction; 

    public MoveIndexer(Indexer indexer, int stage, double power, int direction) {
        this.indexer = indexer;
        this.stage = stage;
        this.power = power;
        this.direction = direction; 
    }

    @Override
    public void initialize() {
        
    }

    @Override
    public void execute() {
        if (stage == 1) {
            indexer.move(1, power, direction);
        } else if (stage == 2) {
            indexer.move(2, power, direction);
        }
    }
    
    @Override
    public void end(boolean interrupted) {
        indexer.move(1, 0.0, 0);
        indexer.move(2, 0.0, 0);
    }

    @Override
    public boolean isFinished() {
        return false; 
    }

}