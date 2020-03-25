import java.util.Queue;
import java.util.LinkedList;
public class practice892 {

	public int surfaceArea(int[][] grid) {
		// ������С�����
		int row = grid.length;  int col = grid[0].length;
		if (row == 0) return 0;
		int ans = 0;
		// ���ڱ�Ǹ������±����ʹ�
		int[][] flag = new int[row][col];
		for (int i=0; i<row; ++i) {
			for (int j=0; j<col; ++j) {
				if (grid[i][j] != 0) flag[i][j] = 1;
			}
		}
		// û����գ����з���û�м��㣨��ӣ�
		while (! this.isClean(grid)) {
			Queue<Integer> q_i = new LinkedList<>();
			Queue<Integer> q_j = new LinkedList<>();
			// �ҵ���һ���з����λ��
			sign:for (int i=0; i<row; ++i) {
				for (int j=0; j<col; ++j) {
					if (grid[i][j]!=0) {
						q_i.offer(i);
						q_j.offer(j);
						ans += this.singleArea(grid[i][j]);
						break sign;
					}
				}
			}
			// �������ұ������ĸ�����
			int[] map_i = {1,-1,0,0}; int[] map_j = {0,0,1,-1};
			// ���в�Ϊ��ʱ����������ͼ�Σ������������
			while (! q_i.isEmpty()) {
				// ȡ���ᡢ������
				int cur_i = q_i.poll(); int cur_j = q_j.poll();
				for (int k=0; k<4; ++k) {
					int new_i = cur_i + map_i[k];
					int new_j = cur_j + map_j[k];
					if (new_i>=0 && new_i<row && new_j>=0 && new_j<col && grid[new_i][new_j]!=0) {
						q_i.offer(new_i); q_j.offer(new_j);
						// �������������ķ��������ӵı����
						if (flag[new_i][new_j] == 1) {
							ans += this.singleArea(grid[new_i][new_j]);
							flag[new_i][new_j] = 0;
							
						}
						// ��ȥ�����������һ�����ص��Ĳ���
						ans -= 2 * Math.min(grid[cur_i][cur_j], grid[new_i][new_j]);
					}
				}
				// ������
				grid[cur_i][cur_j] = 0;
			}
		}
		return ans;
	}
	
	private int singleArea(int n) {
		if (n<2) return 6*n;
		return 4*n+2;
	}
	
	private boolean isClean(int[][] grid) {
		int row = grid.length; int col = grid[0].length;
		for (int i=0; i<row; ++i) {
			for (int j=0; j<col; ++j) {
				if (grid[i][j] != 0) return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		practice892 p = new practice892();
		int[][] grid = {{12,0,0,14,1,9,5,0,11,15,18,16,7,9,1},{18,6,7,3,6,14,6,18,4,8,12,18,15,9,9},{7,0,15,1,6,1,15,8,5,1,3,20,4,5,1},{15,18,20,17,4,19,9,12,8,13,18,3,10,18,6},{12,3,11,0,9,8,2,2,17,20,12,3,20,5,3},{3,11,3,10,14,2,12,16,12,1,5,0,20,8,11},{12,18,2,10,13,6,15,11,13,18,0,6,4,9,19},{13,11,10,3,20,7,13,15,2,0,16,20,5,14,11},{3,4,19,14,6,20,1,2,0,18,19,14,17,12,9},{18,2,13,13,17,12,3,7,13,1,18,19,4,0,7},{12,12,9,14,19,20,17,13,18,8,12,5,2,2,13},{12,4,10,10,13,8,10,3,19,14,20,3,18,5,6},{6,17,15,2,12,18,12,13,9,8,12,12,11,7,15},{15,2,17,20,17,7,7,11,10,17,0,20,18,9,13},{11,18,5,15,18,6,5,15,6,12,11,2,7,15,15}};
		int ans = p.surfaceArea(grid);
		System.out.println(ans);
		System.out.println(p.singleArea(2));
	}
}