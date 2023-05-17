package com.example.server.model;

public class ServerResponse {

    private String message;
    private String decryptedMessage;
    private String cipher;
    private int shift;
    private boolean correct;
    private static final ServerResponse serverResponse = new ServerResponse();


    public static ServerResponse getInstance(){

        return serverResponse;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDecryptedMessage(){

        return this.decryptedMessage;

    }

    public void setDecryptedMessage(String decryptedMessage){

        this.decryptedMessage = decryptedMessage;

    }

    public String getCipher() {
        return cipher;
    }
    public int getShift() {
        return shift;
    }

    public boolean isCorrect() {
        return this.correct;
    }

    public void setCipher(String cipher) {
        this.cipher = cipher;
    }
    public void setShift(int shift) {
        this.shift = shift;
    }

    // used when telling the user if they got it correct or not
    public void setCorrect(boolean correct){

        this.correct = correct;
    }
}
