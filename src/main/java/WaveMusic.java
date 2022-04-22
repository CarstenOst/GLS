package main.java;
/*
 *
 *
 *  Java program to play an Audio
 *  Supports only AIFC, AIFF, AU, SND and WAVE formats
 *
 *  Stolen from: https://www.geeksforgeeks.org/play-audio-file-using-java/
 *
 */

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class WaveMusic
{
    private final Clip clip;
    private AudioInputStream audioInputStream;
    private static String filePath;

    // constructor to initialize streams and clip
    public WaveMusic() throws UnsupportedAudioFileException, IOException, LineUnavailableException
    {
        // create AudioInputStream object
        audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());

        // create clip reference
        clip = AudioSystem.getClip();

        // open audioInputStream to the clip
        clip.open(audioInputStream);

        // Loop
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public static void main(String[] args)
    {
        try
        {
            filePath = "./music/AnimalsRemix.wav";
            WaveMusic audioPlayer = new WaveMusic();

            audioPlayer.play();
            Scanner sc = new Scanner(System.in);

            while (true)
            {
                System.out.println("1. play/pause");
                System.out.println("2. restart");
                System.out.println("3. stop");
                System.out.println("4. Jump to specific time");
                int c = sc.nextInt();
                audioPlayer.gotoChoice(c);
                if (c == 3)
                    break;
            }
            sc.close();
        }
        catch (Exception ex)
        {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }


    private void gotoChoice(int c)
            throws InputMismatchException
    {
        switch (c) {
            case 1 -> playPause();
            case 2 -> restart();
            case 3 -> stop();
            case 4 -> {
                try {
                    long seconds = clip.getMicrosecondLength()/1_000_000;
                    System.out.println("Enter time from (" + 0 +
                            " to " + seconds + ") seconds");
                    Scanner sc = new Scanner(System.in);
                    long c1 = sc.nextLong();
                    jump(c1);
                }
                catch (Exception e) {
                    System.out.println("Use numbers dummy \n" );
                    gotoChoice(5);
                }
            }
        }
    }

    // Method to play the audio
    public void play()
    {
        clip.start();
    }

    // Method to play/pause the audio
    public void playPause()
    {
        if (!clip.isRunning())
        {
            this.play();
            return;
        }
        clip.stop();
    }

    // Method to restart the audio
    public void restart()
    {

        clip.setMicrosecondPosition(0);

        if(!clip.isRunning()){
            this.play();
        }
    }

    // Method to stop the audio
    public void stop() //throws UnsupportedAudioFileException, IOException, LineUnavailableException
    {
        clip.stop();
        clip.close();
    }

    // Method to jump over a specific part
    public void jump(long c)
    {
        long seconds = clip.getMicrosecondLength()/1_000_000L;
        if (c >= 0 && c < seconds)
        {
            // C is getting transformed into microseconds
            c *= 1_000_000;

            clip.stop();
            clip.setMicrosecondPosition(c);
            this.play();
        }
    }
}