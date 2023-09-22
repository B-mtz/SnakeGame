package view;

import javax.swing.*;
import java.awt.*;

public class SnakePanel extends JPanel {
    private int widht = 425, height = 500, squareSize = 25;
    public SnakePanel(){
        this.setSize(425,500);
    }

    @Override
    public void paint(Graphics graphics){
        //Variable que ayuda a alternar entra colores
        boolean isPaire = true;
        // Dibuja una cuadrícula de 16 X 20 rectángulos
        for (int i = 0; i < height/squareSize; i++) {
            for (int j = 0; j < widht/squareSize; j++) {
                if (isPaire){
                    graphics.setColor(new Color(156, 229, 79));
                    graphics.fillRect(j * squareSize, i * squareSize, 25, 25);
                    isPaire = false;
                }else{
                    graphics.setColor(new Color(160, 245, 85));
                    graphics.fillRect(j * squareSize, i * squareSize, 25, 25);
                    isPaire= true;
                }
            }
        }
    }
}
