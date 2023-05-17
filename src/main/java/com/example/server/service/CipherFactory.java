package com.example.server.service;

public class CipherFactory {

    public static Cipher getCipher(String cipher, int shift){

        if(cipher.equalsIgnoreCase("caesar")){
            return new CaesarCipher(shift);
        } else if(cipher.equalsIgnoreCase("random")){
            return randomCipher(shift);
        } else { // if null
            throw new IllegalArgumentException("Cipher not specified");
        }

    }

    private static Cipher randomCipher(int shift){

        return new CaesarCipher(shift);
    }
}
