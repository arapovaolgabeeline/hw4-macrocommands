package org.example.commands.macrocommands;

import java.util.List;
import org.example.commands.BurnFuelCommand;
import org.example.commands.CheckFuelCommand;
import org.example.commands.IMovingCommand;
import org.example.models.IMovingObject;

public class FuelMoveMacrocommand extends MacroCommand {

    protected FuelMoveMacrocommand(IMovingObject object) {
        super(List.of(new CheckFuelCommand(), new IMovingCommand(object), new BurnFuelCommand()));
    }

}
