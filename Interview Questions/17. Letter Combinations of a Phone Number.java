/* Question:
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



 

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]
 

Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].  */

//Solution
class Solution {
    List<String> ans;
    HashMap<Character,String> map;
    
    public List<String> letterCombinations(String digits) {
        ans=new ArrayList<>();
         map=new HashMap<>();
    map.put('2',"abc");
    map.put('3',"def");
    map.put('4',"ghi");
     map.put('5',"jkl");
     map.put('6',"mno");
     map.put('7',"pqrs");
     map.put('8',"tuv");
     map.put('9',"wxyz");
        int n=digits.length();
        if(n==0) return ans;
        arrange(digits,0,new StringBuilder(),n);
        return ans;
        
    }
    
    public void arrange(String digits,int i,StringBuilder sb,int n){
        if(i==n) {ans.add(sb.toString()); return;}
        String g=map.get(digits.charAt(i));
        int len=g.length();
        for(int j=0;j<len;j++){
            sb.append(g.charAt(j));
            arrange(digits,i+1,sb,n);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
