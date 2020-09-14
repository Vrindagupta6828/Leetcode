/* Problem:
A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and uppercase letters only.

We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)

The rules of Goat Latin are as follows:

If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
For example, the word 'apple' becomes 'applema'.
 
If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
For example, the word "goat" becomes "oatgma".
 
Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
Return the final sentence representing the conversion from S to Goat Latin. 

 

Example 1:

Input: "I speak Goat Latin"
Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
Example 2:

Input: "The quick brown fox jumped over the lazy dog"
Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
 

Notes:

S contains only uppercase, lowercase and spaces. Exactly one space between each word.
1 <= S.length <= 150.  */

//My Solution(8 ms 45% time & 52 % memory)

class Solution {
    public String toGoatLatin(String S) {
        String[] words=S.split(" ");
        String ans="";
        for(int i=0;i<words.length;i++){
            if("AEIOUaeiou".indexOf(words[i].charAt(0)) == -1)
                words[i]=words[i].substring(1,words[i].length())+words[i].charAt(0);
           words[i]=words[i]+"ma"+"a".repeat(i+1);
           ans=ans+words[i]+" ";
            }
        return(ans.substring(0,ans.length()-1));
    }
}

//Solution (0 ms 99.9% time & 65 % memory)

class Solution {
    public String toGoatLatin(String S) {
        
        StringBuilder res = new StringBuilder();
        StringBuilder ma = new StringBuilder();
        
        ma.append("maa");
        
        int pos = 0;
        int size = S.length();
        
        while(pos < size)
        {
            char first = S.charAt(pos);
            char hold = ' ';
            
            if(first != 'a' && first != 'e' && first != 'i' && first != 'o' && first != 'u' && 
               first != 'A' && first != 'E' && first != 'I' && first != 'O' && first != 'U')
            {
                hold = first;
                pos++;
            }
            
            while(pos < size && S.charAt(pos) != ' ') 
            {
                res.append(S.charAt(pos));
                pos++;
            }
            
            if(hold != ' ')res.append(hold);
            
            res.append(ma.toString());
            ma.append('a');
            
            if(pos != size) res.append(" ");
            
            pos++;
        }
        
        return res.toString();
    }
}
