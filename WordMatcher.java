// Skyler Hallinan
// 8/18/18

import java.util.*;

// This program simulates a game based on 'Bomb Party'.
// In the game, the user is given a three letter string, and 
// must input an english word containing this string before
// a timer goes down, to continue the game.
public class WordMatcher {
   
   // Amount of letters in string given to user.
   public static final int SUBSTRING_SIZE = 3;
   
   // Time that client has to input given word
   public static final int TIME = 30;
   
   // Random object to generate indeces.
   private Random randomGenerator;
   
   // String given to client to create a word from.
   private String substring;
   
   // Set of all strings previously generated.
   private Set<String> usedStrings;
   
   // List to hold all words in the dictionary.
   private List<String> dictionary;
   
   // Post: Creates a new Word Matcher game from the input from the scanner.
   //       Words must be on a new line
   public WordMatcher(List<String> dict) {
      dictionary = dict;
      // timer = new Timer();
      randomGenerator = new Random();
      usedStrings = new HashSet<String>();
   }
   
   // Pre:  All words in the dictionary are the size of 
   //       SUBSTRING_SIZE or larger.
   // Post: Generates the substring that the user must guess. 
   //       Substring must not have occured before.
   public void generate() {
      int index = randomGenerator.nextInt(dictionary.size());
      String word = dictionary.get(index);
      System.out.println(word);
      
      if (word.length() < SUBSTRING_SIZE) {
         throw new IllegalArgumentException("Word too short!");
      }
         
      else if (word.length() == SUBSTRING_SIZE) {
         substring = word;
      }
         
      else {
         int wordIndex = randomGenerator.nextInt(word.length() - SUBSTRING_SIZE + 1);
         substring = word.substring(wordIndex, wordIndex + SUBSTRING_SIZE);
      }
      
      if (usedStrings.contains(substring)) {
         generate();
      }
      
      usedStrings.add(substring); 
   }
   
   // Post: Returns false if the user sucessfully inputs a word containing
   //       the generated substring, and returns true if they have not.
   public boolean guess(Scanner input) {
      System.out.print("Enter a word that includes \"" + substring + "\": ");
      String userGuess = input.next();
      if (userGuess.contains(substring) && dictionary.contains(userGuess)) {
         return false;
      }
      return true;
   }   
   
}
