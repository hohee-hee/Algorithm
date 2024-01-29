import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc = 0 ; tc < T ; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] A = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < N ; i++) A[i] = Integer.parseInt(st.nextToken());

            int[] B = new int[M];
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < M ; i++) B[i] = Integer.parseInt(st.nextToken());

            Arrays.parallelSort(A);
            Arrays.parallelSort(B);

            int pt = 0;
            int answer = 0;
            // 포인터 첫 위치 찾기
            int num = B[0];
            for(int i = 0 ; i < N ; i++) {
                pt = i;
                if(num < A[i]) break;
            }

            if(pt == N-1 && num >= A[pt]) {
                sb.append(answer).append("\n");
                continue;
            }

            answer += N - pt;
            if(M == 1) {
                sb.append(answer).append("\n");
                continue;
            }

            outer: for(int i = 1 ; i < M ; i++) {
                num = B[i];
                while(num >= A[pt]) {
                    pt++;
                    if(pt >= N) break outer;
                }
                answer += N - pt;
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }
}

