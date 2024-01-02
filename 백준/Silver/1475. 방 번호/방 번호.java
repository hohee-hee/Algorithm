import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();

        int[] cnt = new int[10];

        int max = 0;

        for(int i = 0 ; i < N.length() ; i++) {
            int idx = N.charAt(i) - '0';
            cnt[idx]++;
        }

        cnt[6] += cnt[9];
        cnt[9] = 0;

        if(cnt[6] % 2 == 0) cnt[6] /= 2;
        else cnt[6] = cnt[6] / 2 + 1;

        Arrays.parallelSort(cnt);

        System.out.println(cnt[9]);
    }
}
