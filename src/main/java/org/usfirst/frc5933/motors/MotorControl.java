package org.usfirst.frc5933.motors;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import jaci.openrio.toast.lib.module.IterativeModule;
import jaci.openrio.toast.lib.registry.Registrar;

public class MotorControl extends IterativeModule {

    private Drive drive;
    private Joystick joystick;
    private RobotDrive robotDrive;

    /**
     * Get a Friendly name for the Module. This is what the Module is referenced by. This should be unique
     * per module
     *
     * @return A unique, friendly name for the module
     */
    @Override
    public String getModuleName() {
        return "Like A Record - Team 5933 - Motor Control";
    }

    /**
     * Get a Version for the Module. This should change as the Module is updated. If you Module is only being used by
     * your team, this isn't really necessary. This is here for distributed APIs and modules.
     *
     * @return The version of the module
     */
    @Override
    public String getModuleVersion() {
        return "0.1.0";
    }

    /**
     * Called on 'Pre-Initialization' of the robot. This is called before the Robot is indicated as 'ready to go'. Inputs
     * and Outputs should be configured here. This method should not have much over-head
     */
    @Override
    public void prestart() {
        CANTalon frontLeftMotor = Registrar.canTalon(Constants.FRONT_LEFT_CAN_MOTOR_ID);
        CANTalon frontRightMotor = Registrar.canTalon(Constants.FRONT_RIGHT_CAN_MOTOR_ID);
        CANTalon backLeftMotor = Registrar.canTalon(Constants.BACK_LEFT_CAN_MOTOR_ID);
        CANTalon backRightMotor = Registrar.canTalon(Constants.BACK_RIGHT_CAN_MOTOR_ID);
        robotDrive = new RobotDrive(frontLeftMotor, backLeftMotor, frontRightMotor, backRightMotor);
        joystick = new Joystick(0);
        drive = new Drive(robotDrive);
    }

    /**
     * Called when the Robot has ticked. This happens once every 20ms or once every control
     * packet, whatever comes first. This is for Teleoperated mode.
     */
    @Override
    public void teleopPeriodic() {
        drive.arcadeDrive(joystick);
    }
}
