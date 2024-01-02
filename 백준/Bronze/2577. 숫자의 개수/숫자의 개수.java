import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long num = 1;
        for(int i = 0 ; i < 3 ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            num *= Integer.parseInt(st.nextToken());
        }

        int[] cnt = new int[10];
        char[] numch = Long.toString(num).toCharArray();

        for(int i = 0 ; i < numch.length ; i++) {
            cnt[numch[i] - '0']++;
        }

        for(int i = 0 ; i < 10 ; i++) {
            sb.append(cnt[i]).append("\n");
        }

        System.out.println(sb);
    }
}
