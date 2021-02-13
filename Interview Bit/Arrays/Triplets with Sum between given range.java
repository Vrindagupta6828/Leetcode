/* Question:
Given an array of real numbers greater than zero in form of strings.
Find if there exists a triplet (a,b,c) such that 1 < a+b+c < 2 .
Return 1 for true or 0 for false.

Example:

Given [0.6, 0.7, 0.8, 1.2, 0.4] ,

You should return 1

as

0.6+0.7+0.4=1.7

1<1.7<2

Hence, the output is 1.

O(n) solution is expected.

Note: You can assume the numbers in strings don’t overflow the primitive data type and there are no leading zeroes in numbers. Extra memory usage is allowed.  */

//Solution
public class Solution {
    public int solve(ArrayList<String> A) {
        int n=A.size();
        
        ArrayList<Double> arr=new ArrayList<>();
        for(int i=0;i<n;i++){
            arr.add(Double.parseDouble(A.get(i)));
        }
        
        Collections.sort(arr);
        int i=0,p=1,r=n-1;
        while(r>i && r>p){
            double sum=arr.get(i)+arr.get(p)+arr.get(r);
            if(sum>1 && sum<2)
                return 1;
            else if(sum>2)
                r--;
            else if(sum<1)
               p++;
            if (p==n-1)
            {  i++;
               p=i+1;
               r=n-1;}
        }
        return 0;
        
    }
}
