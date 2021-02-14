/* Question:
Given a matrix, A of size M x N of 0s and 1s. If an element is 0, set its entire row and column to 0.

Note: This will be evaluated on the extra memory used. Try to minimize the space and time complexity.



Input Format:

The first and the only argument of input contains a 2-d integer matrix, A, of size M x N.
Output Format:

Return a 2-d matrix that satisfies the given conditions.
Constraints:

1 <= N, M <= 1000
0 <= A[i][j] <= 1
Examples:

Input 1:
    [   [1, 0, 1],
        [1, 1, 1], 
        [1, 1, 1]   ]

Output 1:
    [   [0, 0, 0],
        [1, 0, 1],
        [1, 0, 1]   ]

Input 2:
    [   [1, 0, 1],
        [1, 1, 1],
        [1, 0, 1]   ]

Output 2:
    [   [0, 0, 0],
        [1, 0, 1],
        [0, 0, 0]   ]   */
        
//Solution (o(n*m) time and o(1) space) 
public class Solution {
    public void setZeroes(ArrayList<ArrayList<Integer>> a) {
        boolean flag2=false;
        for(int i=0;i<a.get(0).size();i++){
            if(a.get(0).get(i)==0){
                flag2=true;
                break;
            }
        }
        for(int i=1;i<a.size();i++){
                for(int j=0;j<a.get(0).size();j++){
                    if(a.get(i).get(j)==0){
                        a.get(i).set(0,0);
                        a.get(0).set(j,0);
                    }
                }
            }
            for(int i=1;i<a.size();i++){
                boolean flag = ((a.get(i)).get(0)==0)?true:false;
                for(int j=0;j<a.get(0).size();j++){
                    if(flag){
                        a.get(i).set(j,0);
                    }
                }
            }
            for(int i=0;i<a.get(0).size();i++){
                boolean flag = ((a.get(0)).get(i)==0)?true:false;
                for(int j=0;j<a.size();j++){
                    if(flag){
                        a.get(j).set(i,0);
                    }
                }
            }
            if(flag2){
                for(int i=0;i<a.get(0).size();i++){
                    a.get(0).set(i,0);
        }
    }
}
}
