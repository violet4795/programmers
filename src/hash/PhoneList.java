package hash;

import java.util.HashMap;

/* author : violet4795
 * 프로그래머스 : 코딩테스트연습 : hash 2번 : 전화번호 목록 문제
 * 
 */
public class PhoneList {
	
	class Solution {
	    public boolean solution(String[] phone_book) {
	    	HashMap<String, Boolean> x = new HashMap<String, Boolean>();
	        boolean answer = true;
	        for(String s : phone_book){
	            x.put(s,true);
	        }
	        A:
	        for(String s : phone_book){
	            for(int i = 1; i < s.length(); i++){
	                if(x.get(s.substring(0, i)) != null){
	                    answer = false;
	                    break A;
	                }
	            }
	        }
	    return answer;
	    }
	}
}
