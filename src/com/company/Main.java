package com.company;

import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
//        System.out.println(reverseCharactersAgain("this is a sentence"));
//        String sentence = "The cow jumped over The moon.";
//        System.out.println(removeCharacter(sentence,'o'));
//        System.out.println(firstNonRepeatingCharacter(sentence));
//        System.out.println(firstNonRepeatingCharacter("hello and hi"));
//        System.out.println(containsDuplicates("abcdefghij "));
//        System.out.println(containsDuplicates("abcd efghij "));
//        System.out.println(containsDuplicatesAgain("abcdefghij "));
//        System.out.println(containsDuplicatesAgain("abcd efghij "));
//        System.out.format("fibonnaci %d \n",fibonnaciSum(7));
//        System.out.println(reverseWords(sentence));
//        System.out.println(reverseCharacters(sentence));
//        System.out.println(reverseCharactersRecursively(sentence));
//        System.out.println(Boolean.toString(isPalindrome(sentence)));
//        System.out.println(Boolean.toString(isPalindrome("tattat")));
//        System.out.println(Boolean.toString(isPalindrome("tatdtat")));
//        System.out.println(Boolean.toString(isOdd(3)));
//        System.out.println(Boolean.toString(isOdd(4)));
//        tryHashtable();
//        useAnArray();
//        useMaps();

//        TwoNumbers swapped = swapNumbers(new TwoNumbers(11,2001));
//        System.out.printf("first: %d second: %d \n",swapped.firstNumber,swapped.secondNumber);

//        Kangaroo k = new Kangaroo();
//        Cat c = new Cat();
//        System.out.printf("a kangaroo has %d legs and says %s \n",k.numberOfLegs(),k.makeNoise());
//        System.out.printf("a cat has %d legs and says %s \n",c.numberOfLegs(),c.makeNoise());
//
//        Creature[] creatures = {new Cat(), new Kangaroo(), new Fly()};
//        for(Creature creature:creatures){
//            System.out.println(creature.breathe()+creature.color()+creature.texture()+creature.lengthInFeet()+creature.widthInFeet());
//            if(creature instanceof Animal){
//                System.out.println(creature.toString()+((Animal) creature).makeNoise()+((Animal) creature).numberOfLegs());
//            }
//        }

//        for(String word: phoneWords("3727265")) {
//            System.out.println(word);
//        }
//        System.out.println(encodeString("aabbcddde"));
//        int[] a = {1,5,7,12,18,32};
//        int[] b = {2,4,9,16,27,76,98};
//        int[] c = mergeArrays(a,b);
//
//        for(int i=0;i<c.length;i++) {
//            System.out.println(c[i]);
//        }

//        int[] a = {5, 2, 5, 1, 6, 9, 3, -9, 299, 4888, 2999};
//        int[] b = sortIntegers(a);
//        for(int i=0;i<b.length;i++) {
//            System.out.println(b[i]);
//        }

