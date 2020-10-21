/* Question:
You are given the array paths, where paths[i] = [cityAi, cityBi] means there exists a direct path going from cityAi to cityBi. Return the destination city, that is, the city without any path outgoing to another city.

It is guaranteed that the graph of paths forms a line without any loop, therefore, there will be exactly one destination city.

 

Example 1:

Input: paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
Output: "Sao Paulo" 
Explanation: Starting at "London" city you will reach "Sao Paulo" city which is the destination city. Your trip consist of: "London" -> "New York" -> "Lima" -> "Sao Paulo".
Example 2:

Input: paths = [["B","C"],["D","B"],["C","A"]]
Output: "A"
Explanation: All possible trips are: 
"D" -> "B" -> "C" -> "A". 
"B" -> "C" -> "A". 
"C" -> "A". 
"A". 
Clearly the destination city is "A".
Example 3:

Input: paths = [["A","Z"]]
Output: "Z"
 

Constraints:

1 <= paths.length <= 100
paths[i].length == 2
1 <= cityAi.length, cityBi.length <= 10
cityAi != cityBi
All strings consist of lowercase and uppercase English letters and the space character.    */

//Solution 1(o(n) time and o(n^2) space)
class Solution {
    public String destCity(List<List<String>> paths) {
        List<String> outgoing=new ArrayList<>();
        List<String> incoming=new ArrayList<>();
        outgoing.add(paths.get(0).get(0));
        incoming.add(paths.get(0).get(1));
        for(int i=1;i<paths.size();i++){
            if(incoming.contains(paths.get(i).get(0)))
            {incoming.remove(paths.get(i).get(0));}
             outgoing.add(paths.get(i).get(0));
            if(!outgoing.contains(paths.get(i).get(1)))
                incoming.add(paths.get(i).get(1));
        }
        return incoming.get(0);
    }
}

//Solution 2(o(n^2) time and o(1) space)
class Solution {
    public String destCity(List<List<String>> paths) {
       String dest="";int flag=1;
       for(int i=0;i<paths.size();i++){
           dest=paths.get(i).get(1);flag=1;
           for(int j=0;j<paths.size();j++){
               if(dest.equals(paths.get(j).get(0))) 
               { flag=0; break;}
           }
           if(flag==1) return dest;
       }
        return dest;
    }}
    
    //Solution 3(o(n) time and space)
    class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> departures = new HashSet<>();
        for(List<String> trip : paths){
            departures.add(trip.get(0));
        }
        for(List<String> trip : paths){
            if(!departures.contains(trip.get(1))){
                return trip.get(1);
            }
        }
        return null;
    }
}
