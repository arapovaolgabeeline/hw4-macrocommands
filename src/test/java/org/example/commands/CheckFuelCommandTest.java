package org.example.commands;

import org.example.exceptions.CommandException;
import org.example.models.IFuelBurningObject;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

class CheckFuelCommandTest {

    @Test
    void shouldCheckFuelAndDoesNotThrowWhenRemainingFuelIsPositiveNumber() {
        // given
        IFuelBurningObject fuelBurningObject = Mockito.spy(IFuelBurningObject.class);
        when(fuelBurningObject.getFuel()).thenReturn(10D);
        when(fuelBurningObject.getBurnFuelVelocity()).thenReturn(1D);
        CheckFuelCommand checkFuelCommand = new CheckFuelCommand(fuelBurningObject);

        // when
        checkFuelCommand.execute();

        // then
        Mockito.verify(fuelBurningObject, times(1)).getFuel();
        Mockito.verify(fuelBurningObject, times(1)).getBurnFuelVelocity();
    }


    @Test
    void shouldCheckFuelAndDoesThrowWhenRemainingFuelIsNegativeNumber() {
        IFuelBurningObject fuelBurningObject = Mockito.spy(IFuelBurningObject.class);
        when(fuelBurningObject.getFuel()).thenReturn(10D);
        when(fuelBurningObject.getBurnFuelVelocity()).thenReturn(100D);

        CheckFuelCommand checkFuelCommand = new CheckFuelCommand(fuelBurningObject);

        assertThrows(CommandException.class, checkFuelCommand::execute);

        Mockito.verify(fuelBurningObject, times(1)).getFuel();
        Mockito.verify(fuelBurningObject, times(1)).getBurnFuelVelocity();
    }

}