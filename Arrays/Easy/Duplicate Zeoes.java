/*Problem:
Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.

Note that elements beyond the length of the original array are not written.

Do the above modifications to the input array in place, do not return anything from your function.

 

Example 1:

Input: [1,0,2,3,0,4,5,0]
Output: null
Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
Example 2:

Input: [1,2,3]
Output: null
Explanation: After calling your function, the input array is modified to: [1,2,3]
 

Note:

1 <= arr.length <= 10000
0 <= arr[i] <= 9   */

//My Solution(O(n^2))
class Solution {
    public void duplicateZeros(int[] arr) {
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]==0) {
                int j=arr.length-2;
                while (j>i && j>=0){
                    arr[j+1]=arr[j];j--;
                }
                arr[j+1]=0;
            }
        }
    }
}

//Solution 2(O(n))
class Solution {
    public void duplicateZeros(int[] arr) {
        int n=arr.length;
        int[] temp=new int[n];int p=0,i=0;
        while(i<n && p<n){
            temp[p++]=arr[i];
            if(arr[i]==0 && p<n) {
                temp[p++]=0;
            }
            i++;
        }
        for(i=0;i<n;i++){
            arr[i]=temp[i];
        }
    }
}
