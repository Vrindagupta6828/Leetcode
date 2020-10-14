/* Question:
Given a string containing alphabets in lowercase and uppercase, find the maximum count of distinct lowercase alphabets present between two uppercase alphabets.

Examples :

Input : zACaAbbaazzC
Output : The maximum count = 3

Input : edxedxxxCQiIVmYEUtLi
Output : The maximum count = 1   */

//Solution 1
static void maxdistinct(String s) {
    	int start=-1; int max=0;StringBuilder count=new StringBuilder();
    	for(int i=0;i<s.length();i++) {
    		if(Character.isUpperCase(s.charAt(i)) && start==-1)  start=i;
    		else if (Character.isLowerCase(s.charAt(i)) && start!=-1 &&
    				    count.indexOf(Character.toString(s.charAt(i)))==-1) count.append(s.charAt(i)); 
    		else if(Character.isUpperCase(s.charAt(i)) && start!=-1) {
    			if(max<count.length()) max=count.length();
    			start=i;count=new StringBuilder();
    			//System.out.println(max);
    		}
    	}
    	System.out.println(max);
    }
    // Driver program to test above function 
    public static void main(String[] args) { 
        //String s="edxedxxxCQiIVmYEUtLi";
        String s2="zACaAbbaazzC";
        //maxdistinct(s);//System.out.println("geek778sforgeeks".toUpperCase());
        maxdistinct(s2);  
    } 
    
    //Solution 2  (Using Character Count Array):
    // Java Program to find maximum 
// lowercase alphabets present 
// between two uppercase alphabets 
import java.util.Arrays; 
  
class GFG  
{ 
  
    static final int MAX_CHAR = 26; 
  
    // Function which computes the 
    // maximum number of distinct 
    // lowercase alphabets between 
    // two uppercase alphabets 
    static int maxLower(String str)  
    { 
        int n = str.length(); 
  
        // Ignoring lowercase characters in the 
        // beginning. 
        int i = 0; 
        for (; i < n; i++) 
        { 
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') 
            { 
                i++; 
                break; 
            } 
        } 
  
        // We start from next of first capital letter 
        // and traverse through remaining character. 
        int maxCount = 0; 
        int count[] = new int[MAX_CHAR]; 
        for (; i < n; i++)  
        { 
  
            // If character is in uppercase, 
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')  
            { 
  
                // Count all distinct lower case 
                // characters 
                int currCount = 0; 
                for (int j = 0; j < MAX_CHAR; j++)  
                { 
                    if (count[j] > 0)  
                    { 
                        currCount++; 
                    } 
                } 
  
                // Update maximum count 
                maxCount = Math.max(maxCount, currCount); 
  
                // Reset count array 
                Arrays.fill(count, 0); 
            } 
  
            // If character is in lowercase 
            if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') 
            { 
                count[str.charAt(i) - 'a']++; 
            } 
        } 
        return maxCount; 
    } 
  
    // Driver code 
    public static void main(String[] args)  
    { 
        String str = "zACaAbbaazzC"; 
        System.out.println(maxLower(str)); 
    } 
} 

//Solution 3 (Using Hash Table):
// Java Program to find maximum 
// lowercase alphabets present 
// between two uppercase alphabets 
import java.util.*; 
  
class GFG  
{ 
  
// Function which computes the 
// maximum number of distinct 
// lowercase alphabets between 
// two uppercase alphabets 
static int maxLower(char[] str) 
{ 
    int n = str.length; 
  
    // Ignoring lowercase characters in the 
    // beginning. 
    int i = 0; 
    for (; i < n; i++) 
    { 
        if (str[i] >= 'A' && str[i] <= 'Z')  
        { 
            i++; 
            break; 
        } 
    } 
  
    // We start from next of first capital letter 
    // and traverse through remaining character. 
    int maxCount = 0; 
    HashSet<Integer> s = new HashSet<Integer>(); 
    for (; i < n; i++)  
    { 
  
        // If character is in uppercase, 
        if (str[i] >= 'A' && str[i] <= 'Z')  
        { 
  
            // Update maximum count if lowercase 
            // character before this is more. 
            maxCount = Math.max(maxCount, (int)s.size()); 
  
            // clear the set 
            s.clear(); 
        } 
  
        // If character is in lowercase 
        if (str[i] >= 'a' && str[i] <= 'z') 
            s.add((int)str[i]); 
    } 
  
    return maxCount; 
} 
  
// Driver Code 
public static void main(String args[])  
{ 
    String str = "zACaAbbaazzC"; 
    System.out.println(maxLower(str.toCharArray())); 
} 
} 
