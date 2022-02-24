package ch11ex12;

import java.io.*;
import javax.sound.sampled.*;
import java.util.Scanner;

public class AudioVolume {
    public static final int HEADER_SIZE = 44; // WAV files have header size of 44 bytes unless file is corrupted
    private File audioFile;

    public void changeVolume(String source, String dest, float scale) {
        File sourceIn = new File(source);
        File sourceOut = new File(dest);

        int BUFFER_SIZE = 10000;
        byte[] header = new byte[HEADER_SIZE]; // stores the header
        byte[] buffer = new byte[BUFFER_SIZE]; // stores the samples

        try (RandomAccessFile fileIn = new RandomAccessFile(sourceIn, "r");
                RandomAccessFile fileOut = new RandomAccessFile(sourceOut, "rw")) {

            // copy header of source to destination file
            int numBytes = fileIn.read(header);
            fileOut.write(header, 0, numBytes);

            // read & write audio samples in blocks of size BUFFER_SIZE
            long seekDistance = 0;
            int bytesToRead = BUFFER_SIZE; // bytes read at a time
            long totalBytesRead = 0; // total bytes read so far

            while (totalBytesRead < fileIn.length()) {
                if (seekDistance + BUFFER_SIZE <= fileIn.length()) {
                    bytesToRead = BUFFER_SIZE;
                } else { // read remaining bytes
                    bytesToRead = (int) (fileIn.length() - totalBytesRead);
                }

                fileIn.seek(seekDistance); // move file pointer forward by seekDistance bytes from start

                // read a block of audio samples into buffer
                int numBytesRead = fileIn.read(buffer, 0, bytesToRead);
                totalBytesRead += numBytesRead;

                for (int i = 0; i < numBytesRead - 1; i++) {
                    // mutiply WAV file samples up or down by floating-point arg scale
                    // within value from 0 to 256 range for 8-bit audio
                    buffer[i] = (byte) (scale * (buffer[i] < 0 ? 256 + (int) buffer[i] : buffer[i]));
                }
                fileOut.write(buffer, 0, numBytesRead); // write buffer to destination
                seekDistance += numBytesRead;
            }
            fileOut.setLength(fileIn.length());

        } catch (FileNotFoundException e) {
            System.err.println("File could not be found" + e.getMessage());
        } catch (IOException e) {
            System.err.println("IOException" + e.getMessage());
        }
    }

    public void setAudioFile(File f) {
        audioFile = f;
    }

    public void play() throws Exception {
        AudioInputStream stream = AudioSystem.getAudioInputStream(audioFile);
        Clip clip = (Clip) AudioSystem.getClip();

        // line listener causes program to exit after play is completed.
        clip.addLineListener(new LineListener() {
            public void update(LineEvent evt) {
                if (evt.getType() == LineEvent.Type.STOP) {
                    System.exit(0);
                }
            }
        });

        clip.open(stream); // open the audio stream and start playing the clip
        clip.start();

        Thread.sleep(1800 * 1000); // program waits here while the music is played
    }

    public static void main(String[] args) {
        AudioVolume controller = new AudioVolume();
        String musicFileIn = "audio/blues.wav";
        String musicFileOut = "audio/bluesVolumeChange.wav";
        System.out.print("Enter float scale from 0.0 silent to 1.0 full volume: ");
        Scanner s = new Scanner(System.in);
        float scaleInput = s.nextFloat();
        controller.changeVolume(musicFileIn, musicFileOut, scaleInput);
        s.close();

        try {
            // File musicFile1 = new File(musicFileIn);
            // controller.setAudioFile(musicFile1);
            File musicFile2 = new File(musicFileOut);
            controller.setAudioFile(musicFile2);
            controller.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// hw5_ch11_p536_pdf541_ex12
