import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<int[]> jewels = new ArrayList<>();
        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            jewels.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        int[] backpacks = new int[K];
        for(int i = 0 ; i < K ; i++) backpacks[i] = Integer.parseInt(br.readLine());

        jewels.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) return o2[1] - o1[1];
                return o1[0]-o2[0];
            }
        });
        Arrays.sort(backpacks);

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

        long answer = 0;
        int jIdx = 0;
        for(int i = 0 ; i < K ; i++) {
            int M = backpacks[i];

            while(jIdx < N) {
                if(jewels.get(jIdx)[0] > M) break;

                pq.offer(jewels.get(jIdx));
                jIdx++;
            }

            if(!pq.isEmpty()) answer += pq.poll()[1];
        }


        System.out.println(answer);
    }
}