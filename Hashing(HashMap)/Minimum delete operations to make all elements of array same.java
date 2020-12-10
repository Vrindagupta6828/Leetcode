/*  Same as Minimum operation to make all elements equal in array question: Given an array with n positive integers. We need to find the minimum number
of operation to make all elements equal. We can perform addition, multiplication, subtraction or division with any element on an array element.

Examples:

Input : arr[] = {1, 2, 3, 4}
Output : 3
Since all elements are different, 
we need to perform at least three
operations to make them same. For
example, we can make them all 1
by doing three subtractions. Or make
them all 3 by doing three additions.

Input : arr[] = {1, 1, 1, 1}
Output : 0  */

/* Question:
Given an array of n elements such that elements may repeat. We can delete any number of elements from the array. The task is to find a minimum number of elements to be deleted from the array to make it equal.
Examples:

Input: arr[] = {4, 3, 4, 4, 2, 4}
Output: 2
After deleting 2 and 3 from array, array becomes 
arr[] = {4, 4, 4, 4} 

Input: arr[] = {1, 2, 3, 4, 5}
Output: 4
We can delete any four elements from array.  */

//Solution(O(n))
// Java program to find minimum number
// of deletes required to make all
// elements same.
import java.util.*;
 
class GFG{
 
// Function to get minimum number of 
// elements to be deleted from array
// to make array elements equal
static int minDelete(int arr[], int n)
{
     
    // Create an hash map and store 
    // frequencies of all array elements
    // in it using element as key and
    // frequency as value
    HashMap<Integer, Integer> freq = new HashMap<>();
    for(int i = 0; i < n; i++)
        freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
 
    // Find maximum frequency among all frequencies.
    int max_freq = Integer.MIN_VALUE;
    for(Map.Entry<Integer, 
                  Integer> entry : freq.entrySet())
        max_freq = Math.max(max_freq, 
                            entry.getValue());
 
    // To minimize delete operations, 
    // we remove all elements but the
    // most frequent element.
    return n - max_freq ;
}
 
// Driver code
public static void main(String[] args)
{
    int arr[] = { 4, 3, 4, 4, 2, 4 };
    int n = arr.length;
     
    System.out.print(minDelete(arr, n));
}
}
