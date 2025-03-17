package com.easv;

// Project imports
import at.favre.lib.crypto.bcrypt.BCrypt;

// Java imports
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;


public class Main {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        String pw = "1234";

        System.out.println("MD5 (128):\t\t" + messageDigestExample(pw,"MD5"));
        System.out.println("SHA-1 (160):\t" + messageDigestExample(pw,"SHA-1"));
        System.out.println("BCrypt (192):\t" + bcryptExample(pw));
        System.out.println("SHA2-256:\t\t" + messageDigestExample(pw,"SHA-256"));
        System.out.println("SHA3-256:\t\t" + messageDigestExample(pw,"SHA3-256"));
        System.out.println("PBKDF2Example:\t" + PBKDF2Example(pw,false));
    }

    /**
     * Example using the BCrypt hash algorithm
     * @param password The input to the algorithm (typically a user password)
     * @return The final output (hash)
     */
    public static String bcryptExample(String password) {

        // Hash password using the specified cost
        String bcryptHashString = BCrypt.withDefaults().hashToString(12, password.toCharArray());
        // Example hash: $2a$12$US00g/uMhoSBm.HiuieBjeMtoN69SN.GE25fCpldebzkryUyopws6

        // Verify hash with original password
        BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), bcryptHashString);
        //System.out.println(result);
        return bcryptHashString;
    }


    /**
     *
     * @param input The input to the algorithm (typically a user password)
     * @param algorithm
     * @return The final output (hash)
     */
    private static String messageDigestExample(String input, String algorithm) {
        try {

            // Get a MessageDigest instance based on a specific algorithm
            MessageDigest md = MessageDigest.getInstance(algorithm);

            md.update(input.getBytes());
            byte[] digest = md.digest();

            return new BigInteger(1, digest).toString();

        } catch (NoSuchAlgorithmException err) {
            return err.toString();
        }
    }


    /**
     *
     * @param input The input to the algorithm (typically a user password)
     * @return The final output (hash)
     */
    private static String PBKDF2Example(String input, boolean verbose) {

        try {
            //Create our random salt
            SecureRandom sr = new SecureRandom();
            byte[] salt = new byte[16];
            sr.nextBytes(salt);

            StringBuilder sb = new StringBuilder();
            for (byte b : salt)
                sb.append(b + ",");

            //Create instance of PBKDF2 hashing algorithm - with parameters (256 bits keylength)
            KeySpec spec = new PBEKeySpec(input.toCharArray(), salt, 5000, 256);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");

            byte[] digest = factory.generateSecret(spec).getEncoded();
            String output = new BigInteger(1, digest).toString();

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
