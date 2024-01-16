import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static StringBuilder sb;
    public static int[] per;
    public static boolean[] isChosen;

    public static void main(String[] args) throws IOException{
        sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        per = new int[M];
        isChosen = new boolean[N+1];

        bt(0, N, M);

        System.out.println(sb);
    }

    public static void bt(int cnt, int N, int M) {
        if(cnt == M) {
            for(int i = 0; i < M ; i++) sb.append(per[i]).append(" ");
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= N ; i++) {
            if(isChosen[i]) continue;
            per[cnt] = i;
            isChosen[i] = true;
            bt(cnt+1, N, M);
            isChosen[i] = false;
            per[cnt] = 0;
        }

    }
}