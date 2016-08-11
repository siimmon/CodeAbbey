package solutionOneThirtyOne;

/**
 * Created by Simon on 11/08/2016.
 */

import java.util.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collector;

public class solutionOneThirtyOne {
    public static void main(String[] args) throws IOException {
        solutionOneThirtyOne a = new solutionOneThirtyOne();
        String s = "C:\\Users\\Simon\\IdeaProjects\\CodeAbbey\\src\\solutionOneThirtyOne\\words.txt";
        String[] wordsFromDictionary = a.readFile(s);
        int size = 17;
        String input =
                        "8 t a a w c e i r r h m g i\n" +
                        "8 g m i l j s r q u z p m y\n" +
                        "7 j e a x a k l b i n g\n" +
                        "8 l c w m f o l o f e p u r\n" +
                        "5 e a f r s r t k\n" +
                        "6 o r b e l i u j s e\n" +
                        "5 i l a f r r n k\n" +
                        "6 a s y r h d x r s n\n" +
                        "12 o a t c c f z w v s i a i r j s t n s\n" +
                        "9 q t i t n t t b u n e i z e\n" +
                        "12 a a q g b g f r e d e r e e l p t p c\n" +
                        "9 m t y l g p s k g t i n i n\n" +
                        "9 r n g c z p e a r y t e l o\n" +
                        "9 n a r h e q i a o f t z c e\n" +
                        "10 o o a i k s o z n i g t i n c s\n" +
                        "9 n u q u n c x s t o o a p c\n" +
                        "10 g i c l m o n v l p n e c u a n";
        String[] inputSplit = input.split("\n");

        for (int i = 0; i < size; i++) {
            int count = 0;
            String lets = inputSplit[i];

            String[] letsSplit = lets.split(" ");
            int wordLength = Integer.parseInt(letsSplit[0]);
            ArrayList<Character> wordChars = new ArrayList<Character>();

            for (int j = 1; j < letsSplit.length; j++) {
                wordChars.add(letsSplit[j].charAt(0));
            }

            for (int j = 0; j < wordsFromDictionary.length; j++) {
                if (wordsFromDictionary[j].length() == wordLength) {
                    if (a.isInChars(wordChars,wordsFromDictionary[j])) {
                        count++;
                        //System.out.print(wordsFromDictionary[j]+" ");
                    }
                }

            }
            System.out.print(count+" ");

        }
    }


    public String[] readFile (String filename) throws IOException {
        String[] words = {};
        try {
            FileReader fr = new FileReader(filename);
            FileReader fr2 = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            BufferedReader br2 = new BufferedReader(fr2);

            String S;
            String Sline[];
            int lines = 0;

            while ((S = br.readLine()) != null) {         /* while line in buffer is not null then lines++ */
                lines++;
            }

            words = new String[lines];

            int j = 0;

            while ((S = br2.readLine()) != null) {
                words[j] = S;
                j++;
            }

            fr.close();
            fr2.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file");
        }
        return (words);
    }

    public boolean isInChars(ArrayList<Character> listOfChars, String dictionaryWord) {
        char[] dictionaryWordChars = dictionaryWord.toCharArray();
        ArrayList c1 = new ArrayList(listOfChars);
        for (int i = 0; i < dictionaryWordChars.length; i++) {
            if (c1.isEmpty() || !c1.contains(Character.valueOf(dictionaryWordChars[i]))) {
                return false;
            } else {
                c1.remove(Character.valueOf(dictionaryWordChars[i]));
            }
            //listOfChars.remove(Character.valueOf(dictionaryWordChars[i]));
        }
        return true;
    }

}
