package stackQueue;

import java.util.LinkedList;

/* author : violet4795
 * 프로그래머스 : 코딩테스트연습 : 해시큐 2번 : 프린터
 * 
 */

public class Printer {
	public static void main(String[] args) {
		Solution s = new Solution();
		//int[] priorities = new int[] {2, 1, 3, 2};
		int[] priorities = new int[] {1, 1, 9, 1, 1, 1};
		int location = 0;
		System.out.println(s.solution(priorities, location));
	}
}

class Solution {
    public int solution(int[] priorities, int location) {
        LinkedList<int[]> queue = new LinkedList<int[]>();
        for(int i = 0; i < priorities.length; i++) {
        	if(i == location) {
        		queue.add(new int[] {priorities[i], 1});
        	}else {
        		queue.add(new int[] {priorities[i], 0});
        	}
        }
    	int answer = 0;
    	
        int printPaperCount = priorities.length;
        int count = 0;
        for(int i = 1; i <= printPaperCount; i++) {
        	count = 0;
        	for(int j = 0; j < queue.size(); j++) {
        		if(queue.get(0)[0] < queue.get(j)[0]) {
        			queue.addLast(queue.remove(0));
        			i--;
        			break;
        		}else {
        			count++;
        			if(count == queue.size()) {
        				if(queue.get(0)[1] == 1) {
        					return i;
        				}else {
        					queue.remove(0);
        				}
        				break;
        			}
        		}
        	}
        }
        return answer;
    }
}
