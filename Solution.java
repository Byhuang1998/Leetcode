// leetcode ��һ��
import java.util.HashMap;

public class Solution {
	
    public int[] twoSum(int[] nums, int target) {
    	int[] ans = {0,0};
    	int len = nums.length;
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	for (int i=0; i <len; i++) {
    		map.put(nums[i],i);
    	}
    	for (int i=0; i<len; i++) {
    		int dif = target - nums[i];
    		if (map.get(dif) != null && map.get(dif) != i) { //����������������һ���������Բ��������±겻����ͬ
    			ans[0] = i;
    			ans[1] = map.get(dif);
    			// ��Ϊ�϶������ظ�����һ���ҵ�����˳��ģ�ֱ�ӷ���
    			return ans;
    		}
    	}
    	return ans;
    }

    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2, 7, 11, 15};
		int target = 26;
		int[] ans = {0, 0};
		Solution s = new Solution();
		ans = s.twoSum(nums, target);
		for (int i=0; i<2; i++) {
			System.out.println(ans[i]);
			
		}
	}

}
