package org.example.commands;

import org.example.models.IMovingObject;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class IMovingCommandTest {

    // Для объекта, находящегося в точке (12, 5) и движущегося со скоростью (-7, 3) движение меняет положение объекта на (5, 8)
    @Test
    void assertObjectMoved() {
        IMovingObject movingObject = Mockito.mock(IMovingObject.class);
        when(movingObject.getPosition()).thenReturn(new Number[]{12D, 5D});
        when(movingObject.getVelocity()).thenReturn(new Number[]{-7D, 3D});
        IMovingCommand movingCommand = new IMovingCommand(movingObject);
        ArgumentCaptor<Number[]> updatedLocation = new ArgumentCaptor<>();

        movingCommand.execute();
        verify(movingObject).setPosition(updatedLocation.capture());

        Number[] expectedPositionAfterMoving = {5D, 8D};
        assertArrayEquals(expectedPositionAfterMoving, updatedLocation.getValue());
    }

    // Попытка сдвинуть объект, у которого невозможно прочитать положение в пространстве, приводит к ошибке
    @Test
    void assertThrowsExceptionWhenCantReadPosition() {
        IMovingObject movingObject = Mockito.mock(IMovingObject.class);
        when(movingObject.getPosition()).thenThrow(NullPointerException.class);
        when(movingObject.getVelocity()).thenReturn(new Number[]{-7D, 3D});
        IMovingCommand movingCommand = new IMovingCommand(movingObject);

        assertThrows(NullPointerException.class, movingCommand::execute);
    }

    // Попытка сдвинуть объект, у которого невозможно прочитать значение мгновенной скорости, приводит к ошибке
    @Test
    void assertThrowsExceptionWhenCantReadVelocity() {
        IMovingObject movingObject = Mockito.mock(IMovingObject.class);
        when(movingObject.getPosition()).thenReturn(new Number[]{-7D, 3D});
        when(movingObject.getVelocity()).thenThrow(NullPointerException.class);
        IMovingCommand movingCommand = new IMovingCommand(movingObject);

        assertThrows(NullPointerException.class, movingCommand::execute);
    }

    // Попытка сдвинуть объект, у которого невозможно изменить положение в пространстве, приводит к ошибке
    @Test
    void assertThrowsExceptionWhenCantMoveObject() {
        IMovingObject movingObject = Mockito.mock(IMovingObject.class);
        when(movingObject.getPosition()).thenReturn(new Number[]{null, 3D});
        when(movingObject.getVelocity()).thenReturn(new Number[]{-7D, 3D});
        IMovingCommand movingCommand = new IMovingCommand(movingObject);

        assertThrows(NullPointerException.class, movingCommand::execute);
    }

}