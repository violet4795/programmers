package stackQueue;

import java.util.ArrayList;

public class FunctionDev {

	public static void main(String[] args) {
		int[] progresses = new int[] {93, 30, 55};
		int[] speeds = new int[] {1, 30, 5};
		int[] x = solution(progresses, speeds);
		for(int i : x) {
			System.out.println(i);
		}
	}
	
	public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int count = 0;
        int max = 0;
        while(true) {
        	count = 0;
        	for(int i = 0; i < progresses.length; i++) {
        		progresses[i] += speeds[i];
        		if(progresses[i] >= 100) {
        			count++;
        			progresses[i] = 0;
        			speeds[i] = 0;
        		}
        	}
        	if(count != 0) {
        		arr.add(count);
        		max += count;
        	}
        	if(max == speeds.length) {
        		answer = new int[arr.size()];
        		for(int i = 0; i < arr.size(); i++) {
        			answer[i] = arr.get(i);
        		}
        		break;
        	}
        }
        return answer;
    }
}
