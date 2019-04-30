package hash;

import java.util.Arrays;

/* author : violet4795
 * 프로그래머스 : 코딩테스트연습 : hash 1번 : 완주하지 못한  선수
 * 
 */

public class NotFinishedPlayer {

	class Solution {
	    public String solution(String[] participant, String[] completion) {
	        String answer = "";
	        
	        Arrays.sort(participant);
	        Arrays.sort(completion);
	        for(int i = 0; i < completion.length; i++){
	            if(!participant[i].equals(completion[i])){
	                answer = participant[i];
	                return answer;
	            }
	        }
	        answer = participant[participant.length-1];
	        return answer;
	    }
	}
}
