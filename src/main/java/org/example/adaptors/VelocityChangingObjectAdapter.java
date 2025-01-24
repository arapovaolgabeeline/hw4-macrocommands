package org.example.adaptors;

import org.example.models.IVelocityChangingObject;
import org.example.models.UObject;

public class VelocityChangingObjectAdapter implements IVelocityChangingObject {
    private UObject object;

    @Override
    public void setVelocity(Number[] vector) {
        object.setProperty("Velocity", vector);
    }

}
