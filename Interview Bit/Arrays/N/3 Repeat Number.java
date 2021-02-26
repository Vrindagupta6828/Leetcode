/* Question:
You’re given a read only array of n integers. Find out if any integer occurs more than n/3 times in the array in linear time and constant additional space.

If so, return the integer. If not, return -1.

If there are multiple solutions, return any one.

Example :

Input : [1 2 3 1 1]
Output : 1 
1 occurs 3 times which is more than 5/3 times.  */

//Solution 1
public class Solution {
    // DO NOT MODIFY THE LIST
    public int repeatedNumber(final List<Integer> a) {
        HashMap<Integer,Integer> freq=new HashMap<>();
        int n=a.size();
        for(int i=0;i<n;i++)
             freq.put(a.get(i),freq.getOrDefault(a.get(i),0)+1);
             
        double val=n/3;
        for(int k:freq.keySet()){
            if(freq.get(k)>val)
                return k;
        }
        return -1;
    }
}
