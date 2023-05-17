package com.example.server.service;

public interface Cipher {

    public String cipher();
    public String encrypt(String message);
    public String decrypt(String message);
}
