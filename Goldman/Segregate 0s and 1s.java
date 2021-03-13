/* Question:
Given an array of length N consisting of only 0s and 1s in random order. Modify the array to segregate 0s on left side and 1s on the right side of the array.

Example 1:

Input:
N = 5
arr[] = {0, 0, 1, 1, 0}
Output: 0 0 0 1 1

Example 2:

Input:
N = 4
Arr[] = {1, 1, 1, 1}
Output: 1 1 1 1
Explanation: There are no 0 in the given array, 
so the modified array is 1 1 1 1.

Your Task:
You don't need to read input or print anything. Your task is to complete the function segregate0and1() which takes arr[] and n as input parameters and modifies arr[] in-place without using any extra memory.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N ≤ 107
0 ≤ arri ≤ 1  */

//Solution
class Solution {
    void segregate0and1(int[] arr, int n) {
        // code here
        int slow=0,fast=0;
        while(fast<n){
            if(arr[slow]==0)
               slow++;
            else if(arr[fast]==0)
                {int temp=arr[slow];
                arr[slow]=arr[fast];
                arr[fast]=temp;
                slow++;
                }
            fast++;
        }
    }

}

//Solution 2
void segregate0and1(int arr[], int size) 
    {
        /* Initialize left and right indexes */
        int left = 0, right = size - 1;
 
        while (left < right) 
        {
            /* Increment left index while we see 0 at left */
            while (arr[left] == 0 && left < right)
               left++;
 
            /* Decrement right index while we see 1 at right */
            while (arr[right] == 1 && left < right)
                right--;
 
            /* If left is smaller than right then there is a 1 at left
               and a 0 at right.  Exchange arr[left] and arr[right]*/
            if (left < right) 
            {
                arr[left] = 0;
                arr[right] = 1;
                left++;
                right--;
            }
        }
    }

//Solution 3

static void segregate0and1(int arr[], int n)
    {
        int count = 0; // counts the no of zeros in arr
     
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0)
                count++;
        }
 
        // loop fills the arr with 0 until count
        for (int i = 0; i < count; i++)
            arr[i] = 0;
 
        // loop fills remaining arr space with 1
        for (int i = count; i < n; i++)
            arr[i] = 1;
    }
