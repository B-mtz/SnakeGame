package view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SnakePanel extends JPanel{
    private int widht, height, squareSize;
    private ArrayList<int[]> snake;
    //Constructor
    public SnakePanel(){
        this.setSize(425,500);
        this.snake = new ArrayList<>();
        this.squareSize = 25;
        this.widht = 425;
        this.height = 500;
    }

    public ArrayList<int[]> getSnake() {
        return snake;
    }

    public void setSnake(ArrayList<int[]> snake) {
        this.snake = snake;
        repaint();
    }

    @Override
    public void paint(Graphics graphics){
        //Variable que ayuda a alternar entra colores
        boolean isPaire = true;
        //Dibuja una cuadrícula de 16 X 20 rectángulos
        for (int i = 0; i < height/squareSize; i++) {
            for (int j = 0; j < widht/squareSize; j++) {
                if (isPaire){
                    graphics.setColor(new Color(156, 229, 79));
                    graphics.fillRect(j * squareSize, i * squareSize, squareSize, squareSize);
                    isPaire = false;
                }else{
                    graphics.setColor(new Color(160, 245, 85));
                    graphics.fillRect(j * squareSize, i * squareSize, squareSize, squareSize);
                    isPaire= true;
                }
            }
        }
        //Dibuja el snake sobre la cuadricula
        for (int[] coord : snake){
            graphics.setColor(Color.BLUE);
            graphics.fillRect(squareSize * coord[0],squareSize * coord[1], squareSize, squareSize);
        }
    }
}