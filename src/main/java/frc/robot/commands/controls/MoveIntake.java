package frc.robot.commands.controls;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class MoveIntake extends CommandBase {

    private Intake intake; 
    private double power; 
    private int direction; 

    public MoveIntake(Intake intake, double power, int direction) {
        this.intake = intake;
        this.power = power;
        this.direction = direction;
        
        addRequirements(intake);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        intake.move(power, direction); 
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
