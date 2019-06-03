package stackQueue;

import java.util.LinkedList;

/* author : violet4795
 * ���α׷��ӽ� : �ڵ��׽�Ʈ���� : �ؽ�ť 3�� : �ٸ��� ������ Ʈ��
 * �ٺ����� ������ ť��� �����ؼ� �������� �ٱ����ߴ�..;
 * ��ũ�帮��Ʈ���� push pop ��ġ�� �޶���.
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
		// �ʿ��Ѱ� �ǳʴµ� �ɸ��� �ð� ( ���½ð� �����½ð�)
		// �Ѳ����� �δ��̻� ���Դ� ����������.
		// ������ ���Ը� ���� ������ üũ�ϸ� ���ҰŰ���.
		// �����°Ͱ� �����°��� ���ÿ� �̷���� �� �ִ�.
		// Ʈ���迭�� �������� �����ؼ� ������ ���°� ���غ��δ�. ���������߱ݹ�ǰ���
		LinkedList<Integer> truckStack = new LinkedList<Integer>();
		LinkedList<int[]> bridgeStack = new LinkedList<int[]>();
		int bridgeWeight = 0;

		for (int i : truck_weights) {
			truckStack.add(i);
		}
		int truck = 0;
		for (int i = 1; !(truckStack.isEmpty() && bridgeStack.isEmpty()); i++) {
			truck = 0;
			// �ٸ����� �ϰ͵�������
			if (bridgeStack.isEmpty()) {
				truck = truckStack.remove(0);
				bridgeStack.add(new int[] { truck, i, i + bridge_length  });
				bridgeWeight += truck;
				// �ٸ����� �����ִ�
			} else {
				// ���� �ٸ��� ù���� �������� ��ٸ�
				if (bridgeStack.get(0)[2] == i) {
					// �����ٲ� ���ÿ��� �����ϰ� �ٸ���ü �߷����̰�.
					truck = bridgeStack.remove(0)[0];
					bridgeWeight -= truck;
				}
				if (!truckStack.isEmpty()) {

					// �׸��� �������� �ƴϵ簣��
					// �������� �� + �ٸ����԰� �߷����� �����ų� ���ٸ�
					if (truckStack.get(0) + bridgeWeight <= weight) {
						// �����°�����
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

	
