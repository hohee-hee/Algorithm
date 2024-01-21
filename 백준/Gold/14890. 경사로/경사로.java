import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        int answer = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];
        for(int r = 0 ; r < N ; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0 ; c < N ; c++) map[r][c] = Integer.parseInt(st.nextToken());
        }

        // R 검사
        boolean[][] isInstalled = new boolean[N][N];
        for(int r = 0 ; r < N ; r++) {
            int prev = map[r][0];
            int curr = 0;
            boolean isSame = true;
            boolean isPos = true;

            outer: for(int c = 1 ; c < N ; c++) {
                curr = map[r][c];
                if(curr == prev) continue;

                isSame = false;

                if(prev - curr < -1 || prev - curr > 1) {
                    isPos = false;
                    break outer;
                }

                if(prev - curr == -1) {
                    // 이전
                    int len = 0;

                    for(int i = c-1 ; i >= 0 ; i--) {
                        if(!isInstalled[r][i] && map[r][i] == prev) len++;
                        else break;

                        if(len == L) break;
                    }
                    if(len == L) {
                        for(int i = 0 ; i < L ; i++) isInstalled[r][c-1 - i] = true;
                    } else {
                        isPos = false;
                        break outer;
                    }
                } else if(prev - curr == 1) {
                    // 다음
                    int len = 0;

                    for(int i = c ; i < N ; i++) {
                        if(!isInstalled[r][i] && map[r][i] == curr) len++;
                        else break;

                        if(len == L) break;
                    }

                    if(len == L) {
                        for(int i = 0 ; i < L ; i++) isInstalled[r][c + i] = true;
                        c += L - 1;
                    } else {
                        isPos = false;
                        break outer;
                    }
                }
                if(c >= N) c = N - 1;
                prev = map[r][c];
            }
            if(isSame || isPos) answer++;
        }

        // C 검사
        isInstalled = new boolean[N][N];
        for(int c = 0 ; c < N ; c++) {
            int prev = map[0][c];
            int curr = 0;
            boolean isSame = true;
            boolean isPos = true;

            outer: for(int r = 1 ; r < N ; r++) {
                curr = map[r][c];
                if(curr == prev) continue;

                isSame = false;

                if(prev - curr < -1 || prev - curr > 1) {
                    isPos = false;
                    break outer;
                }

                if(prev - curr == -1) {
                    // 이전
                    int len = 0;

                    for(int i = r-1 ; i >= 0 ; i--) {
                        if(!isInstalled[i][c] && map[i][c] == prev) len++;
                        else break;

                        if(len == L) break;
                    }
                    if(len == L) {
                        for(int i = 0 ; i < L ; i++) isInstalled[r-1-i][c] = true;
                    } else {
                        isPos = false;
                        break outer;
                    }
                } else if(prev - curr == 1) {
                    // 다음
                    int len = 0;

                    for(int i = r ; i < N ; i++) {
                        if(!isInstalled[i][c] && map[i][c] == curr) len++;
                        else break;

                        if(len == L) break;
                    }

                    if(len == L) {
                        for(int i = 0 ; i < L ; i++) isInstalled[r+i][c] = true;
                        r += L - 1;
                    } else {
                        isPos = false;
                        break outer;
                    }
                }
                if(r >= N) r = N - 1;
                prev = map[r][c];
            }
            if(isSame || isPos) answer++;
        }


        System.out.println(answer);
    }
}
