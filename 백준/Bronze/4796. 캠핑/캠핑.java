import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        int tc = 1;
        while(L != 0 && P != 0 && V != 0) {
            int answer = V / P * L;
            int mod = V % P;
            answer = mod < L ? answer + mod : answer + L;
            sb.append("Case ").append(tc).append(": ").append(answer).append("\n");

            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());
            tc++;
        }

        System.out.println(sb);
    }
}