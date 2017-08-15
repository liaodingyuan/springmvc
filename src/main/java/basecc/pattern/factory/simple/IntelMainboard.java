/**
 * 
 */
package basecc.pattern.factory.simple;

/**
 * <p>
 * Title:IntelMainboard
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017年8月12日
 */
public class IntelMainboard implements Mainboard {

	// 定义cpu插孔数
	private int cpuHoles = 0;

	public IntelMainboard(int cpuHoles) {
		this.cpuHoles = cpuHoles;
	}

	@Override
	public void installCPU() {
		
		System.out.println("Intel主板的CPU插槽孔数是：" + cpuHoles);

	}

}
