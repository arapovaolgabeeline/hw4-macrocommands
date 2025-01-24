package org.example.commands.macrocommands;

import java.util.List;
import org.example.commands.ChangeVelocityCommand;
import org.example.commands.RotateCommand;

/**
 * При повороте движущегося объекта меняется вектор мгновенной скорости
 */
public class RotateChangedVelocityMacrocommand extends MacroCommand {

    protected RotateChangedVelocityMacrocommand(RotateCommand rotatingCommand, ChangeVelocityCommand changeVelocityCommand) {
        super(List.of(rotatingCommand, changeVelocityCommand));
    }

}
