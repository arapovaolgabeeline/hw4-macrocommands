package org.example.commands.macrocommands;

import java.util.List;
import org.example.commands.BurnFuelCommand;
import org.example.commands.CheckFuelCommand;
import org.example.commands.IMovingCommand;
import org.example.models.IFuelBurningObject;
import org.example.models.IMovingObject;

/**
 * Команда движения по прямой с расходом топлива, использующая команды CheckFuelCommand, BurnFuelCommand
 * */
public class FuelMoveMacrocommand extends MacroCommand {

    protected FuelMoveMacrocommand(IMovingObject movingObject, IFuelBurningObject fuelBurningObject) {
        super(List.of(new CheckFuelCommand(fuelBurningObject), new IMovingCommand(movingObject), new BurnFuelCommand(fuelBurningObject)));
    }

}
