package org.example.commands;

import java.util.Objects;
import org.example.models.IMovingObject;
import org.example.models.IRotatingObject;
import org.example.models.IVelocityChangingObject;

/**
 * Команда для модификации вектора мгновенной скорости при повороте.
 * Необходимо учесть, что не каждый разворачивающийся объект движется.
 * */
public class ChangeVelocityCommand implements ICommand {
    private final IVelocityChangingObject velocityChangingObject;
    private final IRotatingObject rotatingObject;
    private final IMovingObject movingObject;

    public ChangeVelocityCommand(IVelocityChangingObject velocityChangingObject, IRotatingObject rotatingObject, IMovingObject movingObject) {
        this.velocityChangingObject = velocityChangingObject;
        this.rotatingObject = rotatingObject;
        this.movingObject = movingObject;
    }

    @Override
    public void execute() {
        if (isMovableObject()) {
            Double angularVelocity = Math.toRadians((Double) rotatingObject.getAngularVelocity());
            velocityChangingObject.setVelocity(new Number[]{
                    (Double) movingObject.getVelocity()[0] * Math.cos(angularVelocity) - (Double) movingObject.getVelocity()[1] * Math.sin(angularVelocity),
                    (Double) movingObject.getVelocity()[0] * Math.sin(angularVelocity) + (Double) movingObject.getVelocity()[1] * Math.cos(angularVelocity)
            });
        }

    }

    private boolean isMovableObject() {
        return Objects.nonNull(movingObject);
    }

}
