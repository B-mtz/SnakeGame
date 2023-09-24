package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Lobby extends JFrame {
    private JPanel contentPane, northPanel, centerPanel;
    private Font font = new Font("Bahnschrift", Font.BOLD,20);
    private Color colorBackground = new Color(240, 235, 213);
    public JButton btnStart, btnInfo;
    public JLabel lbLastScore,lbHighestScore;

    //Constructor
    public Lobby(){
        super("Bienvenido");
        this.setSize(451,600);
        contentPane = new JPanel(new BorderLayout());
        this.setContentPane(contentPane);
        contentPane.setBackground(colorBackground);

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
        northPanel.setOpaque(false);
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
        centerPanel.setOpaque(false);
        centerPanel.setBorder(new EmptyBorder(0,10,10,10));

        //Creamos subPaneles, para los componentes
        JPanel imagePanel = new JPanel();
        imagePanel.setOpaque(false);
        imagePanel.setBorder(null);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.setBorder(new EmptyBorder(20,0,0,0));
        JPanel panelScore = new JPanel(new BorderLayout());
        panelScore.setBorder(new EmptyBorder(0,40,30,40));
        panelScore.setOpaque(false);

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
        lbHighestScore = new JLabel("0");
        lbHighestScore.setFont(new Font("Bahnschrift", Font.BOLD,15));
        lbHighestScore.setForeground(new Color(119, 76, 215));
        lbHighestScore.setIcon(new ImageIcon("src/images/crownImage.png"));
        lbLastScore = new JLabel("0");
        lbLastScore.setFont(new Font("Bahnschrift", Font.BOLD,15));
        lbLastScore.setForeground(new Color(246, 0, 90));
        lbLastScore.setIcon(new ImageIcon("src/images/appleImage.png"));
        panelScore.add(lbHighestScore, BorderLayout.WEST);
        panelScore.add(lbLastScore,BorderLayout.EAST);

        centerPanel.add(imagePanel,BorderLayout.NORTH);
        centerPanel.add(buttonPanel,BorderLayout.CENTER);
        centerPanel.add(panelScore,BorderLayout.SOUTH);
    }
}
