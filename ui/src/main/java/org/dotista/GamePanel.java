package org.dotista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import static java.awt.Color.*;

class GamePanel extends JPanel {

    private List<Cube> cubes = new ArrayList<>();
    private Cube apple;
    private JLabel scoreLabel;

    public GamePanel() {
        this.scoreLabel = new JLabel();
        this.scoreLabel.setBounds(0, 0, 50, 25);
        this.add(scoreLabel);
        this.setFocusable(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(WHITE);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        Cube atom = cubes.get(0);
        CubeDrawer.fillSnakeHead(atom.getX(), atom.getY(), g);
        for (int i = 1; i < cubes.size() - 1; i++) {
            atom = cubes.get(i);
            CubeDrawer.fillSnakeAtom(atom.getX(), atom.getY(), g);
        }
        CubeDrawer.fillApple(apple.getX(), apple.getY(), g);

        Toolkit.getDefaultToolkit().sync();
    }

    public void setCubes(List<Cube> cubes) {
        this.cubes = cubes;
    }

    public void setApple(Cube apple) {
        this.apple = apple;
    }

    public void setScore(int score) {

        scoreLabel.setText(String.valueOf(score));
    }
}
