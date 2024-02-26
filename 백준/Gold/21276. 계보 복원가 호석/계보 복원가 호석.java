import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        TreeMap<String, ArrayList<String>> familyTree = new TreeMap<>();
        TreeMap<String, Integer> indegree = new TreeMap<>();
        String[] resident = new String[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++) {
            resident[i] = st.nextToken();
            familyTree.put(resident[i], new ArrayList<>());
            indegree.put(resident[i], 0);
        }

        int M = Integer.parseInt(br.readLine());
        ArrayList<String> descendant = new ArrayList<>();
        for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            String X = st.nextToken();
            String Y = st.nextToken();
            familyTree.get(Y).add(X);
            indegree.put(X, indegree.get(X)+1);
        }

        // 가문 정하기
        ArrayList<String> family = new ArrayList<>();
        ArrayDeque<String> q = new ArrayDeque<>();
        for(int i = 0 ; i < N ; i++) {
            if(indegree.get(resident[i]) == 0) {
                family.add(resident[i]);
                q.offerLast(resident[i]);
            }
        }

        Collections.sort(family);
        Arrays.sort(resident);

        while(!q.isEmpty()) {
            String cp = q.pollFirst();
            for(int i = 0 ; i < familyTree.get(cp).size() ; i++) {
                String np = familyTree.get(cp).get(i);
                indegree.put(np, indegree.get(np)-1);
                if(indegree.get(np) != 0) {
                    familyTree.get(cp).remove(i);
                    i--;
                } else {
                    q.offerLast(np);
                }
            }
        }


        sb.append(family.size()).append("\n");
        for(String familyName: family) sb.append(familyName).append(" ");
        sb.append("\n");

        for(int i = 0 ; i < N ; i++) {
            sb.append(resident[i]).append(" ").append(familyTree.get(resident[i]).size()).append(" ");
            Collections.sort(familyTree.get(resident[i]));
            for(String child: familyTree.get(resident[i])) sb.append(child).append(" ");
            if(i != N-1) sb.append("\n");
        }

        System.out.println(sb);
    }
}
