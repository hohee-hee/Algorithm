import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        int N = friends.length; // 친구 수
        
        HashMap<String, Integer> map = new HashMap<>(); // 이름과 row의 번호를 매핑해줌
        for(int i = 0 ; i < N ; i++) map.put(friends[i], i);
        
        int[][] giftRec = new int[N+1][N+1]; // row : 준 사람 / col : 받은 사람
        for(int i = 0 ; i < gifts.length ; i++) {
            String[] info = gifts[i].split(" ");
            int gIdx = map.get(info[0]);
            int rIdx = map.get(info[1]);
            giftRec[gIdx][rIdx]++;
            giftRec[gIdx][N]++; // 준 선물의 수의 총합 저장
            giftRec[N][rIdx]++; // 받은 선물의 수의 총합 저장
        }
        
        int[] nextMonth = new int[N];
        for(int giver = 0 ; giver < N ; giver++) {
            for(int receiver = giver ; receiver < N ; receiver++) {
                if(giver == receiver) continue;
                
                if(giftRec[giver][receiver] == giftRec[receiver][giver]) {
                    int gJisu = giftRec[giver][N] - giftRec[N][giver];
                    int rJisu = giftRec[receiver][N] - giftRec[N][receiver];
                    
                    if(gJisu == rJisu) continue;
                    if(gJisu < rJisu) nextMonth[receiver]++;
                    else nextMonth[giver]++;
                } else if(giftRec[giver][receiver] > giftRec[receiver][giver]) {
                    nextMonth[giver]++;
                } else {
                    nextMonth[receiver]++;
                }
            }
        }
        
        Arrays.sort(nextMonth);
        answer = nextMonth[N-1];
        return answer;
    }
}