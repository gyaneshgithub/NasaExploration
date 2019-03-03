package com.rover.command;


import com.rover.MarsRover;

public class RotateRightCommand implements Command {

    @Override
    public void execute(final MarsRover rover) {
        rover.turnRight();
    }

}
