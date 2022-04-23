package main.java;
/*
 *
 *
 *  Java program to play an Audio
 *  Supports only AIFC, AIFF, AU, SND and WAVE formats
 *
 *  Stolen from: https://www.geeksforgeeks.org/play-audio-file-using-java/
 *  Later improved because it was baad
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
    private static final int MICROSECONDS_PER_SECOND = 1_000_000;

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

    public static void main(String[] args) throws InputMismatchException
    {
        try
        {
            filePath = "./music/AnimalsRemix.wav";
            WaveMusic audioPlayer = new WaveMusic();

            audioPlayer.play();
            Scanner sc = new Scanner(System.in);

            while (true)
            {
                clearConsole();
                consoleText();

                try {
                    int c = sc.nextInt();
                    audioPlayer.gotoChoice(c);
                    if (c == 3)
                        break;
                    // If the user doesn't use numbers
                }catch (Exception e){
                    print("Use numbers dummy \n");
                    break;
                }
            }
            sc.close();
        }
        catch (Exception ex)
        {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }

    private static void consoleText(){
        System.out.println("1. play/pause");
        System.out.println("2. restart");
        System.out.println("3. stop");
        System.out.println("4. Jump to specific time");
    }

    private static void clearConsole() {System.out.println("\n\n\n\n\n\n\n\n\n");}

    private void gotoChoice(int c)
            throws InputMismatchException
    {
        switch (c) {
            case 1 -> playPause();
            case 2 -> restart();
            case 3 -> stop();
            case 4 -> preJump(); // The guy that originally wrote this had the preJump() code in here, which was not following common rules
        }
    }

    private static void print(String s){
        System.out.println(s);
    }

    // Method to play the audio
    private void play()
    {
        clip.start();
    }

    // Method to play/pause the audio
    private void playPause()
    {
        if (!clip.isRunning())
        {
            this.play();
            return;
        }
        clip.stop();
    }

    // Method to restart the audio
    private void restart()
    {
        clip.setMicrosecondPosition(0);

        if(!clip.isRunning()){
            this.play();
        }
    }

    // Method to stop the audio
    private void stop() //throws UnsupportedAudioFileException, IOException, LineUnavailableException
    {
        clip.stop();
        clip.close();
    }

    private void preJump(){

        int sampleRate = Math.round(clip.getFramePosition()/clip.getFormat().getSampleRate());
        long currentClipSecond = clip.getMicrosecondLength()/MICROSECONDS_PER_SECOND;

        clearConsole();

        System.out.println(clip.getFormat().getSampleRate());
        System.out.println("Enter wanted time, current = (" + sampleRate + " of " + currentClipSecond + ") seconds");

        Scanner sc = new Scanner(System.in);

        try {
            long c1 = sc.nextLong();
            jump(c1);
        }
        catch (Exception e) {
            print("Use numbers dummy \n");
            gotoChoice(4);
        }
    }

    // Method to jump over a specific part
    private void jump(long c)
    {
        long seconds = clip.getMicrosecondLength()/MICROSECONDS_PER_SECOND;
        if (c >= 0 && c < seconds)
        {
            // c is getting transformed into microseconds
            c *= MICROSECONDS_PER_SECOND;

            clip.stop();
            clip.setMicrosecondPosition(c);
            this.play();
        }
    }
}