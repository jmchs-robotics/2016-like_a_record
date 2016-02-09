package frc.team5933.motors;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;

public class Drive {

    private RobotDrive robotDrive;

    public Drive(RobotDrive drive) {
        robotDrive = drive;
    }

    public void tankDrive(Joystick joystick) {
        robotDrive.tankDrive(joystick, 1, joystick, 3);
    }

    public void tankDrive(Joystick leftStick, Joystick rightStick) {
        robotDrive.tankDrive(leftStick, rightStick);
    }

    public void tankDrive(double leftStick, double rightStick) {
        robotDrive.tankDrive(leftStick, rightStick);
    }

    public void mechDrive(Joystick stick) {
        double x = stick.getX();
        double y = stick.getY();
        double left = y + x;
        double right = y - x;

        if (left > 1) {
            left = 1;
        }
        if (left < -1) {
            left = -1;
        }
        if (right > 1) {
            right = 1;
        }
        if (right < -1) {
            right = -1;
        }
        robotDrive.tankDrive(left, right);
    }

    public void arcadeDrive(Joystick stick) {
        robotDrive.arcadeDrive(stick);
    }

    public void arcadeDrive(double moveValue, double rotateValue) {
        robotDrive.arcadeDrive(moveValue, rotateValue);
    }

    public void driveStraight(double speed) {
        double left = speed;
        double right = speed;

        if (left < 0) {
            left += -0.04;
        }

        if (left > 0) {
            left += 0.04;
        }

        robotDrive.tankDrive(left, right);
    }
}
