import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] dist = new int[N+1][N+1];
        for(int i = 1 ; i <= N ; i++) {
            for(int j = 1 ; j <= N ; j++) dist[i][j] = i == j ? 0 : 10000;
        }

        for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            dist[A][B] = 1;
            dist[B][A] = 1;
        }

        for(int k = 1 ; k <= N ; k++) {
            for(int i = 1 ; i <= N ; i++) {
                for(int j = 1 ; j <= N ; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }


        int sum = 0;
        int max = Integer.MAX_VALUE;
        int answer = 0;
        for(int i = 1 ; i <= N ; i++) {
            sum = 0;
            for(int j = 1 ; j <= N ; j++) {
                sum += dist[i][j];
            }
            if(sum < max) {
                answer = i;
                max = sum;
            }
        }



        System.out.println(answer);
    }
}