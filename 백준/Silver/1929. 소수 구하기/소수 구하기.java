import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        boolean[] sieve = new boolean[N + 1];
        for (int i = 2; i <= N; i++) {
            if (sieve[i]) continue;
            for (int j = 1; j * i <= N; j++) {
                if (sieve[j * i]) continue;
                sieve[j * i] = true;
            }

            if (i >= M) sb.append(i).append("\n");
        }

        System.out.println(sb);
    }
}