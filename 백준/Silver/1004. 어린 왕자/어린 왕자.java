import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc = 0 ; tc < T ; tc++) {
            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());

            int answer = 0;
            int N = Integer.parseInt(br.readLine());
            for(int i = 0 ; i < N ; i++) {
                st = new StringTokenizer(br.readLine());
                int cx = Integer.parseInt(st.nextToken());
                int cy = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                boolean startChk = dist(sx, sy, cx, cy) < r * r;
                boolean endChk = dist(ex, ey, cx, cy) < r * r;
                if(startChk == endChk) continue;

                answer++;
            }

            sb.append(answer).append("\n");

        }

        System.out.println(sb);
    }

    public static int dist(int x1, int y1, int x2, int y2) {
        return Math.abs(x1-x2) * Math.abs(x1-x2) + Math.abs(y1-y2) * Math.abs(y1-y2);
    }
}