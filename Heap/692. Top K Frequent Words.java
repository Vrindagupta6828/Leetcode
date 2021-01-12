/* Question:
Given a non-empty list of words, return the k most frequent elements.

Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.

Example 1:
Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
Output: ["i", "love"]
Explanation: "i" and "love" are the two most frequent words.
    Note that "i" comes before "love" due to a lower alphabetical order.
Example 2:
Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
Output: ["the", "is", "sunny", "day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
    with the number of occurrence being 4, 3, 2 and 1 respectively.
Note:
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Input words contain only lowercase letters.
Follow up:
Try to solve it in O(n log k) time and O(n) extra space. */

//Solution (O(nlogk) time and o(n) space(for hashmap))
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> freq=new HashMap<>();
        List<String> ans=new ArrayList<>();
        for(String word:words)
            freq.put(word,freq.getOrDefault(word,0)+1);
        //ordering ulti so that we can pop out least required elements(can't use ternary operator in pair)
        PriorityQueue<String> pq=new PriorityQueue<>(
        (a,b)-> freq.get(a).equals(freq.get(b))?b.compareTo(a):freq.get(a)-freq.get(b));
        for(String word:freq.keySet()){
            pq.add(word);
            if(pq.size()>k)
                pq.poll();
        }
        while(!pq.isEmpty())
            ans.add(pq.poll());
        Collections.reverse(ans);
        return ans;
    }
}
