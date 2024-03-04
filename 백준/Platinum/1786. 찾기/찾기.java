import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String T = br.readLine();
        String P = br.readLine();
        int[] F = new int[P.length()];

        int j = 0;
        failure: for(int i = 1 ; i < P.length() ; i++) {
            while(j > 0 && P.charAt(i) != P.charAt(j)) j = F[j-1];
            if(P.charAt(i) == P.charAt(j)) {
                j++;
                F[i] = j;
            }
        }

        // PMP
        j = 0;
        int answer = 0;
        ArrayList<Integer> idxList = new ArrayList<>();
        for(int i = 0 ; i < T.length() ; i++) {
            while(j > 0 && T.charAt(i) != P.charAt(j)) j = F[j-1];
            if(T.charAt(i) == P.charAt(j)) {
                j++;
            }

            if(j == P.length()) {
                answer++;
                idxList.add(i-j+2);
                j = F[j-1];
            }
        }

        sb.append(answer).append("\n");
        for(int idx: idxList) sb.append(idx).append(" ");
        System.out.println(sb);
    }
}



