/* Question:Given a list of n points on 2D plane, the task is to find the K (k < n) closest points to the origin O(0, 0). 
Note: The distance between a point P(x, y) and O(0, 0) using the standard Euclidean Distance. 
Examples:

Input: [(1, 0), (2, 1), (3, 6), (-5, 2), (1, -4)], K = 3 
Output: [(1, 0), (2, 1), (1, -4)] 
Explanation: 
Square of Distances of points from origin are 
(1, 0) : 1 
(2, 1) : 5 
(3, 6) : 45 
(-5, 2) : 29 
(1, -4) : 17 
Hence for K = 3, the closest 3 points are (1, 0), (2, 1) & (1, -4).

Input: [(1, 3), (-2, 2)], K = 1 
Output: [(-2, 2)] 
Explanation: 
Square of Distances of points from origin are 
(1, 3) : 10 
(-2, 2) : 8 
Hence for K = 1, the closest point is (-2, 2).  */

//Solution (o(n+klogn))
// Java implementation to find the K 
// closest points to origin 
// using Priority Queue 
import java.util.*; 
  
// Point class to store 
// a point 
class Pair implements Comparable<Pair> 
{ 
    int first, second; 
    Pair(int a, int b) 
    { 
        first = a; 
        second = b; 
    } 
      
    public int compareTo(Pair o) 
    { 
        int x1 = first * first; 
        int y1 = second * second; 
        int x2 = o.first * o.first; 
        int y2 = o.second * o.second; 
        return (x1 + y1) - (x2 + y2); 
    } 
} 
  
class GFG{ 
      
// Function to find the K closest points 
static void kClosestPoints(int x[], int y[],  
                           int n, int k) 
{ 
    // Create a priority queue 
    PriorityQueue<Pair> pq = new PriorityQueue<>(); 
  
    // Pushing all the points 
    // in the queue 
    for(int i = 0; i < n; i++) 
    { 
        pq.add(new Pair(x[i], y[i])); 
    } 
  
    // Print the first K elements 
    // of the queue 
    for(int i = 0; i < k; i++)  
    { 
  
        // Remove the top of the queue 
        // and store in a temporary pair 
        Pair p = pq.poll(); 
  
        // Print the first (x) 
        // and second (y) of pair 
        System.out.println(p.first +  
                     " " + p.second); 
    } 
} 
  
// Driver code 
public static void main(String[] args) 
{ 
      
    // x coordinate of points 
    int x[] = { 1, -2 }; 
  
    // y coordinate of points 
    int y[] = { 3, 2 }; 
    int K = 1; 
  
    int n = x.length; 
  
    kClosestPoints(x, y, n, K); 
} 
} 
  
/*
Output: 
-2 2 */
