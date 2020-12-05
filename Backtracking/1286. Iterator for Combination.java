/* Question:
Design the CombinationIterator class:

CombinationIterator(string characters, int combinationLength) Initializes the object with a string characters of sorted distinct lowercase English letters and a number combinationLength as arguments.
next() Returns the next combination of length combinationLength in lexicographical order.
hasNext() Returns true if and only if there exists a next combination.
 

Example 1:

Input
["CombinationIterator", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
[["abc", 2], [], [], [], [], [], []]
Output
[null, "ab", true, "ac", true, "bc", false]

Explanation
CombinationIterator itr = new CombinationIterator("abc", 2);
itr.next();    // return "ab"
itr.hasNext(); // return True
itr.next();    // return "ac"
itr.hasNext(); // return True
itr.next();    // return "bc"
itr.hasNext(); // return False
 

Constraints:

1 <= combinationLength <= characters.length <= 15
All the characters of characters are unique.
At most 104 calls will be made to next and hasNext.
It's guaranteed that all calls of the function next are valid.  */

//Solution
class CombinationIterator {
       String characters;
      int combinationLength;
     LinkedList<String> ans;
    public CombinationIterator(String characters, int combinationLength) {
        this.characters=characters;
        this.combinationLength=combinationLength;
        ans=new LinkedList<>();
        solve(ans,"",0,characters,combinationLength);
    }
    
    public String next() {
        return ans.removeFirst();
    }
    
    public boolean hasNext() {
        return (!ans.isEmpty());
    }
    
    private void solve(List<String> ans,String s,int start,String characters,
                       int combinationLength){
        if(combinationLength==0)
        { ans.add(s);
           return;}
        for(int i=start;i<characters.length();i++){
            solve(ans,s+characters.charAt(i),i+1,characters,combinationLength-1);
        }
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
 
 //Solution 2
 class CombinationIterator {
    public Deque < String > combinations = new ArrayDeque < String > ();
    String characters;
    int n, k;

    public void backtrack(int first, StringBuilder curr) {
        // if the combination is done
        if (curr.length() == k) {
            combinations.push(curr.toString());
            // speed up by non-constructing combinations 
            // with more than k elements  
            return;
        }

        for (int i = first; i < n; ++i) {
            // add i into the current combination
            curr.append(characters.charAt(i));
            // use next integers to complete the combination
            backtrack(i + 1, curr);
            // backtrack
            curr.deleteCharAt(curr.length() - 1);
        }
    }

    public CombinationIterator(String characters, int combinationLength) {
        this.n = characters.length();
        this.k = combinationLength;
        this.characters = characters;
        backtrack(0, new StringBuilder());
    }

    public String next() {
        return combinations.removeLast();
            }

    public boolean hasNext() {
        return (!combinations.isEmpty());
    }
}
