package com.easv;

import com.easv.util.crypto.BCrypt;

public class Main {

    public static void main(String[] args) {
        String password = "123456";

        String salt = BCrypt.gensalt(16);

        //hash + salt one-liner
        String hashed = BCrypt.hashpw(password, salt );

        System.out.println("Salt for PW" + password + ": " + salt);
        System.out.println("Hashed PW:" + hashed);

        if (BCrypt.checkpw("12345", hashed))
            System.out.println("It matches :)");
        else
            System.out.println("Wrong credentials");
    }
}



