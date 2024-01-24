import java.io.*;
import java.util.*;

public class Main {
    public static int[][] wheels;
    public static int[] pointer;
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        wheels = new int[4][8];
        pointer = new int[4];
        for(int i = 0 ; i < 4 ; i++) {
            String str = br.readLine();
            for(int j = 0 ; j < 8 ; j++) {
                wheels[i][j] = str.charAt(j) - '0';
            }
        }

        int K = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < K ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());

            int[] newpointer = turnWheel(num, dir);

            newpointer[num] = dir;

            for(int p = 0 ; p < 4 ; p++) {
                pointer[p] += (newpointer[p] * (-1));
                if(pointer[p] == -1) pointer[p] = 7;
                else if(pointer[p] == 8) pointer[p] = 0;
            }
        }

        int answer = 0;
        answer += wheels[0][pointer[0]] * 1;
        answer += wheels[1][pointer[1]] * 2;
        answer += wheels[2][pointer[2]] * 4;
        answer += wheels[3][pointer[3]] * 8;

        System.out.println(answer);
    }

    public static int[] turnWheel(int wheelNum , int turnDir){
        int[] newpointer = new int[4];

        // 왼쪽 돌리기
        int lwheel = wheelNum - 1;
        int prevTurn = turnDir;
        while(lwheel >= 0) {
            if(wheels[lwheel+1][(pointer[lwheel+1] + 6) % 8] == wheels[lwheel][(pointer[lwheel] + 2) % 8]) break;

            newpointer[lwheel] = prevTurn * (-1);
            prevTurn *= (-1);
            lwheel--;
        }

        // 오른쪽 돌리기
        int rwheel = wheelNum + 1;
        prevTurn = turnDir;
        while(rwheel < 4) {
            if(wheels[rwheel-1][(pointer[rwheel-1] + 2) % 8] == wheels[rwheel][(pointer[rwheel] + 6) % 8]) break;

            newpointer[rwheel] = prevTurn * (-1);
            prevTurn *= (-1);
            rwheel++;
        }

        return newpointer;
    }
}