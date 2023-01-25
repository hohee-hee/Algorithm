import java.util.ArrayList;

class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        
        int denom3 = denom1 * denom2;
        int numer3 = numer1 * denom2 + numer2 * denom1;
        
        ArrayList<Integer> list_de = new ArrayList<>();
        
        for(int i = 2; i<= denom3 ; i++){
            if(denom3 % i == 0){		
                list_de.add(i);
            }
        }
        
        ArrayList<Integer> list_nu = new ArrayList<>();
        
        for(int i = 2; i<= numer3 ; i++){
            if(numer3 % i == 0){
                list_nu.add(i);
            }
        }
        
        int[] div_de = list_de.stream().mapToInt(Integer::intValue).toArray();
        int[] div_nu = list_nu.stream().mapToInt(Integer::intValue).toArray();
        int common = 0 ;
        
        
        outer : for(int i = div_de.length -1 ; i >= 0 ; i--){
            for(int j = div_nu.length -1 ; j >=0 ; j--){
                if(div_de[i] == div_nu[j]){
                    common = div_de[i];
                    break outer;
                }
            }
        }
        if(common != 0){
            denom3 /= common;
            numer3 /= common;
        }
        
        int[] answer = {numer3, denom3};
        return answer;
    }
}