/* Question:
Given an array of non-negative integers and a value sum, determine if there is a subset of the given set with sum equal to given sum.

Examples:

Input : arr[] = {4, 1, 10, 12, 5, 2}, 
          sum = 9
Output : TRUE 
{4, 5} is a subset with sum 9.

Input : arr[] = {1, 8, 2, 5}, 
          sum = 4
Output : FALSE 
There exists no subset with sum 4.  */

//Solution(o(n*sum) time and o(sum) space)
 static boolean isSubsetSum(int arr[], int n, int sum) 
    { 
        // The value of subset[i%2][j] will be true  
        // if there exists a subset of sum j in  
        // arr[0, 1, ...., i-1] 
        boolean subset[][] = new boolean[2][sum + 1]; 
       
        for (int i = 0; i <= n; i++) { 
            for (int j = 0; j <= sum; j++) { 
       
                // A subset with sum 0 is always possible  
                if (j == 0) 
                    subset[i % 2][j] = true;  
       
                // If there exists no element no sum  
                // is possible  
                else if (i == 0) 
                    subset[i % 2][j] = false;  
                else if (arr[i - 1] <= j) 
                    subset[i % 2][j] = subset[(i + 1) % 2] 
                 [j - arr[i - 1]] || subset[(i + 1) % 2][j]; 
                else
                    subset[i % 2][j] = subset[(i + 1) % 2][j]; 
            } 
        } 
       
        return subset[n % 2][sum]; 
    } 
    
    //THe purpose of using mod 2 is we are just storing the prev row and the current row as only those 2 are req for filling curr one and then keep updating current
    and prev rows.
