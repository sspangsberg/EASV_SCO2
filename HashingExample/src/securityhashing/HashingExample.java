
package securityhashing;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

/**
 *
 * @author sspangsberg
 */
public class HashingExample
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InvalidKeySpecException, NoSuchAlgorithmException {

        String password = "123456";

        //Create our random salt
        SecureRandom sr = new SecureRandom();
        byte[] salt = new byte[16];
        sr.nextBytes(salt);

        StringBuilder sb = new StringBuilder();
        for (byte b: salt)
            sb.append(b + ",");

        System.out.println("Salt generated:" + sb.toString());

        System.out.println("PBKDF2 hash:" + runPBKDF2Algo(salt, password));
        System.out.println("PBKDF2 hash:" + runPBKDF2Algo(salt, "123456"));
    }

    private static String runPBKDF2Algo(byte[] salt, String password) throws NoSuchAlgorithmException, InvalidKeySpecException {

        //Create instance of PBKDF2 hashing algorithm - with parameters (256 bits keylength)
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 1000, 256);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");

        byte[] hash = factory.generateSecret(spec).getEncoded();

        return new BigInteger(1, hash).toString();
    }
}