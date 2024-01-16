import java.io.*;
import java.util.*;

public class Main {
    public static StringBuilder sb;
    public static void main(String[] args) throws IOException{
        sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            if(k == 0) break;

            int[] S = new int[k];
            for(int i = 0 ; i < k ; i++) S[i] = Integer.parseInt(st.nextToken());

            bt(0, 0, k, S, new int[6]);

            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void bt (int cnt, int sidx, int k, int[] S, int[] lotto) {
        if(cnt == 6) {
            for(int i = 0 ; i < 6 ; i++) sb.append(lotto[i]).append(" ");
            sb.append("\n");

            return;
        }

        for(int i = sidx ; i < k ; i++) {
            lotto[cnt] = S[i];
            bt(cnt+1, i+1, k, S, lotto);
        }
    }
}