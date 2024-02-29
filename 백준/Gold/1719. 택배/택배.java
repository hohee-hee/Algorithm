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
        int[][] next = new int[N+1][N+1];
        for(int r = 1 ; r <= N ; r++) {
            for(int c = 1; c <= N ; c++) {
                if(r == c) graph[r][c] = 0;
                else graph[r][c] = 200002;
            }
        }

        for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            if (graph[u][v] > t) {
                graph[u][v] = t;
                next[u][v] = v;
            }

            if (graph[v][u] > t) {
                graph[v][u] = t;
                next[v][u] = u;
            }
        }

        for(int k = 1 ; k <= N ; k++) {
            for(int r = 1 ; r <= N ; r++) {
                for(int c = 1; c <= N ; c++) {
                    if(graph[r][c] > graph[r][k] + graph[k][c]) {
                        graph[r][c] = graph[r][k] + graph[k][c];
                        next[r][c] = next[r][k];
                    }
                }
            }
        }

        for(int r = 1 ; r <= N ; r++) {
            for(int c = 1; c <= N ; c++) {
                if(next[r][c] == 0) sb.append("- ");
                else sb.append(next[r][c]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

