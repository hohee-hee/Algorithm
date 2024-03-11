// 00:09 -

import java.io.*;
import java.util.*;

public class Main{
    public static int[][] sudoku = new int[9][9];
    public static boolean[][] rows = new boolean[9][10];
    public static boolean[][] cols = new boolean[9][10];
    public static boolean[][] grid = new boolean[9][10];
    public static ArrayList<int[]> blanks = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int r = 0 ; r < 9 ; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0 ; c < 9 ; c++) {
                sudoku[r][c] = Integer.parseInt(st.nextToken());
                int gridNum = ((r / 3) * 3) + (c / 3);
                if(sudoku[r][c] == 0) {
                    blanks.add(new int[]{r, c, gridNum});
                    continue;
                }

                rows[r][sudoku[r][c]] = true;
                cols[c][sudoku[r][c]] = true;
                grid[gridNum][sudoku[r][c]] = true;

            }
        }

        bt(0);

        for(int r = 0 ; r < 9 ; r++) {
            for (int c = 0; c < 9; c++) sb.append(sudoku[r][c]).append(" ");
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static boolean bt(int bIdx){
        if(bIdx == blanks.size()) {
            return true;
        }

        int cr = blanks.get(bIdx)[0];
        int cc = blanks.get(bIdx)[1];
        int cg = blanks.get(bIdx)[2];

        for(int i = 1 ; i <= 9 ; i++) {
            if(rows[cr][i] || cols[cc][i] || grid[cg][i]) continue;
 
            sudoku[cr][cc] = i;
            rows[cr][i] = true;
            cols[cc][i] = true;
            grid[cg][i] = true;

            if(bt(bIdx+1)) return true;

            sudoku[cr][cc] = 0;
            rows[cr][i] = false;
            cols[cc][i] = false;
            grid[cg][i] = false;
        }

        return false;
    }
}
