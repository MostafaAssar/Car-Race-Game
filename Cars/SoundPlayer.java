package Cars;

import javax.sound.sampled.*;

public class SoundPlayer {
    private Clip clip;

    public void loadSound(String filename) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource(filename));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void MainMusic()
    {
        if (clip != null) {
            clip.setFramePosition(0);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }

    public void playSound() {
        if (clip != null) {
            clip.setFramePosition(0);
            clip.start();
        }
    }

    public void stopSound() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }
    public void releaseSound() {
        if (clip != null) {
            clip.close();
            clip = null; // Set to null to release the reference
        }
    }
}

