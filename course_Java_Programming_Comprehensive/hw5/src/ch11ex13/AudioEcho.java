package ch11ex13;

import java.io.*;
import java.math.BigInteger;
import javax.sound.sampled.*;
import java.util.Scanner;

public class AudioEcho {
    public static final int HEADER_SIZE = 44; // WAV files have header size of 44 bytes unless file is corrupted
    private static final int LITTLE_ENDIAN = 0;
    private static final int BIG_ENDIAN = 1;
    private File audioFile;

    // returns integer value of a byte array/each header field
    private int getDecimalValueOfByteArray(byte[] array, int order) {
        if (order == BIG_ENDIAN) { // rightmost byte of multibyte number is stored at the largest index
            BigInteger number = new BigInteger(array);
            return number.intValue();
        } else { // LITTLE_ENDIAN order, leftmost byte stored at largest index
            int length = array.length;
            byte[] array1 = new byte[length];

            // reverse contents of array and put in array1
            int up = 0, down = length - 1;
            while (up <= down) {
                array1[up] = array[down];
                array1[down] = array[up];
                up++;
                down--;
            }
            BigInteger number = new BigInteger(array1);
            return number.intValue();
        }
    }

    private int getSampleRate(File s) {
        byte[] array4 = new byte[4];
        int sampleRate = 0;

        try (FileInputStream fileIn = new FileInputStream(s);
                BufferedInputStream bufferedIn = new BufferedInputStream(fileIn)) {
            bufferedIn.skip(24); // skip the first 24 bytes

            bufferedIn.read(array4); // read sample rate
            // System.out.println("Sample Rate = " + getDecimalValueOfByteArray(array4,
            // LITTLE_ENDIAN));
            sampleRate = getDecimalValueOfByteArray(array4, LITTLE_ENDIAN);

        } catch (FileNotFoundException e) {
            System.err.println("File could not be found" + e.getMessage());
        } catch (IOException e) {
            System.err.println("IOException" + e.getMessage());
        }
        return sampleRate;
    }

    public void createEcho(File source, File dest, int num) {
        int BUFFER_SIZE = 10000;
        byte[] header = new byte[HEADER_SIZE]; // stores the header
        byte[] buffer = new byte[BUFFER_SIZE]; // stores the samples
        int sampleRate = getSampleRate(source);

        try (RandomAccessFile fileIn = new RandomAccessFile(source, "r");
                RandomAccessFile fileOut = new RandomAccessFile(dest, "rw")) {

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
                byte[] temp = buffer.clone();
                totalBytesRead += numBytesRead;

                // Echo
                int N = sampleRate / 8;
                for (int i = N + 1; i < numBytesRead - 1; i++) {
                    // add current sample at index i to a previous sample at index i - n
                    buffer[i] = (byte) (temp[i] + temp[i - N]);
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

        // open the audio stream and start playing the clip
        clip.open(stream);
        clip.start();

        // program waits here while the music is played
        Thread.sleep(1800 * 1000);
    }

    public static void main(String[] args) {
        AudioEcho controller = new AudioEcho();
        File sourceIn = new File("audio/blues.wav");
        File sourceOut = new File("audio/bluesWithEcho.wav");

        System.out.print("Enter sample value: ");
        Scanner s = new Scanner(System.in);
        int numInput = s.nextInt();
        controller.createEcho(sourceIn, sourceOut, numInput);
        s.close();

        try {
            controller.setAudioFile(sourceOut);
            controller.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// hw5_ch11_p536_pdf541_ex13
