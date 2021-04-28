/* Question:
You are given a list of integers weights representing peoples' weights and an integer limit representing the weight limit of one rocket ship.

Each rocketship can take at most two people.

Return the minimum number of rocket ships it would take to rescue everyone to Mars.

Constraints

n ≤ 100,000 where n is the length of weights
max(weights) ≤ limit
Example 1
Input
weights = [200, 300, 200]
limit = 400
Output
2
Explanation
It would take one rocket ship to take the two people whose weights are 200, and another to take the person whose weight is 300.   */

//Solution
import java.util.*;

class Solution {
    public int solve(int[] weights, int limit) {
        int n=weights.length,c=0;
        Arrays.sort(weights);
        int i=0,j=n-1;
        while(i<=j){
            if(weights[i]+weights[j]>limit){
                j--;
                c++;
            }
            else if(weights[i]+weights[j]<=limit){
                c++;
                i++;j--;
            }
        }
        return c;
    }
}
