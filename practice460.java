import java.util.HashMap;
import java.util.Map;
public class practice460 {
	HashMap<Integer, Integer> map = new HashMap<>();
	HashMap<Integer, Integer> count = new HashMap<>();
	private int capaticty;

	public practice460(int capacity) {
		this.capaticty = capacity;
	}
	
	public int get(int key) {
		if (! map.containsKey(key)) return -1;
		count.put(key, count.get(key) + 1);
		return map.get(key);
	}
	 
	public void put(int key, int value) {
		int size = map.size();
		// δ�ﵽ�����������map��û��key
		if (size < this.capaticty && ! map.containsKey(key)) {
			map.put(key, value);
			count.put(key, 1);
		}
		// δ�ﵽ�����������map���Ѿ�����key����ʱcount+1
		else if (size <= this.capaticty && map.containsKey(key)) {
			map.put(key, value);
			count.put(key, count.get(key) + 1);
		}
		// �ﵽ���������
		else {
			if (this.capaticty == 0) return;
			int num = Integer.MAX_VALUE;
			Map.Entry<Integer, Integer> minEntry = null;
			for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
				if (entry.getValue() < num) {
					num = entry.getValue();
					minEntry = entry;
				}
			}
			// ������ͼ�еĶ����
			map.remove(minEntry.getKey());
			count.remove(minEntry.getKey());
			map.put(key, value);
			count.put(key, 1);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		practice460 cache = new practice460( 2 /* capacity (��������) */ );

		//cache.put(0, 0);
		cache.put(2, 1);
		//System.out.println(cache.get(1));      // ���� 1
		cache.put(3, 2);    // ȥ�� key 2
		System.out.println(cache.get(3));    // ���� -1 (δ�ҵ�key 2)
		//cache.get(3);       // ���� 3
		System.out.println(cache.get(2));    // ���� -1 (δ�ҵ� key 1)
		cache.put(4, 3);    // ȥ�� key 1
		System.out.println(cache.get(2));      // ���� 3
		System.out.println(cache.get(3));       // ���� 4
		System.out.println(cache.get(4));       // ���� 4

	}

}
/*
 * 211 -1 3
 
["LFUCache","put","put","get","get","put","get","get","get"]
[[2],[2,1],[3,2],[3],[2],[4,3],[2],[3],[4]]
*/