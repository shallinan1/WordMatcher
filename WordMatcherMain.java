// Skyler Hallinan
// 8/18/18
import java.util.*;
import java.io.*;

// Plays a game of Word Matcher.
public class WordMatcherMain {
   
   public static void main(String[] args) throws FileNotFoundException {
     System.out.println("Welcome to the Word Matcher game");
     System.out.println("Type \"STOP\" at any point to end the game.");
     
     Scanner console = new Scanner(System.in);
     System.out.print("What is the name of the dictionary file? ");
     Scanner input = new Scanner(new File(console.nextLine()));

     // read dictionary into an ArrayList
     List<String> dictionary = new ArrayList<String>();
     while (input.hasNextLine()) {
        dictionary.add(input.nextLine());
     }
     
     WordMatcher game = new WordMatcher(dictionary);
     
     String userResponse = "y";
     
     while (userResponse.equals("y")) {
        long startTime = System.currentTimeMillis();
        game.generate();
        boolean notAnswered = true;
        while (notAnswered) {
           notAnswered = game.guess(console);
           long elapsed = System.currentTimeMillis() - startTime;
           System.out.println("You've taken " + elapsed / 1000 + "." + elapsed % 10 + "s so far");
        }
        System.out.print("Do you want to play again?(y/n): ");
        userResponse = console.next();
     }        
   }
}
	