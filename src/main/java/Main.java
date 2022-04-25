package main.java;

import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;

/*
*
*   This program is meant to display graphics on projectors
*   making a laser-show when accompanied by music and a hazer (smoke machine)
*   The whole point is making it better than the already existing MusicBeam
*   which uses microphone input. This is trash as it is impossible to foresee
*   when the song is building up for an eventual drop. The solution is to analyze
*   the whole song b4 playing it and displaying graphics. This makes it possible
*   to reduce horrible lag and create a better dramaturgy in the whole song.
*
*   @author Carsten Østergaard
*   @version potatoSeed (V0.0.1)
*   @since 2022.04.21 (YYYY.MM.DD)
*
 */
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List soundData = AudioToDouble.getAudioData("./music/AnimalsRemix.wav");
        System.out.println("Lenght is " + soundData.size());
    }
}