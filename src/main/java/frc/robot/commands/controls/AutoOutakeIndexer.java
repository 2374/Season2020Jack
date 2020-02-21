package frc.robot.commands.controls;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Outtake;

public class AutoOutakeIndexer extends CommandBase {
    private Outtake outtake;
    private Indexer indexer;
    private double power;

    public AutoOutakeIndexer(Outtake outtake, Indexer indexer, double power) {
        this.outtake = outtake;
        this.indexer = indexer;
        this.power = power;
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        indexer.move(1, power, 1);
        indexer.move(2, power, 1);
        outtake.move(Constants.SPEED_OUTAKE);
    }

    @Override
    public void end(boolean interrupted) {
        outtake.move(0.0);
        indexer.move(1, 0.0, 0);
        indexer.move(2, 0.0, 0);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}