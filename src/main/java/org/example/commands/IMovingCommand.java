package org.example.commands;

import org.example.models.IMovingObject;

public class IMovingCommand implements ICommand {
    private final IMovingObject movingObject;

    public IMovingCommand(IMovingObject movingObject) {
        this.movingObject = movingObject;
    }

    public void execute() {
        movingObject.setPosition(new Number[] {(Double) movingObject.getPosition()[0] + (Double) movingObject.getVelocity()[0],
                (Double) movingObject.getPosition()[1] + (Double) movingObject.getVelocity()[1]});
    }
}
