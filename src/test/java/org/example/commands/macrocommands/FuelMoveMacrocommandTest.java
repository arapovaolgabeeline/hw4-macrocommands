package org.example.commands.macrocommands;

import org.example.commands.BurnFuelCommand;
import org.example.commands.CheckFuelCommand;
import org.example.commands.IMovingCommand;
import org.example.exceptions.CommandException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.doThrow;

class FuelMoveMacrocommandTest {

    /**
     * По пункту 7: отдельно тестов на MacroCommand нет, поскольку она является абстрактным классом
     */
    @Test
    void shouldExecuteAllCommands() {

        // given
        CheckFuelCommand checkFuelCommand = Mockito.mock(CheckFuelCommand.class);
        IMovingCommand movingCommand = Mockito.mock(IMovingCommand.class);
        BurnFuelCommand burnFuelCommand = Mockito.mock(BurnFuelCommand.class);
        FuelMoveMacrocommand fuelMoveMacrocommand = new FuelMoveMacrocommand(checkFuelCommand, movingCommand,
                burnFuelCommand);

        // when
        fuelMoveMacrocommand.execute();

        // then
        Mockito.verify(checkFuelCommand, Mockito.times(1)).execute();
        Mockito.verify(movingCommand, Mockito.times(1)).execute();
        Mockito.verify(burnFuelCommand, Mockito.times(1)).execute();
    }

    @Test
    void shouldThrowExceptionAndDoNotExecuteRemainingCommandsWhenCheckCommandProducedCommandException() {
        // given
        CheckFuelCommand checkFuelCommand = Mockito.mock(CheckFuelCommand.class);
        doThrow(new CommandException()).when(checkFuelCommand).execute();
        IMovingCommand movingCommand = Mockito.mock(IMovingCommand.class);
        BurnFuelCommand burnFuelCommand = Mockito.mock(BurnFuelCommand.class);
        FuelMoveMacrocommand fuelMoveMacrocommand = new FuelMoveMacrocommand(checkFuelCommand, movingCommand,
                burnFuelCommand);

        // when
        Assertions.assertThrows(CommandException.class, fuelMoveMacrocommand::execute);

        // then
        Mockito.verify(checkFuelCommand, Mockito.times(1)).execute();
        Mockito.verify(movingCommand, Mockito.times(0)).execute();
        Mockito.verify(burnFuelCommand, Mockito.times(0)).execute();
    }

}