/* Question:
The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value and the median is the mean of the two middle values.

For example, for arr = [2,3,4], the median is 3.
For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
Implement the MedianFinder class:

MedianFinder() initializes the MedianFinder object.
void addNum(int num) adds the integer num from the data stream to the data structure.
double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
 

Example 1:

Input
["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
[[], [1], [2], [], [3], []]
Output
[null, null, null, 1.5, null, 2.0]

Explanation
MedianFinder medianFinder = new MedianFinder();
medianFinder.addNum(1);    // arr = [1]
medianFinder.addNum(2);    // arr = [1, 2]
medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
medianFinder.addNum(3);    // arr[1, 2, 3]
medianFinder.findMedian(); // return 2.0
 

Constraints:

-105 <= num <= 105
There will be at least one element in the data structure before calling findMedian.
At most 5 * 104 calls will be made to addNum and findMedian.
 

Follow up:

If all integer numbers from the stream are in the range [0, 100], how would you optimize your solution?
If 99% of all integer numbers from the stream are in the range [0, 100], how would you optimize your solution?   */

//Solution(o(1) for each call of median finder and o(log n) for each call of addnum

class MedianFinder {

    /** initialize your data structure here. */
    PriorityQueue<Integer> h1;
    PriorityQueue<Integer> h2;
    double med;
    
    public MedianFinder() {
        h1=new PriorityQueue<>();
        h2=new PriorityQueue<>(Collections.reverseOrder());
        med=Integer.MAX_VALUE;
        
    }
    
    public void addNum(int num) {
        if(h1.size()==0 && h2.size()==0) {h1.add(num); med=num;}
        else if(h1.size()<h2.size()){
            if(num<med){
                h1.add(h2.poll());
                h2.add(num);
            }
            else h1.add(num);
            med=(h1.peek()+h2.peek())/2.0;
        }
        else if(h1.size()>h2.size()){
            if(num<med){
                h2.add(num);
            }
            else {h2.add(h1.poll()); h1.add(num);}
            med=(h1.peek()+h2.peek())/2.0;
        }
        else{
            if(num<med) {h2.add(num); med=h2.peek();}
            else {h1.add(num); med=h1.peek();}
        }
    }
    
    public double findMedian() {
        return med;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
