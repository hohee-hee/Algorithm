import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 0 ; tc < T ; tc++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            int[][] apartment = new int[k+1][n+1];

            for(int room = 1; room <= n ; room++) {
                apartment[0][room] = room;
            }

            for(int floor = 1 ; floor <= k ; floor++) {
                for(int room = 1; room <= n ; room++) {
                    for(int under = 1 ; under <= room ; under++) {
                        apartment[floor][room] += apartment[floor-1][under];
                    }
                }
            }

            sb.append(apartment[k][n]).append("\n");
        }
        System.out.println(sb);
    }
}