import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int prev = 1;
        int curr = 1;
        int line = 1;
        while(curr <= N) {
            curr = prev + line;
            line++;
            prev = curr;
        }

        int startCell = curr - line + 1;
        int startLine = line - 2;
        int cr = 0; int cc = 0;
        if(startLine % 2 == 1) {
            cc = line-2;
        } else {
            cr = line-2;
        }
        for(int i = 0 ; i < line ; i++) {
            if(startCell+i == N) {
                break;
            }

            if(startLine % 2 == 1) {
                cr++; cc--;
            } else {
                cr--; cc++;
            }
        }

        System.out.println((cr+1) + "/" + (cc+1));
    }
}