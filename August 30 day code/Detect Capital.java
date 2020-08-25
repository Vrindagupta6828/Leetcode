// beats 99%

class Solution {
    public boolean detectCapitalUse(String word) {
        
        int caps = 0;
        for (int i = 0; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))){
                caps++;
            }
        }
        if (caps == word.length() || caps == 0) return true;
        return caps == 1 && Character.isUpperCase(word.charAt(0));
        
    }
}


//betas 20.54%(my solution)

class Solution {
    public boolean detectCapitalUse(String word) {
       int flagu=0,flagl=0;int l=word.length();
       for(int i=0;i<l;i++){
           if(Character.isLowerCase(word.charAt(i)))  flagl++;
           if(Character.isUpperCase(word.charAt(i)))  flagu++;
       }
      if((flagl==l) || (flagu==l) || (Character.isUpperCase(word.charAt(0)) && 
                                      (flagl==l-1))  )  return true;
      else return false;
    }
}
