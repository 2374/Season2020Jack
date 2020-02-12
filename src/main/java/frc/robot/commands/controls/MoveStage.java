package frc.robot.commands.controls;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Indexer;

public class MoveStage extends CommandBase {

    private Indexer indexer;
    private int stage;
    private double power;

    public MoveStage(Indexer indexer, int stage, double power) {
        this.indexer = indexer;
        this.stage = stage;
        this.power = power;
    }

    @Override
    public void initialize() {
        if (indexer.isEmpty(stage)) {
            this.withTimeout(5);
        } // if this doesn't work, put in constructor
    }

    @Override
    public void execute() {
        if (indexer.isEmpty(stage)) {
            indexer.move(stage, power, 1);
        }
    }

    @Override
    public void end(boolean interrupted) {
        indexer.move(stage, 0.0, 0);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

}