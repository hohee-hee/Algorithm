
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1 ; test_case <= T ; test_case++) {
			char[] text = sc.next().toCharArray();
			ArrayList<Character> part = new ArrayList<>();
			
			for(int i = 0 ; i < 30 ; i++) {
				if(part.size() == 0) { 
					part.add(text[i]);
					continue;
				}
				
				else {
					boolean flag = true;
					for(int j = 0 ; j < part.size() ; j++) {
						if(text[i+j] != part.get(j)) {
							flag = false;
							part.add(text[i]);
							break;
						}
					}
					if(flag) {
						System.out.printf("#%d %d\n",test_case, part.size());
						break;
					}
				}
			}			
		}
	}
}
