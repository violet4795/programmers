package hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* author : violet4795
 * ���α׷��ӽ� : �ڵ��׽�Ʈ���� : hash 4�� : ����Ʈ�ٹ�
 * 
 */


public class BestAlbum {

	class Solution {
	    public int[] solution(String[] genres, int[] plays) {
	    	HashMap<String, Integer> genreSumMap = new HashMap<String, Integer>();
	    	HashMap<String, ArrayList<int[]>> playList = new HashMap<String, ArrayList<int[]>>();
	       //ArrayList<Integer, ArrayList<Integer>>> playList = new HashMap<String, ArrayList<Integer, ArrayList<Integer>>>();
	        for(int i = 0; i < genres.length; i++){
	        	//�帣Ű�� ���������ʴ´ٸ�
	            if(!playList.containsKey(genres[i])){
	            	playList.put(genres[i], new ArrayList<int[]>());
	            	playList.get(genres[i]).add(new int[] {i, plays[i]});
	            //�帣Ű�� �����Ѵٸ�
	            }else {
					for (int j = 0; j < playList.get(genres[i]).size(); j++) {
						// ��������ʴٸ�
						if (!playList.get(genres[i]).isEmpty()) {
							if (plays[i] > playList.get(genres[i]).get(j)[1]) {
								playList.get(genres[i]).add(new int[] { i, plays[i] });
								break;
							} else if (plays[i] == playList.get(genres[i]).get(j)[1]) {
								if (i > playList.get(genres[i]).get(j)[0]) {
									playList.get(genres[i]).add(new int[] { i + 1, plays[i] });
								} else {
									playList.get(genres[i]).add(new int[] { i, plays[i] });
								}
								break;
							}
						}
						// ����ִٸ�

						// playList.put(genres[i], playList.get(genres[i]).add(e))
					}
	            }
	            genreSumMap.put(genres[i], plays[i]);
	            
	        }
	        return null;
	    }
	}
}
