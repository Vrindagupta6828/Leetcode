/* Question:
Problem Description

Given an integer array A of size N. You need to count the number of special elements in the given array.

A element is special if removal of that element make the array balanced.

Array will be balanced if sum of even index element equal to sum of odd index element.



Problem Constraints
1 <= N <= 105

1 <= A[i] <= 109



Input Format
First and only argument is an integer array A of size N.



Output Format
Return an integer denoting the count of special elements.



Example Input
Input 1:

 A = [2, 1, 6, 4]
Input 2:

 A = [5, 5, 2, 5, 8]


Example Output
Output 1:

 1
Output 2:

 2


Example Explanation
Explanation 1:

 After deleting 1 from array : {2,6,4}
    (2+4) = (6)
 Hence 1 is the only special element, so count is 1
 
Explanation 2:

 If we delete A[0] or A[1] , array will be balanced
    (5+5) = (2+8)
 So A[0] and A[1] are special elements, so count is 2.  */
 
 //Solution(o(n) time and o(1) space)
 
 public class Solution {
    public int solve(ArrayList<Integer> A) {
        int count = 0;
        int odd = 0;
        int even = 0;
        for (int i = 0; i< A.size(); i++){
           if(i%2 == 0){
                even+=A.get(i);
           }
           else {
                odd +=A.get(i);
           }
        }
        for (int i = A.size() - 1; i>=0;i--){
            boolean isEven = i%2 ==0;
            if(isEven) even-=A.get(i);
            else odd-=A.get(i);
            if(odd ==even) count ++;
            if(isEven) odd +=A.get(i);
            else even +=A.get(i);
        }
        return count;
    }
}

//Solution 2
public class Solution {
    public int solve(ArrayList<Integer> A) {
        int n=A.size(),odd[]=new int[n+1],even[]=new int[n+1],oddsum=0,evensum=0;
        for(int i=0;i<n;i++){
            if(i%2==0){
                evensum+=A.get(i);
                even[i+1]=evensum;
                odd[i+1]=odd[i];
            }
            else{
                oddsum+=A.get(i);
                odd[i+1]=oddsum;
                even[i+1]=even[i];
            }
            //System.out.print(odd[i+1]+","+even[i+1]+"  ");
        }
        int ans=0;
        for(int i=0;i<n;i++){
            oddsum=odd[i]+even[n]-even[i+1];
            evensum=even[i]+odd[n]-odd[i+1];
            //System.out.println(evensum+"=="+oddsum);
            if(oddsum==evensum)
                ans++;
        }
        return ans;
    }
}


 
