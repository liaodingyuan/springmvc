/**
 * 
 */
package basecc.pattern.factory.simple;

/**
* <p>Title:AmdMainboard </p>
* <p>Description: </p>
* <p>Company: </p>
* @author liaody
* @date 2017��8��12��
*/
public class AmdMainboard implements Mainboard{

	
	/**
     * CPU��۵Ŀ���
     */
    private int cpuHoles = 0;
    /**
     * ���췽��������CPU��۵Ŀ���
     * @param cpuHoles
     */
    public AmdMainboard(int cpuHoles){
        this.cpuHoles = cpuHoles;
    }
    @Override
    public void installCPU() {
        // TODO Auto-generated method stub
        System.out.println("AMD�����CPU��ۿ����ǣ�" + cpuHoles);
    }
}
