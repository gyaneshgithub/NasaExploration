package com.rover.command;

import com.rover.MarsRover;

public interface Command {

    public void execute(final MarsRover rover);
}
