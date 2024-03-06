import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashMap<Long, Integer> map = new HashMap<>();
        long[][] arr = new long[100002][2];
        int aIdx = 0;
        for(int i = 0 ; i < N ; i++) {
            long num = Long.parseLong(br.readLine());
            if(map.containsKey(num)) {
                int idx = map.get(num);
                arr[idx][1]++;
            } else {
                map.put(num, aIdx);
                arr[aIdx][0] = num;
                arr[aIdx++][1]= 1;
            }
        }

        Arrays.parallelSort(arr, new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                if(o1[1] == o2[1]) {
                    if(o1[0] > o2[0]) return 1;
                    return -1;
                }

                if(o1[1] < o2[1]) return 1;
                return -1;
            }
        });

        System.out.println(arr[0][0]);
    }
}