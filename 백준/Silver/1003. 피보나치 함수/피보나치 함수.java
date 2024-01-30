import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[][] fibo = new int[2][41];
        fibo[0][0] = 1; fibo[1][0] = 0;
        fibo[0][1] = 0; fibo[1][1] = 1;

        for(int tc = 0 ; tc < T ; tc++) {
            int N = Integer.parseInt(br.readLine());

            if(fibo[0][N] == 0 && fibo[1][N] == 0) {
                for(int i = 2 ; i <= N ; i++) {
                    fibo[0][i] = fibo[0][i-1] + fibo[0][i-2];
                    fibo[1][i] = fibo[1][i-1] + fibo[1][i-2];
                }
            }

            sb.append(fibo[0][N]).append(" ").append(fibo[1][N]).append("\n");
        }
        System.out.println(sb);
    }
}

