package org.example.commands;

import org.example.exceptions.CommandException;
import org.example.models.IFuelBurningObject;

/**
 * проверяет, что топлива достаточно, если нет, то выбрасывает исключение CommandException
 */
public class CheckFuelCommand implements ICommand {
    private final IFuelBurningObject object;

    public CheckFuelCommand(IFuelBurningObject object) {
        this.object = object;
    }

    @Override
    public void execute() {
        Double remainingFuel = (Double) object.getFuel() - (Double) object.getBurnFuelVelocity();
        if (remainingFuel <= 0) {
            throw new CommandException();
        }
    }

}
