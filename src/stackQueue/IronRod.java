package stackQueue;

/* author : violet4795
 * 프로그래머스 : 코딩테스트연습 : 해시큐 1번 : 쇠막대기
 * 
 */

public class IronRod {
	class Solution {
	    public int solution(String arrangement) {
	        int answer = 0;
	        int stack = 0;
	        boolean currentStatus = true; // ( == true ) == false
	        for(int i = 0; i < arrangement.length(); i++){
	            if(arrangement.charAt(i) == '('){
	                stack++;
	                currentStatus = true;
	            }else if(arrangement.charAt(i) == ')'){
	                stack--;
	                if(currentStatus){
	                    answer += stack;
	                }else {
	                    answer++;
	                }
	                currentStatus = false;
	            }
	                
	        }
	        return answer;
	    }
	}
}
