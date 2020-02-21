package frc.robot.commands.controls;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Outtake;

public class FullAuto extends SequentialCommandGroup {
    private Outtake outtake;
    private Drivetrain drivetrain;
    private Indexer indexer;

    public FullAuto(Outtake outake, Drivetrain drivetrain, Indexer indexer) {
        this.outtake = outake;
        this.drivetrain = drivetrain;
        this.indexer = indexer;
        super.addCommands(
            new AutonomousMove(this.drivetrain).withTimeout(3.0),
            new AutoOutakeIndexer(outtake, indexer, Constants.SPEED_INDEXER_STAGE_1));
    }
}