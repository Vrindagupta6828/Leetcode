/* Question:
Given a mathematical equation using numbers/variables and +, -, *, /. Print the equation in reverse.

Examples:

Input : 20 - 3 + 5 * 2
Output : 2 * 5 + 3 - 20

Input : 25 + 3 - 2 * 11
Output : 11 * 2 - 3 + 25

Input : a + b * c - d / e
Output : e / d - c * b + a  */

//Solution 1
static void reverseeq(String s){
		int l=s.length();
		String temp="";
		for(int i=l-1;i>=0;i--) {
			if(s.charAt(i)==' ') {System.out.print(temp+" "); temp="";}
			else temp=s.charAt(i)+temp;
			//System.out.print(s.charAt(i));
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
         reverseeq(" "+s);
	}
