import java.util.ArrayList;
import java.util.List;
public class practice119 {

	public List<Integer> getRow(int rowIndex) {
		List<Integer> list = new ArrayList<>();
 		list.add(1);
 		if (rowIndex == 0) return list;
		list.add(1);
		if (rowIndex == 1) return list;
		for (int i=2; i<=rowIndex; ++i) {
			// ��ż���У���ζ����һ������������
			int size = list.size();
			if (i % 2 == 0) {
				for (int j=1; j<i/2; ++j) {
					list.set(j, list.get(i-j) + list.get(i-j-1)); 
					if (j+1 == rowIndex / 2)	list.set(j, 2 * list.get(j));
				}
				for (int j=i/2+1; j<=i; ++j) {
					size = list.size();
					if (j >= size) list.add(0);
					list.set(j, list.get(i-j)); 
				}
			}
			// �����У���ζ����һ����ż������
			else {
				for (int j=1; j<=i/2; ++j) {
					list.set(j, list.get(i-j) + list.get(i-j-1)); 
				}
				for (int j=i/2+1; j<=i; ++j) {
					size = list.size();
					if (j >= size) list.add(0);
					list.set(j, list.get(i-j)); 
				}
			}
		}
		return list;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		practice119 p = new practice119();
		List<Integer> ans = p.getRow(2);
		System.out.println(ans);
	}

}
