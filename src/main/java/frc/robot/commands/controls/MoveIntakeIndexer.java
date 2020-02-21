package frc.robot.commands.controls;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Intake;

public class MoveIntakeIndexer extends CommandBase {
    private Intake intake;
    private Indexer indexer;
    private double power;

    public MoveIntakeIndexer(Intake intake, Indexer indexer, double power) {
        this.intake = intake;
        this.indexer = indexer;
        this.power = power;
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        intake.move(power, 1);
        indexer.move(1, power, 1);
        indexer.move(2, power, 1);
    }

    @Override
    public void end(boolean interrupted) {
        intake.move(0.0, 0);
        indexer.move(1, 0.0, 0);
        indexer.move(2, 0.0, 0);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}