package com.example.server.test;

import edu.stanford.nlp.dcoref.Document;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreSentence;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import edu.stanford.nlp.simple.*;
import edu.stanford.nlp.util.CoreMap;
import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.util.Span;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;


public class CoreNLPExample {

    private static Properties properties;
    private static String propertyName = "";
    private static StanfordCoreNLP stanfordCoreNLP;


    public static void main(String[] args) throws IOException {


        // Create a new pipeline with the desired annotators
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize, ssplit, pos, lemma, parse, sentiment");


        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

        String text = "My name is Ernesto Louis. I have a dog named scratch and a cat named scruffy. We are trying to live happily ever after.";


        CoreDocument document = new CoreDocument(text);

        // Annotate the document
        pipeline.annotate(document);

        // sentences
        List<CoreSentence> sentences = document.sentences();

        // tokens
//        List<CoreLabel> words = document.tokens();
/*
        for (CoreSentence sentence : sentences) {

            System.out.println(sentence);
        }*/

        // gets the words and parts of speech (pos)
/*        for (CoreLabel word : words) {

            String pos = word.get( CoreAnnotations.PartOfSpeechAnnotation.class );

            System.out.println( word.originalText() + " " + pos);
        }*/

        List< List<CoreLabel> > wordList = new ArrayList<>();
        // gets the words and parts of speech (pos)
        for (CoreSentence sentence2 : sentences) {

//            List<C> list = new ArrayList<>();

            List<CoreLabel> words = sentence2.tokens();

            wordList.add(words);
        }

//        System.out.println(wordList);

        List<Map<String, String>> posList = new ArrayList<>();
        for (List<CoreLabel> words : wordList) {

            Map<String, String> postMap = new HashMap<>();

            for( CoreLabel word : words ){

                String pos = word.get( CoreAnnotations.PartOfSpeechAnnotation.class );

                postMap.put( word.originalText(), pos );

            }

            posList.add( postMap );
        }

        System.out.println( posList );


        // lemmanization - root word
/*        for (CoreLabel word : words) {

            String lemma = word.lemma();

            System.out.println( word.originalText() + " - " + lemma );
        }*/

        // ner - named entity recognition
/*        for (CoreLabel word : words) {

            String ner = word.get(CoreAnnotations.NamedEntityTagAnnotation.class);

            System.out.println( word.originalText() + " - " + ner );
        }*/

        // sentiments
/*        for (CoreSentence sentence : sentences) {

            String sentiment = sentence.sentiment();

            System.out.println( sentiment + " = " + sentence );
        }*/

    }
}
