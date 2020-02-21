package frc.robot;

import frc.robot.commands.controls.AutomateIndexer;
import frc.robot.commands.controls.MoveArm;
import frc.robot.commands.controls.MoveClimber;
import frc.robot.commands.controls.MoveFinger;
import frc.robot.commands.controls.MoveIndexer;
import frc.robot.commands.controls.MoveIntake;
import frc.robot.commands.controls.MoveIntakeIndexer;
import frc.robot.commands.controls.MoveOuttake;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Finger;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Climber;
import frc.robot.Controller;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Outtake;
import frc.robot.util.JoystickAxisButton;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  private Controller controller;
  private Drivetrain drivetrain;
  private Indexer indexer; 
  private Intake intake;
  private Climber climber;
  private Arm arm;
  private Outtake outtake; 
  private Finger finger; 
  
  public RobotContainer() {
    this.drivetrain = new Drivetrain();
    this.controller = new Controller();
    this.indexer = new Indexer();
    this.intake = new Intake();
    this.climber = new Climber();
    this.arm = new Arm();
    this.outtake = new Outtake(); 
    this.finger = new Finger();

    configureButtonBindings();  
  }

  private void configureButtonBindings() {
    JoystickButton button2 = new JoystickButton(controller.getJoystickController(), Constants.JOYSTICK_BUTTON_2);
    JoystickButton button3 = new JoystickButton(controller.getJoystickController(), Constants.JOYSTICK_BUTTON_3);
    JoystickButton button4 = new JoystickButton(controller.getJoystickController(), Constants.JOYSTICK_BUTTON_4); 
    JoystickButton button5 = new JoystickButton(controller.getJoystickController(), Constants.JOYSTICK_BUTTON_5);
    JoystickButton button6 = new JoystickButton(controller.getJoystickController(), Constants.CONTROLLER_BUTTON_6); 
    JoystickButton button7 = new JoystickButton(controller.getJoystickController(), Constants.CONTROLLER_BUTTON_7);
    JoystickButton button8 = new JoystickButton(controller.getJoystickController(), Constants.CONTROLLER_BUTTON_8);
    JoystickButton button9 = new JoystickButton(controller.getJoystickController(), Constants.CONTROLLER_BUTTON_9);
    JoystickButton button10 = new JoystickButton(controller.getJoystickController(), Constants.CONTROLLER_BUTTON_10); 
    JoystickButton button11 = new JoystickButton(controller.getJoystickController(), Constants.CONTROLLER_BUTTON_11); 
    JoystickButton trigger = new JoystickButton(controller.getJoystickController(), Constants.JOYSTICK_TRIGGER);
    JoystickAxisButton leftTrigger = new JoystickAxisButton(controller.getXboxController(), Constants.XBOX_CONTROLLER_LEFT_TRIGGER, 0.1);
    JoystickAxisButton rightTrigger = new JoystickAxisButton(controller.getXboxController(), Constants.XBOX_CONTROLLER_RIGHT_TRIGGER, 0.1);
    JoystickButton buttonY = new JoystickButton(controller.getXboxController(), Constants.XBOX_CONTROLLER_BUTTON_Y);
    JoystickButton buttonB = new JoystickButton(controller.getXboxController(), Constants.XBOX_CONTROLLER_BUTTON_B); 
    JoystickButton buttonA = new JoystickButton(controller.getXboxController(), Constants.XBOX_CONTROLLER_BUTTON_A);
    JoystickButton buttonX = new JoystickButton(controller.getXboxController(), Constants.XBOX_CONTROLLER_BUTTON_X);

    button4.whileHeld(new MoveIntakeIndexer(intake, indexer, Constants.SPEED_INDEXER_STAGE_1));
    button3.whileHeld(new MoveIndexer(indexer, 2, Constants.SPEED_INDEXER_STAGE_2, 1));
    button5.whileHeld(new MoveIndexer(indexer, 1, Constants.SPEED_INDEXER_STAGE_1, 1));
    button9.whileHeld(new MoveIndexer(indexer, 1, Constants.SPEED_INDEXER_STAGE_1, -1));
    button10.whileHeld(new MoveIndexer(indexer, 2, Constants.SPEED_INDEXER_STAGE_2, -1));
    trigger.whileHeld(new MoveIntake(intake, Constants.SPEED_INTAKE, 1, indexer));
    button6.whileHeld(new MoveIntake(intake, Constants.SPEED_INTAKE, -1, indexer));
    button11.whileHeld(new MoveOuttake(outtake, Constants.SPEED_OUTAKE));  
    
    //leftTrigger.whileHeld(new MoveClimber(controller, climber, Constants.SPEED_CLIMBER, -1, true));
    buttonX.whenPressed(new MoveClimber(controller, climber, Constants.SPEED_CLIMBER, -1, true).withTimeout(2.0));
    buttonY.whileHeld(new MoveArm(arm, Constants.SPEED_ARM_UP));
    buttonA.whileHeld(new MoveArm(arm, Constants.SPEED_ARM_DOWN));
    buttonB.whileHeld(new MoveFinger(finger, Constants.SPEED_FINGER)); 
    //buttonA.whileHeld(new MoveIntakeIndexer(intake, indexer, 0.6));
    
    
  }

  public Controller getController() { return controller; }

  public Drivetrain getDrivetrain() { return drivetrain; }

  public boolean isButton2Pressed() {return controller.getJoystickButton2(); }
  
}
