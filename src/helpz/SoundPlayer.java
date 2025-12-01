package helpz;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

/**
 * Utilitário simples para tocar sons de áudio a partir da pasta res/.
 * Neste projeto, é usado para tocar arquivos MP3 de vitória e derrota.
 */
public class SoundPlayer {

    private SoundPlayer() {
        // utilitário estático
    }

    /**
     * Toca um arquivo de som localizado em res/.
     * Exemplo: playSound("victory.mp3") procura por res/victory.mp3.
     */
    public static void playSound(String fileName) {
        try {
            File file = new File("src/res/" + fileName);
            if (!file.exists()) {
                // Se o arquivo não existir, simplesmente não faz nada para evitar quebrar o jogo
                return;
            }

            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            // Em caso de erro de áudio, loga no console mas não interrompe o jogo
            e.printStackTrace();
        }
    }

    public static void playVictory() {
        // Arquivo esperado: res/victory.mp3
        playSound("victory.wav");
    }

    public static void playDefeat() {
        // Arquivo esperado: res/defeat.mp3
        playSound("defeat.wav");
    }
}
