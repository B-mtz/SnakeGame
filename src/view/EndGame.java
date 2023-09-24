package view;

import logic.LogicLobby;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EndGame extends JDialog {
    private JButton resStart;
    private FrameSnake frameSnake;

    public EndGame(FrameSnake parent, int score) {
        super(parent, "Fin del juego", true); // El tercer argumento "true" hace que el diálogo sea modal
        this.frameSnake = parent;
        this.setSize(300,200);
        this.setUndecorated(true);

        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setBackground(new Color(161, 210, 85));
        contentPane.setBorder(new EmptyBorder(20, 20, 30, 20));

        JLabel lbMessage = new JLabel("Has perdido");
        lbMessage.setHorizontalAlignment(0);
        lbMessage.setFont(new Font("Bahnschrift", Font.BOLD, 20));
        lbMessage.setForeground(new Color(250, 96, 2));
        contentPane.add(lbMessage, BorderLayout.NORTH);

        JLabel lbMessage2 = new JLabel("Inténtalo de nuevo");
        lbMessage2.setHorizontalAlignment(0);
        lbMessage2.setFont(new Font("Bahnschrift", Font.BOLD, 20));
        lbMessage2.setForeground(new Color(250, 96, 2));
        contentPane.add(lbMessage2, BorderLayout.CENTER);

        // Se crea el botón para reiniciar
        resStart = new JButton("Volver a jugar");
        resStart.setFont(new Font("Bahnschrift", Font.BOLD, 20));
        resStart.setForeground(new Color(250, 96, 2));
        resStart.setBackground(Color.WHITE);
        resStart.setBorder(new LineBorder(new Color(235, 90, 2), 2, false));
        resStart.setPreferredSize(new Dimension(200, 35));
        resStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Lobby lobby = new Lobby();
                lobby.lbLastScore.setText(""+score);
                LogicLobby logicLobby = new LogicLobby(lobby);
                parent.dispose();
            }
        });
        contentPane.add(resStart, BorderLayout.SOUTH);
        this.setContentPane(contentPane);
        this.setLocationRelativeTo(parent);
        this.setVisible(true);
    }
}