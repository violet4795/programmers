package hash;

import java.util.Arrays;

/* author : violet4795
 * ���α׷��ӽ� : �ڵ��׽�Ʈ���� : hash 1�� : �������� ����  ����
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
