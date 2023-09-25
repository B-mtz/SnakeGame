package view;

import logic.FileData;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Random;

public class FrameSnake extends JFrame{
    public  JPanel contentPane;
    private  JPanel northPanel, centerPanel;
    private Color colorBackground = new Color(240, 235, 213);
    public SnakePanel snakePanel;
    public JLabel lbLastScore,lbHighestScore;
    private String[] phrases = {
            "Bienvenido a Snake",
            "Controles: W, A, S, y D.",
            "Come manzanas para crecer.",
            "No te toques a ti mismo.",
            "¡Cuidado! No choques.",
            "¡Has crecido!",
            "¡Supera tu mejor puntuación!",
            "¡Continúa! ¡Vas ganando!",
            "¡No te rindas! ¡Puedes hacerlo!",
            "¡La serpiente está hambrienta!",
            "¡La serpiente está creciendo!",
    };

    //Constructor
    public FrameSnake(){
        super("Start Game");
        this.setSize(450,600);
        contentPane = new JPanel(new BorderLayout());
        this.setContentPane(contentPane);
        contentPane.setBackground(new Color(78, 191, 35));
        contentPane.setBorder(new EmptyBorder(5,5,10,6));

        //Se crean los componentes de los paneles
        northPanelContent();
        centerPanelContet();

        //se añaden al contentPane dentro del Frame
        contentPane.add(northPanel, BorderLayout.NORTH);
        contentPane.add(centerPanel,BorderLayout.CENTER);

        //Configuracion del frame
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setFocusable(true);
        this.requestFocus();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    //Componentes del panelNorte
    public void northPanelContent(){
        northPanel =  new JPanel( new BorderLayout());
        northPanel.setOpaque(false);
        northPanel.setBorder(new EmptyBorder(10,40,15,40));

        //Lee el score y lo muestra en las etiquetas
        FileData fileData = new FileData();
        String[] data = fileData.readFile();

        //Se crea un label para el score mas alto
        lbHighestScore = new JLabel(data[1]);
        lbHighestScore.setFont(new Font("Bahnschrift", Font.BOLD,15));
        lbHighestScore.setForeground(new Color(119, 76, 215));
        lbHighestScore.setIcon(new ImageIcon("src/images/crownImage.png"));

        //Se crea un label para el ultimo score
        lbLastScore = new JLabel("0");
        lbLastScore.setFont(new Font("Bahnschrift", Font.BOLD,15));
        lbLastScore.setForeground(new Color(246, 0, 90));
        lbLastScore.setIcon(new ImageIcon("src/images/appleImage.png"));

        //Se crea un label para mostrar fraces aleatoreamente
        Random random = new Random();
        int indexRandom = random.nextInt(phrases.length);
        JLabel lbPhraces = new JLabel(phrases[indexRandom]);
        lbPhraces.setHorizontalAlignment(0);
        lbPhraces.setFont(new Font("Bahnschrift", Font.ROMAN_BASELINE,15));
        lbPhraces.setForeground(Color.DARK_GRAY);

        northPanel.add(lbHighestScore, BorderLayout.WEST);
        northPanel.add(lbPhraces,BorderLayout.CENTER);
        northPanel.add(lbLastScore,BorderLayout.EAST);
    }

    //componentes del panel Central
    public void centerPanelContet(){
        centerPanel = new JPanel(null);
        snakePanel = new SnakePanel();
        centerPanel.add(snakePanel);
    }
}
