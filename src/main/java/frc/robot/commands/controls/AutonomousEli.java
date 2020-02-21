// package frc.robot.commands.controls;

// import edu.wpi.first.wpilibj2.command.CommandBase;
// import frc.robot.subsystems.Drivetrain;
// import frc.robot.util.Pixy;

// public class AutonomousEli extends CommandBase {
//     private Pixy pixy;
//     private Drivetrain drivetrain;
//     private boolean isFinished;

//     public AutonomousEli(Drivetrain drivetrain, Pixy pixy) {
//         this.pixy = pixy;
//         this.drivetrain = drivetrain;
//     }

//     public void intialize() {
//         isFinished = false;   
//     }

//     public void execute() {
//         if (pixy.getTargetAngle() > 10.0) {
//             drivetrain.arcadeDrive(0.0, pixy.getTargetAngle() / 90);
//         }

//         else if (pixy.getTargetAngle() < -10.0) {
//             drivetrain.arcadeDrive(0.4, pixy.getTargetAngle() / -90);
//         }

//         else if (pixy.getTargetAngle() > -10.0 && pixy.getTargetAngle() < 10.0) {
//             isFinished = true;
//         }
//     }

//     @Override
//     public void end(boolean interrupted) {
//         drivetrain.tankDrive(0.0, 0.0);
//     }

    
//     @Override
//     public boolean isFinished() {
//         return isFinished;
//     }
// }