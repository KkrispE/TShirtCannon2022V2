/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.*;

import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.LauncherSubsystem;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import static frc.robot.Constants.OIConstants.*;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
    // The robot's subsystems and commands are defined here...
    private final Joystick driveJoystick = new Joystick(DRIVE_JOYSTICK_PORT);
    private final Joystick rotateJoystick = new Joystick(ROTATE_JOYSTICK_PORT);

  private final JoystickButton m_topButton = new JoystickButton(driveJoystick, fireTopRowButtonID);
   private final JoystickButton m_bottomButton = new JoystickButton(driveJoystick, fireBottomRowButtonID);
    private final JoystickButton m_moveRight = new JoystickButton(driveJoystick, moveRightButtonID);
    private final JoystickButton m_moveLeft = new JoystickButton(driveJoystick, moveLeftButtonID);
    private final JoystickButton driveStraightButton = new JoystickButton(driveJoystick, frc.robot.Constants.OIConstants.driveStraightButtonID);

    private final LauncherSubsystem launcherSubsystem = LauncherSubsystem.getInstance();
    private final DrivetrainSubsystem drivetrainSubsystem = DrivetrainSubsystem.getInstance();

    /**
     * The container for the robot.  Contains subsystems, OI devices, and commands.
     */
    public RobotContainer() {
      //  DrivetrainSubsystem.getInstance().setDefaultCommand(new DefaultDrive(drivetrainSubsystem, driveJoystick, rotateJoystick));
        // DrivetrainSubsystem.getInstance().setDefaultCommand(new XboxDrive(drivetrainSubsystem, driveJoystick));
        DrivetrainSubsystem.getInstance().setDefaultCommand(new AlphaDriveStraightCommand(drivetrainSubsystem, driveJoystick, driveStraightButton));


        // Configure the button bindings
        configureButtonBindings();
    }

    /**
     * Use this method to define your button->command mappings.  Buttons can be created by
     * instantiating a {@link GenericHID} or one of its subclasses ({@link
     * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
     * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
     */
    private void configureButtonBindings() {
        m_topButton.whenPressed(new FireTopRowGroup(launcherSubsystem));
       m_bottomButton.whenPressed(new FireBottomRowGroup(launcherSubsystem));
          

    }


    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */

}
