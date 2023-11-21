import java.io.*;
import java.util.*;

public class Main {

    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};

    static int N, M, MIN;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 입력 받기, 전역 변수에 값 할당
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] office = new int[N][M]; // 사무실
        ArrayList<int[]> cctvs = new ArrayList<>();
        for(int r = 0 ; r < N ; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0 ; c < M ; c++) {
                office[r][c] = Integer.parseInt(st.nextToken());

                if(office[r][c] == 0 || office[r][c] == 6) continue;

                if(office[r][c] == 5) cctvs.add(0, new int[]{5,r,c});
                else cctvs.add(new int[]{office[r][c],r,c});
            }
        }

        // 2. 5번 먼저 감시체계 돌리기
        int cidx = 0;
        while(cidx < cctvs.size() && cctvs.get(cidx)[0] == 5) {

            int cr = cctvs.get(cidx)[1];
            int cc = cctvs.get(cidx)[2];

            for(int dir = 0 ; dir < 4 ; dir++) {
                office = BigBrother(dir, office, cr,cc);
            }
            cidx++;
        }

        MIN = Integer.MAX_VALUE;
        // 3. 나머지 감시체계 돌리기
        if(cidx != cctvs.size()) BT(office, cidx, cctvs);
        else MIN = count(office);

        System.out.println(MIN);
    }

    public static void BT(int[][] office, int cIdx, ArrayList<int[]> cctvs) {
        if(cIdx == cctvs.size()) {
           int answer = count(office);

            if(MIN > answer) MIN = answer;

            return;
        }

            int cn = cctvs.get(cIdx)[0];
            int cr = cctvs.get(cIdx)[1];
            int cc = cctvs.get(cIdx)[2];

            int[][] nOffice = copyOffice(office);

            if(cn == 1) {
                for(int j = 0 ; j < 4 ; j++) {
                    nOffice = BigBrother(j, nOffice, cr, cc);
                    BT(nOffice, cIdx+1, cctvs);
                    nOffice = copyOffice(office);
                }
            } else if(cn == 2) {
                for(int j = 0 ; j < 2 ; j++) {
                    nOffice  = BigBrother(j, nOffice, cr,cc);
                    nOffice  = BigBrother((j+2)%4, nOffice, cr,cc);
                    BT(nOffice, cIdx+1, cctvs);
                    nOffice = copyOffice(office);
                }
            } else if(cn == 3) {
                for(int j = 0 ; j < 4 ; j++) {
                    nOffice  = BigBrother(j, nOffice, cr,cc);
                    nOffice  = BigBrother((j+1)%4, nOffice, cr,cc);
                    BT(nOffice, cIdx+1, cctvs);
                    nOffice = copyOffice(office);
                }
            } else if(cn == 4) {
                for(int j = 0 ; j < 4 ; j++) {
                    nOffice  = BigBrother(j, nOffice, cr,cc);
                    nOffice = BigBrother((j+1)%4, nOffice, cr,cc);
                    nOffice = BigBrother((j+2)%4, nOffice, cr,cc);
                    BT(nOffice, cIdx+1, cctvs);
                    nOffice = copyOffice(office);
                }
            }

    }

    public static int[][] BigBrother(int dir, int[][] nOffice, int cr , int cc){

        while(true) {
            int nr = cr + dr[dir];
            int nc = cc + dc[dir];

            // idx chk
            if(nr < 0 || nc < 0 || nr >= N || nc >= M) break;

            // wall chk
            if(nOffice[nr][nc] == 6) break;

            nOffice[nr][nc] = 7;
            cr = nr;
            cc = nc;
        }

        return nOffice;
    }

    public static int[][] copyOffice(int[][] office){
        int[][] copy = new int[N][M];
        for(int r = 0 ; r < N ; r++) {
            for(int c = 0 ;c < M ; c++) {
                copy[r][c] = office[r][c];
            }
        }

        return copy;
    }

    public static int count(int[][] office) {
        int answer = 0;
        for(int r = 0 ; r < N ; r++) {
            for(int c = 0 ; c < M ; c++) {
                if(office[r][c] == 0) answer++;
            }
        }
        return answer;
    }
}
