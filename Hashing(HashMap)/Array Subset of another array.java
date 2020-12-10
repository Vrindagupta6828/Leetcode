/* Question:
Given two arrays: arr1[0..m-1] of size m and arr2[0..n-1] of size n. Task is to check whether arr2[] is a subset of arr1[] or not. Both the arrays can be both unsorted or sorted. It may be assumed that elements in both array are distinct.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains an two integers m and n denoting the size of arr1 and arr2 respectively. The following two lines contains the space separated elements of arr1 and arr2 respectively.

Output:
Print "Yes"(without quotes) if arr2 is subset of arr1.
Print "No"(without quotes) if arr2 is not subset of arr1.

Constraints:
1 <= T <= 100
1 <= m,n <= 105
1 <= arr1[i], arr2[j] <= 105

Example:
Input:
3
6 4
11 1 13 21 3 7
11 3 7 1
6 3
1 2 3 4 5 6
1 2 4
5 3
10 5 2 23 19
19 5 3

Output:
Yes
Yes
No

Explanation:
Testcase 1: (11, 3, 7, 1) is a subset of first array.   */

//Solution
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    static Scanner sc=new Scanner(System.in);
	public static void main (String[] args) {
		//code
		int t=sc.nextInt();
		while(t-->0){
		    int m=sc.nextInt();
		    int n=sc.nextInt();
		    HashSet<Integer> set1=new HashSet<>();
		    HashSet<Integer> set2=new HashSet<>();
		    for(int i=0;i<m;i++)
		       set1.add(sc.nextInt());
		    for(int i=0;i<n;i++)
		       set2.add(sc.nextInt());
		    if(set1.containsAll(set2)) 
		       System.out.println("Yes");
		    else
		       System.out.println("No");
		}
	}
}

//Solution 2
// Java code to find whether an array is subset of 
// another array 
import java.util.HashSet; 
class GFG  
{ 
    /* Return true if arr2[] is a subset of arr1[] */
    static boolean isSubset(int arr1[],  
                            int arr2[], int m, 
                            int n) 
    { 
        HashSet<Integer> hset = new HashSet<>(); 
  
        // hset stores all the values of arr1 
        for (int i = 0; i < m; i++) { 
            if (!hset.contains(arr1[i])) 
                hset.add(arr1[i]); 
        } 
  
        // loop to check if all elements 
        //  of arr2 also lies in arr1 
        for (int i = 0; i < n; i++)  
        { 
            if (!hset.contains(arr2[i])) 
                return false; 
        } 
        return true; 
    } 
  
    // Driver Code 
    public static void main(String[] args) 
    { 
        int arr1[] = { 11, 1, 13, 21, 3, 7 }; 
        int arr2[] = { 11, 3, 7, 1 }; 
  
        int m = arr1.length; 
        int n = arr2.length; 
  
        if (isSubset(arr1, arr2, m, n)) 
            System.out.println("arr2 is a subset of arr1"); 
        else
            System.out.println( 
                "arr2 is not a subset of arr1"); 
    } 
} 

//Solution 3(O(m+n) time and O(m) space)
// Java program to find whether an array 
// is subset of another array 
import java.io.*; 
import java.util.*; 
  
class GFG{ 
  
// Return true if arr2[] is a subset of arr1[] 
static boolean isSubset(int[] arr1, int m,  
                        int[] arr2, int n) 
{ 
      
    // Create a Frequency Table using STL 
    HashMap<Integer,  
            Integer> frequency = new HashMap<Integer,  
                                             Integer>(); 
  
    // Increase the frequency of each element 
    // in the frequency table. 
    for(int i = 0; i < m; i++)  
    { 
        frequency.put(arr1[i], 
                      frequency.getOrDefault( 
                          arr1[i], 0) + 1); 
    } 
      
    // Decrease the frequency if the 
    // element was found in the frequency 
    // table with the frequency more than 0. 
    // else return 0 and if loop is 
    // completed return 1. 
    for(int i = 0; i < n; i++)  
    { 
        if (frequency.getOrDefault(arr2[i], 0) > 0) 
            frequency.put(arr2[i], 
                          frequency.get(arr1[i]) - 1); 
        else
        { 
            return false; 
        } 
    } 
    return true; 
} 
  
// Driver Code 
public static void main(String[] args) 
{ 
    int[] arr1 = { 11, 1, 13, 21, 3, 7 }; 
    int[] arr2 = { 11, 3, 7, 1 }; 
      
    int m = arr1.length; 
    int n = arr2.length; 
  
    if (isSubset(arr1, m, arr2, n)) 
        System.out.println( 
            "arr2[] is subset of arr1[] "); 
    else
        System.out.println( 
            "arr2[] is not a subset of arr1[] "); 
} 
} 
