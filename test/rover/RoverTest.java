package rover;

import org.junit.Test;

import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class RoverTest {

    @Test
    public void shouldMove1StepNorth() {
        Rover rover = new Rover(0, 0,Orientation.N);

        rover.followInstructions("M");

        assertThat(rover.getXPosition(), is(0));
        assertThat(rover.getYPosition(), is(1));
        assertThat(rover.getOrientation(), is(Orientation.N));
    }

    @Test
    public void shouldMove2StepsNorth() {
        Rover rover = new Rover(0,0,Orientation.N);

        rover.followInstructions("MM");

        assertThat(rover.getXPosition(), is(0));
        assertThat(rover.getYPosition(), is(2));
        assertThat(rover.getOrientation(), is(Orientation.N));
    }

    @Test
    public void shouldMoveRequiredStepsNorth() {
        Rover rover = new Rover(0,0,Orientation.N);
        Random random = new Random();
        int randomSteps = random.nextInt(10);
        String steps = "";

        for(int i=0; i<randomSteps; i++) {
            steps += "M";
        }

        rover.followInstructions(steps);

        assertThat(rover.getXPosition(), is(0));
        assertThat(rover.getYPosition(), is(randomSteps));
        assertThat(rover.getOrientation(), is(Orientation.N));
    }

//    BORRAR LOS DOS PRIMEROS TESTS


    @Test
    public void shouldRotateRightStartingNorth() {
        Rover rover = new Rover(0, 0,Orientation.N);

        rover.followInstructions("R");

        assertThat(rover.getXPosition(), is(0));
        assertThat(rover.getYPosition(), is(0));
        assertThat(rover.getOrientation(), is(Orientation.E));
    }

    @Test
    public void shouldRotateRightStartingEast() {
        Rover rover = new Rover(0, 0,Orientation.E);

        rover.followInstructions("R");

        assertThat(rover.getXPosition(), is(0));
        assertThat(rover.getYPosition(), is(0));
        assertThat(rover.getOrientation(), is(Orientation.S));
    }

    @Test
    public void shouldRotateRightStartingSouth() {
        Rover rover = new Rover(0, 0,Orientation.S);

        rover.followInstructions("R");

        assertThat(rover.getXPosition(), is(0));
        assertThat(rover.getYPosition(), is(0));
        assertThat(rover.getOrientation(), is(Orientation.W));
    }

    @Test
    public void shouldRotateRightStartingWest() {
        Rover rover = new Rover(0, 0,Orientation.W);

        rover.followInstructions("R");

        assertThat(rover.getXPosition(), is(0));
        assertThat(rover.getYPosition(), is(0));
        assertThat(rover.getOrientation(), is(Orientation.N));
    }

//    REFACTORS ROTATE RIGHT AND CREATE ENUMS FOR ORIENTATION

    @Test
    public void shouldRotateLeftStartingNorth() {
        Rover rover = new Rover(0, 0,Orientation.N);

        rover.followInstructions("L");

        assertThat(rover.getXPosition(), is(0));
        assertThat(rover.getYPosition(), is(0));
        assertThat(rover.getOrientation(), is(Orientation.W));
    }

    @Test
    public void shouldRotateLeftStartingEast() {
        Rover rover = new Rover(0, 0,Orientation.E);

        rover.followInstructions("L");

        assertThat(rover.getXPosition(), is(0));
        assertThat(rover.getYPosition(), is(0));
        assertThat(rover.getOrientation(), is(Orientation.N));
    }

    @Test
    public void shouldRotateLeftStartingSouth() {
        Rover rover = new Rover(0, 0,Orientation.S);

        rover.followInstructions("L");

        assertThat(rover.getXPosition(), is(0));
        assertThat(rover.getYPosition(), is(0));
        assertThat(rover.getOrientation(), is(Orientation.E));
    }

    @Test
    public void shouldRotateLeftStartingWest() {
        Rover rover = new Rover(0, 0,Orientation.W);

        rover.followInstructions("L");

        assertThat(rover.getXPosition(), is(0));
        assertThat(rover.getYPosition(), is(0));
        assertThat(rover.getOrientation(), is(Orientation.S));
    }

//    REFACTORS ROTATE LEFT

    @Test
    public void shouldTurnRightAndMove1StepStartingNorth() {
        Rover rover = new Rover(5, 5,Orientation.N);

        rover.followInstructions("RM");

        assertThat(rover.getXPosition(), is(6));
        assertThat(rover.getYPosition(), is(5));
        assertThat(rover.getOrientation(), is(Orientation.E));
    }

    @Test
    public void shouldTurnLeftAndMove1StepStartingNorth() {
        Rover rover = new Rover(5, 5,Orientation.N);

        rover.followInstructions("LM");

        assertThat(rover.getXPosition(), is(4));
        assertThat(rover.getYPosition(), is(5));
        assertThat(rover.getOrientation(), is(Orientation.W));
    }

    @Test
    public void shouldTurnRightAndMove1StepStartingEast() {
        Rover rover = new Rover(5, 5,Orientation.E);

        rover.followInstructions("RM");

        assertThat(rover.getXPosition(), is(5));
        assertThat(rover.getYPosition(), is(4));
        assertThat(rover.getOrientation(), is(Orientation.S));
    }

//    REFACTOR MOVE METHOD AND CREATE ENUM FOR INSTRUCTIONS
}
