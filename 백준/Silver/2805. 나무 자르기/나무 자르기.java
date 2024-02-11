import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] trees = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++) trees[i] = Integer.parseInt(st.nextToken());

        // 이분탐색
        long sp = 1;
        long ep = 1000000000;
        long mid = 0;
        long H = 0;
        while(sp < ep) {
            mid = (sp+ep+1) / 2;
            long len = 0;
            for(int i = 0; i < N ; i++) {
                len = trees[i] - mid < 0 ? len : len + trees[i] - mid;
            }
            if(len >= M) H = mid;

            if(len < M) ep = mid - 1;
            else sp = mid;
        }

        System.out.println(H);
    }

}