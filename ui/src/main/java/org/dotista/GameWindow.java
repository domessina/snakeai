package org.dotista;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.util.List;

import static javax.swing.JFrame.EXIT_ON_CLOSE;
import static org.dotista.Constants.*;

public class GameWindow extends JFrame {

    private GamePanel panel = new GamePanel();

    public GameWindow() {
        this.setTitle("Snake AI");
        // fix swing because JFrame W & H are not respected
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setContentPane(panel);
        this.setVisible(true);
    }

    public void update(List<Cube> cubes, Cube apple, int score) {
        panel.setCubes(cubes);
        panel.setApple(apple);
        panel.setScore(score);
        panel.repaint();
    }

    public void addKeyListener(KeyAdapter keyAdapter) {
        panel.addKeyListener(keyAdapter);
    }
}