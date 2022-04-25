package main.java;

import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

public class MusicAnalyze {
    public static void main(String[] args) {

        int totalFramesRead = 0;
        File fileIn = new File("./music/AnimalsRemix.mp3");
        try {
            AudioInputStream wavStream = AudioSystem.getAudioInputStream(fileIn);

            int bytesPerFrame = wavStream.getFormat().getFrameSize();
            int numBytes = 1024 * bytesPerFrame;
            byte[] audioBytes = new byte[numBytes];
            try {
                int numBytesRead = 0;

                //My simplified Test part
                System.out.println(wavStream.available());
                while ((numBytesRead = wavStream.read(audioBytes)) != -1) {
                    System.out.println(wavStream.available());
                }
                //End of my test part

            } catch (Exception ignored) {}
            System.out.println("finished");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}