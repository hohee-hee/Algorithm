import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++) arr[i] = Integer.parseInt(st.nextToken());

        long[] sum = new long[N+1];
        for(int i = 1 ; i <= N ; i++) sum[i] = sum[i-1] + arr[i-1];

        int lp = 0;
        int rp = 1;
        long answer = 0;
        while(lp <= rp && rp < N+1) {
            long curr = sum[rp] - sum[lp];

            if(curr > M) {
                lp++;
            } else {
                if(curr == M) answer++;
                rp++;
            }
        }


        System.out.println(answer);
    }
}

