import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 0 ; tc < T ; tc++) {
            String A = br.readLine();
            String W = br.readLine();
            String S = br.readLine();

            // exception: W == 1일때
            if(W.length() == 1) {
                HashMap<Character, Integer> order = new HashMap<>();
                for(int i = 0 ; i < A.length() ; i++) {
                    order.put(A.charAt(i), i);
                }

                int[] SIdx = new int[S.length()];
                for(int i = 0 ; i < S.length() ; i++) {
                    SIdx[i] = order.get(S.charAt(i));
                }

                boolean[] isChecked = new boolean[A.length()];
                TreeSet<Integer> shiftVal = new TreeSet<>();
                for(int i = 0 ; i < S.length() ; i++) {
                    int val = SIdx[i] >= order.get(W.charAt(0)) ? SIdx[i] - order.get(W.charAt(0)) : SIdx[i] + A.length() - order.get(W.charAt(0));
                    if(shiftVal.contains(val)) {
                        shiftVal.remove(val);
                    } else if (isChecked[val]){
                        continue;
                    } else {
                        shiftVal.add(val);
                        isChecked[val] = true;
                    }
                }

                if(shiftVal.isEmpty()) {
                    sb.append("no solution").append("\n");
                } else {
                    Iterator it = shiftVal.iterator();
                    if(shiftVal.size() == 1) {
                        sb.append("unique: ").append(it.next()).append("\n");
                    } else {
                        sb.append("ambiguous: ");
                        while(it.hasNext()) {
                            sb.append(it.next()).append(" ");
                        }
                        sb.append("\n");
                    }
                }

                continue;
            }

            // 1. 간격 구하기
            // - 1. 알파벳 순서에 번호 매기기
            HashMap<Character, Integer> order = new HashMap<>();
            for(int i = 0 ; i < A.length() ; i++) {
                order.put(A.charAt(i), i);
            }

            // - 2. 원문의 간격 구하기
            int[] WIdx = new int[W.length()];
            int[] WInter = new int[W.length()-1];
            WIdx[0] = order.get(W.charAt(0));
            for(int i = 1 ; i < W.length() ; i++) {
                WIdx[i] = order.get(W.charAt(i));
                WInter[i-1] = WIdx[i] < WIdx[i-1] ? WIdx[i] + A.length() - WIdx[i-1] :  WIdx[i] - WIdx[i-1];
            }

            // - 3. 구한 간격으로 실패함수 구하기
            int[] F = new int[W.length()-1];
            int j = 0;
            for(int i = 1 ; i < W.length()-1 ; i++) {
                while(j > 0 && WInter[i] != WInter[j]) j = F[j-1];
                if(WInter[i] == WInter[j]) {
                    j++;
                    F[i] = j;
                }
            }

            // 2. 암호문 간격 구하기
            int[] SIdx = new int[S.length()];
            int[] SInter = new int[S.length()-1];
            SIdx[0] = order.get(S.charAt(0));
            for(int i = 1 ; i < S.length() ; i++) {
                SIdx[i] = order.get(S.charAt(i));
                SInter[i-1] = SIdx[i] < SIdx[i-1] ? SIdx[i] + A.length() - SIdx[i-1] :  SIdx[i] - SIdx[i-1];
            }

            // 3. KMP
            TreeSet<Integer> shiftVal = new TreeSet<>();
            boolean[] isChecked = new boolean[A.length()];
            j = 0;
            for(int i = 0 ; i < S.length()-1 ; i++) {
                while(j > 0 && SInter[i] != WInter[j]) j = F[j-1];
                if(SInter[i] == WInter[j]) j++;

                if(j == WInter.length) {
                    int val = SIdx[i-(j-1)] >= WIdx[0] ? SIdx[i-(j-1)] - WIdx[0] : SIdx[i-(j-1)] + A.length() - WIdx[0];

                    if(shiftVal.contains(val)) {
                        shiftVal.remove(val);
                    } else if (isChecked[val]){
                        j = F[j-1];
                        continue;
                    } else {
                        shiftVal.add(val);
                        isChecked[val] = true;
                    }
                    j = F[j-1];
                }
            }

            // 4. 정답찾기
            if(shiftVal.isEmpty()) {
                sb.append("no solution").append("\n");
            } else {
                Iterator it = shiftVal.iterator();
                if(shiftVal.size() == 1) {
                    sb.append("unique: ").append(it.next()).append("\n");
                } else {
                    sb.append("ambiguous: ");
                    while(it.hasNext()) {
                        sb.append(it.next()).append(" ");
                    }
                    sb.append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}



