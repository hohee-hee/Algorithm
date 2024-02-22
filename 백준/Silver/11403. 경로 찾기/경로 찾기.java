import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] graph = new ArrayList[N];
        for(int i = 0 ; i < N ; i++) graph[i] = new ArrayList<>();

        StringTokenizer st;
        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++) {
                if(Integer.parseInt(st.nextToken()) == 1) graph[i].add(j);
            }
        }

        int[][] answer = new int[N][N];

        for(int i = 0 ; i < N ; i++) {
            ArrayDeque<Integer> q = new ArrayDeque<>();
            boolean[] isVisited = new boolean[N];
            q.offerLast(i);

            while(!q.isEmpty()) {
                int cn = q.pollFirst();

                for(int j = 0 ; j < graph[cn].size() ; j++) {
                    int nn = graph[cn].get(j);

                    if(isVisited[nn]) continue;

                    answer[i][nn] = 1;
                    q.offerLast(nn);
                    isVisited[nn] = true;
                }
            }
        }

        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++) {
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}