/* Problem:
You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to guess what the number is. Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess match your secret number exactly in both digit and position (called "bulls") and how many digits match the secret number but locate in the wrong position (called "cows"). Your friend will use successive guesses and hints to eventually derive the secret number.

Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows. 

Please note that both secret number and friend's guess may contain duplicate digits.

Example 1:

Input: secret = "1807", guess = "7810"

Output: "1A3B"

Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7.
Example 2:

Input: secret = "1123", guess = "0111"

Output: "1A1B"

Explanation: The 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow.
Note: You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal. */

// My Solution

class Solution {
    public String getHint(String secret, String guess) {
        int[] ab=new int[2];List<Integer> used=new ArrayList<>();
        for(int i=0;i<guess.length();i++){
            if(secret.charAt(i)==guess.charAt(i))
            {ab[0]++; secret=secret.substring(0,i)+"o"+secret.substring(i+1,secret.length());used.add(i);}
        }
             for(int i=0;i<guess.length();i++){
                  if(secret.indexOf(guess.charAt(i)) != -1 && !used.contains(i))
            {    ab[1]++;
                secret=secret.substring(0,secret.indexOf(guess.charAt(i)))+"o"+
                    secret.substring(secret.indexOf(guess.charAt(i))+1,secret.length());}
    }return(ab[0]+"A"+ab[1]+"B");
}}

//Solution (100% 0 ms)

class Solution {
//     1807
//     7810
//        i
//     1A3B
        
//     1123
//     0111
//        i
//     1A 1B  
    
//     1. same #, same pos
        
//     2. same #, diff pos 
      
//     1882
//     8880
//        i
//     2A1B  
    // 1st iteration:
    //     find all As/bulls
    //     record all other(not bulls) numbers and count in secret
    //         Map<Integer, Integer> map; key: digit that exist in secret but not a bull, value: count
    // 2nd iteration:
    //     if cur digit is not bull
    //     check whether it is recorded in data structure
    public String getHint(String secret, String guess) {
        int[] secretMap = new int[10];
        int[] guessMap = new int[10];
        int bull = 0;
        int cow = 0;

        for(int i = 0; i < secret.length(); i++) {
            if(secret.charAt(i) == guess.charAt(i)) {
                bull++;
            } else {
                int sDigit = secret.charAt(i) - '0';
                int gDigit = guess.charAt(i) - '0';
                if(guessMap[sDigit] > 0) {
                    guessMap[sDigit]--;
                    cow++;
                } else {
                    secretMap[sDigit]++;
                }
                if(secretMap[gDigit] > 0) {
                    secretMap[gDigit]--;
                    cow++;
                } else {
                    guessMap[gDigit]++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(bull).append("A").append(cow).append("B");
        return sb.toString();
    }
}
