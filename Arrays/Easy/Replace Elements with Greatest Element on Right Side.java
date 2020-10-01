/*Problem:
Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.

After doing so, return the array.

 

Example 1:

Input: arr = [17,18,5,4,6,1]
Output: [18,6,6,6,1,-1]
 

Constraints:

1 <= arr.length <= 10^4
1 <= arr[i] <= 10^5  */

//My Solution(o(1) space o(n) time)
class Solution {
    public int[] replaceElements(int[] arr) {
        if(arr==null || arr.length==0) return arr;
        int n=arr.length;int max=0;int index=0;
        for(int i=1;i<n;i++){ if(max<arr[i]) {max=arr[i];index=i;}}
        arr[0]=max;
        for(int i=1;i<n-1;i++){
            if(index<=i){max=0;
                for(int j=i+1;j<n;j++){
                    if (max<arr[j]) {max=arr[j]; index=j;}}}    
           arr[i]=max;    
        }
        arr[n-1]=-1;return arr;
            }
        }

//Solution
class Solution {
    public int[] replaceElements(int[] arr) {
        int maxSeen=0;
        for(int i=arr.length-1; i>=0; i--){
            if(i == arr.length-1){
                maxSeen = arr[arr.length-1];
                arr[i] = -1;
            }
            else{
                int curVal = arr[i];
                arr[i] = maxSeen;
                if(curVal > maxSeen){
                    maxSeen = curVal;
                }
            }
        }
        return arr;
    }
}
