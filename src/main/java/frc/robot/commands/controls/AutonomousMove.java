package frc.robot.commands.controls;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;


public class AutonomousMove extends CommandBase {

    private Drivetrain drivetrain;

    public AutonomousMove(Drivetrain drivetrain) {
        this.drivetrain = drivetrain;
        addRequirements(drivetrain);
    }

    public void intialize() {
        
    }

    public void execute() {
        drivetrain.tankDrive(-0.35, -0.3);

    }

    @Override
    public void end(boolean interrupted) {
        drivetrain.tankDrive(0.0, 0.0);
    }

    
    @Override
    public boolean isFinished() {
        return false;
    }



}