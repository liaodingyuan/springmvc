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
 * @date 2017��8��12��
 */
public class AmdCpu implements Cpu {

	// ����AMD�������
	private int pins;

	public AmdCpu(int pins) {
		this.pins = pins;
	}

	@Override
	public void calculate() {
		
		System.out.println("AMD CPU���������" + this.pins);

	}

}
