
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] potions = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++) potions[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(potions);
        
        long[] answer = new long[3];
        long closest = Long.MAX_VALUE;
        
        mix: for(int i = 0 ; i < N-1 ; i++) {
            for(int j = i+1 ; j < N ; j++) {
                long two = potions[i] + potions[j];
                long s = 0;
                long e = N-1;
                long mid = 0;

                long[] neg = new long[3];
                long negVal = Long.MIN_VALUE;
                long[] pos = new long[3];
                long posVal = Long.MAX_VALUE;

                boolean useNegVal = false;
                boolean usePosVal = false;

                binarySearch: while(s < e) {
                    mid = (s+e+1) / 2;

                    long sum = two + potions[(int)mid];

                    if(sum == 0 && i != mid && j != mid) {
                        closest = 0;
                        answer[0] = potions[i];
                        answer[1] = potions[j];
                        answer[2] = potions[(int)mid];
                        break mix;
                    }

                    if(sum <= 0) {
                        s = mid;
                    } else {
                        e = mid-1;
                    }

                    if(i == mid || j == mid) continue;

                    if(sum < 0 && negVal < sum) {
                        useNegVal = true;
                        negVal = sum;
                        neg[0] = potions[i];
                        neg[1] = potions[j];
                        neg[2] = potions[(int)mid];
                    } else if(sum > 0 && posVal > sum) {
                        usePosVal = true;
                        posVal = sum;
                        pos[0] = potions[i];
                        pos[1] = potions[j];
                        pos[2] = potions[(int)mid];

                    }
                }

                if(useNegVal && Math.abs(negVal) < closest) {
                    closest = Math.abs(negVal);
                    answer[0] = neg[0];
                    answer[1] = neg[1];
                    answer[2] = neg[2];
                }

                if(usePosVal && Math.abs(posVal) < closest) {
                    closest = posVal;
                    answer[0] = pos[0];
                    answer[1] = pos[1];
                    answer[2] = pos[2];
                }
            }
        }

        Arrays.sort(answer);
        System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
    }
}
