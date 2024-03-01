import java.io.*;
import java.util.*;

public class Main {
    public static final int INF = 30000002;
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        ArrayList<int[]>[] graph = new ArrayList[n+1];
        for(int i = 1 ; i <= n ; i++) graph[i] = new ArrayList<>();

        StringTokenizer st;
        for(int i = 0 ; i < m ; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            graph[A].add(new int[]{B, C});
        }

        st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());

        int[] min = new int[n+1];
        Arrays.fill(min, 100000002);
        int[] pre = new int[n+1];
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        pq.offer(new int[]{from, 0});
        min[from] = 0;
        while(!pq.isEmpty()) {
            int city = pq.peek()[0];
            int cost = pq.poll()[1];
            if(min[city] < cost) continue;

            for(int i = 0 ; i < graph[city].size() ; i++) {
                int tCity = graph[city].get(i)[0];
                int tCost = graph[city].get(i)[1] + min[city];
                if(tCost < min[tCity]) {
                    min[tCity] = tCost;
                    pre[tCity] = city;
                    pq.offer(new int[]{tCity, tCost});
                }
            }
        }
        sb.append(min[to]).append("\n");

        int cnt = 0;
        int next = to;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        while(next != from) {
            cnt++;
            stack.offerFirst(next);
            next = pre[next];
        }
        cnt++;
        stack.offerFirst(from);
        sb.append(cnt).append("\n");

        while(!stack.isEmpty()) {
            sb.append(stack.pollFirst()).append(" ");
        }
        System.out.println(sb);
    }
}
