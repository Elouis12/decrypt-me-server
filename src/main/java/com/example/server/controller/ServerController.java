package com.example.server.controller;

import com.example.server.model.ClientResponse;
import com.example.server.service.Cipher;
import com.example.server.model.ServerResponse;
import com.example.server.service.CipherFactory;
import com.example.server.service.ResponseGenerator;
import com.example.server.service.ResponseHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.tomcat.util.json.ParseException;
import org.json.JSONException;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")

// handling routes for user
@RestController
public class ServerController {


    // RETRIEVE CLIENT RESPONSE
    @PostMapping("/client-prompt-response")
    public ServerResponse sendEncryptedResponse(@RequestBody ClientResponse clientResponse) {

        return ResponseHandler.handleClientPromptResponse(clientResponse);

    }

    // CHECK THE CLIENT's DECRYPTED STRING
    @PostMapping("/client-decryption-response")
    public ServerResponse checkDecryptedResponse(@RequestBody ClientResponse clientResponse){

        return ResponseHandler.handleClientDecryptionResponse(clientResponse);

    }



    // CHECK THE CLIENT's DECRYPTED STRING
    @GetMapping("/decrypted-response")
    public String getDecryptedResponse(int shift){

        return ResponseHandler.handleGetDecryptedMessage(shift);
    }

}
