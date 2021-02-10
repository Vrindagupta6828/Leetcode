/* Question:
Given a list of non negative integers, arrange them such that they form the largest number.

For example:

Given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.  */

//Solution 
public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public String largestNumber(final List<Integer> A) {
        
       String[] arr = new String[A.size()];
       for( int i = 0; i < arr.length ; i++)
       {
        arr[i] = Integer.toString(A.get(i));
       }
        Arrays.sort(arr, new arrSort());
        StringBuilder s = new StringBuilder();
        for( int i = arr.length-1 ; i >= 0 ; i--)
        {
            s.append(arr[i]);
        }
        
        String ans=s.toString();
        
        if( ans.charAt(0) == '0')
        {
            return "0";
        }
        
        return ans;
        
    }
    }

class arrSort implements Comparator<String>
{
    public int compare(String a , String b)
    {
        if( (a+b).compareTo(b+a) > 0 )
            return 1;
        return -1;

    }
}
