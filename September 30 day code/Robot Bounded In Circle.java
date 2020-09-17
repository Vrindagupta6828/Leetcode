/* Problem:
On an infinite plane, a robot initially stands at (0, 0) and faces north.  The robot can receive one of three instructions:

"G": go straight 1 unit;
"L": turn 90 degrees to the left;
"R": turn 90 degress to the right.
The robot performs the instructions given in order, and repeats them forever.

Return true if and only if there exists a circle in the plane such that the robot never leaves the circle.

 

Example 1:

Input: "GGLLGG"
Output: true
Explanation: 
The robot moves from (0,0) to (0,2), turns 180 degrees, and then returns to (0,0).
When repeating these instructions, the robot remains in the circle of radius 2 centered at the origin.
Example 2:

Input: "GG"
Output: false
Explanation: 
The robot moves north indefinitely.
Example 3:

Input: "GL"
Output: true
Explanation: 
The robot moves from (0, 0) -> (0, 1) -> (-1, 1) -> (-1, 0) -> (0, 0) -> ...
 

Note:

1 <= instructions.length <= 100
instructions[i] is in {'G', 'L', 'R'}   */

//My Solution(100% better 0 ms)

class Solution {
    public boolean isRobotBounded(String instructions) {
        //east,west,north,south
        if(instructions.indexOf('L')==-1 && instructions.indexOf('R')==-1) return false;
        if(instructions==null || instructions.length()==0)  return true;
        String current="North";
        HashMap<String,Integer> main=new HashMap<>();
        main.put("North",0);
        main.put("South",0);
        main.put("East",0);
        main.put("West",0);
        HashMap<String,String> left=new HashMap<>();
        HashMap<String,String> right=new HashMap<>();
        left.put("North","West");
        left.put("South","East");
       left.put("East","North");
        left.put("West","South");
         right.put("North","East");
         right.put("South","West");
         right.put("East","South");
        right.put("West","North");
        //System.out.println(left);
        for(int i=0;i<instructions.length();i++){
            if(instructions.charAt(i)=='G')
                 main.put(current,main.get(current)+1);
            else if(instructions.charAt(i)=='L')
                current=left.get(current);
            else if(instructions.charAt(i)=='R')
                current=right.get(current);
        }
        if((main.get("North")==main.get("South") && main.get("East")==main.get("West")) || 
            !current.equals("North")) return true;
        return false;
    }
}
