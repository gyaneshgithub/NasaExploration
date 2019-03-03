import com.rover.MarsRover;
import com.rover.movement.Coordinates;
import com.rover.movement.Direction;
import com.rover.movement.Plateau;
import org.junit.Assert;
import org.junit.Test;


public class MarsRoverTest {

    @Test
    public void canProvideCurrentLocationAsString() {
        Plateau plateau = new Plateau(5,5);
        Coordinates startingPosition = new Coordinates(3,3);
        MarsRover marsRover = new MarsRover(plateau, Direction.N, startingPosition);
        Assert.assertEquals("3 3 N", marsRover.currentLocation());
    }

    @Test
    public void canRotateLeft() {
        Plateau plateau = new Plateau(5,5);
        Coordinates startingPosition = new Coordinates(1,2);
        MarsRover marsRover = new MarsRover(plateau, Direction.N, startingPosition);
        marsRover.turnLeft();
        Assert.assertEquals("1 2 W", marsRover.currentLocation());
    }

    @Test
    public void canRotateRight() {
        Plateau plateau = new Plateau(5,5);
        Coordinates startingPosition = new Coordinates(1,2);
        MarsRover marsRover = new MarsRover(plateau, Direction.N, startingPosition);
        marsRover.turnRight();
        Assert.assertEquals("1 2 E", marsRover.currentLocation());
    }

    @Test
    public void canMove() {
        Plateau plateau = new Plateau(5,5);
        Coordinates startingPosition = new Coordinates(1,2);
        MarsRover marsRover = new MarsRover(plateau, Direction.N, startingPosition);
        marsRover.move();
        Assert.assertEquals("1 3 N", marsRover.currentLocation());
    }

    @Test
    public void canRunCommandToRotateRight() {
        Plateau plateau = new Plateau(5,5);
        Coordinates startingPosition = new Coordinates(1,2);
        MarsRover marsRover = new MarsRover(plateau, Direction.N, startingPosition);
        marsRover.run("R");
        Assert.assertEquals("1 2 E", marsRover.currentLocation());
    }

    @Test
    public void canRunCommandToRotateLeft() {
        Plateau plateau = new Plateau(5,5);
        Coordinates startingPosition = new Coordinates(1,2);
        MarsRover marsRover = new MarsRover(plateau, Direction.N, startingPosition);
        marsRover.run("L");
        Assert.assertEquals("1 2 W", marsRover.currentLocation());
    }

    @Test
    public void canRunCommandToMove() {
        Plateau plateau = new Plateau(5,5);
        System.out.println("********* INPUT *********");
        System.out.println("INPUT PLATEAU --> " + plateau);
        Coordinates startingPosition = new Coordinates(1,2);
        MarsRover marsRover = new MarsRover(plateau, Direction.N, startingPosition);
        String commandString = "LMLMLMLMM";
        System.out.println("INPUT COORDINATES STARTING POSITION --> " + startingPosition + " " + Direction.N.name());
        System.out.println("INPUT COMMAND STRING --> " + commandString);
        marsRover.run(commandString);
        System.out.println("OUTPUT --> " + marsRover.currentLocation());
        Assert.assertEquals("1 3 N", marsRover.currentLocation());
    }

    @Test
    public void canRunCommandWithMultipleInstructions() {
        Plateau plateau = new Plateau(5,5);
        System.out.println("********* INPUT *********");
        System.out.println("INPUT PLATEAU --> " + plateau);
        Coordinates startingPosition = new Coordinates(3,3);
        MarsRover marsRover = new MarsRover(plateau, Direction.E, startingPosition);
        System.out.println("INPUT COORDINATES STARTING POSITION --> " + startingPosition + " " + Direction.E.name());
        String commandString = "MMRMMRMRRM";
        System.out.println("INPUT COMMAND STRING --> " + commandString);

        marsRover.run(commandString);

        System.out.println("OUTPUT --> " + marsRover.currentLocation());
        Assert.assertEquals("5 1 E", marsRover.currentLocation());
    }

    @Test
    public void wontDriveOffPlateau() {
        Plateau plateau = new Plateau(5,5);
        Coordinates startingPosition = new Coordinates(3,3);
        MarsRover marsRover = new MarsRover(plateau, Direction.N, startingPosition);
        marsRover.run("MMMMMMMMMMR");
        Assert.assertEquals("3 5 E", marsRover.currentLocation());
    }
}
