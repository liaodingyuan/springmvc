package basecc.base;
import javax.management.RuntimeErrorException;
public class Test1 {

//	����2
	 public static int getValue1() {
	        int i1 = 1;
	        int i2 = 2;
	        try {
	            return i1;
	        } finally {
	            return i2;
	        }
	    }
	 // ����1
	 public static int getValue2() {
	        int i = 1;
	        try {
	            return i;
	        } finally {
	            i++;
	        }
	  }	 
	// ���쳣����2�����쳣����3
	public int testMethod(boolean flag) {
		int ii;
		try {
			ii = 1;
			if (flag)
				throw new RuntimeErrorException(null);
			return ii;
		} catch (Exception e) {
			ii = 2;
			// �Ὣ3(��������쳣��ִ����finally֮��)������ջ�⣬��������
			return ii;
		} finally {
			ii = 3;
		}

	}
	// �����Ƿ����쳣���ս������3
	public int testMethod2(boolean flag) {
		int ii;
		try {
			if (flag)
				throw new RuntimeErrorException(null);
			ii = 1;
		} catch (Exception e) {
			ii = 2;
		} finally {
			ii = 3;
		}
		return ii;
	}

}
