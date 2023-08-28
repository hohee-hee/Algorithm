import java.util.*;
import java.io.*;


public class Main {
	public static void main(String[] args) throws IOException {
        // 1. 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 도시의 수
        int R = Integer.parseInt(st.nextToken()); // 내일로 티켓 가격
        
        // 모든 도시 입력 받기
        HashMap<String, Integer> cities = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        int cIdx = 0;
        for(int i = 0 ; i < N ; i++) {
        	String city = st.nextToken();
        	if(cities.containsKey(city)) continue;
        	cities.put(city, cIdx);
        	cIdx++;
        }
        
        // 여행할 도시 입력받기
        int M = Integer.parseInt(br.readLine()); // 여행할 도시의 수
        String[] travel = new String[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < M ; i++) travel[i] = st.nextToken();
        
        // 그래프 만들기
        int cityCnt = cities.size(); // 중복을 제거한 도시 개수
        float[][] graphNo = new float[cityCnt][cityCnt]; // 내일로 티켓 없이 여행할 때
        float[][] graphYes = new float[cityCnt][cityCnt]; // 내일로 티켓으로 여행할 때  
        // 최댓값으로 채우기
        for(int r = 0 ; r < cityCnt ; r++) {
        	for(int c = 0 ; c < cityCnt ; c++) {
        		if(r == c) continue;
        		graphNo[r][c] = Integer.MAX_VALUE;
        		graphYes[r][c] = Integer.MAX_VALUE;
        	}
        }
        
        // 교통수단의 가격을 가중치로 하여 입력 받기
        int K = Integer.parseInt(br.readLine()); // 교통수단의 수
        for(int i = 0 ; i < K ; i++) {
            st = new StringTokenizer(br.readLine());
            String type = st.nextToken(); // 교통수단 종류
            String departure = st.nextToken(); // 출발지
            String arrival = st.nextToken(); // 도착지
            int price = Integer.parseInt(st.nextToken()); // 가격
            
            // 출발, 도착지 인덱스 찾기
            int dIdx = cities.get(departure);
            int aIdx = cities.get(arrival);
            
            // 일반 그래프에 넣기
            graphNo[dIdx][aIdx] = Math.min(graphNo[dIdx][aIdx], price);
            graphNo[aIdx][dIdx] = Math.min(graphNo[aIdx][dIdx], price);
            
            // 내일로 사용 그래프에 넣기
            if(type.equals("Mugunghwa") || type.equals("ITX-Saemaeul") || type.equals("ITX-Cheongchun")) { // 무료
            	graphYes[dIdx][aIdx] = Math.min(graphYes[dIdx][aIdx], 0);
            	graphYes[aIdx][dIdx] = Math.min(graphYes[aIdx][dIdx], 0);
            } else if(type.equals("S-Train") || type.equals("V-Train")) { // 반값
            	graphYes[dIdx][aIdx] = (float) Math.min(graphYes[dIdx][aIdx], price * 0.5);
            	graphYes[aIdx][dIdx] = (float) Math.min(graphYes[aIdx][dIdx], price * 0.5);
            } else { // 정가
            	graphYes[dIdx][aIdx] = Math.min(graphYes[dIdx][aIdx], price);
            	graphYes[aIdx][dIdx] = Math.min(graphYes[aIdx][dIdx], price);
            }            	
        }
        
        // 2. 플로이드
        for (int k = 0; k < cityCnt; k++) { // k = 거쳐가는 노드
            for (int i = 0; i < cityCnt; i++) { // i = 출발 노드
				if(i==k) continue;
                for (int j = 0; j < cityCnt; j++) { // j = 도착 노드
                    if (graphNo[i][k] + graphNo[k][j] < graphNo[i][j]) {
                    	graphNo[i][j] = graphNo[i][k] + graphNo[k][j];
                    }
                    if (graphYes[i][k] + graphYes[k][j] < graphYes[i][j]) {
                    	graphYes[i][j] = graphYes[i][k] + graphYes[k][j];
                    }
                }
            }
        }
        
        
        // 3. 값 찾기
        float yes = 0;
        float no = 0;
        
        for(int i = 1 ; i < M ; i++) {
        	String departure = travel[i-1];
        	String arrival = travel[i];
        	
            // 출발, 도착지 인덱스 찾기
            int dIdx = cities.get(departure);
            int aIdx = cities.get(arrival);
            
//            System.out.println(dIdx + " " + aIdx + " " + graphNo[dIdx][aIdx] + " " + graphYes[dIdx][aIdx]);

            yes += graphYes[dIdx][aIdx];
            no += graphNo[dIdx][aIdx];
            
        }
        
        // 4. 비교하기
//        System.out.println("Yes : " + yes + " No : " + no);
        if(yes+R < no)	System.out.println("Yes");
        else System.out.println("No");
	}
}
