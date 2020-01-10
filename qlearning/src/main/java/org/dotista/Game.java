package org.dotista;

import com.sun.javafx.scene.traversal.Direction;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static com.sun.javafx.scene.traversal.Direction.*;
import static org.dotista.Constants.*;

public class Game {

    public static final int THROTTLE = 125;
    private GameWindow gameWindow;
    private AI snakeAI;
    private Direction direction = RIGHT;
    private boolean cycleStarted = true;
    private boolean newDirectionSet = false;
    private CubeConverter cubeConverter = new CubeConverter();
    private Snake snake;
    Atom apple;
    int score = 0;

    public Game() {
        this.gameWindow = new GameWindow();
        this.gameWindow.addKeyListener(new KeyController());
        this.snakeAI = new AI();
    }

    public static void main(String[] args) {
        new Game().start();
    }

    public void start() {

        snake = new Snake(20, 20);
        apple = new Atom(60, 60);

        while(true) {
            cycleStarted = true;
            snake.move();
            List<Cube> cubes = snake.getAtoms().stream().map(atom -> cubeConverter.apply(atom)).collect(Collectors.toList());
            Cube appleCube = cubeConverter.apply(apple);
            gameWindow.update(cubes, appleCube, score);
            snake.setHeadDirection(direction);
            collisions();
            newDirectionSet = false;
            cycleStarted = false;
            sleep();
        }
    }

    private void sleep() {
        try {
            Thread.sleep(THROTTLE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void collisions() {
        if(apple.getX() == snake.getHeadX() && apple.getY() == snake.getHeadY()) {
            score++;
            snake.grow();
            int appleX = new Random().ints(1, 0, FRAME_WIDTH / ATOM_WIDTH).findFirst().getAsInt() * ATOM_WIDTH;
            int appleY = new Random().ints(1, 0, FRAME_HEIGHT / ATOM_HEIGHT).findFirst().getAsInt() * ATOM_HEIGHT;
            apple.setX(appleX);
            apple.setY(appleY);
            System.out.println(appleX + " " + appleY);
        }
    }


    public class KeyController extends KeyAdapter {


        @Override
        public void keyPressed(KeyEvent e) {

            if (!cycleStarted && !newDirectionSet) {
                newDirectionSet = true;
                if(e.getKeyCode() == KeyEvent.VK_UP){
                    if(!direction.equals(DOWN)){
                        direction = UP;
                    }
                }else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    if(!direction.equals(LEFT)){
                        direction = RIGHT;
                    }
                }else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    if(!direction.equals(UP)){
                        direction = DOWN;
                    }
                }else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    if(!direction.equals(RIGHT)){
                        direction = LEFT;
                    }
                }
            }
        }
    }
}
