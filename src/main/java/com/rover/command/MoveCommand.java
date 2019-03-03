package com.rover.command;

import com.rover.MarsRover;

public class MoveCommand implements Command {

    @Override
    public void execute(final MarsRover rover) {
        rover.move();
    }

}
