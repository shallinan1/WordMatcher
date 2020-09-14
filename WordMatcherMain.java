// Skyler Hallinan
// 8/18/18
import java.util.*;
import java.io.*;

// Plays a game of Word Matcher.
public class WordMatcherMain{
   private static double MAX_TIME = 10*1000;
   
   Timer timer = new Timer();
   
   public static void main(String[] args) throws FileNotFoundException {
     System.out.println("Welcome to the Word Matcher game");
     System.out.println("This game will end when you cannot guess a word in time!");
     
     Scanner console = new Scanner(System.in);
     System.out.print("What is the name of the dictionary file? ");
     Scanner input = new Scanner(new File(console.nextLine()));

     // read dictionary into an ArrayList
     List<String> dictionary = new ArrayList<String>();
     while (input.hasNextLine()) {
        dictionary.add(input.nextLine());
     }
     
     WordMatcher game = new WordMatcher(dictionary);
     
     boolean success = true;
     
     while (success) {
        long startTime = System.currentTimeMillis();
        game.generate();
        boolean notAnswered = true;
        while (notAnswered) {
           notAnswered = game.guess(console);
        }
        long elapsed = System.currentTimeMillis() - startTime;
        System.out.println("You took " + elapsed + " seconds!");
     }        
   }
}
	