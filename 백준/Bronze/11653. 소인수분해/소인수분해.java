import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N == 1) return;
        
        boolean[] sieve = new boolean[N + 1];
        sieve[1] = true;
        for (int i = 2; i*i <= N; i++) {
            if (sieve[i]) continue;
            for (int j = i*i; j <= N; j+= i) {
                sieve[j] = true;
            }
        }

        if(!sieve[N]) {
            System.out.println(N);
            return;
        }

        for(int i = 2 ; i <= N ; i++) {
            if(sieve[i]) continue;

            while(N % i == 0) {
                sb.append(i).append("\n");
                N /= i;
            }

            if(!sieve[N]) {
                sb.append(N).append("\n");
                break;
            }
        }

        System.out.println(sb);
    }
}