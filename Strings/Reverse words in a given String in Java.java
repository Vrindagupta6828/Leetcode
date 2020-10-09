/* Question:
Let’s see an approach to reverse words of a given String in Java without using any of the String library function

Examples:

Input : "Welcome to geeksforgeeks"
Output : "geeksforgeeks to Welcome"

Input : "I love Java Programming"
Output :"Programming Java love I"  */

//Solution
import java.util.Scanner;

public class reverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        /*String[] arr=s.split(" ");
        for(int i=arr.length-1;i>=0;i--) {
        	System.out.print(arr[i]+" ");
        }*/
        /*s=s+" ";
        String ans="",word="";
        for(int i=0;i<s.length();i++) {
        	if(s.charAt(i)==' ') {
        		ans=word+" "+ans;
        		word="";
        	}
        	else word+=s.charAt(i);
        }*/
        //System.out.println(ans);
	}

}
