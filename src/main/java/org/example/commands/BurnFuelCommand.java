package org.example.commands;

import org.example.models.IFuelBurningObject;

/**
 * уменьшает количество топлива на скорость расхода топлива
 * */
public class BurnFuelCommand implements ICommand {
    private IFuelBurningObject object;

    public BurnFuelCommand(IFuelBurningObject object) {
        this.object = object;
    }

    @Override
    public void execute() {
        Double remainingFuel = (Double) object.getFuel() - (Double) object.getBurnFuelVelocity();
        object.setFuel(remainingFuel);
    }

}
