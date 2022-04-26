package main.java.wav.extract.data;

import java.io.*;

public class WavToRawDouble {

    public static double[] getAudioData(String soundFile)
    {

        double[] dataSound = new double[0];

        try
        {
            // Open the wav file specified as the first argument
            WavFile wavFile = WavFile.openWavFile(new File(soundFile));

            // Display information about the wav file
            wavFile.display();

            dataSound = new double[((int) (wavFile.getNumChannels()*wavFile.getNumFrames()))];
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
                framesRead = wavFile.readFrames(buffer, 100);

                // Loop through frames and look for minimum and maximum value
                for (int s=0 ; s<framesRead * numChannels ; s++)
                {
                    if (buffer[s] > max) max = buffer[s];

                    if (buffer[s] < min) min = buffer[s];

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