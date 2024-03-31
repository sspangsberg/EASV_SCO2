package com.easv;

// Project imports
import com.easv.util.crytographic.BCrypt;

// Java imports
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter;


public class Main {

    public static void main(String[] args) {

        System.out.println("MD5 (128):\t\t" + messageDigestExample("1234","MD5"));
        System.out.println("SHA-1 (160):\t" + messageDigestExample("1234","SHA-23"));
        System.out.println("BCrypt (192):\t" + bcryptExample("1234", true));System.out.println("SHA2-256:\t\t" + messageDigestExample("1234","SHA-256"));
        System.out.println("SHA3-256:\t\t" + messageDigestExample("1234","SHA3-256"));

    }

    /**
     *
     * @param input The input to the algorithm (typically a user password)
     * @param verbose Whether the method prints additional output information (salt, verification etc.)
     * @return The final output (hash)
     */
    public static String bcryptExample(String input, boolean verbose) {
        String salt = BCrypt.gensalt(10);

        //hash + salt one-liner
        String output = BCrypt.hashpw(input, salt);

        if (verbose) {
            System.out.println("Salt for PW" + input + ": " + salt);
            System.out.println("Hashed PW:" + output);

            if (BCrypt.checkpw(input, output))
                System.out.println("It matches :)");
            else
                System.out.println("Wrong credentials");
        }
        return output;
    }


    /**
     *
     * @param input
     * @param algorithm
     * @return
     */
    private static String messageDigestExample(String input, String algorithm) {
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            md.update(input.getBytes());
            byte[] digest = md.digest();

            return DatatypeConverter.printHexBinary(digest).toUpperCase();
        } catch (NoSuchAlgorithmException err) {
            return err.toString();
        }
    }
}
