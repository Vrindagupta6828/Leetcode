// Java code to implement  
// priority-queue using  
// array implementation of 
// binary heap 
import java.util.*; 
class GFG{ 
  
static int []H = new int[50]; 
static int size = -1; 
  
// Function to return the index of the 
// parent node of a given node 
static int parent(int i) 
{ 
  return (i - 1) / 2; 
} 
  
// Function to return the index of the 
// left child of the given node 
static int leftChild(int i) 
{ 
  return ((2 * i) + 1); 
} 
  
// Function to return the index of the 
// right child of the given node 
static int rightChild(int i) 
{ 
  return ((2 * i) + 2); 
} 
  
// Function to shift up the  
// node in order to maintain  
// the heap property 
static void shiftUp(int i) 
{ 
  while (i > 0 &&  
         H[parent(i)] < H[i])  
  { 
    // Swap parent and current node 
    swap(parent(i), i); 
  
    // Update i to parent of i 
    i = parent(i); 
  } 
} 
  
// Function to shift down the node in 
// order to maintain the heap property 
static void shiftDown(int i) 
{ 
  int maxIndex = i; 
  
  // Left Child 
  int l = leftChild(i); 
  
  if (l <= size &&  
      H[l] > H[maxIndex])  
  { 
    maxIndex = l; 
  } 
  
  // Right Child 
  int r = rightChild(i); 
  
  if (r <= size &&  
      H[r] > H[maxIndex])  
  { 
    maxIndex = r; 
  } 
  
  // If i not same as maxIndex 
  if (i != maxIndex)  
  { 
    swap(i, maxIndex); 
    shiftDown(maxIndex); 
  } 
} 
  
// Function to insert a  
// new element in  
// the Binary Heap 
static void insert(int p) 
{ 
  size = size + 1; 
  H[size] = p; 
  
  // Shift Up to maintain  
  // heap property 
  shiftUp(size); 
} 
  
// Function to extract  
// the element with 
// maximum priority 
static int extractMax() 
{ 
  int result = H[0]; 
  
  // Replace the value  
  // at the root with  
  // the last leaf 
  H[0] = H[size]; 
  size = size - 1; 
  
  // Shift down the replaced  
  // element to maintain the  
  // heap property 
  shiftDown(0); 
  return result; 
} 
  
// Function to change the priority 
// of an element 
static void changePriority(int i,  
                           int p) 
{ 
  int oldp = H[i]; 
  H[i] = p; 
  
  if (p > oldp)  
  { 
    shiftUp(i); 
  } 
  else 
  { 
    shiftDown(i); 
  } 
} 
  
// Function to get value of  
// the current maximum element 
static int getMax() 
{ 
  return H[0]; 
} 
  
// Function to remove the element 
// located at given index 
static void remove(int i) 
{ 
  H[i] = getMax() + 1; 
  
  // Shift the node to the root 
  // of the heap 
  shiftUp(i); 
  
  // Extract the node 
  extractMax(); 
} 
    
static void swap(int i, int j) 
{ 
  int temp= H[i]; 
  H[i] = H[j]; 
  H[j] = temp; 
} 
  
// Driver Code 
public static void main(String[] args) 
{ 
  
  /*           45 
            /        \ 
           31      14 
          /  \    /  \ 
         13  20  7   11 
        /  \ 
       12   7 
    Create a priority queue shown in  
    example in a binary max heap form. 
    Queue will be represented in the 
    form of array as: 
    45 31 14 13 20 7 11 12 7 */
  
  // Insert the element to the 
  // priority queue 
  insert(45); 
  insert(20); 
  insert(14); 
  insert(12); 
  insert(31); 
  insert(7); 
  insert(11); 
  insert(13); 
  insert(7); 
  
  int i = 0; 
  
  // Priority queue before extracting max 
  System.out.print("Priority Queue : "); 
  while (i <= size)  
  { 
    System.out.print(H[i] + " "); 
    i++; 
  } 
  
  System.out.print("\n"); 
  
  // Node with maximum priority 
  System.out.print("Node with maximum priority : " +  
                    extractMax() + "\n"); 
  
  // Priority queue after extracting max 
  System.out.print("Priority queue after " +  
                   "extracting maximum : "); 
  int j = 0; 
  while (j <= size)  
  { 
    System.out.print(H[j] + " "); 
    j++; 
  } 
  
  System.out.print("\n"); 
  
  // Change the priority of element 
  // present at index 2 to 49 
  changePriority(2, 49); 
  System.out.print("Priority queue after " +  
                   "priority change : "); 
  int k = 0; 
  while (k <= size)  
  { 
    System.out.print(H[k] + " "); 
    k++; 
  } 
  
  System.out.print("\n"); 
  
  // Remove element at index 3 
  remove(3); 
  System.out.print("Priority queue after " +  
                   "removing the element : "); 
  int l = 0; 
  while (l <= size)  
  { 
    System.out.print(H[l] + " "); 
    l++; 
  } 
} 
} 
  
/*
Output:
Priority Queue : 45 31 14 13 20 7 11 12 7 
Node with maximum priority : 45 
Priority queue after extracting maximum : 31 20 14 13 7 7 11 12 
Priority queue after priority change : 49 20 31 13 7 7 11 12 
Priority queue after removing the element : 49 20 31 12 7 7 11  */
