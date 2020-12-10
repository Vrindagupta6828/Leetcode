/* Question:
Given an array Arr of N positive integers and another number X. Determine whether or not there exist two elements in Arr whose sum is exactly X.

Example 1:

Input:
N = 6, X = 16
Arr[] = {1, 4, 45, 6, 10, 8}
Output: Yes
Explanation: Arr[3] + Arr[4] = 6 + 10 = 16
Example 2:

Input:
N = 5, X = 10
Arr[] = {1, 2, 4, 3, 6}
Output: Yes
Explanation: Arr[2] + Arr[4] = 4 + 6 = 10
Your Task:
You don't need to read input or print anything. Your task is to complete the function hasArrayTwoCandidates() which takes the array of integers arr, n and x as parameters and returns boolean denoting the answer.

Expected Time Complexity: O(N*logN)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 105
1 ≤ Arr[i] ≤ 105   */

//Solution 1
class Solution {
    boolean hasArrayTwoCandidates(int arr[], int n, int x) {
        // code here
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            if(map.containsKey(x-arr[i]))
                return true;
            map.put(arr[i],i);
        }
        return false;
    }
}

//Solution2(O(n) time and space)
class Solution {
    boolean hasArrayTwoCandidates(int arr[], int n, int x) {
        // code here
        HashSet<Integer> map=new HashSet<>();
        for(int i=0;i<n;i++){
            if(map.contains(x-arr[i]))
                return true;
            map.add(arr[i]);
        }
        return false;
    }
}
