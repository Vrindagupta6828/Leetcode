/* Question:
You are given a read only array of n integers from 1 to n.

Each integer appears exactly once except A which appears twice and B which is missing.

Return A and B.

Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Note that in your output A should precede B.

Example:

Input:[3 1 2 5 3] 

Output:[3, 4] 

A = 3, B = 4   */

//Solution 1(o(n) time and space)
public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        HashSet<Integer> number=new HashSet<>();
        ArrayList<Integer> ans=new ArrayList<>();
        int n=A.size();
        for(int i=0;i<n;i++){
            if(number.contains(A.get(i)))
                ans.add(A.get(i));
            number.add(A.get(i));
        }
        
        for(int i=1;i<=n;i++){
            if(number.contains(b))
               b++;
            else{
                ans.add(b);
                break;
            }
        }
        
        return ans;
    }
}
//  Solution 2
public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        
        
        ArrayList<Integer> out = new ArrayList<Integer>();
        double l = A.size();
        double sum = (l*(l+1))/2;
        long sumA = 0;
        int a=0;
        HashSet<Integer> ASet = new HashSet<Integer>();
        for(int i=0;i<A.size();i++) {
            if(ASet.contains(A.get(i))) {
                a=A.get(i);
            }
            ASet.add(A.get(i));
            sumA = sumA+A.get(i);
        }
        double diff = sumA - sum;
        int b = a - (int)diff;
        out.add(a);
        out.add(b);
        return out;
    
    
    }
}
