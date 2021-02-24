/* Question:
You are given an array (zero indexed) of N non-negative integers, A0, A1 ,…, AN-1.
Find the minimum sub array Al, Al+1 ,…, Ar so if we sort(in ascending order) that sub array, then the whole array should get sorted.
If A is already sorted, output -1.

Example :

Input 1:

A = [1, 3, 2, 4, 5]

Return: [1, 2]

Input 2:

A = [1, 2, 3, 4, 5]

Return: [-1]
In the above example(Input 1), if we sort the subarray A1, A2, then whole array A should get sorted.   */

//Solution (o(nlogn))
public class Solution {
    public ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
        
       ArrayList<Integer> temp=new ArrayList<>();
        int n=A.size();
        
       for(int i=0;i<n;i++){
            temp.add(A.get(i));
        }
        
        Collections.sort(temp);
        
        int start=-1,end=-1;
        
        for(int i=0;i<n;i++){
            if(A.get(i)!=temp.get(i))
            { if(start==-1) start=i;
              end=i;
            }
        }
        
        ArrayList<Integer> ans=new ArrayList<>();
        ans.add(start);
        if(start!=-1)
        ans.add(end);
        
        return ans; 
    }
  
  //Solution 2(o(n))
  public class Solution {
    public ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
        int n = A.size();
        int[] mins = new int[n];
        int[] maxs = new int[n];
        maxs[0] = A.get(0);
        for(int i = 1; i < n; i++) {
            maxs[i] = Math.max(A.get(i), maxs[i-1]);
        }
        mins[n-1] = A.get(n-1);
        for(int i = n - 2; i >= 0; i--) {
            mins[i] = Math.min(A.get(i), mins[i+1]);
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        int start = 0;
        while (start < n && mins[start] == A.get(start)) start++;
        int end = n - 1;
        while (end >= 0 && maxs[end] == A.get(end)) end--;
        if(start == n) result.add(new Integer(-1));
        else {
            result.add(new Integer(start));
            result.add(new Integer(end));
        }
        return result;
    }
}
}
