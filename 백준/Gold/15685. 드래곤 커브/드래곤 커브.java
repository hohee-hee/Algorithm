import java.io.*;
import java.util.*;

public class Main {
    public static int[] dx = {1,0,-1,0};
    public static int[] dy = {0,-1,0,1};
    public static boolean[][][] grid;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int answer = 0;
        grid = new boolean[101][101][4]; // 0 : 상, 1 : 우, 2 : 하, 3 : 좌

        for(int i = 0 ; i < N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            ArrayList<Integer> dragonCurve = new ArrayList<>(); // 방향
            dragonCurve.add(d);
            for(int gen = 1 ; gen <= g ; gen++) {
                int size = dragonCurve.size();
                for(int idx = size - 1 ; idx >= 0  ; idx--) {
                    int dir = dragonCurve.get(idx);
                    dragonCurve.add((dir+1) % 4);
                }
            }

            dot(dragonCurve, new int[]{x, y});
        }

        for(int r = 0 ; r < 101 ; r++) {
            for(int c = 0 ; c < 101 ; c++) {
                boolean isPart = true;
                for(int edge = 0 ; edge < 4 ; edge++) {
                    if(!grid[r][c][edge]) isPart = false;
                }
                if(isPart) answer++;
            }
        }
        System.out.println(answer);
    }

    public static void dot(ArrayList<Integer> dragonCurve, int[] startpt) {
        int x = startpt[0];
        int y = startpt[1];
        for(int i = 0 ; i < dragonCurve.size() ; i++) {
            checker(x, y);
            int dir = dragonCurve.get(i);
            x += dx[dir];
            y += dy[dir];
        }
        checker(x, y);
    }

    public static void checker(int x, int y){
        if(y-1 >= 0 && x-1 >= 0) grid[y-1][x-1][2] = true;
        if(y-1 >= 0) grid[y-1][x][3] = true;
        if(x-1 >= 0) grid[y][x-1][1] = true;
        grid[y][x][0] = true;
    }

}

