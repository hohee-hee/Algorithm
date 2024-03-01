import java.io.*;
import java.util.*;

public class Main {
    public static final int INF = 30000002;
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(br.readLine());

        ArrayList<int[]>[] graph = new ArrayList[V+1];
        for(int i = 1 ; i <= V ; i++) graph[i] = new ArrayList<>();
        for(int i = 0 ; i < E ; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new int[]{v,w});
        }

        int[] answer = new int[V+1];
        Arrays.fill(answer, INF);

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        pq.offer(new int[]{0, K});
        while(!pq.isEmpty()) {
            int dist = pq.peek()[0];
            int target = pq.poll()[1];
            if(answer[target] > dist) answer[target] = dist;

            for(int i = 0 ; i < graph[target].size() ; i++) {
                int nextNode = graph[target].get(i)[0];
                int nextDist = graph[target].get(i)[1] + answer[target];
                if(answer[nextNode] > nextDist) {
                    answer[nextNode] = nextDist;
                    pq.offer(new int[]{answer[nextNode], nextNode});
                }

            }
        }

        for(int i = 1 ; i <= V; i++) {
            if(answer[i] >= INF)sb.append("INF\n");
           else sb.append(answer[i]).append("\n");
        }

        System.out.println(sb);
    }
}
