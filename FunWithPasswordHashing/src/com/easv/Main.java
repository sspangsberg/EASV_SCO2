package com.easv;

// Project imports
import com.easv.util.crytographic.BCrypt;

// Java imports
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.xml.bind.DatatypeConverter;


public class Main {

    public static void main(String[] args) {

        String pw = "1234";

        System.out.println("MD5 (128):\t\t" + messageDigestExample(pw,"MD5"));
        System.out.println("SHA-1 (160):\t" + messageDigestExample(pw,"SHA-1"));
        System.out.println("BCrypt (192):\t" + bcryptExample(pw, false));System.out.println("SHA2-256:\t\t" + messageDigestExample(pw,"SHA-256"));
        System.out.println("SHA3-256:\t\t" + messageDigestExample(pw,"SHA3-256"));
        System.out.println("PBKDF2Example:\t" + PBKDF2Example(pw,false));
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


    /**
     *
     * @param salt
     * @param password
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     */
    private static String PBKDF2Example(String password, boolean verbose) {

        try {


            //Create our random salt
            SecureRandom sr = new SecureRandom();
            byte[] salt = new byte[16];
            sr.nextBytes(salt);

            StringBuilder sb = new StringBuilder();
            for (byte b : salt)
                sb.append(b + ",");

            //Create instance of PBKDF2 hashing algorithm - with parameters (256 bits keylength)
            KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 5000, 256);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");

            byte[] hash = factory.generateSecret(spec).getEncoded();
            String output = new BigInteger(1, hash).toString();

            if (verbose) {
                System.out.println("Salt generated:" + sb.toString());
                System.out.println("Hash generated:" + output);
            }

            return output;
        }
        catch (InvalidKeySpecException | NoSuchAlgorithmException err) {
            return err.toString();
        }
    }
}
