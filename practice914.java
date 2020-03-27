import java.util.HashMap;
import java.util.ArrayList;
public class practice914 {

	public boolean hasGroupSizeX(int[] deck) {
		int len = deck.length;
		if (len<2) return false;
		
		int min = Integer.MAX_VALUE; // map��ֵ������С��ֵ
		HashMap<Integer, Integer> map = new HashMap<>();
		// �����������ֵĴ�������HashMap��
		for (int i=0; i<len; ++i) {
			int cur = deck[i];
			if (! map.containsKey(cur)) map.put(cur, 1);
			else map.put(cur, map.get(cur)+1);
		}
		// �ҳ����ִ�����С��������ôX��ȡֵһ�����������Լ��
		for (int v : map.values()) min = Math.min(min, v);
		if (min < 2) return false;
		// ���min������Լ����Ȼ��������볢��
		ArrayList<Integer> list = new ArrayList<>();
		list.add(min); // ����Ҳ��Լ�����ȷ���
		for (int v=2; v<=min/2; ++v) {
			if (min % v == 0) list.add(v);
		} 
		for (int value : list) {
			int flag = 0;
			for (int v : map.values()) {
				if (v % value != 0) break;
				flag ++;
			}
			if (flag == map.size()) return true;
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		practice914 p = new practice914();
		int[] deck = {1,1,1,1,2,2,2,2,2,2};
		boolean b = p.hasGroupSizeX(deck);
		System.out.println(b);
	}

}
