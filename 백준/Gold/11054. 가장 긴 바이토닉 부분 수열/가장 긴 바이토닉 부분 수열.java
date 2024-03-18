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

        int[] LIS = new int[N];
        int[] LDS = new int[N];
        int[] LIS_len = new int[N];
        int[] LDS_len = new int[N];
        int[] bitonic = new int[N];
        int LIS_pt = 0;
        int LDS_pt = 0;

        Arrays.fill(LIS, 1001);
        Arrays.fill(LDS, 1001);

        for(int i = 0 ; i < N ; i++) {
            int LIS_idx = Arrays.binarySearch(LIS, arr[i]);
            int LDS_idx = Arrays.binarySearch(LDS, arr[N-1-i]);

            if(LIS_idx < 0) {
                LIS_idx = -LIS_idx -1;
                if(LIS[LIS_idx] == 1001) LIS_pt = LIS_idx;
                LIS[LIS_idx] = arr[i];
                LIS_len[i] = LIS_pt+1;
                bitonic[i] += LIS_len[i];
            } else {
                LIS_len[i] = LIS_idx+1;
                bitonic[i] += LIS_len[i];
            }

            if(LDS_idx < 0) {
                LDS_idx = -LDS_idx -1;
                if(LDS[LDS_idx] == 1001) LDS_pt = LDS_idx;
                LDS[LDS_idx] = arr[N-1-i];
                LDS_len[N-1-i] = LDS_pt+1;
                bitonic[N-1-i] += LDS_len[N-1-i];
            } else {
                LDS_len[N-1-i] = LDS_idx+1;
                bitonic[N-1-i] += LDS_len[N-1-i];
            }
        }

        Arrays.sort(bitonic);
        System.out.println(bitonic[N-1] - 1);
    }
}