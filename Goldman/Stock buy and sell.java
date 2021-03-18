/* Question:
The cost of stock on each day is given in an array A[] of size N. Find all the days on which you buy and sell the stock so that in between those days your profit is maximum.
Note: There may be multiple possible solutions. Print any one of them.

Example 1:

Input:
N = 7
A[] = {100,180,260,310,40,535,695}
Output:
1
Explanation:
One possible solution is (0 3) (4 6)
We can buy stock on day 0,
and sell it on 3rd day, which will 
give us maximum profit. Now, we buy 
stock on day 4 and sell it on day 6.
Example 2:

Input:
N = 5
A[] = {4,2,2,2,4}
Output:
1
Explanation:
There are multiple possible solutions.
one of them is (3 4)
We can buy stock on day 3,
and sell it on 4th day, which will 
give us maximum profit.

Your Task:
The task is to complete the function stockBuySell() which takes an array A[] and N as input parameters and finds the days of buying and selling stock. The function must return a 2D list of integers containing all the buy-sell pairs. If there is No Profit, return an empty list.


Expected Time Complexity : O(N)
Expected Auxiliary Space: O(N)


Constraints:
2 <= N <= 106
0 <= Ai <= 106   */

//Solution
class Solution{
    //Function to find the days of buying and selling stock for max profit.
    ArrayList<ArrayList<Integer> > stockBuySell(int A[], int n) {
        // code here
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        if(n==1) return ans;
        
        int i=0;
        
        while(i<n-1)
        {
            while(i<n-1 && A[i]>=A[i+1]) i++;
            
            if(i==n-1) break;
            
            int buy=i++;
            
            while(i<n-1 && A[i]<=A[i+1]) i++;
            
            int sell=i++;
            
            ArrayList<Integer> temp=new ArrayList<>();
            temp.add(buy);
            temp.add(sell);
            ans.add(temp);
        }
        return ans;
    }
}

//If only 1 time buy and sell:
class MaximumDiffrence  
{ 
    /* The function assumes that there are at least two 
       elements in array. 
       The function returns a negative value if the array is 
       sorted in decreasing order. 
       Returns 0 if elements are equal  */
    int maxDiff(int arr[], int arr_size)  
    { 
        int max_diff = arr[1] - arr[0]; 
        int min_element = arr[0]; 
        int i; 
        for (i = 1; i < arr_size; i++)  
        { 
            if (arr[i] - min_element > max_diff) 
                max_diff = arr[i] - min_element; 
            if (arr[i] < min_element) 
                min_element = arr[i]; 
        } 
        return max_diff; 
    } 
  
