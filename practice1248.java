
public class practice1248 {
    public int numberOfSubarrays(int[] nums, int k) {
        int left = 0, right = 0, oddCnt = 0, res = 0;
        while (right < nums.length) {
            // ��ָ�����ߣ�ÿ����һ�������� oddCnt++��
            if ((nums[right++] & 1) == 1) {
                oddCnt++;
            }

            //  ����ǰ�������� [left, right) ���� k �������ˣ�����˷�֧ͳ�Ƶ�ǰ���������е����������������
            if (oddCnt == k) {
                // �Ƚ��������ڵ��ұ߽�������չ��ֱ��������һ������������磩
                // rightEvenCnt ��Ϊ�� k �������ұߵ�ż���ĸ���
                int tmp = right;
                while (right < nums.length && (nums[right] & 1) == 0) {
                    right++;
                }
                int rightEvenCnt = right - tmp;
                // leftEvenCnt ��Ϊ�� 1 ��������ߵ�ż���ĸ���
                int leftEvenCnt = 0;
                while ((nums[left] & 1) == 0) {
                    leftEvenCnt++;
                    left++;
                }
                // �� 1 ��������ߵ� leftEvenCnt ��ż����������Ϊ��������������
                // (��Ϊ��1��������߿���1��ż������ȡ����������ѡ���� leftEvenCnt + 1 �֣�
                // �� k �������ұߵ� rightEvenCnt ��ż����������Ϊ������������յ�
                // (��Ϊ��k�������ұ߿���1��ż������ȡ�������յ��ѡ���� rightEvenCnt + 1 �֣�
                // ���Ըû��������У�������������������ѡ�������Ϊ (leftEvenCnt + 1) * (rightEvenCnt + 1)
                res += (leftEvenCnt + 1) * (rightEvenCnt + 1);

                // ��ʱ left ָ����ǵ� 1 ����������Ϊ�������Ѿ�ͳ�����ˣ���� left ����һλ��oddCnt--
                left++;
                oddCnt--;
            }

        }

        return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		practice1248 p = new practice1248();
		//int[] nums = {2044,96397,50143};
		//int[] nums = {2,2,2,1,2,2,1,2,2,2};
		int[] nums = {45627,50891,94884,11286,35337,46414,62029,20247,72789,89158,54203,79628,25920,16832,47469,80909};
		System.out.println(p.numberOfSubarrays(nums, 1));
	}

}