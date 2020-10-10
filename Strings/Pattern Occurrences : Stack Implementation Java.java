/* Question:
Suppose we have two Strings :- Pattern and Text
pattern: consisting of unique characters
text: consisting of any length

We need to find the number of patterns that can be obtained from text removing each and every occurrence of Pattern in the Text.

Example:

Input : 
Pattern : ABC
Text : ABABCABCC
Output :
3
Occurrences found at: 
4 7 8
Explanation
Occurrences and their removal in the order
1. ABABCABCC
2. ABABCC
3. ABC  */

//Solution 1(simple)

import java.util.*;//Scanner;

public class patternandtext {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String pattern=sc.nextLine();
		String text=sc.nextLine();
		StringBuilder sb=new StringBuilder(pattern);
		int count=0;
		//System.out.println(pattern.indexOf(text));
		while(sb.indexOf(text)!=-1) {
			sb.delete(sb.indexOf(text),sb.indexOf(text)+text.length());
			count++;
		}
        System.out.println(count);
	}

}

//Solution 2
import java.util.ArrayList; 
import java.util.Stack; 
  
class StackImplementation 
{ 
  // custom class for returning multiple values 
  class Data 
  { 
    ArrayList<Integer> present; 
    int count; 
  
    public Data(ArrayList<Integer> present, int count) 
    { 
      this.present = present; 
      this.count = count; 
    } 
  } 
  public Data Solution(char pattern[], char text[]) 
  { 
    // stores the indices for all occurrences 
    ArrayList<Integer> list = new ArrayList<>(); 
    Stack<String>  stack = new Stack<>(); 
  
    // present index pointer searched for in 
    // the entire array of string characters 
    int p = 0; 
  
    //count of all the number of occurrences 
    int counter = 0 ; 
  
    // any random number less than 0 to mark 
    // the previous index where the occurrence 
    // was found 
    int lastOccurrence = -10; 
  
    // traversing all the indexes of the text 
    // searching for possible pattern 
    for (int i = 0; i < text.length; i ++) 
    { 
      // if the present index and the pointer in 
      // the pattern is at same character 
      if(text[i] == pattern[p]) 
      { 
        // and if that character is the end of 
        // the pattern to be found 
        if(text[i] == pattern[pattern.length - 1]) 
        { 
          //index at which pattern is found 
          list.add(i); 
  
          // incrementing total occurrences by 1 
          counter ++; 
  
          // last found index to be initizalized 
          // to present index 
          lastOccurrence = i; 
  
          // begin the search for the next pointer 
          // again from 0th index of the pattern 
          p = 0; 
        } 
        else
        { 
          // if present character at pattern and index 
          // is same but still not the end of pattern 
          p ++; 
        } 
      } 
  
      // if characters are not same 
      else
      { 
        // if the present character is same as the 1st 
        // character of the pattern 
        // here 0 = pointer in the pattern fixed to 0 
        if(text[i] == pattern[0]) 
        { 
          // assume a temporary string 
          String temp = ""; 
  
          // and add all characters to it to the pattern 
          // length from the present pointer to the end 
          for (int i1 = p; i1 < pattern.length; i1 ++) 
            temp += pattern[i1]; 
  
          // push the present pattern length into the stack 
          // for checking if pattern is same as subsequence 
          // of the text 
          stack.push(temp); 
  
          //pattern at pointer = 0 already checked so we 
          // start from 1 for the next step 
          p = 1; 
        } 
        else
        { 
          // if the previous occurrence was just before 
          // the present index 
          if (lastOccurrence == i - 1) 
          { 
            // if the stack is empty place the pointer = 0 
            if (stack.isEmpty()) 
              p = 0; 
            else
            { 
              // pick up the present possible pattern 
              String temp = stack.pop(); 
  
              // check if it's character has the matching 
              // occurrence 
              if (temp.charAt(0) == text[i]) 
              { 
                //increment last index by the present index 
                // so that net index is checked 
                lastOccurrence = i; 
  
                // check if stack character is last character 
                // in the pattern 
                if (temp.charAt(0) == pattern[pattern.length - 1]) 
                { 
                  // index found 
                  list.add(i); 
  
                  // increment occurrences by 1 
                  counter ++; 
                } 
                else
                { 
                  // if present index character doesn't 
                  // match the last character in the pattern 
                  // remove the first character which was same 
                  // and check for further occurrences of the 
                  // remaining letters in the stack string 
                  temp = temp.substring(1, temp.length()); 
  
                  // add the remaining string back to stack 
                  // for further review 
                  stack.push(temp); 
                } 
              } 
              // if first string character in the stack doesn't 
              // match the present character in the text 
              else
              { 
                // if stack is not empty empty it. 
                if (!stack.isEmpty()) 
                  stack.clear(); 
  
                // reinitialize the pointer back to 0 for 
                // checking pattern from beginning 
                p = 0; 
              } 
            } 
          } 
          else
          { 
            // empty the stack under any other circumstances 
            if (!stack.isEmpty()) 
              stack.clear(); 
  
            // reinitialize the pointer back to 0 for 
            // checking pattern from beginning 
            p = 0; 
          } 
        } 
      } 
    } 
    // return the result 
    return new Data(list, counter); 
  } 
  
  public static void main(String args[]) 
  { 
    // the simple pattern to be matched 
    char[] pattern = "ABC".toCharArray(); 
  
    // the input string in which the number of 
    // occurrences can be found out after removing 
    // each occurrence. 
    char[] text = "ABABCABCC".toCharArray(); 
  
    StackImplementation obj = new StackImplementation(); 
    Data data = obj.Solution(pattern, text); 
  
    int count = data.count; 
    ArrayList<Integer> list = data.present; 
    System.out.println(count); 
    if (count > 0) 
    { 
      System.out.println("Occurrences found at:"); 
      for (int i : list) 
        System.out.print(i + " "); 
    } 
  } 
} 

/*Output:

3
Occurrences found at:
4 7 8  */
