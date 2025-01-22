package org.example.adaptors;

import org.example.models.UObject;
import org.example.models.IMovingObject;

public class MovingObjectAdapter implements IMovingObject {
    private UObject uObject;

    public MovingObjectAdapter(UObject uObject) {
        this.uObject = uObject;
    }

    @Override
    public Number[] getPosition() {
        return (Number[]) uObject.getProperty("Position");
    }

    @Override
    public void setPosition(Number[] vector) {
        uObject.setProperty("Position", vector);
    }

    @Override
    public Number[] getVelocity() {
        Integer direction = (Integer) uObject.getProperty("Direction");
        Integer velocity = (Integer) uObject.getProperty("Velocity");
        Integer directionNumbers = (Integer) uObject.getProperty("DirectionNumbers");
        return new Number[]{velocity * Math.cos(direction / (360 * directionNumbers)),
                velocity * Math.sin(direction / (360 * directionNumbers))};
    }
}
