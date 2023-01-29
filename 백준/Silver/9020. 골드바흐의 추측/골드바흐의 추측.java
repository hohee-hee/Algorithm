import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); //테스트케이스 T
		int[] n = new int[T]; //T개의 짝수 n을 저장할 배열
		//짝수 n 입력받고 저장하기
		for(int i = 0 ; i < T ; i++) {
			n[i] = sc.nextInt();
		}
		
		/*
		 * 골드바흐의 파티션 찾기
		 * 1. 주어진 수보다 작은 소수 찾기
		 * 2. 각 소수들을 더하면서 파티션 찾기
		 */
		
		for(int i = 0 ; i < T ; i++) {
			//1. 소수찾기(에레토스테네스의 체)
			ArrayList<Boolean> list = new ArrayList<>();
            //0부터 n까지의 인덱스에 모두 true를 넣기
			for(int j = 0; j <= n[i] ; j++) {
				list.add(j, true);
			}
            //0,1은 false로 처리
			list.set(0, false);
			list.set(1, false);
			//2 이상의 인덱스는 각각의 배수라면 false로 바꾸기
			for(int j = 2 ; j <= n[i] ; j++) {
				if(list.get(j)) {
					for(int k = j*j ; k <= n[i] ; k+=j) {
						list.set(k, false);
					}
				}
			}
			//2. 각 소수들을 더하면서 파티션 찾기
			ArrayList<Integer> pnum = new ArrayList<>(); //소수를 넣을 동적 리스트
			for(int j = 0 ; j <= n[i] ; j++) {
                //각 인덱스가 true라면 리스트에 인덱스를 넣기
				if(list.get(j)){
					pnum.add(j);
				}
			}
			int p1 = 0; //출력을 위한 더 작은 소수
			int p2 = 0; //출력을 위한 더 큰 소수
			int minus = n[i]; //차가 더 작은 수를 찾기 위한 변수
            //조건에 맞는 소수 찾기
			for(int j = 0 ; j < pnum.size(); j++) {
				int tmp = n[i] - pnum.get(j); //파티션 찾기
				for(int k = j ; k < pnum.size() ; k++) {
                     //k번째 수와 tmp가 갖고 이전 두 수의 차보다 작다면 p1과 p2에 저장
					if(tmp == pnum.get(k) && pnum.get(j) - pnum.get(k) < minus) {
						p1 = pnum.get(j);
						p2 = pnum.get(k);
						minus = p2 - p1;
					}						
				}
			}
			
			System.out.println(p1 + " " + p2);
		}

	}

}
