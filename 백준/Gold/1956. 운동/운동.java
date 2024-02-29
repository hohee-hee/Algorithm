import sun.reflect.generics.tree.Tree;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int[][] dist = new int[V+1][V+1];
        for(int i = 1 ; i <= V ; i++) Arrays.fill(dist[i], -1);

        for(int i = 0 ; i < E ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            dist[a][b] = c;
        }

        for(int k = 1 ; k <= V ; k++) {
            for(int r = 1 ; r <= V ; r++) {
                for(int c = 1; c <= V ; c++) {
                    if(dist[r][k] == -1 || dist[k][c] == -1) continue;
                    if(dist[r][c] == -1 || dist[r][c] > dist[r][k] + dist[k][c]) dist[r][c] = dist[r][k] + dist[k][c];
                }
            }
        }

        int answer = -1;
        for(int r = 1 ; r <= V ; r++) {
            for(int c = 1; c <= V ; c++) {
                if(dist[r][c] != -1 && dist[c][r] != -1) {
                    answer = answer == -1 ? answer = dist[r][c] + dist[c][r] : Math.min(answer, dist[r][c] + dist[c][r]);
                }
            }
        }

        System.out.println(answer);
    }
}

