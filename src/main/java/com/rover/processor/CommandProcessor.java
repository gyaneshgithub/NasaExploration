package com.rover.processor;

import com.rover.command.Command;
import com.rover.command.MoveCommand;
import com.rover.command.RotateLeftCommand;
import com.rover.command.RotateRightCommand;

import java.util.*;
public class CommandProcessor {

    public static final String BY_EACH_CHARACTER = "";
    public static final int START_INDEX = 0;

    private static Map<String, Command> stringToCommandMap = new HashMap<String, Command>() {{
        put("L", new RotateLeftCommand());
        put("R", new RotateRightCommand());
        put("M", new MoveCommand());
    }};

    private String commandString;

    public CommandProcessor(final String commandString) {
        this.commandString = commandString;
    }

    public List<Command> toCommands() {
        if(isNullOrEmpty(commandString)) return new ArrayList<>();
        return buildCommandsList(commandString);
    }

    private List<Command> buildCommandsList(final String commandString) {
        List<Command> commands = new ArrayList<Command>();

        for(String commandCharacter : commandCharactersFrom(commandString)) {
            if (commandCharacter == null) break;
            Command mappedCommand = lookupEquivalentCommand(commandCharacter.toUpperCase());
            commands.add(mappedCommand);
        }

        return commands;
    }

    private boolean isNullOrEmpty(final String commandString) {
        return (null == commandString || commandString.trim().length() == 0);
    }

    private String[] commandCharactersFrom(final String commandString) {
        return Arrays.copyOfRange(commandString.split(BY_EACH_CHARACTER), START_INDEX, commandString.length() + 1);
    }

    private Command lookupEquivalentCommand(final String commandString) {
        return stringToCommandMap.get(commandString);
    }

}
