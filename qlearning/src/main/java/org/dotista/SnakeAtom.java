package org.dotista;

import com.sun.javafx.scene.traversal.Direction;

import static org.dotista.Constants.ATOM_HEIGHT;
import static org.dotista.Constants.ATOM_WIDTH;

public class SnakeAtom extends Atom{

    private Direction direction;

    public SnakeAtom(int x, int y, Direction direction) {
        super(x, y);
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int calculateNewX(int x, Direction direction) {
        switch (direction) {
            case LEFT: return x - ATOM_WIDTH;
            case RIGHT: return x + ATOM_WIDTH;
            default:return x;
        }
    }

    public int calculateNewY(int y, Direction direction) {
        switch (direction) {
            case UP: return y - ATOM_HEIGHT;
            case DOWN: return y + ATOM_HEIGHT;
            default:return y;
        }
    }

    @Override
    public SnakeAtom clone() {
        return new SnakeAtom(super.getX(), super.getY(), direction);
    }
}
