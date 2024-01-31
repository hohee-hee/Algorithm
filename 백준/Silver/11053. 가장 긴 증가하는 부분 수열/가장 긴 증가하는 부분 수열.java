import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        if(n == 1) {
            System.out.println(1);
            return;
        };
        int[] arr = new int[n];
        int[] len = new int[n];
        int answer = 0;
        for(int i = 0 ; i < n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            len[i] = 1;
            for(int j = i-1 ; j >= 0 ; j--) {
                if(arr[j] < arr[i]) {
                    len[i] = Math.max(1+ len[j], len[i]);
                }
            }
            if(len[i] > answer) answer = len[i];
        }

        System.out.println(answer);
    }
}

