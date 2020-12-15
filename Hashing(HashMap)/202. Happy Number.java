/* Question:
Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.

 

Example 1:

Input: n = 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
Example 2:

Input: n = 2
Output: false
 

Constraints:

1 <= n <= 231 - 1  */

//Solution 1:  Detect Cycles with a HashSet

A good way to get started with a question like this is to make a couple of examples. Let's start with the number 77. The next number will be 4949 (as 7^2 = 497 
2
 =49), and then the next after that will be 9797 (as 4^2 + 9^2 = 974 
2
 +9 
2
 =97). We can continually repeat the process of squaring and then adding the digits until we get to 11. Because we got to 11, we know that 77 is a happy number, and the function should return true.

The chain of numbers starting with 7. It has the numbers 7, 49, 97, 130, 10 and 1.

As another example, let's start with 116116. By repeatedly applying the squaring and adding process, we eventually get to 5858, and then a bit after that, we get back to 5858. Because we are back at a number we've already seen, we know there is a cycle, and therefore it is impossible to ever reach 11. So for 116116, the function should return false.

The chain of numbers starting with 116. It has the numbers 116, 38, 73, 58, and then goes in a circle to 89, 145, 42, 20, 4, 16, 37, and back to 58.

Based on our exploration so far, we'd expect continually following links to end in one of three ways.

It eventually gets to 11.
It eventually gets stuck in a cycle.
It keeps going higher and higher, up towards infinity.
That 3rd option sounds really annoying to detect and handle. How would we even know that it is going to continue going up, rather than eventually going back down, possibly to 1?1? Luckily, it turns out we don't need to worry about it. Think carefully about what the largest next number we could get for each number of digits is.

Digits	Largest	Next
1	9	81
2	99	162
3	999	243
4	9999	324
13	9999999999999	1053
For a number with 33 digits, it's impossible for it to ever go larger than 243243. This means it will have to either get stuck in a cycle below 243243 or go down to 11. Numbers with 44 or more digits will always lose a digit at each step until they are down to 33 digits. So we know that at worst, the algorithm might cycle around all the numbers under 243243 and then go back to one it's already been to (a cycle) or go to 11. But it won't go on indefinitely, allowing us to rule out the 3rd option.

Even though you don't need to handle the 3rd case in the code, you still need to understand why it can never happen, so that you can justify why you didn't handle it.

Algorithm

There are 2 parts to the algorithm we'll need to design and code.

Given a number nn, what is its next number?
Follow a chain of numbers and detect if we've entered a cycle.
Part 1 can be done by using the division and modulus operators to repeatedly take digits off the number until none remain, and then squaring each removed digit and adding them together. Have a careful look at the code for this, "picking digits off one-by-one" is a useful technique you'll use for solving a lot of different problems.

Part 2 can be done using a HashSet. Each time we generate the next number in the chain, we check if it's already in our HashSet.

If it is not in the HashSet, we should add it.
If it is in the HashSet, that means we're in a cycle and so should return false.
The reason we use a HashSet and not a Vector, List, or Array is because we're repeatedly checking whether or not numbers are in it. Checking if a number is in a HashSet takes O(1)O(1) time, whereas for the other data structures it takes O(n)O(n) time. Choosing the correct data structures is an essential part of solving these problems.

//Solution(o(log n) time and space)
class Solution {

    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }
        return n == 1;
    }
}

//Solution 2(better): Floyd's Cycle-Finding Algorithm
(O(log n) time and o(1) space)

class Solution {

     public int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    public boolean isHappy(int n) {
        int slowRunner = n;
        int fastRunner = getNext(n);
        while (fastRunner != 1 && slowRunner != fastRunner) {
            slowRunner = getNext(slowRunner);
            fastRunner = getNext(getNext(fastRunner));
        }
        return fastRunner == 1;
    }
}
