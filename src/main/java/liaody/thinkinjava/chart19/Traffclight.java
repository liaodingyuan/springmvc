/**
 * 
 */
package liaody.thinkinjava.chart19;

/**
 * <p>
 * Title:Traffclight
 * </p>
 * <p>
 * Description:��switch�����ʹ��enum
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017��11��11��
 */
public class Traffclight {

	Signal color = Signal.RED;

	public void change() {
		switch (color) {
		case RED:
			color = Signal.GRENN;
			break;
		case GRENN:
			color = Signal.YELLOW;
			break;
		case YELLOW:
			color = Signal.RED;
			break;
		}
	}

}

enum Signal {
	GRENN, YELLOW, RED
}