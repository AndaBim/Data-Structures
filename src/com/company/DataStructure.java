package com.company;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.Scanner;
import java.util.Stack;

public class DataStructure {

    static void Assignment1() {
        ArrayList<String> randomNames = new ArrayList<String>();
        randomNames.add("Computer");
        randomNames.add("Plate");
        randomNames.add("Chair");
        randomNames.add("Girl");
        randomNames.add("Boy");
        randomNames.add("Cat");
        randomNames.add("Dog");
        randomNames.add("Shirt");
        randomNames.add("Determination");

        int startsWithCCount = 0;
        int endsWithECount = 0;
        int valuesWithLengthOf5Count = 0;
        int valuesCountainingEcount = 0;
        boolean isThereSubStringTe = false;

        for (int i = 0; i < randomNames.size(); i++) {

            if (randomNames.get(i).charAt(0) == 'C') {
                startsWithCCount++;
            }

            if (randomNames.get(i).charAt(randomNames.get(i).length() - 1) == 'e') {
                endsWithECount++;
            }

            if (randomNames.get(i).length() == 5) {
                valuesWithLengthOf5Count++;
            }

            if (randomNames.get(i).contains("e")) {
                valuesCountainingEcount++;
            }

            if (randomNames.get(i).contains("te")) {
                isThereSubStringTe = true;
            }

        }
        System.out.println("There are " + startsWithCCount + " value(-s) starting with a 'C'. ");
        System.out.println("There are " + endsWithECount + " value(-s) ending with an 'e'.");
        System.out.println("There are " + valuesWithLengthOf5Count + " value(-s) with the length of 5.");
        System.out.println("There are " + valuesCountainingEcount + " value(-s) containing letter 'e'");
        if (isThereSubStringTe) {
            System.out.println("There are values containing subString 'te'.");
        } else {
            System.out.println("Very sad news, no substring 'te' found");
        }

        //histogram
        int[] arrForCountedWords = new int[12];

        for (int j = 0; j < arrForCountedWords.length; j++) {
            int charCounter2 = 0;
            for (String word : randomNames) {
                if (j == word.length()) {
                    charCounter2++;
                }
            }
            arrForCountedWords[j] = charCounter2;
            if (charCounter2 != 0) {
                System.out.println("There are " + arrForCountedWords[j] + " words with " + j + " characters.");
            }
        }

        //sorting alphabetically
        String temp;

        for (int times = 0; times < randomNames.size(); times++) { //times necessary to go through the list
            for (int i = 0; i < randomNames.size() - 1 - times; i++) { //going through the list minus last element minus last looptime (or the number of elements already sorted)
                if (randomNames.get(i).compareToIgnoreCase(randomNames.get(i + 1)) > 0) { //compare>0 if the first is larger; compare<0 if second is larger; compare=0 if equal
                    temp = randomNames.get(i);
                    randomNames.set(i, randomNames.get(i + 1)); //changing i-th element to i+1 element
                    randomNames.set(i + 1, temp);
                }
            }
        }
        for (String word : randomNames) {
            System.out.println(word);
        }
        System.out.println();
    }

    //Start of Assignment 2
    static boolean checkPalindrome(String sent) {
        sent = sent.replaceAll("[^a-zA-Z]", "").toLowerCase();

        boolean isPalindrome = true;
        int i = 0;
        int k = sent.length() - 1;

        while (i < k) {
            if (sent.charAt(i) != sent.charAt(k)) {
                isPalindrome = false;

                break;
            } else {
                i++;
                k--;
            }

        }
        return isPalindrome;
    }

    static void Assignment2() {
        Stack<String> sentences = new Stack<>();
        sentences.push("Mom");
        sentences.push("Was it a car or a cat I saw?");
        sentences.push("Madam, in Eden, I’m Adam.");
        sentences.push("Yo, banana boy!");
        sentences.push("Is Java great or what?");

        for (String sent : sentences) {
            System.out.println(sent);
            if (checkPalindrome(sent)) {
                System.out.println("This sentence is a palindrome");
            } else {
                System.out.println("This sentence is not a palindrome");
            }
        }
        BlockingQueue<String> sentences1 = new ArrayBlockingQueue<String>(5);
        sentences1.add("Mom");
        sentences1.add("Was it a car or a cat I saw?");
        sentences1.add("Madam, in Eden, I’m Adam.");
        sentences1.add("Yo, banana boy!");
        sentences1.add("Is Java great or what?");

        for (String sent1 : sentences1) {
            System.out.println(sent1);
            if (checkPalindrome(sent1)) {
                System.out.println("This sentence is a palindrome");
            } else {
                System.out.println("This sentence is not a palindrome");
            }
        }

        System.out.print("Enter any string:");
        Scanner in = new Scanner(System.in);
        String inputString = in.nextLine();
        Stack stack = new Stack();

        for (int i = 0; i < inputString.length(); i++) {
            stack.push(inputString.charAt(i));
        }

        String reverseString = "";

        while (!stack.isEmpty()) {
            reverseString = reverseString + stack.pop();
        }

        if (inputString.equals(reverseString))
            System.out.println("The input String is a palindrome.");
        else
            System.out.println("The input String is not a palindrome.");

    }


