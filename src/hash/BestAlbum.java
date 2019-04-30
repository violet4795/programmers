package hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* author : violet4795
 * 프로그래머스 : 코딩테스트연습 : hash 4번 : 베스트앨범
 * 
 */


public class BestAlbum {

	class Solution {
	    public int[] solution(String[] genres, int[] plays) {
	    	HashMap<String, Integer> genreSumMap = new HashMap<String, Integer>();
	    	HashMap<String, ArrayList<int[]>> playList = new HashMap<String, ArrayList<int[]>>();
	       //ArrayList<Integer, ArrayList<Integer>>> playList = new HashMap<String, ArrayList<Integer, ArrayList<Integer>>>();
	        for(int i = 0; i < genres.length; i++){
	        	//장르키가 존재하지않는다면
	            if(!playList.containsKey(genres[i])){
	            	playList.put(genres[i], new ArrayList<int[]>());
	            	playList.get(genres[i]).add(new int[] {i, plays[i]});
	            //장르키가 존재한다면
	            }else {
					for (int j = 0; j < playList.get(genres[i]).size(); j++) {
						// 비어있지않다면
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
						// 비어있다면

						// playList.put(genres[i], playList.get(genres[i]).add(e))
					}
	            }
	            genreSumMap.put(genres[i], plays[i]);
	            
	        }
	        return null;
	    }
	}
}
