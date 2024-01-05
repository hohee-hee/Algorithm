import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] children = new ArrayList[N+1];
        for(int i = 0 ; i < N+1 ; i++) children[i] = new ArrayList<>();

        for(int i = 0 ; i < N - 1 ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            children[num1].add(num2);
            children[num2].add(num1);
        }

        // BFS
        int[] parent = new int[N+1];
        boolean[] isVisited = new boolean[N+1];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offerFirst(1);

        while(!q.isEmpty()) {
            int curr = q.pollLast();

            for(int i = 0 ; i < children[curr].size() ; i++) {
                int nNode = children[curr].get(i);

                if(isVisited[nNode]) continue;

                parent[children[curr].get(i)] = curr;
                q.offerFirst(nNode);
                isVisited[nNode] = true;
            }
        }

        for(int i = 2 ; i < N+1; i++) sb.append(parent[i]).append("\n");
        System.out.println(sb);
    }
}
