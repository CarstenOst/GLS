package main.java;
import main.java.wav.extract.data.WavSlowToRawDouble;
import main.java.wav.extract.data.WavToRawDouble;

import java.util.List;


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

public class Main {
    public static void main(String[] args) {
        List soundData = WavSlowToRawDouble.getAudioData("./music/AnimalsRemix.wav");
        System.out.println("Lenght is " + soundData.size());
        System.out.println("\n\n\n");
        System.out.println("Lenght is " + WavToRawDouble.getAudioData("./music/AnimalsRemix.wav").length);
    }
}