import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static StringBuilder sb;
    public static int[] per;

    public static void main(String[] args) throws IOException{
        sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        per = new int[M];

        bt(0, 1, N, M);

        System.out.println(sb);
    }

    public static void bt(int cnt, int pt, int N, int M) {
        if(cnt == M) {
            for(int i = 0; i < M ; i++) sb.append(per[i]).append(" ");
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= N ; i++) {
            per[cnt] = i;
            bt(cnt+1, i+1, N, M);
            per[cnt] = 0;
        }

    }
}