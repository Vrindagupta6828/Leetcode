/* Question:
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

You need to do this in place.

Note that if you end up using an additional array, you will only receive partial score.

Example:

If the array is

[
    [1, 2],
    [3, 4]
]
Then the rotated array becomes:

[
    [3, 1],
    [4, 2]
]    */

//Solution (o(n^2))
public class Solution {
    public void rotate(ArrayList<ArrayList<Integer>> a) {
        int n=a.size();
        Collections.reverse(a); // reverse full rows position
        
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int temp=a.get(i).get(j);
                a.get(i).set(j,a.get(j).get(i));
                a.get(j).set(i,temp);
            }
        }
        
    }
}

/* Thus, if we were allowed extra memory, the solution should be easy.

    result[j][matrix.size() - i - 1] = matrix[i][j];  */
    
//Solution 2
public class Solution {
    public void rotate(ArrayList<ArrayList<Integer>> A) {
        transpose(A); 
        for (int i = 0; i < A.size(); i++){ 
            Collections.reverse(A.get(i));
        }
    }
    
    void transpose(ArrayList<ArrayList<Integer>> arr) { 
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i; j < arr.get(0).size(); j++) { 
                int temp = arr.get(j).get(i); 
                arr.get(j).set(i,arr.get(i).get(j)); 
                arr.get(i).set(j,temp); 
            } 
        }
    }
}

//Solution 3
public class Solution {
    public void rotate(ArrayList<ArrayList<Integer>> a) {
       int n=a.size();
       int i2=0,j2=n-1;
       while(i2<j2){
           ArrayList<Integer> temp=a.get(i2);
           a.set(i2,a.get(j2));
           a.set(j2,temp);
           i2++;j2--;
       }
        
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int temp=a.get(i).get(j);
                a.get(i).set(j,a.get(j).get(i));
                a.get(j).set(i,temp);
            }
        }
        
    }
}
