/* Question:
Write a function detectAndCountLoop() that checks whether a given Linked List contains loop and if loop is present then returns count of nodes in loop. For example, the loop is present in below-linked list and length of the loop is 4. If the loop is not present, then the function should return 0.  */

//Solution (O(n) time and O(1) space)

// Returns count of nodes present in loop.  
static int countNodes( Node n)  
{  
int res = 1;  
Node temp = n;  
while (temp.next != n)  
{  
    res++;  
    temp = temp.next;  
}  
return res;  
}  
  
/* This function detects and counts loop  
nodes in the list. If loop is not there  
in then returns 0 */
static int countNodesinLoop( Node list)  
{  
    Node slow_p = list, fast_p = list;  
  
    while (slow_p !=null && fast_p!=null && fast_p.next!=null)  
    {  
        slow_p = slow_p.next;  
        fast_p = fast_p.next.next;  
  
        /* If slow_p and fast_p meet at some point  
        then there is a loop */
        if (slow_p == fast_p)  
            return countNodes(slow_p);  
    }  
  
    /* Return 0 to indeciate that ther is no loop*/
    return 0;  
}  
