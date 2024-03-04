import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String P = br.readLine();

        int[] F = new int[S.length()];

        int j = 0;
        failure: for(int i = 1 ; i < P.length() ; i++) {
            while(j > 0 && P.charAt(i) != P.charAt(j)) j = F[j-1];
            if(P.charAt(i) == P.charAt(j)) {
                j++;
                F[i] = j;
            }
        }

        // KMP
        j = 0;
        for(int i = 0 ; i < S.length() ; i++) {
            while(j > 0 && S.charAt(i) != P.charAt(j)) j = F[j-1];
            if(S.charAt(i) == P.charAt(j)) {
                j++;
            }

            if(j == P.length()) {
                System.out.println(1);
                return;
            }
        }

        System.out.println(0);
    }
}



