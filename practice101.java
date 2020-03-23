import java.util.Stack;
public class practice101 {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){val = x;}
	}
	public boolean isSymmetric(TreeNode root) {
		// ���Ϊ��������ֻ�и��ڵ㣬�ǶԳƵ�
		if (root == null || root.left == null && root.right == null) return true;
		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();
		TreeNode l = root.left;
		TreeNode r = root.right;
		s1.push(l);
		s2.push(r);
		while(! s1.isEmpty()) {
			TreeNode cur1 = s1.pop();
			TreeNode cur2 = s2.pop();
			// һ�����ǿգ�����һ�������գ��϶����Գ�
			if (cur1==null&&cur2!=null || cur2==null&&cur1!=null) return false;
			// ��Ϊ�գ���ʱ�ǶԳƵģ������жϺ�������
			else if (cur1 == null && cur2 == null) continue;
			// �ڵ�ֵ����ȣ��϶�Ҳ���Գ�
			else if (cur1.val != cur2.val) return false;
			// �����ѹ������������֤��pop�����������ұ���ѹ������������֤��pop��������
			s1.push(cur1.right); s1.push(cur1.left);
			s2.push(cur2.left); s2.push(cur2.right);
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		practice101 p = new practice101();
		// ��
		TreeNode root = p.new TreeNode(1);
		// �ڶ���
		TreeNode l = root.left = p.new TreeNode(3);	TreeNode r = root.right = p.new TreeNode(3);
		// ������
		l.left = p.new TreeNode(4);	l.right = p.new TreeNode(3);
		r.left = p.new TreeNode(3);	r.right = p.new TreeNode(4);
		System.out.println(p.isSymmetric(root));
	}

}
