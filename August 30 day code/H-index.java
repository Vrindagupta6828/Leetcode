/* PROBLEM:
Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.

According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."

Example:

Input: citations = [3,0,6,1,5]
Output: 3 
Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had 
             received 3, 0, 6, 1, 5 citations respectively. 
             Since the researcher has 3 papers with at least 3 citations each and the remaining 
             two with no more than 3 citations each, her h-index is 3.
Note: If there are several possible values for h, the maximum one is taken as the h-index */

//Solution (100% 0 ms)

class Solution {
    public int hIndex(int[] arr) {
        Arrays.sort(arr);
        int i;
        for(i=arr.length-1;i>=0;i--){
            int hindex = arr.length - i;
            if(hindex>arr[i]){
                return hindex-1;
            }
        }
        return i<0?arr.length:0;
    }
        
    }

//My Solution(39% 1 ms)

import java.util.*;
class Solution {
    public int hIndex(int[] arr) {
        Arrays.sort(arr);
        int max=0;int[] b=new int[arr.length];
        int j=arr.length-1;
        for(int i=0;i<arr.length;i++){ 
            b[j--]=arr[i];}
        
        for(int i=0;i<arr.length;i++){
            if(i+1<=b[i]) {if(i+1>max) max=i+1;}
        }
        return max;
    }
        
    }

