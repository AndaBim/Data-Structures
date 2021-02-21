package com.company;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

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
        int[] emptyArrForCharacterCount = new int[12];

        for (int j = 0; j < emptyArrForCharacterCount.length; j++) {
            int charCounter2 = 0;
            for (String word : randomNames) {
                if (j == word.length()) {
                    charCounter2++;
                }
            }
            emptyArrForCharacterCount[j] = charCounter2;
            if (charCounter2 != 0) {
                System.out.println("There are " + emptyArrForCharacterCount[j] + " words with " + j + " characters.");
            }
        }

        //sorting alphabetically
        String temp;

        for (int times = 0; times < randomNames.size(); times++) {
            for (int i = 0; i < randomNames.size() - 1; i++) {
                if (randomNames.get(i).compareToIgnoreCase(randomNames.get(i + 1)) > 0) {
                    temp = randomNames.get(i);
                    randomNames.set(i, randomNames.get(i + 1));
                    randomNames.set(i + 1, temp);
                }
            }
        }
        for (String word : randomNames) {
            System.out.println(word);
        }
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
        for (Map.Entry<String, Integer> entry : productList.entrySet())
        {
            if(entry.getValue() < cheapestPrice)
            {
                cheapestPrice = entry.getValue();
                cheapestProduct = entry.getKey();
                }
        }
        System.out.println("The cheapest product is " + cheapestProduct + " and it costs " + productList.get(cheapestProduct) + " euros.");

        //which one is the most expensive product
        int dearestPrice = Integer.MIN_VALUE;
        String dearestProduct = "unknown";
        for(Map.Entry<String, Integer> entry1 : productList.entrySet())
        {
            if(entry1.getValue() > dearestPrice)
            {
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
        for (Map.Entry<String, Integer> entry1 : listOfProducts.entrySet())
        {
            if(entry1.getValue() < cheapestPrice1)
            {
                cheapestPrice1 = entry1.getValue();
                cheapestProduct1 = entry1.getKey();
                }
        }
        System.out.println("The cheapest product is " + cheapestProduct1 + " and it costs " + listOfProducts.get(cheapestProduct1) + " euros.");
    }
    //Since it seems that everything in HashTable works the same as in HashMap, I stopped doing copy+paste. I checked on the net that merge is also with .putAll
    //so I saved some time in not repeating actions, but will spend some time trying to do sorting the values in ascending order.

    public static void main(String[] args) {
        Assignment1();
        Assignment2();
        Assignment3();
    }
}
