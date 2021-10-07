package application;

import java.io.*;
import java.util.Scanner;
public class DictionaryManagement extends DictionaryCommandline {
    public static void insertListFromFile() {
        try {
            Scanner sc = new Scanner(new File("src/dictionaries.txt"));
            while (sc.hasNext()) {
                String wordTarget = sc.nextLine();
                String wordExplain = sc.nextLine();
                listWord.add(new Word(wordTarget, wordExplain));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static String dictionaryLookup(String wordTarget) {
        StringBuilder results = new StringBuilder();
        for (Word word : listWord) {
            if (word.getWordTarget().contains(wordTarget.toLowerCase()) && !wordTarget.equals("")) {
                results.append(word.getWordTarget()).append(":  ").append(word.getWordExplain()).append("\n");
            }
        }
        return results.toString();
    }

    public static String dictionaryShowAllWord() {
        StringBuilder results = new StringBuilder();
        for (Word word : listWord) {
            results.append(word.getWordTarget()).append(":  ").append(word.getWordExplain()).append("\n");
        }
        return results.toString();
    }

    public static void insertWordToFile(String wordTarget, String wordExplain) {
        try {
            FileWriter myWriter = new FileWriter("src/dictionaries.txt", true);
            myWriter.write(wordTarget + "\n");
            myWriter.write(wordExplain + "\n");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
            Word newWord = new Word(wordTarget, wordExplain);
            listWord.add(newWord);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void insertListToFile(){
        try {
            FileWriter myWriter = new FileWriter("src/dictionaries.txt", false);
            for (Word s : listWord) {
                myWriter.write(s.getWordTarget() + "\n");
                myWriter.write(s.getWordExplain() + "\n");
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void deleteWord(String wordTarget) {
        for (Word iWord : listWord) {
            String w = iWord.getWordTarget().toLowerCase();
            if (w.equals(wordTarget)) {
                listWord.remove(iWord);
                System.out.println("Xóa thành công! ");
                insertListToFile();
                break;
            }
        }
    }
}

