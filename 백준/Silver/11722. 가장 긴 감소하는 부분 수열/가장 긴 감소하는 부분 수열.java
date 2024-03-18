import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++) arr[i] = Integer.parseInt(st.nextToken());

        int[] LDS = new int[N];
        int[] len = new int[N];
        int pt = 0;
        Arrays.fill(LDS, 1001);
        for(int i = N - 1 ; i >= 0 ; i--) {
            int idx = Arrays.binarySearch(LDS, arr[i]);
            if(idx >= 0) {
                len[i] = pt;
                continue;
            }

            idx = -idx -1;
            LDS[idx] = arr[i];
            if(idx > pt) pt = idx;
            len[i] = pt;
        }

        System.out.println(len[0]+1);
    }
}