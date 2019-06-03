package stackQueue;

import java.util.LinkedList;

/* author : violet4795
 * 프로그래머스 : 코딩테스트연습 : 해시큐 3번 : 다리를 지나는 트럭
 * 바보같이 스택을 큐라고 생각해서 스택으로 다구현했던..;
 * 링크드리스트에서 push pop 위치가 달랐다.
 */


public class PassTruck {
	public static void main(String[] args) {
		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = {7, 4, 5, 6};
		System.out.println(solution(bridge_length, weight, truck_weights));
	}
	
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;
		// 필요한것 건너는데 걸리는 시간 ( 들어온시간 나가는시간)
		// 한꺼번에 두대이상 들어왔다 나갈수없음.
		// 스택의 무게를 따로 변수로 체크하면 편할거같다.
		// 나가는것과 들어오는것이 동시에 이루어질 수 있다.
		// 트럭배열도 스택으로 관리해서 팝으로 쓰는게 편해보인다. 만개정도야금방되겠지
		LinkedList<Integer> truckStack = new LinkedList<Integer>();
		LinkedList<int[]> bridgeStack = new LinkedList<int[]>();
		int bridgeWeight = 0;

		for (int i : truck_weights) {
			truckStack.add(i);
		}
		int truck = 0;
		for (int i = 1; !(truckStack.isEmpty() && bridgeStack.isEmpty()); i++) {
			truck = 0;
			// 다리위에 암것도없으면
			if (bridgeStack.isEmpty()) {
				truck = truckStack.remove(0);
				bridgeStack.add(new int[] { truck, i, i + bridge_length  });
				bridgeWeight += truck;
				// 다리위에 뭔가있다
			} else {
				// 만약 다리위 첫놈이 나갈때가 됬다면
				if (bridgeStack.get(0)[2] == i) {
					// 보내줄께 스택에서 제거하고 다리전체 중량줄이고.
					truck = bridgeStack.remove(0)[0];
					bridgeWeight -= truck;
				}
				if (!truckStack.isEmpty()) {

					// 그리고 나갈때든 아니든간에
					// 다음들어올 차 + 다리무게가 중량보다 가볍거나 같다면
					if (truckStack.get(0) + bridgeWeight <= weight) {
						// 들어오는거지뭐
						truck = truckStack.remove(0);
						bridgeStack.add(new int[] { truck, i, i + bridge_length });
						bridgeWeight += truck;
					}
				}
			}
			answer = i;
		}
		return answer;
	}
}

	
