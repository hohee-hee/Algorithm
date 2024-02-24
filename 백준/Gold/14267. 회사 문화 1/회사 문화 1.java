import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] employee = new ArrayList[N+1];
        for(int i = 1 ; i <= N ; i++) employee[i] = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        int ceo = Integer.parseInt(st.nextToken());
        for(int i = 2 ; i <= N ; i++) {
            int parent = Integer.parseInt(st.nextToken());
            employee[parent].add(i);
        }

        int[] praise = new int[N+1];
        for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            praise[num] += w;
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offerLast(1);
        boolean[] isVisited = new boolean[N+1];
        isVisited[1] = true;
        while(!q.isEmpty()) {
            int cn = q.pollFirst();
            for(int i = 0 ; i < employee[cn].size() ; i++) {
                int nn = employee[cn].get(i);
                if(isVisited[nn]) continue;
                isVisited[nn] = true;
                q.offerLast(nn);
                praise[nn] += praise[cn];
            }
        }

        for(int i = 1 ; i <= N ; i++) sb.append(praise[i]).append(" ");
        System.out.println(sb);
    }
}
