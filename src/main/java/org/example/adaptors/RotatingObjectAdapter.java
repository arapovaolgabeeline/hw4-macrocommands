package org.example.adaptors;

import org.example.models.UObject;
import org.example.models.IRotatingObject;

/**
 * Код из дз 1, не менялся
 */
public class RotatingObjectAdapter implements IRotatingObject {
    private UObject uObject;

    public RotatingObjectAdapter(UObject uObject) {
        this.uObject = uObject;
    }

    @Override
    public Number getAngle() {
        return (Number) uObject.getProperty("Angle");
    }

    @Override
    public Number getAngularVelocity() {
        return (Number) uObject.getProperty("AngularVelocity");
    }

    @Override
    public void setAngle(Number value) {
        uObject.setProperty("Angle", value);
    }
}
