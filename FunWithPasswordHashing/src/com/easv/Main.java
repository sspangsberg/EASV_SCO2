package com.easv;

// Project imports
import at.favre.lib.crypto.bcrypt.BCrypt;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;


// Java imports
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.sql.SQLOutput;
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
        System.out.println("PBKDF2:\t\t\t" + PBKDF2Example(pw,false));
        System.out.println("Argon2:\t\t\t" + argon2Example(pw));
    }

    /**
     * Example using the BCrypt hash algorithm
     * @param password The input to the algorithm (typically a user password)
     * @return The final output (hash)
     */
    public static String bcryptExample(String password) {

        // Hash password using the specified cost
        int workFactor = 12;

        String bcryptHashString = BCrypt.withDefaults().hashToString(workFactor, password.toCharArray());
        // Example hash: $2a$12$US00g/uMhoSBm.HiuieBjeMtoN69SN.GE25fCpldebzkryUyopws6

        // Verify hash with original password
        BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), bcryptHashString);
        //System.out.println(result);
        return bcryptHashString;
    }


    public static String argon2Example(String password) {

        Argon2 argon2 = Argon2Factory.create();

        try {
            // Hash password
            String argon2Hash = argon2.hash(
                    2,  // iterations (linear).
                    65536,  // memory in KB (64 MB)
                    1,      // parallelism
                    password.toCharArray()
            );

            //System.out.println("Hash: " + argon2Hash);

            // Verify password
            boolean isMatch = argon2.verify(argon2Hash, password.toCharArray());

            //System.out.println("Password matches: " + isMatch);

            return argon2Hash;

        } finally {
            // Wipe password from memory (important for security)
            argon2.wipeArray(password.toCharArray());
        }
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
