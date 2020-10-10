/*Question:
Given a string, write a program to count the occurrence of Lowercase characters, Uppercase characters, Special characters, and Numeric values.

Examples:

Input : #GeeKs01fOr@gEEks07
Output : 
Upper case letters : 5
Lower case letters : 8
Numbers : 4
Special Characters : 2

Input : *GeEkS4GeEkS*
Output :
Upper case letters : 6
Lower case letters : 4
Numbers : 1
Special Characters : 2   */

//Solution
import java.util.Scanner;

public class sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int l=s.length();
        System.out.println(l);
        int u=0,lr=0,sp=0,n=0;
        for(int i=0;i<l;i++) {
        	char c=s.charAt(i);
        	if(Character.isUpperCase(c)) u++;
        	else if(Character.isLowerCase(c)) lr++;
        	else if(Character.isDigit(c)) n++;
        	else sp++;
        }
        System.out.println(lr+" "+u+" "+sp+" "+n);
	}

}

//Solution 2
// Java program to count the uppercase, 
// lowercase, special characters  
// and numeric values 
import java.io.*; 
  
class Count 
{ 
    public static void main(String args[]) 
    { 
        String str = "#GeeKs01fOr@gEEks07"; 
        int upper = 0, lower = 0, number = 0, special = 0; 
  
        for(int i = 0; i < str.length(); i++) 
        { 
            char ch = str.charAt(i); 
            if (ch >= 'A' && ch <= 'Z') 
                upper++; 
            else if (ch >= 'a' && ch <= 'z') 
                lower++; 
            else if (ch >= '0' && ch <= '9') 
                number++; 
            else
                special++; 
        } 
  
        System.out.println("Lower case letters : " + lower); 
        System.out.println("Upper case letters : " + upper); 
        System.out.println("Number : " + number); 
        System.out.println("Special characters : " + special); 
    } 
} 
