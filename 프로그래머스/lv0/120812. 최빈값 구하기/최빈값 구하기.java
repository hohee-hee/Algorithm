class Solution {
    public int solution(int[] array) {
        int answer = 0;        
        int[] freq = new int[1000]; //빈도수를 저장하는 배열
        int cnt = 0; //최빈값이 여러 개임을 확인할 변수
        //array의 원소가 1개라면, 그 값을 그대로 반환
        if(array.length == 1){
            answer = array[0];            
        }
        // 2개 이상이라면 계산
        else{
            for(int i = 0 ; i < array.length ; i++){
                freq[array[i]]++; //array의 원소를 인덱스로 나올때마다 1씩 증가
            }
            int max = 0; // 최댓값을 찾기 위한 변수
            for(int i = 0 ; i < 1000 ; i++){
                if(freq[i]>max)
                    max = freq[i];
            }
        
            for(int i = 0 ; i < 1000 ; i++){
                if(max == freq[i]){
                    cnt++;
                    if(cnt >= 2){
                        answer = -1;
                        break;
                    }
                    answer = i;
                }
            }
        }        
        return answer;
    }
}