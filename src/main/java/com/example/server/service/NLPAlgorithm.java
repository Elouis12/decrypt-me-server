/*
package com.example.server.service;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreSentence;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.util.Span;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

//@Service
public class NLPAlgorithm {

    private final String input;
    private String output;

    private Properties properties;
    private StanfordCoreNLP NLPPipeline;
    private CoreDocument coreDocument;
    private List<CoreSentence> sentences; // store sentences
    private List< List<CoreLabel> > words; // store each word of each sentence
    private List<Map<String, String>> posList;
    private Map<String, String> sentiments;

    public NLPAlgorithm(String input){

        this.input = input;

        // add the properties
        properties = new Properties();
        properties.setProperty("annotators", "tokenize, ssplit, pos, lemma, parse, sentiment");

        // annotate the document
        coreDocument = new CoreDocument(this.input);

        // create the pipeline
        NLPPipeline = new StanfordCoreNLP(properties);
        NLPPipeline.annotate(this.coreDocument);

        // extract the sentences
        this.extractSentences();

        // extract the words
        this.extractWords();

        //extract POS
        this.extractPOS();

        // extract the sentiments
        this.extractSentiments();
    }


    private void extractSentences(){

        this.sentences = this.coreDocument.sentences();

    }

    private void extractWords(){

        List< List<CoreLabel> > wordList = new ArrayList<>();

        for (CoreSentence sentence : this.getSentences() ) {

            List<CoreLabel> words = sentence.tokens();

            wordList.add(words);
        }

        this.words = wordList;
    }

    private void extractSentiments(){

        Map<String, String> sentiments = new HashMap<>();

        for (CoreSentence sentence : this.getSentences() ) {

            String sentiment = sentence.sentiment();

            sentiments.put(sentence.text(), sentiment);

        }

        this.sentiments = sentiments;
    }

    public Map<String, String> getSentiments(){

        return this.sentiments;
    }

    private void extractPOS(){


        List<Map<String, String>> posList = new ArrayList<>();

        for (List<CoreLabel> words : this.getWords() ) {

            Map<String, String> postMap = new HashMap<>();

            for( CoreLabel word : words ){

                String pos = word.get( CoreAnnotations.PartOfSpeechAnnotation.class );

                postMap.put( word.originalText(), pos );

            }

            posList.add( postMap );
        }

        this.posList = posList;

    }

    public List< Map<String, String> > getPOS(){

        return this.posList;
    }

    public List<Map<String, String>> getNER(){
        return null;
    }


    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public List<CoreSentence> getSentences() {

        return this.sentences;

    }

    public List<List<CoreLabel>> getWords() {

        return words;
    }

    public Span[] getNames(List<CoreLabel> coreLabelList) throws IOException, IOException {

        InputStream inputStream = new FileInputStream("C:\\Users\\eloui\\OneDrive\\Documents\\FOLDERS\\PROGRAMMING\\JAVA\\STUFF\\DECRYPT ME\\server\\src\\main\\java\\com\\example\\server\\resources\\en-ner-person.bin");
        TokenNameFinderModel tokenNameFinder = new TokenNameFinderModel(inputStream);
        NameFinderME nameFinder = new NameFinderME(tokenNameFinder);


        // add to string array
        String[] words = new String[coreLabelList.size()];

        for( int x = 0; x < words.length; x++ ){

            words[x] = coreLabelList.get(x).originalText();
        }

        Span[] names = nameFinder.find(words);


        return names;


    }

}
*/
