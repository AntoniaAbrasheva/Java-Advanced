package regularExam_19022022;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class foodFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] vowels = scanner.nextLine().split("\\s+");
        String[] consonants = scanner.nextLine().split("\\s+");

        ArrayDeque<String> vowelsQueue = new ArrayDeque<>();
        ArrayDeque<String> consonantsStack = new ArrayDeque<>();

        fillVowelsQueue(vowels,vowelsQueue);
        fillConsonantsStack(consonants,consonantsStack);


        int wordsCount = 0;
        String pear = "pear";
        String flour = "flour";
        String pork = "pork";
        String olive = "olive";

        List<String> wordsList = new ArrayList<>();

        wordsList.add(pear);
        wordsList.add(flour);
        wordsList.add(pork);
        wordsList.add(olive);

        while (!consonantsStack.isEmpty() && !vowelsQueue.isEmpty()) {

                String currentVowels = vowelsQueue.peek();
                String  currentConsonants = consonantsStack.peek();

            if (pear.contains(currentVowels)) {
                pear = pear.replace(currentVowels, "");
            }
            if (pear.contains(currentConsonants)) {
                pear = pear.replace(currentConsonants, "");
            }
            if (flour.contains(currentVowels)) {
                flour = flour.replace(currentVowels, "");
            }
            if (flour.contains(currentConsonants)) {
                flour = flour.replace(currentConsonants, "");
            }
            if (pork.contains(currentVowels)) {
                pork = pork.replace(currentVowels, "");
            }
            if (pork.contains(currentConsonants)) {
                pork = pork.replace(currentConsonants, "");
            }
            if (olive.contains(currentVowels)) {
                olive = olive.replace(currentVowels, "");
            }
            if (olive.contains(currentConsonants)) {
                olive = olive.replace(currentConsonants, "");
            }
            consonantsStack.pop();
            vowelsQueue.poll();
            vowelsQueue.offer(currentVowels);
        }
        if (pear.equals("")){
            wordsCount++;
        } else {
            wordsList.remove("pear");
        }
        if (flour.equals("")){
            wordsCount++;
        } else {
            wordsList.remove("flour");
        }
        if (pork.equals("")){
            wordsCount++;
        }else {
            wordsList.remove("pork");
        }
        if (olive.equals("")){
            wordsCount++;
        } else {
            wordsList.remove("olive");
        }
        System.out.printf("Words found: %d \n",wordsCount);
        for (String s:wordsList) {
            System.out.println(s);
        }
    }

    private static void fillConsonantsStack(String[] consonants, ArrayDeque<String> consonantsStack) {
        for (String consonant : consonants) {
            consonantsStack.push(consonant);

        }
    }

    private static void fillVowelsQueue(String[] vowels, ArrayDeque<String> vowelsQueue) {
        for (String vowel : vowels) {
            vowelsQueue.offer(vowel);

        }
    }
}


