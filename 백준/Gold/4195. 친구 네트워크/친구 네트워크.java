import java.io.*;
import java.util.*;

public class Main {

    static int[] parent, link;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        // 1. 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc = 0 ; tc < T ; tc++){
            int F = Integer.parseInt(br.readLine());

            int pidx = 0;
            HashMap<String, Integer> fList = new HashMap<>(); // 이름과 pidx를 저장할 map
            parent = new int[F*2];
            link = new int[F*2];
            for(int i = 0 ; i < F ; i++){

                // 2. 이름이 map 안에 있는지 파악하기
                String[] idList = br.readLine().split(" ");
                for(int j = 0 ; j < 2 ; j++){
                    // fList에 없으면 새로 넣기
                    if(!fList.containsKey(idList[j])){
                        fList.put(idList[j], pidx);
                        parent[pidx]=pidx;
                        link[pidx] = 1;
                        pidx++;
                    }
                }

                // 3. 인덱스 찾기
                int id1 = fList.get(idList[0]);
                int id2 = fList.get(idList[1]);

                // 4. 합치기
                union(id1, id2);
                
                // 5. 출력
                sb.append(link[find(id2)] + "\n");
            }

        }
        System.out.println(sb);
    }

    public static int find(int x){
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x == y) return;

        if(x < y) {
            parent[y] = x;
            link[x] += link[y];
        }
        else {
            parent[x] = y;
            link[y] += link[x];
        }

    }
}

