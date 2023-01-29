import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] words = new String[N];
		for(int i = 0 ; i < N ; i++) {
			words[i] = sc.next();
		}
		
		Arrays.sort(words,new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if(o1.length() == o2.length())
					return o1.compareTo(o2);
				else
					return o1.length() - o2.length();
			}
			
		});
		for(int i = 0 ; i < N ; i++) {
			if(i == 0)
				System.out.println(words[i]);
			else if(!words[i].equals(words[i-1]))
				System.out.println(words[i]);
			
		}
	}
}
