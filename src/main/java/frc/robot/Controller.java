package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Controller extends SubsystemBase {
    private Joystick joystickController;
    private XboxController xboxController;

    public Controller() {
        
        this.joystickController = new Joystick(Constants.JOYSTICK_PORT);
        this.xboxController = new XboxController(Constants.XBOX_CONTROLLER_PORT);   
    }

    public double getJoystickXAxis() { return deadZone(joystickController.getRawAxis(Constants.JOYSTICK_X_AXIS), 0.2); }

    public double getJoystickYAxis() { return deadZone(joystickController.getRawAxis(Constants.JOYSTICK_Y_AXIS), 0.2); }

    public boolean getJoystickTrigger() { return joystickController.getRawButton(Constants.JOYSTICK_TRIGGER); }

    public boolean getJoystickButton2() { return joystickController.getRawButton(Constants.JOYSTICK_BUTTON_2); }

    public boolean getJoystickButton3() { return joystickController.getRawButton(Constants.JOYSTICK_BUTTON_3); }

    public boolean getJoystickButton4() { return joystickController.getRawButton(Constants.JOYSTICK_BUTTON_4); }

    public boolean getJoystickButton5() { return joystickController.getRawButton(Constants.JOYSTICK_BUTTON_5); }

    public double getControllerZAxis() { return deadZone(joystickController.getRawAxis(Constants.CONTROLLER_Z_AXIS), 0.0); }

    public boolean getControllerButton6() { return joystickController.getRawButton(Constants.CONTROLLER_BUTTON_6); }

    public boolean getControllerButton7() { return joystickController.getRawButton(Constants.CONTROLLER_BUTTON_7); }

    public boolean getControllerButton8() { return joystickController.getRawButton(Constants.CONTROLLER_BUTTON_8); }

    public boolean getControllerButton9() { return joystickController.getRawButton(Constants.CONTROLLER_BUTTON_9); }

    public boolean getControllerButton10() { return joystickController.getRawButton(Constants.CONTROLLER_BUTTON_10); }

    public boolean getControllerButton11() { return joystickController.getRawButton(Constants.CONTROLLER_BUTTON_11); }

    public double getXboxControllerLeftTrigger() { return xboxController.getRawAxis(Constants.XBOX_CONTROLLER_LEFT_TRIGGER); }

    public double getXboxControllerRightTrigger() { return xboxController.getRawAxis(Constants.XBOX_CONTROLLER_RIGHT_TRIGGER); }

    public double deadZone(double axisValue, double deadValue) { return Math.abs(axisValue) > deadValue ? axisValue : 0.0; }

    public Joystick getJoystickController() { return joystickController; }

    public XboxController getXboxController() { return xboxController; }

}