import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] potions = new int[N];
        int[] potions_sorted = new int[N];
        for(int i = 0 ; i < N ; i++) {
            potions[i] = Integer.parseInt(st.nextToken());
            potions_sorted[i] = potions[i];
        }
        Arrays.parallelSort(potions_sorted);

        long[] answer = new long[2]; // [0] 용액 1 [1] 용액 2
        long sub = Long.MAX_VALUE ;
        for(int i = 0 ; i < N ; i++) {
            int potion = potions[i];
            int target = 0 - potion;
            int idx = Arrays.binarySearch(potions_sorted, target);

            if(idx >= 0) {
                if(potions[i] == potions_sorted[idx]) {
                    int left = idx-1;
                    int right = idx+1;

                    if(left >= 0 && sub > Math.abs(potions_sorted[left]+potion)) {
                        sub = Math.abs(potions_sorted[left]+potion);
                        answer[0] = potion;
                        answer[1] = potions_sorted[left];
                    }

                    if(right < N && sub > Math.abs(potions_sorted[right]+potion)) {
                        sub = Math.abs(potions_sorted[right]+potion);
                        answer[0] = potion;
                        answer[1] = potions_sorted[right];
                    }

                } else {
                    if(sub > Math.abs(potions_sorted[idx]+potion)) {
                        sub = Math.abs(potions_sorted[idx]+potion);
                        answer[0] = potion;
                        answer[1] = potions_sorted[idx];
                    }
                }
            } else {
                int left = idx * (-1) - 2;
                int right = idx * (-1) - 1;

                if(left >= 0 && potions_sorted[left] == potions[i]) left--;
                if(right < N && potions_sorted[right] == potions[i]) right++;

                if(left >= 0 && sub > Math.abs(potions_sorted[left]+potion)) {
                    sub = Math.abs(potions_sorted[left]+potion);
                    answer[0] = potion;
                    answer[1] = potions_sorted[left];
                }

                if(right < N && sub > Math.abs(potions_sorted[right]+potion)) {
                    sub = Math.abs(potions_sorted[right]+potion);
                    answer[0] = potion;
                    answer[1] = potions_sorted[right];
                }
            }

            if(sub == 0) break;
        }

        Arrays.parallelSort(answer);
        System.out.println(answer[0] + " " + answer[1]);
    }
}