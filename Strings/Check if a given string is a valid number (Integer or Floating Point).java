/* Question:
In Set 1, we have discussed general approach to check whether a string is a valid number or not. In this post, we will discuss regular expression approach to check for a number.

Examples:

Input : str = "11.5"
Output : true

Input : str = "abc"
Output : false

Input : str = "2e10"
Output : true

Input : 10e5.4
Output : false  */

//Solution

import java.util.*;
import java.util.regex.Matcher; 
import java.util.regex.Pattern; 
public class checkifinteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        //String regex= "[+-]?[0-9]+";  to check integer no.
        String regex = "[+-]?[0-9]+(\\.[0-9]+)?([Ee][+-]?[0-9]+)?"; //for floating no.
        Pattern p=Pattern.compile(regex);
        Matcher match=p.matcher(s);
        if(match.find() && match.group().equals(s)) {
        	System.out.println(true);}
        else 
        		System.out.println(false);
        }
	}


