/*Problem:
An integer has sequential digits if and only if each digit in the number is one more than the previous digit.

Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.

 

Example 1:

Input: low = 100, high = 300
Output: [123,234]
Example 2:

Input: low = 1000, high = 13000
Output: [1234,2345,3456,4567,5678,6789,12345]
 

Constraints:

10 <= low <= high <= 10^9  */

//My Solution(100 % better in time 73% better in memory 0 ms)

class Solution {
    ArrayList<Integer> res=new ArrayList<>();
    public List<Integer> sequentialDigits(int low, int high) {
        for(int i=1;i<=9;i++){
            int num=i;
            dig(num,low,high);
        }
        Collections.sort(res);
        return res;
    }
    private void dig(int num,int low,int high){
        if(num%10<9)
        num=num*10+(num%10)+1;
        else return;
        if(num>high)  return;
        if(num>=low && num<=high)  res.add(num);
        dig(num,low,high);
    }
}
