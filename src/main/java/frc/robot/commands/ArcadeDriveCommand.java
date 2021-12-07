package frc.robot.commands.DriveCommands;

import static frc.robot.Constants.robotMovementConstants.*;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;

public class ArcadeDriveCommand extends CommandBase {
    private final DrivetrainSubsystem drivetrainSubsystem = DrivetrainSubsystem.getInstance();

    Joystick m_moveStick;
    Joystick m_rotateStick;
    AHRS navx;

    public ArcadeDriveCommand(
            Joystick MoveStick,
            Joystick RotateStick,
            AHRS NavX) {
        m_moveStick = MoveStick;
        m_rotateStick = RotateStick;
        navx = NavX;

        addRequirements(drivetrainSubsystem);
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {

                    drivetrainSubsystem.ArcadeDriveStraight(
                        -m_moveStick.getRawAxis(flightStickMoveAxis),
                        m_rotateStick.getRawAxis(flightStickRotateAxis),
                        navx.getAngle());
                }

    }


    @Override
    public boolean isFinished() {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return false;
    }

    @Override
    public void end(boolean interrupted) {}
}
