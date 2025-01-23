package org.example.commands.macrocommands;

import java.util.List;
import org.example.commands.ChangeVelocityCommand;
import org.example.commands.RotateCommand;
import org.example.models.IMovingObject;
import org.example.models.IRotatingObject;
import org.example.models.IVelocityChangingObject;

/**
 * При повороте движущегося объекта меняется вектор мгновенной скорости
 */
public class RotateChangedVelocityMacrocommand extends MacroCommand {

    protected RotateChangedVelocityMacrocommand(IRotatingObject rotatingObject, IVelocityChangingObject velocityChangingObject,
                                                IMovingObject movingObject) {
        super(List.of(new RotateCommand(rotatingObject), new ChangeVelocityCommand(velocityChangingObject, rotatingObject, movingObject)));
    }

}
