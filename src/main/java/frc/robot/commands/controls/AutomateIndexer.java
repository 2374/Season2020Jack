package frc.robot.commands.controls;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.commands.controls.MoveStage;
import frc.robot.subsystems.Indexer;

public class AutomateIndexer extends SequentialCommandGroup {

    public AutomateIndexer(Indexer indexer) {
        
        super.addCommands(
            new MoveStage(indexer, 1, Constants.SPEED_INDEXER_STAGE_1),
            new MoveStage(indexer, 2, Constants.SPEED_INDEXER_STAGE_2));

    }

}