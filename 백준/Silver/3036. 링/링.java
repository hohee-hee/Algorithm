import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int first = Integer.parseInt(st.nextToken());
        for(int i = 1 ; i < N ; i++) {
            int ring = Integer.parseInt(st.nextToken());
            int max = 0;
            for(int j = 1 ; j <= Math.min(first, ring) ; j++) {
                if(ring % j == 0 && first % j ==0) max = Math.max(j, max);
            }
            sb.append(first/max).append("/").append(ring/max).append("\n");
        }

        System.out.println(sb);
    }
}