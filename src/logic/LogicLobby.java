package logic;
import view.Information;
import view.Lobby;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class LogicLobby implements ActionListener {
    private Lobby lobby;
    //constructor
    public LogicLobby(Lobby lobby){
        this.lobby = lobby;
        lobby.btnStart.addActionListener(this);
        lobby.btnInfo.addActionListener(this);
        buttonStartInteraction(lobby.btnStart);
        buttonInfotInteraction(lobby.btnInfo);
    }

    //Eventos de los botones
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(lobby.btnStart)){

        }else  if (e.getSource().equals(lobby.btnInfo)){
            Information information = new Information();
        }
    }

    //se le da diseño interactivo al boton start
    private void buttonStartInteraction(JButton btnStart){
        btnStart.addMouseListener(new MouseListener() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnStart.setCursor(new Cursor(Cursor.HAND_CURSOR));
                btnStart.setForeground(Color.WHITE);
                btnStart.setBackground(new Color(250, 96, 2));
                btnStart.setFont(new Font("Bahnschrift", Font.PLAIN,22));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnStart.setForeground(new Color(250, 96, 2));
                btnStart.setBackground(Color.WHITE);
                btnStart.setFont(new Font("Bahnschrift", Font.BOLD,20));
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
                btnStart.setFont(new Font("Bahnschrift", Font.BOLD,22));
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                btnStart.setFont(new Font("Bahnschrift", Font.PLAIN,22));
            }
        });
    }
    //se le da diseño interactivo al boton info
    private void buttonInfotInteraction(JButton btnInfo){
        btnInfo.addMouseListener(new MouseListener() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnInfo.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e) {
            }
            @Override
            public void mouseClicked(MouseEvent e) {
            }
            @Override
            public void mousePressed(MouseEvent e) {
                btnInfo.setIcon(new ImageIcon("src/images/info-pres.png"));
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                btnInfo.setIcon(new ImageIcon("src/images/information.png"));
            }
        });
    }
}
