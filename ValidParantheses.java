import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Stack;

public class Main {
  /**
   * Iterate through each line of input.
   */
  public static void main(String[] args) throws IOException {
    InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
    BufferedReader in = new BufferedReader(reader);
    String line;
    while ((line = in.readLine()) != null) {
      System.out.println(isValid(line));
    }
  }
  
  static HashMap<Character, Character> mapping = new HashMap<>();
  //put each pair of parantheses in mapping
  static {
    mapping.put('(', ')');
    mapping.put('{', '}');
    mapping.put('[', ']');
  }
  
  public static String isValid(String s) {
    String valid = "True";
    String notValid = "False";
    //use a stack and push each character of s 
    Stack<Character> paranthesis = new Stack<>();
    for(int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      //check if it's already in mapping as a key
      //if so, push on to the stack
      if(mapping.containsKey(ch)) {
        paranthesis.push(mapping.get(ch));
      }
      //if it's in mapping as a value
      //then we need to check if the stack is not empty and the top of the stack
      //isn't that character -> wouldn't be a valid string then
      else if(mapping.containsValue(ch)) {
        if(paranthesis.isEmpty() || paranthesis.pop() != ch) {
          return notValid;
        }
      }
    }
    //at this point we know it's a valid string
    return valid;
  }
  
  
  
}