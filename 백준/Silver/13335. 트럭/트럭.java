import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] trucks = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++) trucks[i]=Integer.parseInt(st.nextToken());

        int currL = 0;
        int answer = 1;
        int tIdx= 0;

        LinkedList<int[]> bridge = new LinkedList<>();
        while(tIdx < n) {
            // 시간 다 된 트럭 빼기
            if(!bridge.isEmpty() && bridge.get(0)[1] + W == answer) {
                currL -= bridge.get(0)[0];
                bridge.remove();
            }

            // 이미 꽉 차서 다음 트럭이 올라갈 수 없다면
            if(bridge.size() == W) {
                answer++;
                continue;
            }

            if(currL + trucks[tIdx] > L) { // 최대 하중보다 커지면 합칠 수 없다.
                answer++;
            } else { // 같거나 작으면 트럭을 이동시킨다.
                bridge.add(new int[]{trucks[tIdx], answer});
                currL += trucks[tIdx];
                tIdx++; answer++;
            }
        }

        // 마지막에 들어간 트럭 빼기
        answer += W - 1;

        System.out.println(answer);
    }
}
