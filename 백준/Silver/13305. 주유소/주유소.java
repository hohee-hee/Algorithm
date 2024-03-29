import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] dist = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i < N ; i++) dist[i] = Integer.parseInt(st.nextToken()) + dist[i-1];

        long[][] info = new long[N][3];
        int[] price = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++) {
            price[i] = Integer.parseInt(st.nextToken());
            info[i] = new long[]{price[i], i, dist[N-1]-dist[i]};
        }

        Arrays.parallelSort(info, new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                if(o1[0] == o2[0]) {
                    if(o1[1] < o2[1]) return -1;
                    return 1;
                } else if(o1[0] < o2[0]) return -1;
                else return 1;
            }
        });

        long answer = 0;
        long curr = N;
        int pt = 0;
        long prevDist = 0;
        while(curr > 0) {
            if(info[pt][1] > curr) {
                pt++;
                continue;
            }

            answer = info[pt][0] * (info[pt][2] - prevDist) + answer;
            curr = info[pt][1];
            prevDist = info[pt][2];
            pt++;
        }

        System.out.println(answer);
    }
}