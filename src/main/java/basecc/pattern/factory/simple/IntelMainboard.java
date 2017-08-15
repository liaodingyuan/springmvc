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
 * @date 2017��8��12��
 */
public class IntelMainboard implements Mainboard {

	// ����cpu�����
	private int cpuHoles = 0;

	public IntelMainboard(int cpuHoles) {
		this.cpuHoles = cpuHoles;
	}

	@Override
	public void installCPU() {
		
		System.out.println("Intel�����CPU��ۿ����ǣ�" + cpuHoles);

	}

}
