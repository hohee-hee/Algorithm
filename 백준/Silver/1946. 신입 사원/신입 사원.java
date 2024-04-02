import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int tc = 0 ; tc < T ; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[] ranks = new int[N];
            for(int i = 0 ; i < N ; i++) {
                st = new StringTokenizer(br.readLine());
                int cv = Integer.parseInt(st.nextToken());
                int interview = Integer.parseInt(st.nextToken());
                ranks[cv-1] = interview;
            }

            int answer = 1;
            int minRank = ranks[0];
            for(int i = 1 ; i < N ; i++) {
                if(minRank > ranks[i]) minRank = ranks[i];
                if(minRank < ranks[i]) continue;
                answer++;
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}