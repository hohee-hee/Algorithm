import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        int[] alpha = new int[26];
        Arrays.fill(alpha, -1);

        for(int i = 0 ; i < S.length() ; i++) {
            int c = S.charAt(i) - 'a';
            if(alpha[c] != -1) continue;
            alpha[c] = i;
        }

        for(int i = 0 ; i < 26 ; i++) sb.append(alpha[i] + " ");
        System.out.println(sb);
    }
}
