package org.example.commands.macrocommands;

import java.util.List;
import org.example.commands.BurnFuelCommand;
import org.example.commands.CheckFuelCommand;
import org.example.commands.IMovingCommand;

/**
 * Команда движения по прямой с расходом топлива, использующая команды CheckFuelCommand, BurnFuelCommand
 * */
public class FuelMoveMacrocommand extends MacroCommand {

    protected FuelMoveMacrocommand(CheckFuelCommand checkFuelCommand, IMovingCommand movingCommand, BurnFuelCommand burnFuelCommand) {
        super(List.of(checkFuelCommand, movingCommand, burnFuelCommand));
    }

}
