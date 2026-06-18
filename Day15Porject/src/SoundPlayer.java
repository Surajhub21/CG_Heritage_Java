import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public final class SoundPlayer extends Thread {

    public static final String CORRECT_SOUND_PATH = "src/assets/correct_answer.wav";

    public static void playCorrectAnswerSound() {
            try {

                File soundFile = new File(CORRECT_SOUND_PATH);

                AudioInputStream audioStream =
                        AudioSystem.getAudioInputStream(soundFile);

                Clip clip = AudioSystem.getClip();
                clip.open(audioStream);

                clip.start();

                // Wait until playback finishes
                while (!clip.isRunning())
                    Thread.sleep(10);

                while (clip.isRunning())
                    Thread.sleep(10);

                clip.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    @Override
    public void run() {
        playCorrectAnswerSound();
    }
}

