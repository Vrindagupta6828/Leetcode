/* Problem Description

Given an integer array A, find if an integer p exists in the array such that the number of integers greater than p in the array equals to p.



Input Format
First and only argument is an integer array A.



Output Format
Return 1 if any such integer p is found else return -1.



Example Input
Input 1:

 A = [3, 2, 1, 3]
Input 2:

 A = [1, 1, 3, 3]


Example Output
Output 1:

 1
Output 2:

 -1


Example Explanation
Explanation 1:

 For integer 2, there are 2 greater elements in the array. So, return 1.
Explanation 2:

 There is no such integer exists.   */
 
 //Solution (o(nlogn))
 public class Solution {
    public int solve(ArrayList<Integer> A) {
        Collections.sort(A);
        int n=A.size();
        for(int i=0;i<n;i++){
            if(n-i-1==A.get(i)){
                if(i!=n-1 && A.get(i+1)!=A.get(i))
                     return 1;
                else if(i==n-1)
                    return 1;
            }
        }
        return -1;
    }
}
