import java.util.Scanner;

public class Solution {
	
	static int[] heap;
	static int lastIdx;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int tc = 1 ; tc <= T ; tc++) {
			sb.append("#" + tc);
			
			int N = sc.nextInt();
			heap = new int[N+1];
			lastIdx = 0;
			
			for(int i = 0 ; i < N ; i++) {
				int c = sc.nextInt();
				if(c == 1) {
					heap[++lastIdx] = sc.nextInt();
					int cur = lastIdx;
					while(cur > 1 && heap[cur] > heap[cur/2]) {
						swap(cur, cur/2);
						cur /= 2;
					}
				}
				
				else {
					if(heap[1] == 0) { 
						sb.append(" " + -1); 
						continue;
					}
					else { sb.append(" " + heap[1]); }
					
					heap[1] = heap[lastIdx];
					heap[lastIdx--] = 0;
							
					int cur = 1;
					
					while(true) {
                        int child = cur * 2;

                        //자식들 중 큰 값 찾기
                        if(child + 1 <= lastIdx && heap[child] < heap[child+1]) {
                            child++;
                        }
						if(child > lastIdx || heap[cur] > heap[child]) {
							break;
						}
						
						swap(cur, child);
						cur = child;
					}
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	private static void swap(int a, int b) {
		int tmp = heap[a];
		heap[a] = heap[b];
		heap[b] = tmp;
	}
}
