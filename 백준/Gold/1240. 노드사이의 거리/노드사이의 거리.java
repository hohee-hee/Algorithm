import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<int[]>[] graph = new ArrayList[N+1];
        for(int i = 1 ; i <= N ; i++) graph[i] = new ArrayList<>();

        for(int i = 0 ; i < N-1 ; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            graph[u].add(new int[]{v, dist});
            graph[v].add(new int[]{u, dist});
        }

        bfs: for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int sn = Integer.parseInt(st.nextToken());
            int en = Integer.parseInt(st.nextToken());

            ArrayDeque<int[]> q = new ArrayDeque<>();
            q.offerLast(new int[]{sn, 0});
            boolean[] isVisited = new boolean[N+1];
            isVisited[sn] = true;
            while(!q.isEmpty()) {
                int cn = q.peekFirst()[0];
                int cd = q.pollFirst()[1];

                for(int j = 0 ; j < graph[cn].size() ; j++) {
                    int nn = graph[cn].get(j)[0];
                    int nd = graph[cn].get(j)[1] + cd;

                    if(isVisited[nn]) continue;

                    if(nn == en) {
                        sb.append(nd).append("\n");
                        continue bfs;
                    }
                    isVisited[nn] = true;
                    q.offerLast(new int[]{nn, nd});
                }
            }
        }

        System.out.println(sb);
    }
}
