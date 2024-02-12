import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] sum = new int[N+1];
        sum[0] = 0;
        for(int i = 1 ; i <= N ; i++) {
            sum[i] = Integer.parseInt(st.nextToken());
            sum[i] += sum[i-1];
        }

        int lp = 0;
        int rp = 1;
        int minLen = Integer.MAX_VALUE;
        while(lp <= N && rp <= N && lp < rp) {
            if(sum[rp] - sum[lp] >= S) minLen = Math.min(minLen, rp-lp);
            
            if(sum[rp] - sum[lp] < S) rp++;
            else lp++;
        }

        if(minLen == Integer.MAX_VALUE) minLen = 0;

        System.out.println(minLen);
    }
}
