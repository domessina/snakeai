package org.dotista;

import java.awt.*;

import static java.awt.Color.*;
import static org.dotista.Constants.ATOM_HEIGHT;
import static org.dotista.Constants.ATOM_WIDTH;

final class CubeDrawer {

    private CubeDrawer(){}

    static void fillSnakeAtom(int x, int y, Graphics g) {
        g.setColor(BLACK);
        g.fillRect(x, y, ATOM_WIDTH, ATOM_HEIGHT);
    }

    static void fillSnakeHead(int x, int y, Graphics g) {
        g.setColor(RED);
        g.fillRect(x, y, ATOM_WIDTH, ATOM_HEIGHT);
    }

    static void fillApple(int x, int y, Graphics g) {
        g.setColor(GREEN);
        g.fillRect(x, y, ATOM_WIDTH, ATOM_HEIGHT);
    }
}
