import java.io.*;
import java.security.*;
import java.util.Arrays;

public class Main {

    public static byte[] getMessageDigest(String input, String algorithm) throws NoSuchAlgorithmException, NoSuchProviderException {
        MessageDigest md = MessageDigest.getInstance(algorithm);
        return md.digest(input.getBytes());
    }

    public static byte[] getMessageDigestByte(byte[] input, String algorithm) throws NoSuchAlgorithmException, NoSuchProviderException {
        MessageDigest md = MessageDigest.getInstance(algorithm);
        return md.digest(input);
    }

    public static void main(String[] args) {
        long tstart = System.currentTimeMillis();
        String filePath = "ignis-10M.txt";
        byte[] hash = {
                (byte) 0x82, (byte) 0xe1, (byte) 0x41, (byte) 0x69,
                (byte) 0xce, (byte) 0xd3, (byte) 0xbd, (byte) 0x66,
                (byte) 0x12, (byte) 0x33, (byte) 0x6f, (byte) 0xe7,
                (byte) 0x74, (byte) 0xe9, (byte) 0x0d, (byte) 0xc7,
                (byte) 0xeb, (byte) 0x2e, (byte) 0x30, (byte) 0x2f,
                (byte) 0x8b, (byte) 0xcc, (byte) 0x6a, (byte) 0xef,
                (byte) 0x4e, (byte) 0xf4, (byte) 0x6c, (byte) 0xbf,
                (byte) 0x62, (byte) 0x67, (byte) 0xdb, (byte) 0x34
        };

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            String line;
            while ((line = reader.readLine()) != null) {
                String word = "ismsap" + line;
                byte[] MD5_word = getMessageDigest(word, "MD5");
                byte[] SHA256_word = getMessageDigestByte(MD5_word, "SHA-256");

                if (Arrays.equals(SHA256_word, hash)) {
                    System.out.println("Pass is: " + line);
                    long tfinal = System.currentTimeMillis();
                    System.out.println("Duration is : " + (tfinal - tstart));
                    System.exit(0);
                }
            }
            reader.close();
        } catch (IOException | NoSuchAlgorithmException | NoSuchProviderException e) {
            e.printStackTrace();
        }
    }
}
