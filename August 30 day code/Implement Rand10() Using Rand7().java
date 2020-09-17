/* Problem:
Given the API rand7() that generates a uniform random integer in the range [1, 7], write a function rand10() that generates a uniform random integer in the range [1, 10]. You can only call the API rand7(), and you shouldn't call any other API. Please do not use a language's built-in random API.

Each test case will have one internal argument n, the number of times that your implemented function rand10() will be called while testing. Note that this is not an argument passed to rand10().

Follow up:

What is the expected value for the number of calls to rand7() function?
Could you minimize the number of calls to rand7()?
 

Example 1:

Input: n = 1
Output: [2]
Example 2:

Input: n = 2
Output: [2,8]
Example 3:

Input: n = 3
Output: [3,8,10]
 

Constraints:

1 <= n <= 105  */

//Solution(1ms) 
/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    
    int num=1;

    
    public int rand10() {
        if(num == 11)
        {
            num = 1;
        }
        return num++;
    }
}

//Solution(39 ms)

/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {
        int[][] vals={
            {1,2,3,4,5,6,7},
            {8,9,10,1,2,3,4},
            {5,6,7,8,9,10,1},
            {2,3,4,5,6,7,8},
            {9,10,1,2,3,4,5},
            {6,7,8,9,10,0,0},
            {0,0,0,0,0,0,0}
            };
        int result=0;
        while(result==0){
            int i=rand7();
            int j=rand7();
            result=vals[i-1][j-1];
        }
        return result;
    }
}
