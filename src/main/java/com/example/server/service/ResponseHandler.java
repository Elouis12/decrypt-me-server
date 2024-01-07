package com.example.server.service;

import com.example.server.model.ClientResponse;
import com.example.server.model.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
    HANDLES THE VARIOUS RESPONSES
*/
@Service
public class ResponseHandler {


    private final ResponseGenerator responseGenerator;

    @Autowired
    public ResponseHandler(ResponseGenerator responseGenerator) {
        this.responseGenerator = responseGenerator;
    }

    public /*static*/ ServerResponse handleClientPromptResponse(ClientResponse clientResponse) {

        String message = clientResponse.getMessage();
        String clientCipher = clientResponse.getCipher();
        int clientCipherShift = clientResponse.getShift();
        String clientCipherToUse = clientResponse.getCipherToUse();
        String clientDecryptedMessage;

        System.out.println(message + " -1");
        System.out.println(clientCipherShift + " -2");
       // 1. decrypt message if needed
        if (clientCipher != null) {
            clientDecryptedMessage = CipherFactory.getCipher(clientCipher, clientCipherShift).decrypt(message);
        } else {
            // the message was sent unencrypted
            clientDecryptedMessage = message;
        }

        // 2. use NLP algo or OPENAI interface to retrieve a response based on the client's decrypted message
/*
        ResponseGenerator responseGenerator = new ResponseGenerator(clientDecryptedMessage);
        String responseGenerated = responseGenerator.getResponse();// generate a response using AI
*/
//        ResponseGenerator responseGenerator = new ResponseGenerator();
        this.responseGenerator.setInput(clientDecryptedMessage);
        responseGenerator.generateResponse();
        String responseGenerated = responseGenerator.getResponse();// generate a response using AI

        // 3. use specified or random algo to encrypt it
        Cipher cipher = CipherFactory.getCipher(clientCipherToUse, clientCipherShift);
        String encryptedResponse = cipher.encrypt(responseGenerated);

        System.out.println(clientDecryptedMessage + " -3");
        System.out.println(responseGenerated + " -4");
        System.out.println(encryptedResponse + " -5");

        // 4. save it as a server response object
        ServerResponse serverResponse = ServerResponse.getInstance();/* new ServerResponse(encryptedResponse, cipher.cipher());*/
        serverResponse.setMessage( encryptedResponse ); // the message encrypted
        serverResponse.setDecryptedMessage( responseGenerated ); // the message encrypted
        serverResponse.setCipher( cipher.cipher() ); // the cipher the server used
        serverResponse.setShift( clientCipherShift ); // the cipher the shift to be used
        return serverResponse;

    }

    public /*static*/ ServerResponse handleClientDecryptionResponse(ClientResponse clientResponse) {

        String clientMessage = clientResponse.getMessage();
        int clientCipherShift = clientResponse.getShift();

        System.out.println(clientMessage);
        System.out.println(clientCipherShift);
        ServerResponse serverResponse = ServerResponse.getInstance();

        // decrypt the message stored in the server response to check it
/*        String originalText = CipherFactory.getCipher( serverResponse.getCipher(), clientCipherShift ).decrypt( serverResponse.getMessage() );
        String originalText2 = CipherFactory.getCipher( serverResponse.getCipher(), clientCipherShift ).encrypt( clientMessage );

        System.out.println(clientMessage + " - " + originalText + " - " + originalText2 + " - " + serverResponse.getMessage());
        System.out.println(clientMessage.equalsIgnoreCase(originalText));*/

        if( clientMessage.equalsIgnoreCase( serverResponse.getDecryptedMessage() ) ){

            serverResponse.setCorrect( true );

        }

        return serverResponse;


    }

    public /*static*/ String handleGetDecryptedMessage(int shift) {


        ServerResponse serverResponse = ServerResponse.getInstance();

        // decrypt the message stored in the server response to check it
        String decryptedText = CipherFactory.getCipher( serverResponse.getCipher(), shift ).decrypt( serverResponse.getMessage() );

        System.out.println(shift + " - the shift");
        System.out.println(serverResponse.getShift() + " - the shift2");
        System.out.println(decryptedText + " - " + serverResponse.getMessage());

        return serverResponse.getDecryptedMessage();


    }

}
