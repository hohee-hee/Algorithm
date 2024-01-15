import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static String[][] stars;

    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        stars = new String[N][N*2];
        for(int r = 0 ; r < N ; r++) {
            for(int c = 0 ; c < N*2 ; c++) {
                stars[r][c] = " ";
            }
        }

        star(0, 0, N);


        for(int r = 0 ; r < N ; r++) {
            for(int c = 0 ; c < N*2 ; c++) {
                sb.append(stars[r][c]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void star(int sr, int sc, int N){
        if(N == 3) {
            for(int r = 0 ; r < 3 ; r++) {
                for(int c = 0 ; c < 6 ; c++) {
                    if(r == 0 && c == 2) stars[sr+r][sc+c] = "*";
                    else if(r == 1 && (c == 1 || c == 3)) stars[sr+r][sc+c] = "*";
                    else if(r == 2 && c != 5)  stars[sr+r][sc+c] = "*";
                }
            }


            return;
        }

        int nlen = N/2;
        star(sr, sc+nlen, nlen);
        star(sr+nlen,sc, nlen);
        star(sr+nlen,sc+N, nlen);
    }
}