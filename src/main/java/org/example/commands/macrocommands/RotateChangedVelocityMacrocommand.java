package org.example.commands.macrocommands;

import java.util.List;
import org.example.commands.BurnFuelCommand;
import org.example.commands.CheckFuelCommand;
import org.example.commands.ICommand;
import org.example.commands.IMovingCommand;
import org.example.commands.RotateCommand;
import org.example.models.IRotatingObject;

/**
 * При повороте движущегося объекта меняется вектор мгновенной скорости. Напишите команду, которая модифицирует вектор
 * мгновенной скорости, в случае поворота.
 * Постройте цепочку команд для поворота.
 * */
public class RotateChangedVelocityMacrocommand extends MacroCommand {

    protected RotateChangedVelocityMacrocommand(IRotatingObject object) {
        super(List.of(new CheckFuelCommand(), new RotateCommand(object), new BurnFuelCommand()));
    }

}
