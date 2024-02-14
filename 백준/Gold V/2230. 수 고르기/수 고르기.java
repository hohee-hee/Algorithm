import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        if(M == 0) {
            System.out.println(0);
            return;
        }

        int[] arr = new int[N];
        for(int i = 0 ; i < N ; i++) arr[i] = Integer.parseInt(br.readLine());
        Arrays.parallelSort(arr);


        int lp = 0;
        int rp = 1;
        int answer = Integer.MAX_VALUE;
        while(lp <= rp && lp < N && rp < N) {
            if(arr[rp] - arr[lp] < M) {
                rp++;
            } else {
                answer = Math.min(answer, arr[rp] - arr[lp]);
                lp++;
            }
        }

        System.out.println(answer);
    }

}
