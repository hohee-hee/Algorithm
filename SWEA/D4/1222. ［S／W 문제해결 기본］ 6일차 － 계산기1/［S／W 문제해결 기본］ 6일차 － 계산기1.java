import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int test_case = 1 ; test_case <= 10; test_case++) {
			Stack<Character> stack = new Stack<>();
			int len = sc.nextInt();
			String cal = sc.next();			
			int val_sum = 0;
			for(int i = 0 ; i < len ; i++) {
				stack.push(cal.charAt(i));
			}
			
			while(!stack.isEmpty()) {
				if(stack.peek() != '+') {
					val_sum += stack.pop() -'0';
				}
				else
				{
					stack.pop();
				}
			}
			
			System.out.printf("#%d %d\n", test_case, val_sum);
		}
	}
}
