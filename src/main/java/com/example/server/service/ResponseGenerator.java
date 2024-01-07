package com.example.server.service;

import com.theokanning.openai.*;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.edit.EditRequest;
import com.theokanning.openai.service.OpenAiService;
import org.apache.tools.ant.types.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ResponseGenerator {

//    private NLPAlgorithm nlpAlgorithm;
//    private NLGAlgorithm nlgAlgorithm;

    private String input;
    private String output;

    @Value("${API_KEY}")
    private String API_KEY;


    @Autowired
    public ResponseGenerator(){

    }

    public void generateResponse(){

        System.out.println("hey " + this.API_KEY);
        OpenAiService service = new OpenAiService(this.API_KEY);


        CompletionRequest completionRequest = CompletionRequest.builder()
                .prompt(this.input)
                .temperature(0.7)
                .maxTokens(10)
                .model("text-ada-001")
                .echo(true)
                .build();


//        service.createCompletion(completionRequest).getChoices().forEach( System.out::println );
        String response = service.createCompletion(completionRequest).getChoices().get(0).getText();

        String desiredOutput = response.split("\n\n").length > 1 ?
                                        response.split("\n\n")[1]         // removes the prompt given by the user ex. "what color is the sky?  The sky is blue"
                                                    :
                                        response;


        this.output = desiredOutput;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getResponse(){

        return this.output;
    }


}
