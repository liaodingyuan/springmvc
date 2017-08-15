/**
 * 
 */
package basecc.pattern.factory.simple;

/**
 * <p>
 * Title:AmdCpu
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
public class AmdCpu implements Cpu {

	// 定义AMD的针脚数
	private int pins;

	public AmdCpu(int pins) {
		this.pins = pins;
	}

	@Override
	public void calculate() {
		
		System.out.println("AMD CPU的针脚数：" + this.pins);

	}

}
