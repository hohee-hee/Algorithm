import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] A = new int[n];
        int[] B = new int[n];
        int[] C = new int[n];
        int[] D = new int[n];
        for(int i = 0 ; i < n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        // 각각 두개씩 더한 답 찾기
        int[] AB = new int[n*n];
        int[] CD = new int[n*n];
        int pt = 0;
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                AB[pt] = A[i] + B[j];
                CD[pt] = C[i] + D[j];
                pt++;
            }
        }

        Arrays.parallelSort(AB);
        Arrays.parallelSort(CD);

        long answer = 0;
        // 이분탐색으로 찾기
        for(int i = 0 ; i < n*n ; i++) {
            int s = 0;
            int e = n*n;
            int lower = lower_bound(CD, s, e, -AB[i]);
            int upper = upper_bound(CD, s, e, -AB[i]);
            if(upper > lower) answer += upper - lower;
        }

        System.out.println(answer);
    }

    public static int lower_bound(int[] CD, int s, int e, int target){
        int mid = 0;

        while(s < e) {
            mid = (s+e) / 2;

            if(CD[mid] >= target) e = mid;
            else s = mid+1;
        }

        return s;
    }

    public static int upper_bound(int[] CD, int s, int e, int target){
        int mid = 0;

        while(s < e) {
            mid = (s+e) / 2;

            if(CD[mid] > target) e = mid;
            else s = mid+1;
        }

        return s;
    }
}
