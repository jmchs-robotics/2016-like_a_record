package org.usfirst.frc5933.LikeARecord;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import jaci.openrio.toast.lib.module.ToastStateModule;
import jaci.openrio.toast.lib.state.RobotState;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class LikeARecordModule extends ToastStateModule {

    static RobotDrive robotDrive;
    static Joystick joystick;

    /**
     * Get a Friendly name for the Module. This is what the Module is referenced by. This should be unique
     * per module
     *
     * @return A unique, friendly name for the module
     */
    @Override
    public String getModuleName() {
        return "Like A Record - Motor Control";
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
     * Called when a state is 'ticked' (periodically called). This is called once every 20ms, or once every contol
     * packet, whichever comes first.
     *
     * @param state
     */
    @Override
    public void tickState(RobotState state) {
        switch (state) {
            case DISABLED:
                robotDrive.stopMotor();
                break;
            case TELEOP:
                robotDrive.tankDrive(joystick.getZ(GenericHID.Hand.kLeft), joystick.getZ(GenericHID.Hand.kRight));
                break;
            case AUTONOMOUS:
                robotDrive.stopMotor();
                break;
            case TEST:
                robotDrive.drive(1.0, 0.0);
                break;
        }
    }

    /**
     * Called on 'Pre-Initialization' of the robot. This is called before the Robot is indicated as 'ready to go'. Inputs
     * and Outputs should be configured here. This method should not have much over-head
     */
    @Override
    public void prestart() {
        RobotMap.init();
        robotDrive = RobotMap.driveTrainRobotDrive;
        joystick = new Joystick(0);
    }

    /**
     * Called on 'Initialization' of the robot. This is called after the Robot is indicated as 'ready to go'. Things like
     * Network Communications and Camera Tracking should be initialized here.
     */
    @Override
    public void start() {}
}
