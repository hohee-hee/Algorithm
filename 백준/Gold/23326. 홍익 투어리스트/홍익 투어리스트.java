import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        TreeSet<Integer> spots = new TreeSet<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N ; i++) {
            int type = Integer.parseInt(st.nextToken());
            if(type == 1) spots.add(i);
        }

        int dohyun = 1;
        for(int i = 0 ; i < Q ; i++) {
            st = new StringTokenizer(br.readLine());
            int query = Integer.parseInt(st.nextToken());
            if(query == 1) {
                int n = Integer.parseInt(st.nextToken());
                if(spots.contains(n)) spots.remove(n);
                else spots.add(n);
            } else if(query == 2) {
                int x = Integer.parseInt(st.nextToken());
                dohyun = (dohyun + x) % N == 0 ? N : (dohyun + x) % N;
            } else {
                int answer = 0;
                if(spots.isEmpty()) {
                    answer = -1;
                } else if(spots.ceiling(dohyun) == null) {
                    answer = spots.first()+N-dohyun;
                } else {
                    int target = spots.ceiling(dohyun);
                    if(target < dohyun) answer = target+N-dohyun;
                    else answer = target - dohyun;
                }
                sb.append(answer).append("\n");
            }
        }

        System.out.println(sb);
    }
}