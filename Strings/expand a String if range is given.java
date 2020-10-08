/* Question:
Suppose we have given a String in which some ranges as specified and we have to place the numbers which is between the given range in the specified place as given in the example:

Examples:

Input : string x = "1-5, 8, 11-14, 18, 20, 26-29" 
Output : string y = "1, 2, 3, 4, 5, 8, 11, 12, 
                    13, 14, 18, 20, 26, 27, 28, 29"  */
                    
//Solution
import java.util.*;
public class printrange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String[] arr=s.split(",");
        StringBuilder a=new StringBuilder("");
        for(int i=0;i<arr.length;i++) {
        	if(arr[i].indexOf('-')!=-1) {
        		int index=arr[i].indexOf('-');
        		int j=Integer.parseInt(arr[i].substring(0,index));
        		for(;j<=Integer.parseInt(arr[i].substring(index+1));j++)
        		{   a.append(Integer.toString(j));
        		    a.append(",");
        		}
        	}
        	else {
        	a.append(arr[i]);a.append(",");
        }
	}
    System.out.println(a.toString());
}}
