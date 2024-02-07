import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] sieve = new boolean[N+1];
        sieve[1] = true;
        int cnt = 0;
        int answer = 0;
        for(int i = 2 ; i <= N ; i++) {
            if(sieve[i]) continue;
            int multi = 1;
            while(multi*i <= N && cnt < K) {
                if(sieve[i*multi]) {
                    multi++;
                    continue;
                }
                sieve[i*multi] = true;
                cnt++;
                answer = i*multi;
                multi++;

            }
            if(cnt == K) break;
        }

        System.out.println(answer);
    }
}