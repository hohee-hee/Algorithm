import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        test: for(int tc = 0 ; tc < K ; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            ArrayList<Integer>[] graph = new ArrayList[V+1];
            for(int i = 1 ; i <= V ; i++) graph[i] = new ArrayList<>();

            for(int i = 0 ; i < E ; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                graph[u].add(v);
                graph[v].add(u);
            }

            int[] vInfo = new int[V+1];
            find: for(int i = 1 ; i <= V ; i++) {
                if(vInfo[i] != 0) continue;

                vInfo[i] = 1;

                ArrayDeque<Integer> q = new ArrayDeque<>();
                q.offerLast(i);
                boolean[] isVisited = new boolean[V+1];
                isVisited[i] = true;
                while(!q.isEmpty()) {
                    int cv = q.pollFirst();
                    int cg = vInfo[cv];
                    int og = cg == 1 ? 2 : 1;

                    for(int j = 0 ; j < graph[cv].size() ; j++) {
                        int nv = graph[cv].get(j);
                        if(vInfo[nv] == cg) {
                            sb.append("NO").append("\n");
                            continue test;
                        }

                        vInfo[nv] = og;
                        if(isVisited[nv]) continue;
                        q.offerLast(nv);
                        isVisited[nv] = true;
                    }
                }
            }

            sb.append("YES").append("\n");

        }

        System.out.println(sb);
    }
}
