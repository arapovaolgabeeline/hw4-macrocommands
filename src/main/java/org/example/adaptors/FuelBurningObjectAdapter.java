package org.example.adaptors;

import org.example.models.IFuelBurningObject;
import org.example.models.UObject;

public class FuelBurningObjectAdapter implements IFuelBurningObject {
    private final UObject uObject;

    public FuelBurningObjectAdapter(UObject uObject) {
        this.uObject = uObject;
    }

    @Override
    public Number getFuel() {
        return (Double) uObject.getProperty("Fuel");
    }

    @Override
    public void setFuel(Number newValue) {
        uObject.setProperty("Fuel", newValue);
    }

    @Override
    public void setBurnFuelVelocity(Number velocity) {
        uObject.setProperty("BurnFuelVelocity", velocity);
    }

    @Override
    public Number getBurnFuelVelocity() {
        return (Number) uObject.getProperty("BurnFuelVelocity");
    }

}
