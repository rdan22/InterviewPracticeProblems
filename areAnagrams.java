import java.io.*; 
import java.util.*;

class Main {

    public static void main(String args[]) 
    { 
        char str1[] = { 'c', 'a', 'r', 'e' }; 
        char str2[] = { 'r', 'a', 'c', 'e' }; 
        if (areAnagrams(str1, str2)) 
            System.out.println("The two strings are anagrams of each other"); 
        else
            System.out.println("The two strings are not anagrams of each other"); 
    }
      
    /* function to check whether two strings are  
    anagram of each other */
    public static boolean areAnagrams(char[] str1, char[] str2) 
    {
        //get lengths of both strings 
        int n1 = str1.length; 
        int n2 = str2.length; 

        // if length not equal, can't be anagrams of each other
        if (n1 != n2) return false;

        //array of the first 26 primes
        int primes[] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        //map of each letter in the alphabet to the primes
        HashMap<Character, Integer> map = new HashMap<>();
        for(char letter = 'a'; letter <='z'; letter++) {
                map.put(letter, primes[letter - 97]);
        }

        int product1 = 1;
        int product2 = 1;
        //multiply each of the characters of each word based on the prime mapping
        //since every integer is a prime or a unique product of primes (fundamental theorem of arithmetic)
        //two words are anagrams if their products are the same
        for (int i = 0; i < n1; i++) {
            product1 *= map.get(str1[i]);
            product2 *= map.get(str2[i]);
        }

        return (product1 == product2); 
    } 
}
     
