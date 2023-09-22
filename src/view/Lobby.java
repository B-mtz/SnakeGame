package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Lobby extends JFrame {
    private JPanel contentPane, northPanel, centerPanel;
    private Font font = new Font("Bahnschrift", Font.BOLD,20);
    public Color colorBackground = new Color(240, 235, 213);
    public JButton btnStart, btnInfo;
    public  JLabel lbAutor;

    //Constructor
    public Lobby(){
        super("Bienvenido");
        this.setSize(450,600);
        contentPane = new JPanel(new BorderLayout());
        this.setContentPane(contentPane);

        //Se crean los componenetes en los paneles
        northPanelComponents();
        centerPanelComponents();

        //se agregan los paneles al contentPane del frame
        contentPane.add(northPanel,BorderLayout.NORTH);
        contentPane.add(centerPanel,BorderLayout.CENTER);

        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    //Se crean los componentes para el panel norte
    public void northPanelComponents(){
        //Inicializamos el panel y le damos un borde
        northPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        northPanel.setBackground(colorBackground);
        northPanel.setBorder(new EmptyBorder(5,5,5,5));

        //Se crea un boton para mostrar información del autor
        btnInfo = new JButton();
        btnInfo.setBorder(null);
        btnInfo.setIcon(new ImageIcon("src/images/information.png"));
        btnInfo.setRolloverEnabled(false);

        //Se agrega el boton al panel norte
        northPanel.add(btnInfo);
    }

    //Se crean los componentes para el panel central
    public void centerPanelComponents(){
        //Inicializamos el panel y le damos un borde
        centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(colorBackground);
        centerPanel.setBorder(new EmptyBorder(0,10,10,10));

        //Creamos subPaneles, para los componentes
        JPanel imagePanel = new JPanel();
        imagePanel.setBackground(colorBackground);
        imagePanel.setBorder(null);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(colorBackground);
        buttonPanel.setBorder(new EmptyBorder(20,0,0,0));
        JPanel panelScore = new JPanel(new BorderLayout());
        panelScore.setBorder(new EmptyBorder(0,40,30,40));
        panelScore.setBackground(colorBackground);

        //se crea un etiqueta para mostrar la imagen de portada
        JLabel lbCoverImage = new JLabel();
        lbCoverImage.setIcon(new ImageIcon("src/images/coverImage.png"));
        imagePanel.add(lbCoverImage);

        //Se crean botones: jugar, puntuaciones y configuración
        btnStart = new JButton("Jugar");
        btnStart.setFont(font);
        btnStart.setForeground(new Color(250, 96, 2));
        btnStart.setBackground(Color.WHITE);
        btnStart.setBorder(new LineBorder(new Color(235, 90, 2),2,false));
        btnStart.setPreferredSize(new Dimension(200,35));
        buttonPanel.add(btnStart);

        //Se crea un label para el score mas alto
        JLabel lbHighestScore = new JLabel("Puntaje mas alto : 0 ");
        lbHighestScore.setFont(new Font("Bahnschrift", Font.BOLD,13));
        lbHighestScore.setForeground(new Color(255, 154, 1));
        JLabel lbLastScore = new JLabel("Ultimo puntaje : 0 ");
        lbLastScore.setFont(new Font("Bahnschrift", Font.BOLD,13));
        lbLastScore.setForeground(new Color(255, 154, 1));
        panelScore.add(lbHighestScore, BorderLayout.WEST);
        panelScore.add(lbLastScore,BorderLayout.EAST);

        centerPanel.add(imagePanel,BorderLayout.NORTH);
        centerPanel.add(buttonPanel,BorderLayout.CENTER);
        centerPanel.add(panelScore,BorderLayout.SOUTH);
    }
}
