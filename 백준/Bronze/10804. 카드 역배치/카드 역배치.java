import java.io.*;
import java.util.*;

public class Main {

    public static int[] LIST;

    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        LIST = new int[21];

        for(int i = 0 ; i < 21 ; i++) LIST[i] = i;


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0 ; i < 10 ; i++) {
           StringTokenizer st = new StringTokenizer(br.readLine());
           int sp = Integer.parseInt(st.nextToken());
           int ep = Integer.parseInt(st.nextToken());
           reverse(sp, ep);
        }

        for(int i = 1 ; i < 21 ; i++) {
            sb.append(LIST[i]).append(" ");
        }

        System.out.println(sb);
    }

    public static void reverse(int sp, int ep){
        // 배열 복사
        int[] tmp = new int[ep-sp+1];
        int tidx = 0;
        for(int i = sp ; i <= ep ; i++) {
            tmp[tidx++] = LIST[i];
        }

        // reverse
        tidx--;
        for(int i = sp; i <= ep; i++) {
            LIST[i] = tmp[tidx--];
        }
    }
}
