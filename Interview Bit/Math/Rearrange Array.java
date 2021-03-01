/* Question:
Rearrange a given array so that Arr[i] becomes Arr[Arr[i]] with O(1) extra space.

Example:

Input : [1, 0]
Return : [0, 1]
 Lets say N = size of the array. Then, following holds true :
All elements in the array are in the range [0, N-1]
N * N does not overflow for a signed integer   */

//Solution (o(n) space)
public class Solution {
    public void arrange(ArrayList<Integer> a) {
        ArrayList<Integer> ans=new ArrayList<>();
        int n=a.size();
        for(int i=0;i<n;i++){
            ans.add(a.get(a.get(i)));
        }
        for(int i=0;i<n;i++){
            a.set(i,ans.get(i));
        }
    }
}

//Solution 2
public class Solution {
	public void arrange(ArrayList<Integer> A) {
	   	    int n = A.size();
	    for (int i = 0; i < n; i++) A.set(i, A.get(i) + (A.get(A.get(i)) % n) * n );
	    for (int i = 0; i < n; i++) A.set(i, A.get(i) / n);
	}
}
