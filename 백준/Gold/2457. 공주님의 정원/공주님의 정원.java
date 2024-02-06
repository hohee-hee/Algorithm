import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] flowers = new int[N][2];
        int date = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String month = st.nextToken();
            String day = st.nextToken();
            if(day.length() == 1) day = "0" + day;
            flowers[i][0] = Integer.parseInt(month+day);

            month = st.nextToken();
            day = st.nextToken();
            if(day.length() == 1) day = "0" + day;
            flowers[i][1] = Integer.parseInt(month+day);

            if(flowers[i][0] <= 301 && date < flowers[i][1]) date = flowers[i][1];
        }

        // 개화일이 모두 301보다 작으면 반환
        if(date < 301) {
            System.out.println(0);
            return;
        } else if(date > 1130) {
            System.out.println(1);
            return;
        }

        // 개화 일자를 기준으로 오름차순 정렬
        Arrays.parallelSort(flowers, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) return o2[1] - o1[1];
                return o1[0] - o2[0];
            }
        });

        // 2. 현재 date보다 작거나 같은 꽃 중 낙화 일자가 제일 늦은 꽃 심기
        int answer = 1;
        for(int f = 0 ; f < N ; f++) {
            int finDate = date;
            for(int i = f ; i < N ; i++) {
                if(flowers[i][0] > date) break;
                if(finDate < flowers[i][1]) finDate = flowers[i][1];
                f = i;
            }
            answer++;
            date = finDate;
            if(date > 1130) break;
        }

        // 3. 현재 date가 11월 30일을 넘어가면 => 출력 / 배열을 전부 순회했는데 date가 1130보다 작거나 같으면 0
        if(date <= 1130) answer = 0;

        System.out.println(answer);

    }
}