/* Question:
Given a set of digits (A) in sorted order, find how many numbers of length B are possible whose value is less than number C.

 NOTE: All numbers can only have digits from the given set. 
Examples:

	Input:
	  0 1 5  
	  1  
	  2  
	Output:  
	  2 (0 and 1 are possible)  

	Input:
	  0 1 2 5  
	  2  
	  21  
	Output:
	  5 (10, 11, 12, 15, 20 are possible)
Constraints:

    1 <= B <= 9, 0 <= C <= 1e9 & 0 <= A[i] <= 9   */

//Solution
public class Solution {
    static int solve(ArrayList<Integer> A, int B, int C) {
    int n = A.size();
    int result = 0;
    if(n==0) return 0;

    // A = [0, 0, 1, 2, 2, 3] -> A = [0, 1, 2, 3]
    Set<Integer> aSet = new HashSet<>();
    for (int d : A) {
        aSet.add(d);
    }
    A.clear();
    A.addAll(aSet);
    
    // C = 123  ->  cList = [1, 2, 3]
    ArrayList<Integer> cList = new ArrayList<>();
    while(C > 0) {
        cList.add(0, C % 10);
        C /= 10;
    }
    if (cList.size() < B) {
        // A = [0, 1, 2, 5]
        // B = 4
        // C = 10
        // There is no value less than 10 and which has 4 digits.
        return 0;
    }
    if (B < cList.size()) {
            if(A.get(0)==0 && B!=1)
            { return (int)((n-1)*Math.pow(n,(B-1))); }
            else
            { return (int)(Math.pow(n,B)); }
        }
        
        // A = [0, 1, 2, 5]
    // B = 3
    // C = 101
    // "101" has 3 digits, which equals with B.
    boolean isFirst = true;
    int prevCnt = 0;
    for (int digit : cList) {
        int cnt = 0;
        if (isFirst && B > 1) {
            for (int d : A) {
                cnt += (d > 0 && d < digit) ? 1 : 0;
            }
        } else {
            for (int d : A) {
                cnt += (d < digit) ? 1 : 0;
            }
        }
        isFirst = false;
        result += cnt * (int)Math.pow(n, --B);
        if (!aSet.contains(digit)) break;
    }
    return result;
}
}
