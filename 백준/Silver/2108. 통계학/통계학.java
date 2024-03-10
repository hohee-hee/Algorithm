// 0:41 -

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int sum = 0;
        int[] arr = new int[N];
        int[][] cnt = new int[N][2];
        int cIdx = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
            if(!map.containsKey(arr[i])) {
                map.put(arr[i], cIdx);
                cnt[cIdx++][0] = arr[i];
            }
            cnt[map.get(arr[i])][1]++;
        }

//      산술평균 : N개의 수들의 합을 N으로 나눈 값
        sb.append(Math.round((double) sum/N)).append("\n");

//      중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
        Arrays.parallelSort(arr);
        sb.append(arr[N/2]).append("\n");

//      최빈값 : N개의 수들 중 가장 많이 나타나는 값
        Arrays.parallelSort(cnt, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o2[1] == o1[1]) return o1[0] - o2[0];
                return o2[1] - o1[1];
            }
        });
        if(N == 1) sb.append(arr[0]).append("\n");
        else if(cnt[0][1] == cnt[1][1]) sb.append(cnt[1][0]).append("\n");
        else sb.append(cnt[0][0]).append("\n");

//      범위 : N개의 수들 중 최댓값과 최솟값의 차이
        sb.append(arr[N-1] - arr[0]).append("\n");

        System.out.println(sb);
    }
}