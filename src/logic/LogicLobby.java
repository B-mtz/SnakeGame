package logic;
import view.Lobby;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class LogicLobby implements ActionListener {
    private Lobby lobby;
    public LogicLobby(Lobby lobby){
        this.lobby = lobby;
        lobby.btnStart.addActionListener(this);
        linkLabelAutor(lobby.lbAutor);
        buttonStartInteraction(lobby.btnStart);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(lobby.btnStart)){

        }
    }

    //Se da diseño al link
    private void linkLabelAutor(JLabel lbAutor){
        lbAutor.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    // Abre el enlace en el navegador web predeterminado
                    Desktop.getDesktop().browse(new URI("https://github.com/B-mtz"));
                } catch (IOException | URISyntaxException ex) {
                    ex.printStackTrace();
                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                // Cambia el color del texto cuando el ratón entra
                lbAutor.setForeground(new Color(250, 96, 2));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                // Restaura el color del texto cuando el ratón sale
                lbAutor.setForeground(new Color(202, 164, 123));
            }
        });
    }

    //se le da diseño interactivo al boton
    private void buttonStartInteraction(JButton btnStart){
        btnStart.addMouseListener(new MouseListener() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnStart.setCursor(new Cursor(Cursor.HAND_CURSOR));
                btnStart.setForeground(Color.WHITE);
                btnStart.setBackground(new Color(250, 96, 2));
                btnStart.setFont(new Font("Century Gothic", Font.PLAIN,22));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnStart.setForeground(new Color(250, 96, 2));
                btnStart.setBackground(Color.WHITE);
                btnStart.setFont(new Font("Century Gothic", Font.BOLD,20));
            }
            @Override
            public void mouseClicked(MouseEvent e) {
            }
            @Override
            public void mousePressed(MouseEvent e) {
                //Lee un audio al presionar el boton
                try {
                    Clip clip = AudioSystem.getClip();
                    clip.open(AudioSystem.getAudioInputStream(new File("src/sound/click.wav")));
                    clip.start();
                    clip.addLineListener(event -> {
                        if (event.getType() == LineEvent.Type.STOP) {
                            clip.close();
                        }
                    });
                } catch (LineUnavailableException | UnsupportedAudioFileException | IOException ex) {
                    ex.printStackTrace();
                }
                btnStart.setFont(new Font("Century Gothic", Font.BOLD,22));
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                btnStart.setFont(new Font("Century Gothic", Font.PLAIN,22));
            }
        });
    }
}
