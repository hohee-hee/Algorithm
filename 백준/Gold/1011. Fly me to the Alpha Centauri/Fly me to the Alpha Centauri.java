import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc = 0 ; tc < T ; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int sub = y-x;
            int answer = 1;
            int cnt = 0;
            outer: while(cnt < sub) {
                for(int i = 0 ; i < (answer+1)/2 ; i++) {
                    cnt++;
                    if(cnt == sub) break outer;
                }
                answer++;
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }
}