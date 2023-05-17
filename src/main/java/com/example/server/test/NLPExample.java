package com.example.server.test;

//import opennlp.tools.*;
import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.Span;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class NLPExample {

    public static void main(String[] args) throws IOException {

        String paragraph = "Mike. I have a dog named scratch and a cat named scruffy. We live happily ever after.";

        // get the sentences
        String[] sentences = getSentences(paragraph);

        // get the words of each sentences
        String[][] sentencesWords = getWords(sentences);

        Span[][] names = getNames(sentencesWords);
        System.out.println( Arrays.toString( sentences ) );

        //
        for( String[] words : sentencesWords ){

            System.out.println( Arrays.toString( words ) );

        }

        for( Span[] name : names ){

            System.out.println( Arrays.toString( name ) );

        }

    }

    public static String[] getSentences(String paragraph) throws IOException {

        // load the sentence model detector
        InputStream inputStream = new FileInputStream("C:\\Users\\eloui\\OneDrive\\Documents\\FOLDERS\\PROGRAMMING\\JAVA\\STUFF\\DECRYPT ME\\server\\src\\main\\java\\com\\example\\server\\resources\\en-sent.bin");
        SentenceModel sentenceModel = new SentenceModel(inputStream);

        // instantiate the sentence dectorME class
        SentenceDetectorME detectorME = new SentenceDetectorME(sentenceModel);

        // get the sentences
        String sentences[] = detectorME.sentDetect(paragraph);

        return sentences;

    }

    public static String[][] getWords(String[] sentences) throws IOException {

        InputStream inputStream = new FileInputStream("C:\\Users\\eloui\\OneDrive\\Documents\\FOLDERS\\PROGRAMMING\\JAVA\\STUFF\\DECRYPT ME\\server\\src\\main\\java\\com\\example\\server\\resources\\en-token.bin");
        TokenizerModel tokenModel = new TokenizerModel(inputStream);
        TokenizerME tokenizer = new TokenizerME(tokenModel);

        String[][] sentenceTokens = new String[sentences.length][];

        // for each sentences break up them up into words
        for( int x = 0; x < sentences.length; x++ ){

            sentenceTokens[x] = tokenizer.tokenize(sentences[x]);
        }

        return sentenceTokens;

    }

    public static Span[][] getNames(String[][] words) throws IOException {

        InputStream inputStream = new FileInputStream("C:\\Users\\eloui\\OneDrive\\Documents\\FOLDERS\\PROGRAMMING\\JAVA\\STUFF\\DECRYPT ME\\server\\src\\main\\java\\com\\example\\server\\resources\\en-ner-person.bin");
        TokenNameFinderModel tokenNameFinder = new TokenNameFinderModel(inputStream);
        NameFinderME nameFinder = new NameFinderME(tokenNameFinder);



        Span[][] names = new Span[words.length][];

        for( int x = 0; x < names.length; x++ ){

            names[x] = nameFinder.find(words[x]);

        }

        return names;


    }
}
