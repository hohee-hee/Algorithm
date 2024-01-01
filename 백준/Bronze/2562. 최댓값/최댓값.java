import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = -1;
        int th = 0;
        for(int i = 0 ; i < 9 ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            if(max < num) {
                max = num;
                th = i+1;
            }
        }

        sb.append(max).append("\n").append(th);
        System.out.println(sb);
    }
}
