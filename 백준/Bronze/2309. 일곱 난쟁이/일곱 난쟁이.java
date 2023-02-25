import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> dwarfs = new ArrayList<>(); //난쟁이의 키를 저장할 리스트
		int d_sum = 0; //아홉난쟁이의 키의 합
		
		//입력받으면서 키의 합 구하기
		for(int i = 0 ; i < 9 ; i++) {
			int height = Integer.parseInt(br.readLine());
			dwarfs.add(height);
			d_sum += height;
		}
		
		//정렬
		Collections.sort(dwarfs);
		
		//이중 for문을 돌면서 두 수의 합이 d_sum - 100과 같은 경우를 찾아준다
		//2명만 빠지면 100이 맞기 때문에.
		outer : for(int i = 0 ; i < 8 ; i++) {
			for(int j = i+1 ; j < 9 ; j++) {
				if(dwarfs.get(i) + dwarfs.get(j) == d_sum - 100) {
					//앞에 있는걸 먼저 지우면 인덱스가 변한다
					//j는 무조건 i보다 앞에 있으므로  j를 먼저 지우고 i를 지운다
					dwarfs.remove(j);
					dwarfs.remove(i);
					break outer;
				}
			}
		}
		
		for(int i = 0 ; i < 7 ; i++) {
			System.out.println(dwarfs.get(i));
		}
	}
}
