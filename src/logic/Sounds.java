package logic;

import javax.sound.sampled.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;

public class Sounds {
    private Clip clipSnake, clipBackground, clipTurn, clipEat, clipLoseGame;
    AudioInputStream aisBackground,aisSnake,aisTurn,aisEat,aisLoseGame;

    //inicializa los archivos de sonidos para: fondo, giros,movimiento, mordida y de choque.
    public Sounds() {
        try {
            // Sonido de fondo
            clipBackground = AudioSystem.getClip();
            URL backgSoundURL = Sounds.class.getResource("/sound/background.wav");
            aisBackground = AudioSystem.getAudioInputStream(backgSoundURL);
            clipBackground.open(aisBackground);
            clipBackground.loop(Clip.LOOP_CONTINUOUSLY);

            // Moviemiento del snake
            clipSnake = AudioSystem.getClip();
            URL snakeMovementSound = Sounds.class.getResource("/sound/snakeMovement.wav");
            aisSnake = AudioSystem.getAudioInputStream(snakeMovementSound);
            clipSnake.open(aisSnake);
            clipSnake.loop(Clip.LOOP_CONTINUOUSLY);


            // Vueltas del snake
            clipTurn = AudioSystem.getClip();
            URL turnSound = Sounds.class.getResource("/sound/turn.wav");
            aisTurn = AudioSystem.getAudioInputStream(turnSound);
            clipTurn.open(aisTurn);

            //Mordida del snake
            clipEat = AudioSystem.getClip();
            URL eatSound = Sounds.class.getResource("/sound/eat.wav");
            aisEat = AudioSystem.getAudioInputStream(eatSound);
            clipEat.open(aisEat);

            //Partida perdida
            clipLoseGame = AudioSystem.getClip();
            URL loseGame = Sounds.class.getResource("/sound/loseGame.wav");
            aisLoseGame = AudioSystem.getAudioInputStream(loseGame);
            clipLoseGame.open(aisLoseGame);
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException ex) {
            ex.printStackTrace();
        }
    }

    //Metodos que inician los sonidos

    public void playBackground() {
        clipBackground.start();
        clipSnake.start();
    }
    public void stopBackground() {
        clipBackground.stop();
        clipSnake.stop();
    }

    public void playTurn() {
        clipTurn.setFramePosition(0);
        clipTurn.start();
    }
    public void playEat() {
        clipEat.setFramePosition(0);
        clipEat.start();
    }
    public void playLoseGame() {
        clipLoseGame.start();
    }
}