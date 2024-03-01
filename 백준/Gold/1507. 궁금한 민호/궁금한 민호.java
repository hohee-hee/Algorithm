import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] dist = new int[N+1][N+1];
        StringTokenizer st;
        for(int r = 1 ; r <= N ; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 1 ; c <= N ;c++) {
                dist[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] brokenRoad = new boolean[N+1][N+1];
        for(int k = 1 ; k <= N ; k++) {
            for(int r = 1 ; r <= N ; r++) {
                if(r == k) continue;
                for(int c = 1; c <= N ; c++) {
                    if(c == k || c == r) continue;
                    if(dist[r][c] == dist[r][k] + dist[k][c]) {
                        dist[r][c] = dist[r][k] + dist[k][c];
                        brokenRoad[r][c] = true;
                    }
                }
            }
        }
        
        int answer = 0;
        int[][] nDist = new int[N+1][N+1];
        for(int r = 1 ; r <= N ; r++) {
            for(int c = 1; c <= N ; c++) {
                if(brokenRoad[r][c]) {
                    nDist[r][c] = 1000002;
                } else {
                    nDist[r][c] = dist[r][c];
                }
            }
            for(int c = 1; c < r ; c++) {
                if(!brokenRoad[r][c]) {
                    answer += dist[r][c];
                }
            }
        }

        for(int k = 1 ; k <= N ; k++) {
            for(int r = 1 ; r <= N ; r++) {
                for(int c = 1; c <= N ; c++) {
                    if(nDist[r][c] > nDist[r][k] + nDist[k][c]) {
                        nDist[r][c] = nDist[r][k] + nDist[k][c];
                    }
                }
            }
        }

        chk: for(int r = 1 ; r <= N ; r++) {
            for(int c = 1; c < r ; c++) {
                if(dist[r][c] != nDist[r][c]) {
                    answer = -1;
                    break chk;
                }
            }
        }


        System.out.println(answer);
    }
}

