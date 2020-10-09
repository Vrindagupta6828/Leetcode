//5 diff ways to convert a string

//Solution 1
// Java program to ReverseString using ByteArray. 
import java.lang.*; 
import java.io.*; 
import java.util.*; 
  
// Class of ReverseString 
class ReverseString { 
    public static void main(String[] args) 
    { 
        String input = "GeeksforGeeks"; 
  
        // getBytes() method to convert string 
        // into bytes[]. 
        byte[] strAsByteArray = input.getBytes(); 
  
        byte[] result = new byte[strAsByteArray.length]; 
  
        // Store result in reverse order into the 
        // result byte[] 
        for (int i = 0; i < strAsByteArray.length; i++) 
            result[i] = strAsByteArray[strAsByteArray.length - i - 1]; 
  
        System.out.println(new String(result)); 
    } 
} 

//Solution 2
//Java program to ReverseString using StringBuilder 
import java.lang.*; 
import java.io.*; 
import java.util.*; 

//Class of ReverseString 
class reverseString { 
 public static void main(String[] args) 
 { 
     String input = "Geeks for Geeks"; 

     StringBuilder input1 = new StringBuilder(input); 

     // append a string into StringBuilder input1 
     //input1.append(input); 

     // reverse StringBuilder input1 
     input1 = input1.reverse(); 

     // print reversed String 
     System.out.println(input1); 
 } 
} 

//Solution 3

// Java program to Reverse a String  by 
// converting string to characters  one 
// by one 
import java.lang.*; 
import java.io.*; 
import java.util.*; 
  
// Class of ReverseString 
class ReverseString { 
    public static void main(String[] args) 
    { 
        String input = "GeeksForGeeks"; 
  
        // convert String to character array 
        // by using toCharArray 
        char[] try1 = input.toCharArray(); 
  
        for (int i = try1.length - 1; i >= 0; i--) 
            System.out.print(try1[i]); 
    } 
} 

//Solution 4
// Java program to Reverse a String using swapping 
// of variables 
import java.lang.*; 
import java.io.*; 
import java.util.*; 
  
// Class of ReverseString 
class ReverseString { 
    public static void main(String[] args) 
    { 
        String input = "Geeks For Geeks"; 
        char[] temparray = input.toCharArray(); 
        int left, right = 0; 
        right = temparray.length - 1; 
  
        for (left = 0; left < right; left++, right--) { 
            // Swap values of left and right 
            char temp = temparray[left]; 
            temparray[left] = temparray[right]; 
            temparray[right] = temp; 
        } 
  
        for (char c : temparray) 
            System.out.print(c); 
        System.out.println(); 
    } 
} 

//Solution 5
// Java program to Reverse a String using ListIterator 
import java.lang.*; 
import java.io.*; 
import java.util.*; 
  
// Class of ReverseString 
class ReverseString { 
    public static void main(String[] args) 
    { 
        String input = "Geeks For Geeks"; 
        char[] hello = input.toCharArray(); 
        List<Character> trial1 = new ArrayList<>(); 
  
        for (char c : hello) 
            trial1.add(c); 
  
        Collections.reverse(trial1); 
        ListIterator li = trial1.listIterator(); 
        while (li.hasNext()) 
            System.out.print(li.next()); 
    } 
} 
