package com.example.server.test;

import com.example.server.service.NLPAlgorithm;

import com.simiacryptus.text.gpt2.GPT2Util;
import com.simiacryptus.text.gpt2.TextGenerator;

public class Test {

    public static void main(String[] args) {

        String input = "My name is Ernesto Louis. I like teh color purple.";
        NLPAlgorithm nlpAlgorithm = new NLPAlgorithm(input);

        System.out.println(nlpAlgorithm.getSentences());
        System.out.println(nlpAlgorithm.getWords());
        System.out.println(nlpAlgorithm.getSentiments());
        System.out.println(nlpAlgorithm.getPOS());


        TextGenerator textGenerator = GPT2Util.get345M();
        System.out.println(textGenerator.generateText(1, "once upon a time"));
    }
}
