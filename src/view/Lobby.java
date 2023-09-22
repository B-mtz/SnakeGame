package view;

import javax.swing.*;
import java.awt.*;

public class Lobby extends JFrame {
    JPanel contentPane,panelNorth,panelCenter,PanelLeft,PanelRight;

    public Lobby(){
        super("Bienvenido");
        this.setSize(400,600);
        contentPane = new JPanel(new BorderLayout());
        this.setContentPane(contentPane);

        //Se crean los componenetes en los paneles


        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }
}
