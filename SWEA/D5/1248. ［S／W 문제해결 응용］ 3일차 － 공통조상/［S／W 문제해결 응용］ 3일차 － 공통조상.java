import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		for(int test_case = 1 ; test_case <= T ; test_case++) {
			//입력받기
			int V = sc.nextInt(); //정점 수
			int E = sc.nextInt(); //간선 수
			int N1 = sc.nextInt(); //조상 노드를 찾을 노드
			int N2 = sc.nextInt(); //조상노드를 찾을 노드
			
			int[] tree = new int[V+1]; //부모노드의 정보만을 저장할 트리
			//노드에 부모노드의 정보를 저장하여 트리 생성
			for(int i = 0 ; i < E ; i++) {
				int parent = sc.nextInt();
				tree[sc.nextInt()] = parent;
			}
			//주어진 노드의 공통 부모노드 찾기
			//1. 첫번째 노드의 조상노드의 번호를 리스트에 모두 넣기
			int p1 = tree[N1];
			ArrayList<Integer> parents = new ArrayList<>();		
			while(p1 != 0) {
				parents.add(p1);
				p1 = tree[p1];
			}

			//2. 두 번째 노드의 조상 노드를 탐색하며 parents 리스트에 있는지 확인하고 존재한다면 해당 노드를 공통 조상으로 저장
			int same = tree[N2]; //공통 조상을 저장할 변수
			outer : while(same != 0){
				for(int i = 0 ; i < parents.size(); i++) {
					if(same == parents.get(i)) { break outer; }
				}
				same = tree[same];
			}

			//공통조상을 루트노드로 하는 트리의 크기 구하기
			int size = 1; //본인노드
			for(int i = 1 ; i <= V ; i++) {
				int p = tree[i];
				while( p != 0) {
					if(p == same) {
						size++;
						break;
					}
					p = tree[p];
				}
			}
			
			//출력을 위해 스트링 빌더에 넣기
			sb.append("#" + test_case + " " + same + " " + size + "\n");
		}
		
		System.out.println(sb);
	}
}
