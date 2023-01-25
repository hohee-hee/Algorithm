import java.util.Arrays;

class Solution {
    public int solution(String[] spell, String[] dic) {
		
		String[] copy = Arrays.copyOf(spell,spell.length);
		
		int answer = 2;
		for(int i = 0 ; i < dic.length ; i++) {
			copy = Arrays.copyOf(spell,spell.length);
			for(int j = 0 ; j < copy.length ; j++) {
				if(dic[i].contains(copy[j])) {
					dic[i] = dic[i].replaceFirst(copy[j], "");
                    copy[j] = copy[j].replace(copy[j],"");
				}
			}
            boolean flag = true;
			
			for(int j = 0 ; j < copy.length ; j++) {
				if(!copy[j].equals(""))
					flag = false;
			}
			if(flag) {
				answer = 1;
				break;				
			}
        }
		
        return answer;
    }
}