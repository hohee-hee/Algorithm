import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
        // 1. 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int tc = 0 ; tc < T ; tc++) {
            int N = Integer.parseInt(br.readLine());
            
        	PriorityQueue<Long> pq = new PriorityQueue<>(new Comparator<Long>() {
        		@Override
        		public int compare(Long o1, Long o2) {        			
        			return (int) (o1 - o2);
        		}
			});
        	
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int i = 0 ; i < N ; i++) {
        		pq.add(Long.parseLong(st.nextToken()));
        	}
        	
        	long answer = 0;
        	while(pq.size() > 1) {
        		long file1 = pq.poll();
        		long file2 = pq.poll();
        		long temp = file1 + file2;
        		answer += temp;
        		pq.add(temp);
        	}
        	
        	System.out.println(answer);
        }
        
	}
}
