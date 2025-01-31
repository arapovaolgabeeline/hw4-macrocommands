package org.example.commands;

import org.example.models.IRotatingObject;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class RotateCommandTest {

    // Поворот объекта с угловой скоростью -70 и углом 120 приводит к углу 50
    @Test
    void assertObjectRotated() {
        IRotatingObject rotatingObject = Mockito.mock(IRotatingObject.class);
        when(rotatingObject.getAngle()).thenReturn(120D);
        when(rotatingObject.getAngularVelocity()).thenReturn(-70D);
        RotateCommand rotateCommand = new RotateCommand(rotatingObject);
        ArgumentCaptor<Number> updatedAngle = ArgumentCaptor.captor();

        rotateCommand.execute();
        verify(rotatingObject).setAngle(updatedAngle.capture());

        Number expectedAngle = 50D;
        assertEquals(expectedAngle, updatedAngle.getValue());
    }

    // Попытка повернуть объект, у которого невозможно прочитать угол, приводит к ошибке
    @Test
    void assertThrowsExceptionWhenCantReadAngle() {
        IRotatingObject rotatingObject = Mockito.mock(IRotatingObject.class);
        when(rotatingObject.getAngle()).thenThrow(NullPointerException.class);
        when(rotatingObject.getAngularVelocity()).thenReturn(-70D);
        RotateCommand rotateCommand = new RotateCommand(rotatingObject);

        assertThrows(NullPointerException.class, rotateCommand::execute);
    }

    // Попытка повернуть объект, у которого невозможно прочитать значение угловой скорости, приводит к ошибке
    @Test
    void assertThrowsExceptionWhenCantReadAngularVelocity() {
        IRotatingObject rotatingObject = Mockito.mock(IRotatingObject.class);
        when(rotatingObject.getAngle()).thenReturn(40D);
        when(rotatingObject.getAngularVelocity()).thenThrow(NullPointerException.class);
        RotateCommand rotateCommand = new RotateCommand(rotatingObject);

        assertThrows(NullPointerException.class, rotateCommand::execute);
    }

    // Попытка повернуть объект, у которого невозможно изменить поворот в пространстве, приводит к ошибке
    @Test
    void assertThrowsExceptionWhenCantRotateObject() {
        IRotatingObject rotatingObject = Mockito.mock(IRotatingObject.class);
        when(rotatingObject.getAngle()).thenReturn(null);
        when(rotatingObject.getAngularVelocity()).thenReturn(30D);
        RotateCommand rotateCommand = new RotateCommand(rotatingObject);

        assertThrows(NullPointerException.class, rotateCommand::execute);
    }

}