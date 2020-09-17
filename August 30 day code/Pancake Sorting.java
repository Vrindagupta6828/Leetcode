/* Problem:

Given an array of integers arr, sort the array by performing a series of pancake flips.

In one pancake flip we do the following steps:

Choose an integer k where 1 <= k <= arr.length.
Reverse the sub-array arr[1...k].
For example, if arr = [3,2,1,4] and we performed a pancake flip choosing k = 3, we reverse the sub-array [3,2,1], so arr = [1,2,3,4] after the pancake flip at k = 3.

Return the k-values corresponding to a sequence of pancake flips that sort arr. Any valid answer that sorts the array within 10 * arr.length flips will be judged as correct.

 

Example 1:

Input: arr = [3,2,4,1]
Output: [4,2,4,3]
Explanation: 
We perform 4 pancake flips, with k values 4, 2, 4, and 3.
Starting state: arr = [3, 2, 4, 1]
After 1st flip (k = 4): arr = [1, 4, 2, 3]
After 2nd flip (k = 2): arr = [4, 1, 2, 3]
After 3rd flip (k = 4): arr = [3, 2, 1, 4]
After 4th flip (k = 3): arr = [1, 2, 3, 4], which is sorted.
Notice that we return an array of the chosen k values of the pancake flips.
Example 2:

Input: arr = [1,2,3]
Output: []
Explanation: The input is already sorted, so there is no need to flip anything.
Note that other answers, such as [3, 3], would also be accepted.
 

Constraints:

1 <= arr.length <= 100
1 <= arr[i] <= arr.length
All integers in arr are unique (i.e. arr is a permutation of the integers from 1 to arr.length).   */

//Solution(3 ms)

class Solution {
    
    public void flip(int[] a,int j){
        int i=0;
        while(i<=j){
            int temp=a[i];
            a[i]=a[j];
            a[j]=temp;
            i++;
            j--;
        }}
    
    
    public List<Integer> pancakeSort(int[] arr) {
         int i=0;
         int j=arr.length-1;
        List<Integer> flips=new ArrayList<>();
        while(i<=j){
            int max=0,maxI=0;
        for(int k=0;k<=j;k++){
            if(arr[k]>max){
                max=arr[k];
                maxI=k;
            }
        }
            if(maxI!=j){
                flip(arr,maxI);
            flips.add(maxI+1);
            
            flip(arr,j);
            flips.add(j+1);
        }
        j--;}
        return flips;}}
         
    
//Solution(1 ms)
class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> res = new ArrayList<>();
        if (arr == null || arr.length < 2) {
            return res;
        }
        int curEndIndex = arr.length - 1;
        while (curEndIndex > 0) {
            int curMaxIndex = findMax(arr, 0, curEndIndex);
            if (curMaxIndex != curEndIndex) {
                flip(arr, 0, curMaxIndex);  // get the cur max to the 0-th index.
                res.add(curMaxIndex + 1);
                flip(arr, 0, curEndIndex);  // get the cur max to curEndIndex so everything after curEndIndex (inclusive) is sorted
                res.add(curEndIndex + 1);
            }
            curEndIndex--;
        }
        return res;
    }
    
    private int findMax(int[] arr, int start, int end) {
        int val = arr[start];
        int idx = start;
        for (int i = start;i<=end;i++) {
            if (arr[i] > val) {
                val = arr[i];
                idx = i;
            }
        }
        return idx;
    }
    
    private void flip(int[] A, int start, int end) {
        while (start < end) {
            int temp = A[start];
            A[start] = A[end];
            A[end] = temp;
            start++;
            end--;
        }
    }
}
