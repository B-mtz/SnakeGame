package logic;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Sounds {
    private Clip clipSnake, clipBackground, clipTurn, clipEat, clipLoseGame;
    AudioInputStream aisBackground,aisSnake,aisTurn,aisEat,aisLoseGame;

    //inicializa los archivos de sonidos para: fondo, giros,movimiento, mordida y de choque.
    public Sounds() {
        try {
            // Sonido de fondo
            clipBackground = AudioSystem.getClip();
            aisBackground = AudioSystem.getAudioInputStream(new File("src/sound/background.wav"));
            clipBackground.open(aisBackground);
            clipBackground.loop(Clip.LOOP_CONTINUOUSLY);

            // Moviemiento del snake
            clipSnake = AudioSystem.getClip();
            aisSnake = AudioSystem.getAudioInputStream(new File("src/sound/snakeMovement.wav"));
            clipSnake.open(aisSnake);
            clipSnake.loop(Clip.LOOP_CONTINUOUSLY);


            // Vueltas del snake
            clipTurn = AudioSystem.getClip();
            aisTurn = AudioSystem.getAudioInputStream(new File("src/sound/turn.wav"));
            clipTurn.open(aisTurn);

            //Mordida del snake
            clipEat = AudioSystem.getClip();
            aisEat = AudioSystem.getAudioInputStream(new File("src/sound/eat.wav"));
            clipEat.open(aisEat);

            //Partida perdida
            clipLoseGame = AudioSystem.getClip();
            aisLoseGame = AudioSystem.getAudioInputStream(new File("src/sound/loseGame.wav"));
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