    static void Assignment3() {
        HashMap<String, Integer> productList = new HashMap<String, Integer>();
        productList.put("Eggs", 2);
        productList.put("Milk", 1);
        productList.put("Wine", 8);
        productList.put("Bread", 3);
        productList.put("Cheese", 11);
        productList.put("Grapes", 4);
        productList.put("Salmon", 19);
        productList.put("Basket", 0);
        productList.put("Napkins", 5);

        //how many products cost less than 1
        int valueCount = 0;
        for (Integer value : productList.values())  //found the solution on https://stackoverflow.com/questions/21801203/check-if-hashmap-contains-value-other-than-certain-value
        {
            if (value < 1) {
                valueCount++;
            }
        }
        System.out.println("There are " + valueCount + " products costing less than one euro.");

        //which one is the cheapest product
        int cheapestPrice = Integer.MAX_VALUE;
        String cheapestProduct = "unknown";
        for (Map.Entry<String, Integer> entry : productList.entrySet()) {
            if (entry.getValue() < cheapestPrice) {
                cheapestPrice = entry.getValue();
                cheapestProduct = entry.getKey();
            }
        }
        System.out.println("The cheapest product is " + cheapestProduct + " and it costs " + productList.get(cheapestProduct) + " euros.");

        //which one is the most expensive product
        int dearestPrice = Integer.MIN_VALUE;
        String dearestProduct = "unknown";
        for (Map.Entry<String, Integer> entry1 : productList.entrySet()) {
            if (entry1.getValue() > dearestPrice) {
                dearestPrice = entry1.getValue();
                dearestProduct = entry1.getKey();
            }
        }
        System.out.println("The most expensive product is " + dearestProduct + " and it costs " + productList.get(dearestProduct) + " euros.");

        HashMap<String, Integer> productList2 = new HashMap<String, Integer>();
        productList2.put("Settee", 500);
        productList2.put("Mirror", 270);
        productList2.put("Chairs", 240);
        productList2.put("PC", 800);
        productList2.put("Bike", 600);
        productList2.put("Curtains", 90);
        productList2.put("Vase", 19);
        productList2.put("Petrol", 65);

        //merging both hashmaps

        productList.putAll(productList2);
        System.out.println("The new shopping list contains " + productList.size() + " items.");

        //repeating the same in HashTable

        Hashtable<String, Integer> listOfProducts = new Hashtable<>();
        listOfProducts.put("Eggs", 2);
        listOfProducts.put("Milk", 1);
        listOfProducts.put("Wine", 8);
        listOfProducts.put("Bread", 3);
        listOfProducts.put("Cheese", 11);
        listOfProducts.put("Grapes", 4);
        listOfProducts.put("Salmon", 19);
        listOfProducts.put("Basket", 0);
        listOfProducts.put("Napkins", 5);

        //how many products cost less than 1
        int valueCount1 = 0;
        for (Integer value1 : listOfProducts.values())  //found the solution on https://stackoverflow.com/questions/21801203/check-if-hashmap-contains-value-other-than-certain-value
        {
            if (value1 < 1) {
                valueCount1++;
            }
        }
        System.out.println("There are " + valueCount1 + " products costing less than one euro.");

        //which one is the cheapest product
        int cheapestPrice1 = Integer.MAX_VALUE;
        String cheapestProduct1 = "unknown";
        for (Map.Entry<String, Integer> entry1 : listOfProducts.entrySet()) {
            if (entry1.getValue() < cheapestPrice1) {
                cheapestPrice1 = entry1.getValue();
                cheapestProduct1 = entry1.getKey();
            }
        }
        System.out.println("The cheapest product is " + cheapestProduct1 + " and it costs " + listOfProducts.get(cheapestProduct1) + " euros.");
    }
    //Since it seems that everything in HashTable works the same as in HashMap, I stopped doing copy+paste. I checked on the net that merge is also with .putAll

    public static void main(String[] args) {
//        Assignment1();
//        Assignment2();
//        Assignment3();

    }

    public static class PalindromeCheckUsingStack { // for this and the next palindrome check I worked with: https://beginnersbook.com/2014/01/java-program-to-check-palindrome-string/

        public static void main(String[] args) {

            System.out.println("Enter any sentence you wish to check for a palindrome: ");
            Scanner input = new Scanner(System.in);
            String inputString = input.nextLine();

            inputString = inputString.toLowerCase();
            String inputStringToLetters = inputString.replaceAll("[^a-z]", "");

            Stack stack = new Stack();

            for (int i = 0; i < inputString.length(); i++) {
                stack.push(inputString.charAt(i));
            }

            String reverseInputStringLetters = "";

            while (!stack.isEmpty()) {
                reverseInputStringLetters = reverseInputStringLetters + stack.pop();
            }

            if (inputStringToLetters.equals(reverseInputStringLetters))
                System.out.println("This sentence is a palindrome.");
            else
                System.out.println("This sentence is not a palindrome.");
        }

    }

    public static class PalindromeUsingQueue {
        public static void main(String[] args) {
            System.out.print("Enter any sentence you wish to check for a palindrome: ");
            Scanner in = new Scanner(System.in);
            String inputSentence = in.nextLine();
            inputSentence = inputSentence.toLowerCase();

            Queue queue = new LinkedList();

            for (int i = inputSentence.length() - 1; i >= 0; i--) {
                queue.add(inputSentence.charAt(i));
            }

            String reverseSentence = "";

            while (!queue.isEmpty()) {
                reverseSentence = reverseSentence + queue.remove();
            }
            if (inputSentence.equals(reverseSentence))
                System.out.println("The input sentence is a palindrome.");
            else
                System.out.println("The input sentence is not a palindrome.");

        }

    }
}




