import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        test: for(int tc = 0 ; tc < T ; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(x == y) {
                sb.append(x).append("\n");
                continue;
            }

            // 1. 최대 몇번째해까지 있는지 계산하기 => 최소공배수 구하기
            int min = Math.min(M, N);
            int maxCnt = 1;
            int m = M; int n = N;
            for(int i = 2 ; i*i < min ; i++) {
                while(m % i == 0 && n % i == 0) {
                    maxCnt *= i;
                    m /= i;
                    n /= i;
                }
            }
            maxCnt *= m*n;

            // 2. 계산하기
            int sub = Math.max(M, N) - min;
            if(min == M) {
                int ny = x;
                for(int i = 1 ; i < maxCnt / M ; i++) {
                    ny = ny-sub <= 0 ? ny+N-sub : ny-sub;
                    if(ny == y) {
                        sb.append(i*M+x).append("\n");
                        continue test;
                    }
                }
            } else {
                int nx = y;
                for(int i = 1 ; i < maxCnt / N ; i++) {
                    nx = nx-sub <= 0 ? nx+M-sub : nx-sub;
                    if(nx == x) {
                        sb.append(i*N+y).append("\n");
                        continue test;
                    }
                }
            }

            sb.append(-1).append("\n");
        }

        System.out.println(sb);
    }
}