//        int[] inputValues = {10, 2, 3, 7, 11, 15};
        int[] inputValues = {5, 2, 5, 1, 6, 9, 3, -9, 299, 4888, 2999};
        int inputTarget = 3004;
        int[] answer = indecesSumToTarget(inputValues, inputTarget);
        System.out.printf("first: %d second: %d", answer[0], answer[1]);
    }

    public static int[] indecesSumToTarget(int[] values, int target) {
        int[] indeces = new int[2];

        for( int i=0; i < values.length; i++) {
            for( int j=i+1; j < values.length; j++) {
                if( values[i] + values[j] == target) {
                    indeces[0] = i;
                    indeces[1] = j;
                    break;
                }
            }
        }

        return indeces;
    }


    public static int[] sortIntegers(int[] a) {
        boolean swapped;

        do {
            swapped = false;
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    swapped = true;
                }
            }
        } while(swapped);

        return a;
    }

    public static int[] mergeArrays(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int cpos = 0, apos = 0, bpos = 0;

        while (cpos < c.length) {
            if (apos == a.length) {
                c[cpos] = b[bpos];
                bpos++;
            }
            else if (bpos == b.length) {
                c[cpos] = a[apos];
                apos++;
            }
            else if (a[apos] < b[bpos]) {
                c[cpos] = a[apos];
                apos++;
            } else if (b[bpos] < a[apos]){
                c[cpos] = b[bpos];
                bpos++;
            } else if (a[apos] == b[bpos]) {
                c[cpos] = a[apos];
                apos++;
                cpos++;
                c[cpos] = b[bpos];
                bpos++;
            }

            cpos++;
        }


        return c;
    }

    public static char maxRepeatingCharacter(String s) {
        char[] c = s.toCharArray();

        int count = 1;
        int maxCount = 1;
        char max = c[0];

        for(int i=1; i<c.length; i++) {
            if(c[i] == c[i - 1]) {
                count++;
            } else {
                if(count > maxCount) {
                    maxCount = count;
                    max = c[i - 1];
                }
                count = 1;
            }
        }

        return max;
    }

    public static class TwoNumbers{
        public int firstNumber;
        public int secondNumber;

        public TwoNumbers(int first, int second){
            firstNumber = first;
            secondNumber = second;
        }
    }

    public static TwoNumbers swapNumbers(TwoNumbers initial){
        initial.firstNumber = initial.firstNumber + initial.secondNumber;
        initial.secondNumber = initial.firstNumber - initial.secondNumber;
        initial.firstNumber = -(initial.secondNumber - initial.firstNumber);

        return initial;
    }

    public static String removeCharacter(String sentence, char c){
        String returnSentence="";

        for(int i=0;i<sentence.length();i++){
            if(sentence.charAt(i)!=c){
                returnSentence += sentence.charAt(i);
            }
        }

        return returnSentence;
    }


   private static Character firstNonRepeatingCharacter(String string){
        Hashtable<Character,Integer> characters = new Hashtable<>();

        Character c;
        for(int i=0;i<string.length();i++){
            c = string.charAt(i);
            if(characters.containsKey(c)){
                characters.put(c,characters.get(c)+1);
            }
            else{
                characters.put(c,1);
            }
        }

        for(int i=0;i<string.length();i++){
            c = string.charAt(i);
            if(characters.get(c)==1){
                return c;
            }
        }

        return null;
   }

    private static boolean containsDuplicates(String string){
        char[] characters = string.toCharArray();

        char currentCharacter;
        int characterCount;
        for(int i=0;i<characters.length;i++){
            currentCharacter = characters[i];
            characterCount = 0;
            for(int j=0;j<characters.length;j++){
                if(currentCharacter == characters[j]){
                    characterCount += 1;
                }
            }

            if(characterCount > 1){
                return true;
            }
        }

        return false;
    }

    private static boolean containsDuplicatesAgain(String string) {
        Hashtable<Character,Integer> charCount = new Hashtable<>();

        for(int i=0;i<string.length();i++){
            char c = string.charAt(i);
            if(charCount.containsKey(c)){
                charCount.put(c,charCount.get(c)+1);
            }
            else{
                charCount.put(c,1);
            }
        }

        for(Character key:charCount.keySet()){
            if(charCount.get(key)>1){
                return true;
            }
        }


        return false;
    }




    private static int fibonnaciSum(int n){
        int a=0, b=1, result=1;

        for(int i=0; i<n; i++){
            result = a + b;
            a = b;
            b = result;
        }

        return result;

    }

    private static String reverseWords(String sentence){
        sentence = sentence.replace(".","");
        String[] words = sentence.split(" ");
        String sentenceReversed="";

        for(int i=words.length-1;i>=0;i--){
            sentenceReversed+=words[i];
            if(i!=0){
                sentenceReversed += " ";
            }
        }

        return sentenceReversed + ".";

    }

    private static String reverseCharacters(String sentence){
        char[] letters = sentence.toCharArray();
        String lettersReversed="";

        for(int i=letters.length-1;i>-1;i--){
            lettersReversed += letters[i];
        }

        return lettersReversed;
    }

    private static String reverseCharactersAgain(String sentence){
        String reversed = "";

        for(int i = sentence.length()-1;i>=0;i--){
            reversed += sentence.charAt(i);
        }

        return reversed;
    }

    private static String reverseCharactersRecursively(String sentence){

        if(sentence.length()<2){
            return sentence;
        }


        return sentence.substring(sentence.length()-1) + reverseCharactersRecursively(sentence.substring(0,sentence.length()-1));
    }

    private static boolean isPalindrome(String sentence){

        for(int i=0,j=sentence.length()-1;i < (sentence.length())/2;i++,j--){
            if(sentence.charAt(i)!=sentence.charAt(j)){
                return false;
            }
        }

        return true;

    }

    private static boolean isOdd(int number){
        if(number%2==0){
            return false;
        }
        else{
            return true;
        }
    }

    private static void tryHashtable(){
        Hashtable<String,String> dictionary = new Hashtable<>();
        dictionary.put("dog","a furry big thing");
        dictionary.put("cat","a furry small thing");
        dictionary.put("mouse","a very small fuzzy thing");

        for(String animal:dictionary.keySet()){
            System.out.println(animal+" "+dictionary.get(animal));
        }
    }

    private static void useAnArray(){
        //SORT AN ARRAY USING THE ARRAYS CLASS
        String[] stringArray = {"jim", "bob", "joe", "sam", "doug"};
        Arrays.sort(stringArray);
        for(String name:stringArray){
            System.out.println(name);
        }

        //SET AN ARRAY VALUE USING THE ARRAY CLASS
        int[] numbers = new int[10];
        for(int i=0; i<numbers.length;i++){
            Array.setInt(numbers,i,i+1);
        }
        for(int i:numbers){
            System.out.printf("value:%d \n",i );
        }

        //FILL AN ARRAY WITH VALUES USING THE ARRAYS CLASS
        Arrays.fill(numbers,0);
        for(int i:numbers){
            System.out.printf("value:%d \n",i );
        }

        //SORT A LIST USING THE COLLECTIONS CLASS
        List<String> cities = new ArrayList<>();
        cities.add("seattle");
        cities.add("new york");
        cities.add("los angeles");
        for(String city:cities){
            System.out.println(city);
        }
        Collections.sort(cities);
        for(String city:cities){
            System.out.println(city);
        }
    }

    //TREEMAPS ARE HASHMAPS SORTED IN ASCENDING VALUE BY KEY. HASHMAPS ARE UNORDERED
    private static void useMaps() {
        HashMap<String, String> phoneNumbers = new HashMap<>();
        TreeMap<String, String> phoneNumbersTree = new TreeMap<>();

        phoneNumbers.put("jim", "2053332222");
        phoneNumbersTree.put("jim", "2053332222");
        phoneNumbers.put("bob", "5553332222");
        phoneNumbersTree.put("bob", "5553332222");
        phoneNumbers.put("sam", "5553432222");
        phoneNumbersTree.put("sam", "5553432222");
        phoneNumbers.put("alice", "4553432222");
        phoneNumbersTree.put("alice", "4553432222");

        for (String entry : phoneNumbers.keySet()) {
            String value = phoneNumbers.get(entry);

            System.out.println(entry + " => " + value);
        }
        for (Map.Entry<String, String> entry : phoneNumbersTree.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            System.out.println(key + " => " + value);
        }
    }

    private static List<String> phoneWords(String phoneNumber) throws Exception {
        String[] keys = {"0", "1", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
        List<String> words = new ArrayList<String>();

        if(phoneNumber == null) {
            throw new Exception("NULL PHONE NUMBER");
        }

        if(phoneNumber.length() != 7) {
            throw new Exception("PHONE NUMBER NOT 7 DIGITS");
        }

        Long.parseLong(phoneNumber);

        //  prefix words
        String first = keys[Character.getNumericValue(phoneNumber.charAt(0))];
        String second = keys[Character.getNumericValue(phoneNumber.charAt(1))];
        String third = keys[Character.getNumericValue(phoneNumber.charAt(2))];
        String fourth = keys[Character.getNumericValue(phoneNumber.charAt(3))];
        String fifth = keys[Character.getNumericValue(phoneNumber.charAt(4))];
        String sixth = keys[Character.getNumericValue(phoneNumber.charAt(5))];
        String seventh = keys[Character.getNumericValue(phoneNumber.charAt(6))];

        for(int i=0; i < first.length(); i++) {
            for(int j=0; j < second.length(); j++) {
                for(int k=0; k < third.length(); k++) {
                    for(int l=0; l < fourth.length(); l++) {
                        for (int m=0; m < fifth.length(); m++) {
                            for(int n=0; n < sixth.length(); n++) {
                                for(int o=0; o < seventh.length(); o++) {
                                    String prefixWord = Character.toString(first.charAt(i)) +
                                            Character.toString(second.charAt(j)) +
                                            Character.toString(third.charAt(k))+
                                            Character.toString(fourth.charAt(l))+
                                            Character.toString(fifth.charAt(m))+
                                            Character.toString(sixth.charAt(n))+
                                            Character.toString(seventh.charAt(o));

                                    words.add(prefixWord);
                                }
                            }
                        }
                    }
                }
            }
        }

        return words;
    }

    private static String encodeString(String stringToEncode) {
        String encodedString = "";

        char current;
        int count = 0;
        for(int i=0; i < stringToEncode.length(); i++) {
            current = stringToEncode.charAt(i);
            count += 1;

            if(((i != stringToEncode.length() - 1) && (current != stringToEncode.charAt(i+1))) || i == stringToEncode.length() - 1) {
                encodedString += Character.toString(current);
                if(count > 1) {
                    encodedString += Integer.toString(count);
                }
                count = 0;
            }
            else {
                continue;
            }
        }

        return encodedString;
    }


}
