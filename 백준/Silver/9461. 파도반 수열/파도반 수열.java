import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
  
		int T = Integer.parseInt(br.readLine());
        ArrayList<Long> dp = new ArrayList<>();
        dp.add((long) 1);
        dp.add((long) 1);
        dp.add((long) 1);
        dp.add((long) 2);
        dp.add((long) 2);
        
        for(int tc = 0 ; tc < T ; tc++) {
        	int N = Integer.parseInt(br.readLine());
        	
        	if(N <= dp.size()) {
        		sb.append(dp.get(N-1) + "\n");
        		continue;
        	}
        	
        	int idx = dp.size();
        	while(idx < N) {
        		dp.add(dp.get(idx-1) + dp.get(idx-5));
        		idx++;
        	}
        	

    		sb.append(dp.get(N-1) + "\n");
        	
        }
        
        System.out.println(sb);
	}
}
