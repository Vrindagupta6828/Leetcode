/*Problem:

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
hashSet.contains(2);    // returns false (already removed) */


//That means that list.remove(1) removes the object at position 1 and remove(new Integer(1)) removes the first occurrence of the specified element from this list.
//for adding also new integer was used in previous days

//my solution
import java.util.ArrayList;

class MyHashSet {

    /** Initialize your data structure here. */
    List<Integer> a;
    
    public MyHashSet() {
        a=new ArrayList<Integer>();
    }
    
    public void add(int key) {
        if(!a.contains(key))  
            a.add(new Integer(key));
    }
    
    public void remove(int key) {
        if(a.contains(key))
            a.remove(new Integer(key));
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        if(a.contains(key))
            return true;
        else return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
 
 //solution better than 94%
 
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
 
