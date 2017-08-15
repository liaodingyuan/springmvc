/**
 * 
 */
package basecc.pattern.factory.simple;

/**
* <p>Title:CpuFactory </p>
* <p>Description: </p>
* <p>Company: </p>
* @author liaody
* @date 2017��8��12��
*/
public class CpuFactory {

	public static Cpu createCpu(int type){
        Cpu cpu = null;
        if(type == 1){
            cpu = new IntelCpu(755);
        }else if(type == 2){
            cpu = new AmdCpu(938);
        }
        return cpu;
    }
}
