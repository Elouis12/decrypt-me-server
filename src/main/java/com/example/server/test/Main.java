package com.example.server.test;

import com.example.server.service.CaesarCipher;

public class Main {

    public static void main(String[] args) {

        CaesarCipher caesarCipher = new CaesarCipher(10);

        String encrypted = caesarCipher.encrypt("the sky is blue.");

        System.out.println( encrypted );

        String decrypted = caesarCipher.decrypt("dro cui sc lveo");

        System.out.println( decrypted );
    }
}
