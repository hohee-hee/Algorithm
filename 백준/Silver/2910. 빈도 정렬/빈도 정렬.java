import java.io.*;

import java.util.*;

public class Main {

    

    public static void main(String[] args) throws IOException{

        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        

        int N = Integer.parseInt(st.nextToken());

        int C = Integer.parseInt(st.nextToken());

        

        int[][] info = new int[N][3];

        HashMap<Integer, Integer> index = new HashMap<>();

        st = new StringTokenizer(br.readLine());

        int curr = 0;

        for(int i = 0 ; i < N ; i++){

            int num = Integer.parseInt(st.nextToken());

            

            if(!index.containsKey(num)) {

                index.put(num, curr);

                info[curr][0] = num;

                info[curr][1] = 1;

                info[curr][2] = i+1;

                curr++;

            } else {

                int idx = index.get(num);

                info[idx][1]++;

            }

            

        }

        

        Arrays.sort(info, new Comparator<int []>(){

             @Override

            public int compare(int[] o1, int[] o2) {

                if(o1[1] == o2[1]) return o1[2] - o2[2];

                return o2[1] - o1[1];

            }

        });

        

        int size = index.size();

        for(int i = 0 ; i < size ; i++) {

            int cnt = info[i][1];

            while(cnt > 0) {

                sb.append(info[i][0]).append(" ");

                cnt--;

            }

        }

        System.out.println(sb);

    }

}