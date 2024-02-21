import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] graph = new ArrayList[N+1];
        for(int i = 1 ; i <= N ; i++) graph[i] = new ArrayList<>();

        for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        boolean[] isVisited = new boolean[N+1];
        int answer = 0;
        for(int i = 1 ; i <= N ; i++) {
            if(isVisited[i]) continue;

            ArrayDeque<Integer> q = new ArrayDeque<>();
            q.offerLast(i);
            isVisited[i] = true;
            while(!q.isEmpty()) {
                int cn = q.pollFirst();

                for(int j = 0 ; j < graph[cn].size(); j++) {
                    int tn = graph[cn].get(j);
                    if(isVisited[tn]) continue;
                    q.offerLast(tn);
                    isVisited[tn] = true;
                }
            }

            answer++;
        }

        System.out.println(answer);
    }
}