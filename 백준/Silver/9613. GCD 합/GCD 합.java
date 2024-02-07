import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        HashMap<Integer, ArrayList<Integer>> divisors = new HashMap<>();

        for(int tc = 0 ; tc < T ; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[] nums = new int[N];

            for(int i = 0 ; i < N ; i++) {
                int num = Integer.parseInt(st.nextToken());
                nums[i] = num;

                if(divisors.containsKey(num)) continue;

                ArrayList<Integer> pq = new ArrayList<>();

                for(int j = 1 ; j*j <= num ; j++) {
                    if(j*j == num) {
                        pq.add(j);
                    } else if(num%j == 0) {
                        pq.add(j);
                        pq.add(num/j);
                    }
                }
                Collections.sort(pq, Collections.reverseOrder());
                divisors.put(num, pq);
            }

            int GCD = 1;
            long answer = 0;
            for(int i = 0 ; i < N-1 ; i++) {
                GCD = 1;
                for(int j = i+1 ; j < N ; j++) {
                    int a = nums[i];
                    int b = nums[j];

                    int apt = 0;
                    int bpt = 0;
                    boolean isFound = false;
                    while(apt < divisors.get(a).size() && bpt < divisors.get(b).size()) {
                        int divA = divisors.get(a).get(apt);
                        int divB = divisors.get(b).get(bpt);

                        // 비교하기
                        if(divA == divB) {
                            GCD = divisors.get(a).get(apt);
                            isFound = true;
                            break;
                        }

                        // 큰 수 줄이기
                        if(divA < divB) {
                            bpt++;
                        } else {
                            apt++;
                        }
                    }

                    answer += GCD;
                }
            }

            sb.append(answer).append("\n");

        }

        System.out.println(sb);
    }
}