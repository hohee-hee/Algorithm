import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 조기종료 조건
        if(N == K) {
            System.out.println(0);
            return;
        } else if(N > K) {
            System.out.println(N-K);
            return;
        }

        // BFS
        int[] dx = { 1, -1 };

        ArrayDeque<int[]> q = new ArrayDeque<>();
        int[] minT = new int[200001];
        for(int i = 0 ; i < 200001 ; i++) minT[i] = Integer.MAX_VALUE;
        q.offer(new int[]{N, 0});
        minT[N] = 0;

        int answer = Integer.MAX_VALUE;

        bfs: while(!q.isEmpty()) {

            int cx = q.peek()[0];
            int ct = q.poll()[1];

            if(ct > answer) continue;

            // 1. 순간이동
            int nx = cx*2;

            if(nx == K && ct < answer) {
                answer = ct;
            }

            if(nx-K <= K-N && minT[nx] > ct) {
                q.offer(new int[]{ nx, ct });
                minT[nx] = ct;
            }

            // 2. 이동
            for(int d = 0 ; d < 2 ; d++) {
                nx = cx + dx[d];

                if(nx == K && (ct+1) < answer) {
                    answer = ct+1;
                }

                if(nx >= 0 && nx-K <= K-N && minT[nx] > ct+1) {
                    q.offer(new int[]{ nx, ct+1 });
                    minT[nx] = ct+1;
                }
            }

        }

        System.out.println(answer);
    }
}