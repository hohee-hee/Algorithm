import sun.reflect.generics.tree.Tree;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] graph = new int[N+1][N+1];
        for(int r = 1 ; r <= N ; r++) {
            for(int c = 1; c <= N ; c++) {
                if(r == c) graph[r][c] = 0;
                else graph[r][c] = 250;
            }
        }

        for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (b == 0) {
                graph[u][v] = 0;
                graph[v][u] = Math.min(graph[v][u], 1);
            } else {
                graph[u][v] = 0;
                graph[v][u] = 0;
            }
        }

        for(int k = 1 ; k <= N ; k++) {
            for(int r = 1 ; r <= N ; r++) {
                for(int c = 1; c <= N ; c++) {
                    if(graph[r][c] > graph[r][k] + graph[k][c]) graph[r][c] = graph[r][k] + graph[k][c];
                }
            }
        }

        int k = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < k ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(graph[a][b]).append("\n");
        }
        System.out.println(sb);
    }
}

