package stackQueue;

import java.util.LinkedList;

/* author : violet4795
 * 프로그래머스 : 코딩테스트연습 : 해시큐 6번 : 주식가격
 * 
 */

public class StockPrice {
	class Solution {
	    public int[] solution(int[] prices) {
	        int[] answer = new int[prices.length];
	        LinkedList<int[]> queue = new LinkedList<int[]>();
	        for(int i = 0; i < prices.length-1; i++){
	            
	            if(queue.isEmpty()){
	                int[] temp = {prices[i], i, 0};
	                queue.push(temp);
	                for(int j = 0; j < queue.size(); j++){
	                    queue.get(j)[2] ++;
	                }
	            }else if(queue.peek()[0] > prices[i]){
	                int k = queue.size();
	                for(int j = k-1; j >= 0; j--){
	                    if(queue.peek()[0] > prices[i]){
	                        answer[queue.peek()[1]] = queue.peek()[2];
	                        queue.pop();
	                    }else{
	                        break;
	                    }
	                }
	                int[] temp = {prices[i], i, 0};
	                queue.push(temp);
	                for(int j = 0; j < queue.size(); j++){
	                    queue.get(j)[2] ++;
	                }
	            }else{
	                int[] temp = {prices[i], i, 0};
	                queue.push(temp);
	                for(int j = 0; j < queue.size(); j++){
	                    queue.get(j)[2] ++;
	                }
	            }
	        }
	        for(int j = 0; j < queue.size(); j++){
	            answer[queue.get(j)[1]] = queue.get(j)[2];
	        }
	        return answer;
	    }
	}
}
