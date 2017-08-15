/**
 * 
 */
package basecc.pattern.factory.simple;

/**
 * <p>
 * Title:IntelCpu
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
public class IntelCpu implements Cpu {
	// 定义cpu的针脚数
	private int pins;

	public IntelCpu(int pins) {
		this.pins = pins;
	}

	@Override
	public void calculate() {

		System.out.println("Intel CPU的针脚数：" + this.pins);

	}

}
