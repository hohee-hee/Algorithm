import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        S = S.replaceAll("[0-9]", "");
        String K = br.readLine();

        int[] F = new int[S.length()];

        int j = 0;
        failure: for(int i = 1 ; i < K.length() ; i++) {
            while(j > 0 && K.charAt(i) != K.charAt(j)) j = F[j-1];
            if(K.charAt(i) == K.charAt(j)) {
                j++;
                F[i] = j;
            }
        }

        // KMP
        j = 0;
        for(int i = 0 ; i < S.length() ; i++) {
            while(j > 0 && S.charAt(i) != K.charAt(j)) j = F[j-1];
            if(S.charAt(i) == K.charAt(j)) {
                j++;
            }

            if(j == K.length()) {
                System.out.println(1);
                return;
            }
        }

        System.out.println(0);
    }
}



