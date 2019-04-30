package hash;

import java.util.HashMap;

/* author : violet4795
 * ���α׷��ӽ� : �ڵ��׽�Ʈ���� : hash 3�� : ����
 * 
 */

public class Camouflage {
	class Solution {
		public int solution(String[][] clothes) {
			int answer = 1;

			HashMap<String, Integer> clothMap = new HashMap<String, Integer>();
			for (String[] cloth : clothes) {
				if (clothMap.containsKey(cloth[1])) {
					clothMap.put(cloth[1], clothMap.get(cloth[1]) + 1);
				} else {
					clothMap.put(cloth[1], 1);
				}
			}
			for (int x : clothMap.values()) {
				answer *= x+1;
			}
			return answer-1;
		}
	}
}
