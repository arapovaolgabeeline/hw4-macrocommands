package org.example.commands;

import org.example.models.IVelocityChangingObject;

/**
 * Команда для модификации вектора мгновенной скорости при повороте.
 * Необходимо учесть, что не каждый разворачивающийся объект движется.
 * */
public class ChangeVelocityCommand implements ICommand {
    private final IVelocityChangingObject object;

    public ChangeVelocityCommand(IVelocityChangingObject object) {
        this.object = object;
    }

    @Override
    public void execute() {
        // как мы поймем, движется он или нет?
        // куда менять вектор мгновенной скорости? нам надо знать, куда именно он поворачивает
        if (true) { // объект движется
            object.setVelocity(new Number[]{}); // а как менять? куда поворачивает?
        }

    }

}
