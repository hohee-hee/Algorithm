import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] lines = new int[K];
        for(int i = 0 ; i < K ; i++) lines[i] = Integer.parseInt(br.readLine());

        // 이분탐색
        long sp = 1;
        long ep = 2147483647;
        long mid = (sp+ep+1) / 2;
        long answer = 0;
        while(sp < ep) {
            long cnt = lineCounter(lines, mid, N);
            if(cnt >= N && answer < mid) answer = mid;

            if(cnt < N) ep = mid - 1;
            else sp = mid;

            mid = (sp+ep+1) / 2;
        }
        
        if(sp == ep) {
            long cnt = lineCounter(lines, sp, N);
            if(cnt >= N && answer < sp) answer = sp;
        }

        System.out.println(answer);
    }

    public static long lineCounter(int[] lines, long X, int N) {
        long cnt = 0;
        for(int i = 0 ; i < lines.length ; i++) cnt += lines[i] / X;
        return cnt;
    }
}