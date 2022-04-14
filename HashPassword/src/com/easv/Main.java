package com.easv;

import com.easv.util.crytographic.BCrypt;
import java.security.NoSuchAlgorithmException;

public class Main {

    public static void main(String[] args) throws NoSuchAlgorithmException {

        String password = "123456";

        // hash + salt one-liner
        // String hashed = BCrypt.hashpw(password, BCrypt.gensalt());

        // Randomly generated salt
        // gensalt's log_rounds parameter determines the complexity
        // the work factor is 2**log_rounds, and the default is 10
        String salt = BCrypt.gensalt(10);

        // Hash a password for the first time
        // Store this value in DB. Salt is included, so no need for separate salt column in DB
        String hashed = BCrypt.hashpw(password, salt);

        // Output the salt + hash
        System.out.println("Generated salt for (" + password + "):" + salt);
        System.out.println("Hashed password for (" + password + "):" + hashed);

        // Check that an unencrypted password matches one that has
        // previously been hashed
        if (BCrypt.checkpw("123456", hashed))
            System.out.println("It matches");
        else
            System.out.println("It does not match");
    }
}
