import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] graph = new ArrayList[N+1];
        for(int i = 1 ; i <= N ; i++) graph[i] = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        while(a != -1 && b != -1) {
            graph[a].add(b);
            graph[b].add(a);

            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
        }

        TreeMap<Integer, ArrayList<Integer>> scores = new TreeMap<>();

        for(int i = 1 ; i <= N ; i++) {
            if(graph[i].size() == 0) continue;

            ArrayDeque<int[]> q = new ArrayDeque<>();
            q.offerLast(new int[]{i, 0});
            boolean[] isVisited = new boolean[N+1];
            isVisited[i] = true;

            int cm = 0; int cd = 0;
            while(!q.isEmpty()) {
                cm = q.peekFirst()[0];
                cd = q.pollFirst()[1];

                for(int j = 0 ; j < graph[cm].size() ; j++) {
                    int nm = graph[cm].get(j);

                    if(isVisited[nm]) continue;

                    isVisited[nm] = true;
                    q.offerLast(new int[]{nm, cd+1});
                }
            }

            if(!scores.containsKey(cd)) scores.put(cd, new ArrayList<Integer>());

            ArrayList<Integer> list = scores.get(cd);
            list.add(i);
            scores.put(cd, list);
        }

        int huboScore = scores.firstKey();
        ArrayList<Integer> huboList = scores.get(huboScore);
        int huboCnt = huboList.size();
        sb.append(huboScore).append(" ").append(huboCnt).append("\n");

        Collections.sort(huboList);
        for(int i = 0 ; i < huboList.size() ; i++) {
            sb.append(huboList.get(i)).append(" ");
        }
        System.out.println(sb);
    }
}