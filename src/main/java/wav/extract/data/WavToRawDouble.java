package main.java.wav.extract.data;

import java.io.File;



public class WavToRawDouble {

    public static double[] getAudioData(String soundFile)
    {

        double[] dataSound = new double[0];

        try
        {
            // Janis eksamen IS-105
            // 2 Timer : Språk FA CFG Turing, shannon?, socket Client / server
            //
            // 1 Time : FA, CFG, Touring machine, PDA, Stack
            //
            // 2 Timer : Tolke wireshark, kodeeksempel,

            // UDP: Man vet ikke om pakken kommer frem

            // Open the wav file specified as the first argument
            WavFile wavFile = WavFile.openWavFile(new File(soundFile));
            dataSound = new double[((int) (wavFile.getNumChannels()*wavFile.getNumFrames()))];
            // Display information about the wav file
            wavFile.display();

            // Get the number of audio channels in the wav file
            int numChannels = wavFile.getNumChannels();

            // Create a buffer of 100 frames
            double[] buffer = new double[100 * numChannels];

            int framesRead;
            double min = Double.MAX_VALUE;
            double max = Double.MIN_VALUE;
            do
            {
                // Read frames into buffer
                framesRead = wavFile.readFrames(buffer, 100); // In wav 100 is standard

                // Loop through frames and look for minimum and maximum value
                for (int s=0 ; s<framesRead * numChannels ; s++)
                {
                    if (buffer[s] > max) max = buffer[s];

                    if (buffer[s] < min) min = buffer[s];
                    //System.out.println(buffer[s]); // Remove comment for slow code :)
                    //Store data in an array
                    dataSound[s] = buffer[s];
                }
                
            }
            while (framesRead != 0);

            // Close the wavFile
            wavFile.close();

            // Output the minimum and maximum value
            System.out.printf("Min: %f, Max: %f\n", min, max);
        }
        catch (Exception e)
        {
            System.err.println(e);
        }
        return dataSound;
    }
}