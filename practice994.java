import java.util.ArrayList;
public class practice994 {
	
	public int orangesRotting(int[][] grid) {
		// ��ȡ���г���
		int col = grid.length;
		int row = grid[0].length;
		
		// ��Ҫ���ѵ�ʱ��
		int time = 0;
		// �ֱ����ڴ洢�ո��ӵ�����	
		ArrayList<Integer> emptyCol = new ArrayList<>();
		ArrayList<Integer> emptyRow = new ArrayList<>();
		int emptyCount = 0;		
		
		// �ֱ����ڴ洢�տ�ʼ�ĸ��õ����ӵ�����	
		ArrayList<Integer> freshCol = new ArrayList<>();
		ArrayList<Integer> freshRow = new ArrayList<>();
		int freshCount = 0;		
		
		// �ֱ����ڴ洢�տ�ʼ�ĸ��õ����ӵ�����	
		ArrayList<Integer> rottenCol = new ArrayList<>();
		ArrayList<Integer> rootenRow = new ArrayList<>();
		int rottenCount = 0;
		
		// �ҵ���ʼʱ���ո��ӡ����ʡ����õ�λ��
		for (int i=0; i<col; i++) {
			
			for (int j=0; j<row; j++) {
				if (grid[i][j] == 0) {
					emptyCol.set(emptyCount, i);
					emptyRow.set(emptyCount, j);
					emptyCount++;
					
				} else	if (grid[i][j] == 1) {
					freshCol.set(freshCount, i);
					freshRow.set(freshCount, j);
					freshCount++;
				} else {
					rottenCol.set(rottenCount, i);
					rootenRow.set(rottenCount, j);
					rottenCount++;
				}
			}
		}		
		return time;
	}

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println();
	}

}
