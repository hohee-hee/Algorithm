import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Integer> multitab = new ArrayList<>();
        int[] elec = new int[K];
        ArrayDeque<Integer>[] info = new ArrayDeque[K+1];
        for(int i = 0 ; i <= K ; i++) info[i] = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < K ; i++) {
            elec[i] = Integer.parseInt(st.nextToken());
            info[elec[i]].offerLast(i);
        }

        int answer = 0;
        for(int i = 0 ; i < K ; i++) {
            if(multitab.contains(elec[i])) {
                info[elec[i]].pollFirst();
                continue;
            }
            
            if(multitab.size() < N) {
                multitab.add(elec[i]);
                info[elec[i]].pollFirst();
                continue;
            }

            int targetIdx = -1;
            int next = -1;
            for(int j = 0 ; j < multitab.size() ; j++) {
                if(info[multitab.get(j)].isEmpty()) {
                    targetIdx = j;
                    break;
                }

                if(info[multitab.get(j)].peekFirst() > next) {
                    targetIdx = j;
                    next = info[multitab.get(j)].peekFirst();
                }
            }

            multitab.remove(targetIdx);
            answer++;
            multitab.add(elec[i]);
            info[elec[i]].pollFirst();
        }

        System.out.println(answer);
    }
}