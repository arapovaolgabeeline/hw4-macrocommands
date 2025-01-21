package org.example.commands;

import org.example.models.IRotatingObject;

public class RotateCommand implements ICommand {
    private final IRotatingObject rotatingObject;

    public RotateCommand(IRotatingObject rotatingObject) {
        this.rotatingObject = rotatingObject;
    }

    public void execute() {
        rotatingObject.setAngle((Double) rotatingObject.getAngle() + (Double) rotatingObject.getAngularVelocity());
    }

}
