package org.example.commands;

import org.example.models.IMovingObject;
import org.example.models.IRotatingObject;
import org.example.models.IVelocityChangingObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ChangeVelocityCommandTest {

    @Mock
    private IVelocityChangingObject velocityChangingObject;

    @Mock
    private IRotatingObject rotatingObject;

    @Mock
    private IMovingObject movingObject;

    @Test
    void shouldChangeVelocityWhenIsMovableObject() {
        // given
        when(rotatingObject.getAngularVelocity()).thenReturn(30D);
        when(movingObject.getVelocity()).thenReturn(new Double[] {50D, 100D});
        ArgumentCaptor<Double[]> changedVelocity = ArgumentCaptor.forClass(Double[].class);
        ChangeVelocityCommand changeVelocityCommand = new ChangeVelocityCommand(velocityChangingObject,
                rotatingObject, movingObject);

        // when
        changeVelocityCommand.execute();

        // then
        Mockito.verify(movingObject, times(1)).getVelocity();
        Mockito.verify(rotatingObject, times(1)).getAngularVelocity();
        Mockito.verify(velocityChangingObject).setVelocity(changedVelocity.capture());
        Assertions.assertArrayEquals(new Double[]{-6.698729810778055D, 111.60254037844388D}, changedVelocity.getValue());
    }

    @Test
    void shouldNotChangeVelocityWhenIsNotMovableObject() {
        // given
        ChangeVelocityCommand changeVelocityCommand = new ChangeVelocityCommand(velocityChangingObject,
                rotatingObject, null);

        // when
        changeVelocityCommand.execute();

        // then
        Mockito.verify(movingObject, times(0)).getVelocity();
        Mockito.verify(rotatingObject, times(0)).getAngularVelocity();
    }
}