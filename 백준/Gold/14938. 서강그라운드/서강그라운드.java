import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[] items = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= n ; i++) items[i] = Integer.parseInt(st.nextToken());

        int[][] graph = new int[n+1][n+1];
        for(int i = 1 ; i <= n ; i++) {
            for(int j = 1; j <= n ;j++) {
                if(i == j) graph[i][j] = 0;
                else graph[i][j] = 2000;
            }
        }

        for(int i = 0 ; i < r ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            if(a == b) continue;
            graph[a][b] = l;
            graph[b][a] = l;
        }

        for(int k = 1 ; k <= n; k++) {
            for(int i = 1 ; i <= n ; i++) {
                for(int j = 1 ; j <= n ; j++) {
                    if(graph[i][j] > graph[i][k] + graph[k][j]) graph[i][j] = graph[i][k] + graph[k][j];
                }
            }
        }
        
        int answer = 0;
        for(int i = 1 ; i <= n ; i++) {
            int temp = 0;
            for(int j = 1 ; j <= n ; j++) {
                if(graph[i][j] <= m) temp += items[j];
            }
            if(answer < temp) answer = temp;
        }

        System.out.println(answer);
    }
}

