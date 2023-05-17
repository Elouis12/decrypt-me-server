package com.example.server.test;

import simplenlg.framework.*;
import simplenlg.lexicon.*;
import simplenlg.realiser.english.*;
import simplenlg.phrasespec.*;
import simplenlg.features.*;

public class NLGExample {

    public static void main(String[] args) {

        /*// create a lexicon
        Lexicon lexicon = Lexicon.getDefaultLexicon();

        // create a NLG factory
        NLGFactory nlgFactory = new NLGFactory(lexicon);

        // create a realizer
        Realiser realiser = new Realiser(lexicon);

        // create a sentence
        SPhraseSpec sentence = nlgFactory.createClause();

        // set the subject, verb and object
        NPPhraseSpec subject = nlgFactory.createNounPhrase("the", "sun");
        VPPhraseSpec verb = nlgFactory.createVerbPhrase("be");
        verb.setFeature(Feature.TENSE, Tense.PRESENT);
        verb.setFeature(Feature.PERSON, Person.THIRD);
        verb.setFeature(Feature.NUMBER, NumberAgreement.SINGULAR);
        NPPhraseSpec object = nlgFactory.createNounPhrase("nice");

        sentence.setSubject(subject);
        sentence.setVerb(verb);
        sentence.setObject(object);

        // realize the sentence
        String output = realiser.realiseSentence(sentence);

        System.out.println(output);*/

        Lexicon lexicon = Lexicon.getDefaultLexicon();

        // create a NLG factory
        NLGFactory nlgFactory = new NLGFactory(lexicon);

        SPhraseSpec p = nlgFactory.createClause();
        p.setSubject("Mary");
        p.setVerb("chase");
        p.setVerb("chase");
        p.setObject("the monkey");

    }
}
