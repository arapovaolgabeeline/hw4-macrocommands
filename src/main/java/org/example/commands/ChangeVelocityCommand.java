package org.example.commands;

import org.example.models.IRotatingObject;

public class ChangeVelocityCommand implements ICommand {
    private IRotatingObject object;

    public ChangeVelocityCommand(IRotatingObject object) {
        this.object = object;
    }

    @Override
    public void execute() {
        // а тут адаптер нужен или какое там от нас требуется velocity? наверное, из IRotatingObject
    }

}
