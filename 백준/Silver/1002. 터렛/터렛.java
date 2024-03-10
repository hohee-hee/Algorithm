import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 0 ; tc < T ; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            if(x1 == x2 && y1 == y2) {
                if(r1 == r2) {
                    sb.append(-1).append("\n");
                    continue;
                } else {
                    sb.append(0).append("\n");
                    continue;
                }
            }

            // 1. 둘 사이의 거리 구하기
            long dist = ((x1-x2) * (x1-x2)) + ((y1-y2) * (y1-y2));
            long sum = (r1+r2) * (r1+r2);
            if(dist == sum) sb.append(1);
            else if(dist > sum) sb.append(0);
            else if(Math.sqrt(dist) + Math.min(r1, r2) < Math.max(r1,r2)) sb.append(0);
            else if(Math.sqrt(dist) + Math.min(r1, r2) > Math.max(r1,r2)) sb.append(2);
            else sb.append(1);
            sb.append("\n");

        }

        System.out.println(sb);
    }
}