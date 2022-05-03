package main.java;


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
    String name = new String("Pluto");
    String name1 = new String("Pluto");

    Dog dog = new Dog(20, name);
    Dog dog1 = new Dog(20, name1);

        System.out.println(name.equals(name1));
        System.out.println(dog.equals(dog1));


/*

        System.out.println("Lenght is " + WavToRawDouble.getAudioData("./music/AnimalsRemix.wav").length);
        //double[] buff = WavToRawDouble.getAudioData("./music/AnimalsRemix.wav");
        System.out.println("\n");

        List soundData = WavSlowToRawDouble.getAudioData("./music/AnimalsRemix.wav");
        System.out.println("Lenght is " + soundData.size());

*/

    }
}