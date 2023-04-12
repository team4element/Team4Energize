package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Intake;

public class ScoreMidAndTaxiAuto extends SequentialCommandGroup {
  private final DriveTrain m_drive;
  private final Arm m_arm;
  private final Intake m_intake;

  public ScoreMidAndTaxiAuto(DriveTrain drive, Arm arm, Intake intake) {
    this.m_drive = drive;
    this.m_arm = arm;
    this.m_intake = intake;

    addCommands(new DriveToPosition(this.m_drive, -12).withTimeout(2),
        new HoldArmPosition(this.m_arm, 74.5).withTimeout(2),
        new DriveToPosition(this.m_drive, 11.5).withTimeout(2),
        new ToggleClaw(this.m_intake),
        new LowerArmAndDrive(this.m_drive, this.m_arm, -190).withTimeout(5));
  }
}