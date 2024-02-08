import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] sum = new int[M+1];
        int num = 1; int pt = 1;
        while(pt <= M) {
            for(int i = 0 ; i < num && pt <= M; i++) {
                sum[pt] = sum[pt-1] + num;
                pt++;
            }
            num++;
        }
        
        System.out.println(sum[M] - sum[N-1]);
    }
}