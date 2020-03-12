import java.util.ArrayList;
public class practice1071 {
	
	public String gcdOfStrings(String str1, String str2) {
		int len1 = str1.length();
		int len2 = str2.length();
		if (len1==0 || len2==0) return "";
		int gcd = gcd(len1, len2);
		int time1 = len1 / gcd;
		int time2 = len2 / gcd;
		// ���ڴ洢����Լ�������0��ʼ
		ArrayList<Integer> gcdNums = new ArrayList<>();
		for (int i=1; i<=gcd/2; i++) {
			if (gcd%i == 0) gcdNums.add(i);
		}
		gcdNums.add(gcd); // ��Ȼ����ҲҪ�����ȥ
		int num = gcdNums.size();
		// sign���ڱ��ѭ��
		sign: for (int m=num-1; m>=0; m--) {
			gcd = gcdNums.get(m);
			String division = str1.substring(0,gcd);
			
			// �ж�str1�ܷ�division�з�
			for (int i=0; i<time1; i++) {
				String tem = str1.substring(i*gcd, (i+1)*gcd);
				if (!tem.equals(division)) continue sign;
			}
			// �ж�str2�ܷ�division�з�
			for (int i=0; i<time2; i++) {
				String tem = str2.substring(i*gcd, (i+1)*gcd);
				if (!tem.equals(division)) continue sign;
			}
			return division;
		}
		return "";
	}

	public int gcd(int len1, int len2) {
		if (len1 == 0) return len2;
		if (len2 == 0) return len1;
		if (len2 > len1) return gcd(len2%len1, len1);
		if (len2 <= len1) return gcd(len1%len2, len2);
		return 0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "ABABAB";
		String str2 = "ABAB";
		practice1071 p = new practice1071();
		String ans = p.gcdOfStrings(str1, str2);
		System.out.println(ans);
	}

}
