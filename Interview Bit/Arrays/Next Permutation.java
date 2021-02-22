/* Question:
Implement the next permutation, which rearranges numbers into the numerically next greater permutation of numbers for a given array A of size N.

If such arrangement is not possible, it must be rearranged as the lowest possible order i.e., sorted in an ascending order.

Note:

1. The replacement must be in-place, do **not** allocate extra memory.
2. DO NOT USE LIBRARY FUNCTION FOR NEXT PERMUTATION. Use of Library functions will disqualify your submission retroactively and will give you penalty points.
Input Format:

The first and the only argument of input has an array of integers, A.
Output Format:

Return an array of integers, representing the next permutation of the given array.
Constraints:

1 <= N <= 5e5
1 <= A[i] <= 1e9
Examples:

Input 1:
    A = [1, 2, 3]

Output 1:
    [1, 3, 2]

Input 2:
    A = [3, 2, 1]

Output 2:
    [1, 2, 3]

Input 3:
    A = [1, 1, 5]

Output 3:
    [1, 5, 1]

Input 4:
    A = [20, 50, 113]

Output 4:
    [20, 113, 50]    */
    
//Solution 1
public class Solution {
    public ArrayList<Integer> nextPermutation(ArrayList<Integer> A) {
        int n=A.size();boolean flag=true;
        
        //Checking if all digits are same
        
        int p=0;
        for(;p<n-1;p++){
            if(A.get(p)!=A.get(p+1))
               break;
        }
        if(p==n-1)  return A;
        
        //Checking if no. is in descending order
        
        for(int i=0;i<n-1;i++){
            if(A.get(i)<A.get(i+1))
                {flag=false;
                break;}
        }
        if(flag){
            Collections.reverse(A);
            return A;
        }
        
        //Finding the rightmost element an dthe smalest no. greater than that no. on it's rght side and then swap and sort the rest
        int pos=-1;
        for(int i=n-2;i>=0;i--){
            int max=Integer.MAX_VALUE;
            for(int j=i+1;j<n;j++){
                if(A.get(j)>A.get(i))
                {
                    if(max>A.get(j)){
                        max=A.get(j);
                        pos=j;
                    }
                }
            }
            if(max<Integer.MAX_VALUE){
                int temp=max;
                A.set(pos,A.get(i));
                A.set(i,temp);
                pos=i+1;
                break;
            } 
        }
        Collections.sort(A.subList(pos,n));
        return A;
    }
}

//Solution 2
public class Solution {
	public void nextPermutation(ArrayList<Integer> a) {
	    int n = a.size();
	    int index = -1;
	    
	    /* 
	        traverse the list from back and find the first occurance of 
	        element a[i] such that a[i] > a[i-1]. Store i-1 in index
	        eg. for a list a = {20, 10, 40, 48, 44, 34}, 40 is such an element. 
	        put index = 2 and break. 
	    */
	    for (int i = n-1; i > 0; i--) {
            if (a.get(i) > a.get(i-1)) {
                index = i-1;
                break;
            }
        }
        /*
            if such element does not exist, that means the list is in highest permutaion. 
            return the list sorted in ascending order. 
        */
        if (index == -1) {
            Collections.sort(a);
        }
        else {
            /*
                find the succssor element of a[index] in the traversed part of the
                list. Eg. for the given example list, look for an element which is successor 
                of 40 in the traversed part. a[index+1:n]. when found such element store
                the index in swapWithIndex. In this scenario swapWithIndex = 4 and the 
                element is 44.
            */
            int swapWithIndex = -1;
            for(int j = n-1; j >index; j--) {
                if (a.get(j) > a.get(index)) {
                    swapWithIndex = j;
                    break;
                }
            }
            /*
                swap elements a[index] with a[swapWithIndex]. 
                The list in scenario looks like this after this operation:
                a = {20, 10, 44, 48, 40, 34}
            */
            int temp = a.get(index);
            a.set(index, a.get(swapWithIndex));
            a.set(swapWithIndex, temp);
            /*
                sort the post index part of the list a[index+1:n] in ascending order.
                That means, in the example sort a[3:6] = {48, 40, 34}
            */
            Collections.sort(a.subList(index+1, n));
        }
	}
}
