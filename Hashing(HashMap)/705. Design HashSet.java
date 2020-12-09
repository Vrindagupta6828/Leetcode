/* Question:
Design a HashSet without using any built-in hash table libraries.

To be specific, your design should include these functions:

add(value): Insert a value into the HashSet. 
contains(value) : Return whether the value exists in the HashSet or not.
remove(value): Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing.

Example:

MyHashSet hashSet = new MyHashSet();
hashSet.add(1);         
hashSet.add(2);         
hashSet.contains(1);    // returns true
hashSet.contains(3);    // returns false (not found)
hashSet.add(2);          
hashSet.contains(2);    // returns true
hashSet.remove(2);          
hashSet.contains(2);    // returns false (already removed)

Note:

All values will be in the range of [0, 1000000].
The number of operations will be in the range of [1, 10000].
Please do not use the built-in HashSet library.   */

//Solution
class MyHashSet {
     LinkedList<Integer> myhashset; 
    /** Initialize your data structure here. */
    public MyHashSet() {
        myhashset=new   LinkedList<>();
    }
    
    public void add(int key) {
        if(!myhashset.contains(key))
            myhashset.add(key);
    }
    
    public void remove(int key) {
        if(myhashset.contains(key))
        myhashset.remove(new Integer(key));
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return myhashset.contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
 
 //Solution(better)
 class MyHashSet {

    public class ListNode {
        int key;
        ListNode next;
        public ListNode(int key) {this.key = key;}
    }
    
    private ListNode[] nodes;
    /** Initialize your data structure here. */
    public MyHashSet() {
        nodes = new ListNode[10000];
    }
    
    private int getHash(int key) {
        return key % nodes.length;
    }
    
    private ListNode find(int key, int index) {
        ListNode prev = nodes[index];
        while(prev != null && prev.next != null) {
            if (prev.next.key == key) break;
            prev = prev.next;
        }
        return prev;
    }
    
    public void add(int key) {
        int index = getHash(key); 
        if (nodes[index] == null) {
            nodes[index] = new ListNode(-1);
        }
        ListNode prev = find(key, index);
        if (prev.next == null) {
            prev.next = new ListNode(key);
        }
    }
    
    public void remove(int key) {
        int index = getHash(key);
        if (nodes[index] == null) return;
        ListNode prev = find(key, index);
        if (prev.next == null) return;
        else {
            ListNode victim = prev.next;
            prev.next = prev.next.next;
            victim.next = null;
            victim = null;
        }
         
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = getHash(key); 
        if (nodes[index] == null) return false;
        ListNode prev = find(key, index);
        if (prev.next == null) return false;
        return true;
    }
}
/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
