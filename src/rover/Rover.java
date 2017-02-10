package rover;

import java.util.HashMap;

public class Rover {

    private int yPosition;
    private int xPosition;
    private Orientation orientation;

    public Rover(int xPosition, int yPosition, Orientation orientation) {
        this.yPosition = yPosition;
        this.xPosition = xPosition;
        this.orientation = orientation;
    }

    public void followInstructions(String steps) {
        for (int i = 0; i < steps.length(); i++) {
            Instruction movement = Instruction.valueOf(String.valueOf(steps.charAt(i)));

            switch (movement) {
                case M:
                    move();
                    break;
                case R:
                    this.orientation = rotateRight();
                    break;
                case L:
                    this.orientation = rotateLeft();
                    break;
            }
        }
    }

    private void move() {
        switch (this.orientation) {
            case N:
                this.yPosition += 1;
                break;
            case S:
                this.yPosition -= 1;
                break;
            case E:
                this.xPosition += 1;
                break;
            case W:
                this.xPosition -= 1;
                break;
        }
    }

    private Orientation rotateRight() {
        HashMap<Orientation, Orientation> rightEndingOrientation = new HashMap<>();
        rightEndingOrientation.put(Orientation.N, Orientation.E);
        rightEndingOrientation.put(Orientation.E, Orientation.S);
        rightEndingOrientation.put(Orientation.S, Orientation.W);
        rightEndingOrientation.put(Orientation.W, Orientation.N);

        return rightEndingOrientation.get(orientation);
    }

    private Orientation rotateLeft() {
        HashMap<Orientation, Orientation> leftEndingOrientation = new HashMap<>();
        leftEndingOrientation.put(Orientation.N, Orientation.W);
        leftEndingOrientation.put(Orientation.W, Orientation.S);
        leftEndingOrientation.put(Orientation.S, Orientation.E);
        leftEndingOrientation.put(Orientation.E, Orientation.N);

        return leftEndingOrientation.get(orientation);
    }

    public int getXPosition() {
        return this.xPosition;
    }

    public int getYPosition() {
        return this.yPosition;
    }

    public Orientation getOrientation() {
        return this.orientation;
    }
}
