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
            int BCD = 1;
            int LCM = 1;
            int max = Math.max(N, M);
            int min = Math.min(N, M);
            PriorityQueue<Integer> divisor = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2-o1;
                }
            });

            for(int i = 1 ; i*i <= max ; i++) {
                if(i*i == max) {
                    divisor.offer(i);
                }
                else if(max%i == 0) {
                    divisor.offer(i);
                    divisor.offer(max/i);
                }
            }

            while(!divisor.isEmpty()) {
                int num = divisor.poll();
                if(min % num == 0) {
                    BCD = num;
                    break;
                }
            }

            if(BCD == 1) LCM = M*N;
            else LCM = BCD * (M/BCD) * (N/BCD);

            if(M == x) x = 0;
            if(N == y) y = 0;

            if(x == 0 && y == 0) {
                sb.append(LCM).append("\n");
                continue test;
            }

            for(int cy = x ; cy <= LCM ; cy += M) {
                if(cy % N == y) {
                    sb.append(cy).append("\n");
                    continue test;
                }
            }

            sb.append(-1).append("\n");
        }

        System.out.println(sb);
    }
}