package org.example.commands;

import org.example.models.IFuelBurningObject;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class BurnFuelCommandTest {

    @Test
    void shouldBurnFuel() {
        // given
        IFuelBurningObject fuelBurningObject = spy(IFuelBurningObject.class);
        when(fuelBurningObject.getFuel()).thenReturn(10D);
        when(fuelBurningObject.getBurnFuelVelocity()).thenReturn(1D);
        ArgumentCaptor<Double> remainingFuel = ArgumentCaptor.forClass(Double.class);
        BurnFuelCommand burnFuelCommand = new BurnFuelCommand(fuelBurningObject);

        // when
        burnFuelCommand.execute();

        // then
        verify(fuelBurningObject).setFuel(remainingFuel.capture());
        assertEquals(9D, remainingFuel.getValue());
        verify(fuelBurningObject, times(1)).getFuel();
        verify(fuelBurningObject, times(1)).getBurnFuelVelocity();
        verify(fuelBurningObject, times(1)).setFuel(anyDouble());
    }

    @Test
    void shouldNotThrowWhenRemainingFuelIsNegativeNumber() {
        // given
        IFuelBurningObject fuelBurningObject = spy(IFuelBurningObject.class);
        when(fuelBurningObject.getFuel()).thenReturn(10D);
        when(fuelBurningObject.getBurnFuelVelocity()).thenReturn(100D);
        ArgumentCaptor<Double> remainingFuel = ArgumentCaptor.forClass(Double.class);
        BurnFuelCommand burnFuelCommand = new BurnFuelCommand(fuelBurningObject);

        // when
        burnFuelCommand.execute();

        // then
        verify(fuelBurningObject).setFuel(remainingFuel.capture());
        assertEquals(-90D, remainingFuel.getValue());
        verify(fuelBurningObject, times(1)).getFuel();
        verify(fuelBurningObject, times(1)).getBurnFuelVelocity();
        verify(fuelBurningObject, times(1)).setFuel(anyDouble());
    }

}