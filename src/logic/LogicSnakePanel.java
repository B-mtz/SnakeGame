package logic;

import view.EndGame;
import view.FrameSnake;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class LogicSnakePanel extends Thread  implements KeyListener, ActionListener{
    private FrameSnake frameSnake;
    private ArrayList<int[]> snake;
    private int rows, columns, gameSpeed,score;
    private int[] nextHead;
    private Timer gameTimer;
    private char direction;
    private boolean correctMovement;
    private int applePosition[];
    private Sounds sounds;

    //Constructor
    public  LogicSnakePanel(FrameSnake frameSnake){
        //Configuramos el frame del snake
        this.frameSnake = frameSnake;
        frameSnake.addKeyListener(this);
        //configuramos variables locales
        this.score = 0;
        this.rows = 17;
        this.columns = 20;
        this.snake = new ArrayList<>();
        this.applePosition = new int[2];
        //inicializamos el snake en el centro
        initSnake();
        this.nextHead = new int[]{9, 10};
        // Configurar un temporizador para el juego
        gameSpeed = 200;
        gameTimer = new Timer(gameSpeed,this);
        gameTimer.start();
        //inicializamos la dirección derecha
        direction = 'd';
        //Valida que no se cambie la direción antes de avanzar aunque sea un celda
        this.correctMovement = true;
        //inicializa sonidos del juego
        sounds = new Sounds();
        sounds.playBackground();
    }

    //Captura la direccion del snake
    @Override
    public void keyTyped(KeyEvent e) {
        char keyChar = e.getKeyChar();
        // Obtén la dirección actual del snake y valida que la dirección no sea el opuesto
        int[] head = snake.get(0);
        if (keyChar == 'D' || keyChar == 'd') {
            if (direction != 'A' && correctMovement && direction != 'D'){
                direction = 'D';
                correctMovement = false;
                sounds.playTurn();
            }
        } else if (keyChar == 'A' || keyChar == 'a') {
            if (direction != 'D' && correctMovement && direction != 'A'){
                direction = 'A';
                correctMovement = false;
                sounds.playTurn();
            }
        } else if (keyChar == 'S' || keyChar == 's') {
            if (direction != 'W' && correctMovement && direction != 'S'){
                direction = 'S';
                correctMovement = false;
                sounds.playTurn();
            }
        } else if (keyChar == 'W' || keyChar == 'w') {
            if (direction != 'S' && correctMovement && direction != 'W'){
                direction = 'W';
                correctMovement = false;
                sounds.playTurn();
            }
        }
    }
    //Ejecuta el movimeinto del snake
    @Override
    public void actionPerformed(ActionEvent e) {
        moveSnake();
    }

    //Mueve el snake segun la dirección actual
    public void moveSnake(){
        //Recupera la cabeza del snkae, y dependiendo de la direción calcula la nueva cabeza
        int[] head = snake.get(0);
        if (direction == 'D' || direction == 'd') {
            nextHead = new int[]{head[0] + 1, head[1]};
        } else if (direction == 'A' || direction == 'a') {
            nextHead = new int[]{head[0] - 1, head[1]};
        } else if (direction == 'S' || direction == 's') {
            nextHead = new int[]{head[0], head[1] + 1};
        } else if (direction == 'W' || direction == 'w') {
            nextHead = new int[]{head[0], head[1] - 1};
        }

        // Valida que no se excedan los límites del mapa
        if (nextHead[0] != rows && nextHead[0] > -1 && nextHead[1] != columns && nextHead[1] > -1 && collisionWithSnake()) {
            // Agrega la nueva cabeza
            snake.add(0, nextHead);
            // Elimina el último elemento de la cola siempre y cuando no haya comido una manzana
            if (applePosition[0] == nextHead[0] && applePosition[1] == nextHead[1]) {
                score++;
                frameSnake.lbLastScore.setText(""+score);
                applePositionRandom();
                sounds.playEat();
            }else{
                snake.remove(snake.size() - 1);
            }
            // Se envía el nuevo snake para que se dibuje
            frameSnake.snakePanel.setSnake(snake);
            // Libre las teclas
            correctMovement = true;
        }else{
            sounds.stopBackground();
            sounds.playLoseGame();
            gameTimer.stop();
            EndGame endGame = new EndGame(frameSnake,score);
            frameSnake.dispose();
        }
    }

    public boolean collisionWithSnake(){
        for (int[] position : snake) {
            if (position[0] == nextHead[0] && position[1] == nextHead[1]) {
                return false; // Hay una colisión, retorna false inmediatamente
            }
        }
        return true; // No se encontraron colisiones, retorna true
    }

    //inicializa el snake en el centro
    public void initSnake(){
        int [] a = {9,10};
        int [] b = {8,10};
        int [] c = {7,10};
        snake.add(a);
        snake.add(b);
        snake.add(c);
        frameSnake.snakePanel.setSnake(snake);
        applePositionRandom();
    }

    //Genar una posicion aleatorea que sea diferente a la posicion del snake para la manzana
    public void applePositionRandom(){
        int x, y;
        boolean flag = false;
        do {
            x = (int) (Math.random() * 17);
            y = (int) (Math.random() * 20);

            flag = false; // Reinicializa flag en cada iteración

            for (int[] position : snake) {
                if (position[0] == x && position[1] == y) {
                    flag = true;
                    break;
                }
            }
        } while (flag);
        applePosition[0] = x;
        applePosition[1] = y;
        frameSnake.snakePanel.setApplePosition(applePosition);
    }


    @Override
    public void keyPressed(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}
}
