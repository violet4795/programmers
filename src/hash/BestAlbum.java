package hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* author : violet4795
 * ���α׷��ӽ� : �ڵ��׽�Ʈ���� : hash 4�� : ����Ʈ�ٹ�
 * �̿ϼ� 40��. �׽�Ʈ���̽� ���� ã������
 * 20190507 ġ������ ���� �߰�.. ������ Ǯ�̿Ϸ�
 */

public class BestAlbum {

	public static void main(String[] args) {
		Solution s = new Solution();
		//String[] genres = new String[] {"classic", "pop", "classic", "classic", "pop"};
		String[] genres = new String[] {"a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a"};
		//String[] genres = new String[] {"a", "a", "a", "a", "e", "b", "f", "f", "a", "a", "b", "b"};
		//int[] plays = new int[] {500, 600, 150, 800, 2500};
		int[] plays = new int[] {801,800,800,800,800,800,800,800,800,800,800,800,800};
		//int[] plays = new int[] {800, 800, 800, 800, 953, 456, 448, 15987, 800, 800, 10000, 10000};
		int[] answer = s.solution(genres, plays);
		System.out.println(Arrays.toString(answer));
	}
	
}
class Solution {
	public int[] solution(String[] genres, int[] plays) {
		HashMap<String, Integer> genreSumMap = new HashMap<String, Integer>();
		HashMap<String, ArrayList<int[]>> playList = new HashMap<String, ArrayList<int[]>>();
		int[] answer;
		ArrayList<Integer> tempAnswer = new ArrayList<Integer>();
		for (int i = 0; i < genres.length; i++) {
			// �帣Ű�� ���������ʴ´ٸ�
			if (!playList.containsKey(genres[i])) {
				playList.put(genres[i], new ArrayList<int[]>());
				playList.get(genres[i]).add(new int[] { i, plays[i] });
				// �帣Ű�� �����Ѵٸ�
			} else {
				for (int j = 0; j < playList.get(genres[i]).size(); j++) {
					// ��������ʴٸ�
					if (!playList.get(genres[i]).isEmpty()) {
						if (plays[i] > playList.get(genres[i]).get(j)[1]) {
							playList.get(genres[i]).add(j, new int[] { i, plays[i] });
							break;
						} else if (plays[i] == playList.get(genres[i]).get(j)[1]) {
							if (i > playList.get(genres[i]).get(j)[0]) {
								if(j + 1 == playList.get(genres[i]).size()) {
									playList.get(genres[i]).add(j + 1, new int[] { i, plays[i] });
									break;
								}
							} else {
								playList.get(genres[i]).add(j, new int[] { i, plays[i] });
								break;
							}
							
						}else {
							playList.get(genres[i]).add(new int[] { i, plays[i] });
						}
					}

					// playList.put(genres[i], playList.get(genres[i]).add(e))
				}
			}
			if(genreSumMap.containsKey(genres[i])) {
				genreSumMap.put(genres[i], genreSumMap.get(genres[i]) + plays[i]);
			}else {
				genreSumMap.put(genres[i], plays[i]);
			}

		}
		int in = genreSumMap.size();
		int current = -1;
		String tempGenre;
		for (int index = 0; index < in; index++) {
			current = -1;
			tempGenre = "";
			for (String genre : genreSumMap.keySet()) {
				if (current != -1) {
					if(current < genreSumMap.get(genre)) {
						current = genreSumMap.get(genre);
						tempGenre = genre;
					}
				} else {
					current = genreSumMap.get(genre);
					tempGenre = genre;
				}
			}
			tempAnswer.add(playList.get(tempGenre).get(0)[0]);
			if(playList.get(tempGenre).size() > 1){
				tempAnswer.add(playList.get(tempGenre).get(1)[0]);
			}
			genreSumMap.remove(tempGenre);
		}
		answer = new int[tempAnswer.size()];
		for(int i = 0; i < tempAnswer.size(); i++) {
			answer[i] = tempAnswer.get(i);
		}
		return answer;
	}
}