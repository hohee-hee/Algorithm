import java.io.*;

public class Main {
    public static StringBuilder sb;
    public static int N;
    public static int[][] video;

    public static void main(String[] args) throws IOException{
        sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        video = new int[N][N];
        for(int r = 0 ; r < N ; r++) {
            String str = br.readLine();
            for(int c = 0 ; c < N ; c++) {
                video[r][c] = str.charAt(c) - '0';
            }
        }

        recur(0, 0, N);

        System.out.println(sb);
    }

    public static void recur(int sr, int sc, int len) {
        boolean isFin = true;
        int startNum = video[sr][sc];
        chk: for(int r = sr ; r < sr+len ; r++) {
            for(int c = sc ; c < sc+len ; c++) {
                if(video[r][c] != startNum) {
                    isFin = false;
                    break chk;
                }
            }
        }

        if(isFin) {
            sb.append(startNum);
            return;
        }

        sb.append('(');

        recur(sr, sc, len/2);
        recur(sr, sc+len/2, len/2);
        recur(sr+len/2, sc, len/2);
        recur(sr+len/2, sc+len/2, len/2);

        sb.append(')');

    }
}