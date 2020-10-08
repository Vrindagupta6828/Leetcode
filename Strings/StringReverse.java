/* Question:
Write a Java Program to Swap first and last character of words in a Sentence as mentioned in the example?

Examples:

Input : geeks for geeks
Output :seekg rof seekg  */

//Solution
import java.util.*;

public class stringreverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	   Scanner sc=new Scanner(System.in);
	   String s=sc.nextLine();
	   char[] arr=s.toCharArray();
	   for(int i=0;i<arr.length;i++) {
		   int k=i;
		   while(i<arr.length && arr[i]!=' ') i++;
		   char temp=arr[k];
		   arr[k]=arr[i-1];
		   arr[i-1]=temp;
	   }
	   System.out.println(new String(arr));
	}

}
