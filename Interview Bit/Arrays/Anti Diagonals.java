/* Question:
Give a N*N square matrix, return an array of its anti-diagonals. Look at the example for more details.

Example:

		
Input: 	

1 2 3
4 5 6
7 8 9

Return the following :

[ 
  [1],
  [2, 4],
  [3, 5, 7],
  [6, 8],
  [9]
]


Input : 
1 2
3 4

Return the following  : 

[
  [1],
  [2, 3],
  [4]
]
   */
   
 //Solution (O(n^2) time and space)
 public class Solution {
    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        int n=A.size();
        for(int i=0;i<n;i++){
            ArrayList<Integer> temp=new ArrayList<>();
            int k=0,j=i;
            while(k<n && j>=0){
                temp.add(A.get(k).get(j));
                k++;j--;
            }
            ans.add(temp);
        }
        
        for(int i=1;i<n;i++){
            ArrayList<Integer> temp=new ArrayList<>();
            int k=n-1,j=i;
            while(j<n && k>=0){
                temp.add(A.get(j).get(k));
                k--;j++;
            }
            ans.add(temp);
        }
        return ans;
    }
}

//Solution 2
public class Solution {
	public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> a) {
	    
	    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	    int dimension = a.size();
	    for (int i = 0; i < dimension*2-1; i++) {
	        result.add(getDiagonal(i, a));
	    }
	    return result;
	}
	
	public ArrayList<Integer> getDiagonal(int layer, ArrayList<ArrayList<Integer>> a) {
	    ArrayList<Integer> result = new ArrayList<Integer>();
	    for (int i = 0; i <= layer; i++) {
	        int j = layer-i;
	        if (i < a.size() && j < a.size()) {
	             result.add(a.get(i).get(j));
	        }
	    }
	    return result;
	}
}
