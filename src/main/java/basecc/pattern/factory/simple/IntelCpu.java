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
 * @date 2017��8��12��
 */
public class IntelCpu implements Cpu {
	// ����cpu�������
	private int pins;

	public IntelCpu(int pins) {
		this.pins = pins;
	}

	@Override
	public void calculate() {

		System.out.println("Intel CPU���������" + this.pins);

	}

}
