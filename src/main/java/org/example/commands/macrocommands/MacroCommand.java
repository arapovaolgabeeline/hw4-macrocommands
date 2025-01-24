package org.example.commands.macrocommands;

import java.util.List;
import org.example.commands.ICommand;

public abstract class MacroCommand implements ICommand {
    private final List<ICommand> commands;

    protected MacroCommand(List<ICommand> commands) {
        this.commands = commands;
    }

    @Override
    public void execute() {
        commands.forEach(ICommand::execute);
    }

}
