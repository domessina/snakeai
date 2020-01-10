package org.dotista;

import com.sun.javafx.scene.traversal.Direction;

import java.util.ArrayList;
import java.util.List;

public class Snake {

    private List<SnakeAtom> atoms = new ArrayList<SnakeAtom>();
    private SnakeAtom tailShadow;

    public Snake(int x, int y) {
        atoms.add(new SnakeAtom(x, y, Direction.RIGHT));
        tailShadow = new SnakeAtom(x, y, Direction.RIGHT);
    }

    void grow() {
        SnakeAtom newTail = tailShadow.clone();
        atoms.add(newTail);
        tailShadow = new SnakeAtom(newTail.getX(), newTail.getY(), newTail.getDirection());
    }

    public void move() {


        // move body
        for (int i = atoms.size() - 1; i > 0; i--) {
            SnakeAtom atom = atoms.get(i);
            SnakeAtom previous = atoms.get(i - 1);
            atom.setX(previous.getX());
            atom.setY(previous.getY());
        }

        // move head
        SnakeAtom head = atoms.get(0);
        head.setX(head.calculateNewX(head.getX(), head.getDirection()));
        head.setY(head.calculateNewY(head.getY(), head.getDirection()));
    }

    private SnakeAtom getLastAtom() {
        return atoms.get(atoms.size() - 1);
    }

    public void setHeadDirection(Direction direction) {
        atoms.get(0).setDirection(direction);
    }

    public int getHeadX() {
        return atoms.get(0).getX();
    }

    public int getHeadY() {
        return atoms.get(0).getY();
    }

    public List<SnakeAtom> getAtoms() {
        return atoms;
    }
}
