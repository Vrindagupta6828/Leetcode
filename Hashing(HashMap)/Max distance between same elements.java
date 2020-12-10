/* Question:
Given an array with repeated elements, the task is to find the maximum distance between two occurrences of an element.

Example 1:

Input
n= 6
arr = {1, 1, 2, 2, 2, 1}

Output
5

Explanation
arr[] = {1, 1, 2, 2, 2, 1}
Max Distance: 5
Distance for 1 is: 5-0 = 5
Distance for 2 is : 4-2 = 2
Max Distance 5
Example 2:

Input
n = 12
arr = {3, 2, 1, 2, 1, 4, 5, 8, 6, 7, 4, 2}

Output
10

Explanation



arr[] = {3, 2, 1, 2, 1, 4, 5, 8, 6, 7, 4, 2}
Max Distance 10
maximum distance for 2 is 11-1 = 10
maximum distance for 1 is 4-2 = 2
maximum distance for 4 is 10-5 = 5
Your Task:
Complete maxDistance() function which takes both the given array and their size as function arguments and returns the maximum distance between 2 same elemenrs.


Expected Time Complexity : O(N)
Expected Auxilliary Space : O(N)

Constraints:

1<=T<=100
1<=N<=1000   */

//Solution(O(n))
class GfG
{
    int maxDistance(int arr[], int n)
    {
	// Your code here
 	 HashMap<Integer,Integer> map=new HashMap<>();
 	 int max=0;
 	 for(int i=0;i<n;i++){
 	     if(map.containsKey(arr[i])){
 	         if(max<i-map.get(arr[i]))
 	            max=i-map.get(arr[i]);
 	     }
 	     else map.put(arr[i],i);
 	 }
 	 return max;
    }
}
