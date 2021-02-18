/* Question:
Given a read only array of n + 1 integers between 1 and n, find one number that repeats in linear time using less than O(n) space and traversing the stream sequentially O(1) times.

Sample Input:

[3 4 1 4 1]
Sample Output:

1
If there are multiple possible answers ( like in the sample case above ), output any one.

If there is no duplicate, output -1   */

//Solution
public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int repeatedNumber(final List<Integer> A) {
        HashSet<Integer> ans=new HashSet<>();
        for(int i=0;i<A.size();i++){
            if(ans.contains(A.get(i)))
               return A.get(i);
            ans.add(A.get(i));
        }
        return -1;
    }
}

//Solution 2
public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int repeatedNumber(final List<Integer> A) {
        //find cycle
        Integer tortoise = A.get(0);
        Integer hare = A.get(0);
        do {
            tortoise = A.get(tortoise);
            hare = A.get(A.get(hare));
        } while (!tortoise.equals(hare));
        
        //head and meeting point will always have the same distance from cycle beginning
        tortoise = A.get(0);
        while(!tortoise.equals(hare)) {
            tortoise = A.get(tortoise);
            hare = A.get(hare);
        }
        
        return hare;
    }
}
