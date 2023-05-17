package com.example.server.service;

public class CaesarCipher implements Cipher{

    private final int shift;
    private final String cipher = "caesar";

    public CaesarCipher(int shift){

        this.shift = shift;
    }


    @Override
    public String encrypt(String message) {

        message = message.toLowerCase();
        String result = "";
        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            if (Character.isLetter(ch)) {
                char shifted = (char) ((ch - 'a' + this.shift) % 26 + 'a');
                result += shifted;
            } else {
                result += ch;
            }
        }
        return result;
    }

    @Override
    public String decrypt(String message) {

        message = message.toLowerCase();
        String result = "";
        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            if (Character.isLetter(ch)) {
                char shifted = (char) ((ch - 'a' - shift + 26) % 26 + 'a');
                result += shifted;
            } else {
                result += ch;
            }
        }
        return result;
    }

    @Override
    public String cipher() {
        return this.cipher;
    }
}
