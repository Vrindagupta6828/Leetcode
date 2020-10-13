/*Problem: Given a string containing only lowercase letters, generate a string with the same letters, but in uppercase.

Input : GeeksForGeeks
Output : GEEKSFORGEEKS */

// Java program to convert a string to uppercase 
  
class GFG  
{ 
  
    // Converts a string to uppercase 
    static String to_upper(char[] in) 
    { 
        for (int i = 0; i < in.length; i++)  
        { 
            if ('a' <= in[i] & in[i] <= 'z') 
            { 
                in[i] = (char) (in[i] - 'a' + 'A'); 
            } 
        } 
        return String.valueOf(in); 
    } 
  
    // Driver code 
    public static void main(String[] args)  
    { 
        String str = "geeksforgeeks"; 
        System.out.println(to_upper(str.toCharArray())); 
    } 
}  
  
