package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Information extends JDialog {
    //Constructor
    public Information(){
        this.setTitle("Información");
        this.setSize(300,200);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setModal(true);

        //Panel de los componentes
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setBackground(new Color(233, 229, 207));
        contentPane.setBorder(new EmptyBorder(20,20,30,20));

        //Se crea un lb para infor del autor
        JPanel infoAutorPanel = new JPanel();
        infoAutorPanel.setOpaque(false);
        infoAutorPanel.setBorder(new EmptyBorder(5,5,30,5));
        JLabel lbAutor = new JLabel("  Autor: https://github.com/B-mtz");
        lbAutor.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lbAutor.setFont(new Font("Bahnschrift", Font.PLAIN,12));
        lbAutor.setForeground(Color.DARK_GRAY);
        linkLabelAutor(lbAutor);
        infoAutorPanel.add(lbAutor);

        //Se crea un lb para la musica
        JPanel infoMusicPanel = new JPanel(new BorderLayout());
        infoMusicPanel.setOpaque(false);
        JLabel lbMusic = new JLabel("Musica :");
        lbMusic.setFont(new Font("Bahnschrift", Font.PLAIN,12));
        lbMusic.setForeground(Color.DARK_GRAY);
        infoMusicPanel.add(lbMusic, BorderLayout.NORTH);
        JLabel lbMusicTitle = new JLabel("Obra: Perros y Gatos");
        lbMusicTitle.setFont(new Font("Bahnschrift", Font.PLAIN,12));
        lbMusicTitle.setForeground(Color.DARK_GRAY);
        infoMusicPanel.add(lbMusicTitle, BorderLayout.CENTER);
        JLabel lbMusicAutor = new JLabel("Música de https://www.fiftysounds.com/es/");
        lbMusicAutor.setFont(new Font("Bahnschrift", Font.PLAIN,12));
        lbMusicAutor.setForeground(Color.DARK_GRAY);
        infoMusicPanel.add(lbMusicAutor, BorderLayout.SOUTH);

        //Se añaden los componentes al panel y el panel al frame
        contentPane.add(infoAutorPanel,BorderLayout.NORTH);
        contentPane.add(infoMusicPanel, BorderLayout.CENTER);

        this.add(contentPane);
        this.setVisible(true);
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
                lbAutor.setForeground(Color.DARK_GRAY);
            }
        });
    }
}
