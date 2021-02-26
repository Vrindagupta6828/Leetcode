/* Question:
You are given a binary string(i.e. with characters 0 and 1) S consisting of characters S1, S2, …, SN. In a single operation, you can choose two indices L and R such that 1 ≤ L ≤ R ≤ N and flip the characters SL, SL+1, …, SR. By flipping, we mean change character 0 to 1 and vice-versa.

Your aim is to perform ATMOST one operation such that in final string number of 1s is maximised. If you don’t want to perform the operation, return an empty array. Else, return an array consisting of two elements denoting L and R. If there are multiple solutions, return the lexicographically smallest pair of L and R.

Notes:

Pair (a, b) is lexicographically smaller than pair (c, d) if a < c or, if a == c and b < d.
For example,

S = 010

Pair of [L, R] | Final string
_______________|_____________
[1 1]          | 110
[1 2]          | 100
[1 3]          | 101
[2 2]          | 000
[2 3]          | 001

We see that two pairs [1, 1] and [1, 3] give same number of 1s in final string. So, we return [1, 1].
Another example,

If S = 111

No operation can give us more than three 1s in final string. So, we return empty array [].   */

//Solution 
public class Solution {
    public ArrayList<Integer> flip(String A) {
        int n=A.length();
        int l=0,r=0,L=0,R=0;
        int ans=Integer.MIN_VALUE;
        int s=0,c=0;
        ArrayList<Integer> ansF=new ArrayList<>();
        
        for(int i=0;i<n;i++) 
        { if(A.charAt(i)=='1')
             c++;
        }
        
        if(c==n) return ansF;
        
        for(int i=0;i<n;i++){
            if(A.charAt(i)=='0')
               {s++; r=i;}
            else{
                s--;
                
                if(s<0){
                    s=0;
                    l=i+1;
                    r=i+1;
                } 
            }
            if(ans<s){
                ans=s;
                L=l;
                R=r;
            }
        }
        
        ansF.add(L+1);ansF.add(R+1);
        return ansF;
    }
}

//Solution 2 - if not a string you can replace 0 by 1 and 1 by -1 you can then cal contagious maxm subarray by kadane's algo


//Solution 3
int n = A.length();
        
        int c0=0,c1=0,left=Integer.MAX_VALUE,right=0;
        boolean flag=false;
        int ansl=0,ansr=0,prev=-1;
        for(int i=0;i<A.length();i++){
            char c =A.charAt(i);
            if(c=='1')c1+=1;
            else c0+=1;
            if(c0>0)flag =true;
            
            if(c1>c0){
                c0=0;
                c1=0;
               
                left = Integer.MAX_VALUE;
                right=0;
                
            }
            else if(c=='0'){
                left = Math.min(left,i);
                right=i;
                if(c0-c1>prev){
                    ansl = left;
                    ansr=right;
                    prev=c0-c1;
                }
            }
            
        }
        if(!flag) return new ArrayList<>(0);
        res.add(ansl+1);
        res.add(ansr+1);
        return res;
