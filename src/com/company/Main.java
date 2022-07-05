package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    static String databaseFileName = "words.txt";

    public static void main(String[] args) {

        String randomWord = getRandomWord();
        System.out.println(randomWord); //TODO REMOVE THIS

        char[] charArray = new char[randomWord.length()];
        for(int j = 0; j < charArray.length; j++) charArray[j] = '_';
        for(int i = 1; i <= 5; i++){
            Scanner scannerInput = new Scanner(System.in);
            String inputWord = scannerInput.next().toUpperCase(Locale.ROOT);
            if(inputWord.length() != 5){
                System.out.println("WORD MUST BE 5 CHARACTERS LONG!");
                i -= 1;
            }
            else{
                if(inputWord.equals(randomWord)){
                    System.out.println("WIN!");
                    System.exit(0);
                }
                else{
                    for(int j = 0; j < randomWord.length(); j++){
                        for(int k = 0; k < inputWord.length(); k++){
                            if(randomWord.charAt(j) == inputWord.charAt(k)){
                                if(j == k){
                                    charArray[j] = randomWord.charAt(j);
                                    System.out.println("letter and location match: " + randomWord.charAt(j));
                                }
                                else{
                                    System.out.println("letter match: " + randomWord.charAt(j));
                                }
                            }
                        }
                    }
                }
            }
            for(int j = 0; j < charArray.length; j++) System.out.print(charArray[j] + " ");
            System.out.println();
        }
        System.out.println("GAME OVER!");

    }

    public static List<String> getDatabase(){
        List<String> wordList = new ArrayList<String>();
        Scanner databaseFileScanner = null;
        try {
            databaseFileScanner = new Scanner(new File(databaseFileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Database File is Missing!");
            System.exit(0);
        }
        while(databaseFileScanner.hasNextLine()){
            wordList.add(databaseFileScanner.nextLine().toUpperCase(Locale.ROOT));
        }
        return wordList;
    }

    public static String getRandomWord() {
        List<String> wordList = getDatabase();
        int randomValue = new Random().nextInt(wordList.size());
        return wordList.get(randomValue);
    }

}
