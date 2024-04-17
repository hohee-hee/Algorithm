import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();

        String P = "I";
        for(int i = 0 ; i < N ; i++) P += "OI";

        int cnt = 0;
        int en = 1;
        for(int st = 0 ; st <= M-(2*N+1) ; st++) {
            if(S.charAt(st) == 'O') {
                en = st+1;
                continue;
            }

            while(en < M && en - st < 2*N+1 && S.charAt(en) == P.charAt(en-st)) en++;
            if(en - st == 2*N+1) cnt++;
        }

        System.out.println(cnt);
    }
}