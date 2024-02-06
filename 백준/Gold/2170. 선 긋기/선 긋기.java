import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] lines = new int[N][2];
        for(int i = 0 ; i < N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            lines[i][0] = Integer.parseInt(st.nextToken());
            lines[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.parallelSort(lines, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int st = lines[0][0];
        int en = lines[0][1];
        int answer = 0;
        for(int i = 1 ; i < N ; i++) {
            int j = i;
            for(j = i ; j < N ; j++) {
                if(lines[j][0] <= en) {
                    en = Math.max(en, lines[j][1]);
                } else {
                    answer += en-st;
                    st = lines[j][0];
                    en = lines[j][1];
                    break;
                }
            }
            i=j;
        }
        answer += en-st;

        System.out.println(answer);
    }
}