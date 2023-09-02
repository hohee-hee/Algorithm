import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toLowerCase();

        int max = 0;
        int maxidx = -1;
        int[] alpha = new int[26];
        for(int i = 0 ; i < str.length() ; i++) {
            int idx = str.charAt(i) - 'a';
            alpha[idx]++;
            if(max < alpha[idx]) {
                max = alpha[idx];
                maxidx = idx;
            }
        }

        int num = 0;
        for(int i = 0 ; i < 26 ; i++){
            if(alpha[i] == max) num++;
        }

        if(num > 1) System.out.println("?");
        else System.out.println((char)('A'+maxidx));
    }
}
