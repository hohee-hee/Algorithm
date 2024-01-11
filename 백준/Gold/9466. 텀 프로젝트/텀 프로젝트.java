import java.io.*;
import java.util.*;

public class Main {

    public static boolean[] hasTeam, isVisited;
    public static int teamed;

    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 0 ; tc < T ; tc++) {

            int N = Integer.parseInt(br.readLine());
            teamed = 0;
            hasTeam = new boolean[N+1];
            isVisited = new boolean[N+1];
            int[] stu = new int[N+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 1 ; i <= N ; i++) {
                int target = Integer.parseInt(st.nextToken());
                stu[i] = target;

                if(i == target) {
                    teamed++;
                    hasTeam[i] = true;
                }
            }

            for(int i = 1 ; i <= N ; i++) {
                if(hasTeam[i]) continue;
                bfs(stu, i);
            }

            sb.append(N - teamed).append("\n");
        }

        System.out.println(sb);
    }

    public static void bfs(int[] stu, int num){
        if(isVisited[num]) return; // 이미 방문

        isVisited[num] = true;
        int next = stu[num];

        if(!isVisited[next]) bfs(stu, next);
        else {
            if(!hasTeam[next]) {
                teamed++;
                for(int s = next ; s != num ; s = stu[s]) teamed++;
            }
        }

        hasTeam[num] = true;
    }
}