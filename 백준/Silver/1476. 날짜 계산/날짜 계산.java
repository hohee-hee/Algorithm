import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if(E == 15) E = 0;
        if(S == 28) S = 0;
        if(M == 19) M = 0;
        int answer = 1;
        while(true) {
            if(answer % 15 == E && answer % 28 == S && answer % 19 == M) break;
            answer++;
        }
        System.out.println(answer);
    }
}