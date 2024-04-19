import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] des = new int[101][1];
        for(int i = 0 ; i < N+M ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            des[start][0] = end;
        }

        ArrayDeque<int[]> q = new ArrayDeque<>();
        boolean[] isVisited = new boolean[101];
        q.offerLast(new int[]{1, 0});
        isVisited[1] = true;
        while(!q.isEmpty()) {
            int cc = q.peekFirst()[0];
            int cd = q.pollFirst()[1];

            for(int num = 1 ; num <= 6 ; num++) {
                int nc = cc + num;

                if(nc > 100) continue;
                if(nc == 100) {
                    System.out.println(cd + 1);
                    return;
                }

                if(des[nc][0] != 0) nc = des[nc][0];
                if(isVisited[nc]) continue;

                isVisited[nc] = true;
                q.offerLast(new int[]{nc, cd+1});
            }
        }

    }
}