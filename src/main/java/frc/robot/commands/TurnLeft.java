// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.RomiDrivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
//Class name for the commands to turn left.
public class TurnLeft extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  //Declaring RomiDriveTrain associated object called m_db
  private final RomiDrivetrain m_db;
  //Declaring variable for the distance
  private final double distance;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  //Class constructor for distance
  public Turnleft(RomiDrivetrain db, double inches) {
    distance = inches;
    m_db = db;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(db);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
        //Reset values of the drive base and encoders.
    m_db.arcadeDrive(0,0);
    m_db.resetEncoder();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
        //When excuted, the drivebase will turn left with the speed of 0.54.
    m_db.arcadeDrive(0, -0.54);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    //When the command is done, the speed and rotation of the drive base is set to 0.
    m_db.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
      //If the average distance from both drive bases is greater than the distance travel, this returns true to stop the drive base.
    return m_db.getAverageDistanceInch() > distance;
  }
}
