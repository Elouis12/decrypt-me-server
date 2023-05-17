package com.example.server.model;

public class ClientResponse {

    private final String message;
    private final String cipher;
    private final int shift;
    private final String cipherToUse;

    public ClientResponse(String message, String cipher, int shift, String cipherToUse){

        this.message = message;
        this.cipher = cipher;
        this.shift = shift;
        this.cipherToUse = cipherToUse;
    }


    public String getMessage() {
        return message;
    }

    public String getCipher() {
        return cipher;
    }

    public int getShift() {
        return shift;
    }

    public String getCipherToUse() {
        return cipherToUse;
    }
}
