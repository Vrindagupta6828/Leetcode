/* Question:
Given two arrays A and B of equal size N, the task is to find if given arrays are equal or not. Two arrays are said to be equal if both of them contain same set of elements, arrangements (or permutation) of elements may be different though.
Note : If there are repetitions, then counts of repeated elements must also be same for two array to be equal.

Example 1:

Input:
N = 5
A[] = {1,2,5,4,0}
B[] = {2,4,5,0,1}
Output: 1
Explanation: Both the array can be 
rearranged to {0,1,2,4,5}
Example 2:

Input:
N = 3
A[] = {1,2,5}
B[] = {2,4,15}
Output: 0
Explanation: A[] and B[] have only 
one common value.
Your Task:
Complete check() function which takes both the given array and their size as function arguments and returns true if the arrays are equal else returns false.The 0 and 1 printing is done by the driver code.

Expected Time Complexity : O(N)
Expected Auxilliary Space : O(N)

Constraints:
1<=N<=107
1<=A[],B[]<=1018  */

//Solution:
public static boolean check(long arr[],long brr[],int n)
{
    //Your code here
    HashMap<Long,Integer> freq=new HashMap<>();
    for(long i:arr){
        freq.put(i,freq.getOrDefault(i,0)+1);
    }
    
    for(long i:brr){
        if(!freq.containsKey(i))
           return false;
        if(freq.get(i)==0) return false;
        freq.put(i,freq.get(i)-1);
    }
    
    return true;
}


//Solution 2
import java.io.*;
import java.util.*;
 
class GFG{
     
// Returns true if arr1[0..n-1] and arr2[0..m-1]
// contain same elements.
public static boolean areEqual(int arr1[],
                               int arr2[])
{
     
    // Length of the two array
    int n = arr1.length;
    int m = arr2.length;
     
    // If lengths of arrays are not equal
    if (n != m)
        return false;
         
    // To store xor of both arrays
    int b1 = arr1[0];
    int b2 = arr2[0];
     
    // Find xor of each elements in array
    for(int i = 1; i < n; i++) 
    {
        b1 ^= arr1[i];
    }
    for(int i = 1; i < m; i++) 
    {
        b2 ^= arr2[i];
    }
    int all_xor = b1 ^ b2;
     
    // If xor is zero means they are 
    // equal (5^5=0)
    if (all_xor == 0)
        return true;
         
    // If all elements were not same,
    // then xor will not be zero
    return false;
}
