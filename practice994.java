import java.util.Queue;
import java.util.ArrayDeque;
import java.util.HashMap;
public class practice994 {
	
	public int orangesRotting(int[][] grid) {
		int row = grid.length;
		if (row==0) return 0;
		int col = grid[0].length;
		HashMap<Integer, Integer> map = new HashMap<>();
		int[] ii = {1,-1,0,0};
		int[] jj = {0,0,1,-1};
		int time = 0;
		Queue<Integer> q_i = new ArrayDeque<>(); // �洢������
		Queue<Integer> q_j = new ArrayDeque<>(); // �洢������
		// ����ʼ���õ����ӷ���HashMap�У������ʾλ�ã�ֵ��ʾ�������õ�ʱ�䡣
		for (int i=0; i<row; i++) {
			for (int j=0; j<col; j++) {
				if (grid[i][j]==2) {
					int code = i * col + j;
					map.put(code, 0);
					q_i.offer(i);
					q_j.offer(j);
				}
			}
		}
		// ���в�Ϊ��ʱ��˵����ǰ���и��õ����ӣ����Ը�Ⱦ����������
		while (!q_i.isEmpty()) {
			int cur_i = q_i.poll();
			int cur_j = q_j.poll();
			int code = cur_i * col + cur_j;
			for (int k=0; k<4; k++) {
				int tem_i = cur_i + ii[k];
				int tem_j = cur_j + jj[k];
				// �жϸ������δԽ�磬�������ʵģ���ô������Ⱦ
				// ������Ϊ2��������HashMap�����
				// ֱ������Ϊ��
				if (tem_i>=0 && tem_i<row && tem_j>=0 && tem_j<col && grid[tem_i][tem_j]==1) {
					grid[tem_i][tem_j] = 2;
					int ncode = tem_i * col + tem_j;
					map.put(ncode, map.get(code)+1);
					q_i.offer(tem_i);
					q_j.offer(tem_j);
					time = map.get(ncode); // ����ʱ��
				}
			}
		}
		// ���������ʵ����ӣ�˵�����ղ��ܸ�Ⱦ������-1
		for (int i=0; i<row; i++) {
			for (int j=0; j<col; j++) {
				if (grid[i][j] == 1) return -1; 
			}
		}
		return time;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = {{1},{2}};
		practice994 p = new practice994();
		int time = p.orangesRotting(grid);
		System.out.println(time);
	}
}
