package basecc.base;
import javax.management.RuntimeErrorException;
public class Test1 {

//	返回2
	 public static int getValue1() {
	        int i1 = 1;
	        int i2 = 2;
	        try {
	            return i1;
	        } finally {
	            return i2;
	        }
	    }
	 // 返回1
	 public static int getValue2() {
	        int i = 1;
	        try {
	            return i;
	        } finally {
	            i++;
	        }
	  }	 
	// 有异常返回2，无异常返回3
	public int testMethod(boolean flag) {
		int ii;
		try {
			ii = 1;
			if (flag)
				throw new RuntimeErrorException(null);
			return ii;
		} catch (Exception e) {
			ii = 2;
			// 会将3(如果出现异常，执行了finally之后)，弹出栈外，将保存在
			return ii;
		} finally {
			ii = 3;
		}

	}
	// 无论是否有异常最终结果返回3
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
