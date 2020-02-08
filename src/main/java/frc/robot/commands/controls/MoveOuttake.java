package frc.robot.commands.controls;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Outtake;

public class MoveOuttake extends CommandBase {

   private Outtake outtake; 
   private double power; 

    public MoveOuttake(Outtake outtake, double power) {
        this.outtake = outtake;
        this.power = power; 

        addRequirements(outtake);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        outtake.move(power);
    }

    
    @Override
    public void end(boolean interrupted) {
        outtake.move(0.0); 
    }

    public boolean isFinished() {
        return false; 
    }

}