import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] graph = new int[n+1][n+1];
        for(int i = 0 ; i <= n ; i++) Arrays.fill(graph[i], Integer.MAX_VALUE);
        for(int i = 1 ; i <= n ; i++) graph[i][i] = 0;

        StringTokenizer st;
        for(int i = 0 ; i < m ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a][b] = Math.min(graph[a][b], c);
        }

        for(int i = 1 ; i <= n ; i++) {
            for(int j = 1 ; j <= n ; j++) {
                for(int k = 1 ; k <= n ; k++) {
                    int min = graph[j][k];
                    if(graph[j][i] != Integer.MAX_VALUE && graph[i][k] != Integer.MAX_VALUE) min = Math.min(min, graph[j][i] + graph[i][k]);
                    graph[j][k] = min;
                }
            }
        }

        for(int r = 1 ; r <= n ; r++) {
            for(int c = 1 ; c <= n ;c++) {
                if(graph[r][c] == Integer.MAX_VALUE) sb.append(0).append(" ");
                else sb.append(graph[r][c]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

