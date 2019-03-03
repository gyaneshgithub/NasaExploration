package com.rover.command;

import com.rover.MarsRover;

public class RotateLeftCommand implements Command {

    @Override
    public void execute(final MarsRover rover) {
        rover.turnLeft();
    }

}
