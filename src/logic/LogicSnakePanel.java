package logic;

import view.FrameSnake;
import view.SnakePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;
import java.util.ArrayList;

public class LogicSnakePanel extends Thread  implements KeyListener, ActionListener{
    private FrameSnake frameSnake;
    private ArrayList<int[]> snake;
    private boolean stop = false;
    private boolean threadStart = false;
    private int rows, columns, gameSpeed;
    private int[] nextHead;
    private Timer gameTimer;

    private char direction;

    //Constructor
    public  LogicSnakePanel(FrameSnake frameSnake){
        //Configuramos el frame del snake
        this.frameSnake = frameSnake;
        frameSnake.setFocusable(true);
        frameSnake.requestFocus();
        frameSnake.addKeyListener(this);
        //configuramos variables locales
        this.rows = 17;
        this.columns = 20;
        this.snake = frameSnake.snakePanel.getSnake();
        //inicializamos el snake en el centro
        initSnake();
        nextHead = new int[]{9, 10};

        // Configurar un temporizador para el juego (cambia el intervalo según sea necesario)
        gameSpeed = 700;
        gameTimer = new Timer(gameSpeed,this);
        gameTimer.start(); // Comenzar el temporizador

        //inicializamos la dirección derecha
        direction = 'D';
    }

    //Captura la direccion del snake
    @Override
    public void keyTyped(KeyEvent e) {
        char keyChar = e.getKeyChar();
        // Obtén la dirección actual del snake
        int[] head = snake.get(0);
        if (keyChar == 'D' || keyChar == 'd') {
            direction = 'D';
        } else if (keyChar == 'A' || keyChar == 'a') {
            direction = 'A';
        } else if (keyChar == 'S' || keyChar == 's') {
            direction = 'S';
        } else if (keyChar == 'W' || keyChar == 'w') {
            direction = 'W';
        }
    }
    //Ejecuta el movimeinto del snake
    @Override
    public void actionPerformed(ActionEvent e) {
        moveSnake();
    }

    //mueve el snake segun la dirección actual
    public void moveSnake(){
        //Recupera la cabeza del snkae, y dependiendo de la direción calcula la nueva cabeza
        int[] head = snake.get(0);
        if (direction == 'D') {
            nextHead = new int[]{head[0] + 1, head[1]};
        } else if (direction == 'A') {
            nextHead = new int[]{head[0] - 1, head[1]};
        } else if (direction == 'S') {
            nextHead = new int[]{head[0], head[1] + 1};
        } else if (direction == 'W') {
            nextHead = new int[]{head[0], head[1] - 1};
        }

        // Valida que no se excedan los límites del mapa
        if (nextHead[0] != rows && nextHead[0] > -1 && nextHead[1] != columns && nextHead[1] > -1) {
            // Agrega la nueva cabeza
            snake.add(0, nextHead);
            // Elimina el último elemento de la cola
            snake.remove(snake.size() - 1);
            // Se envía el nuevo snake para que se dibuje
            frameSnake.snakePanel.setSnake(snake);
        } else {
           stop = true;
        }
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
    }

    @Override
    public void keyPressed(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}
}
