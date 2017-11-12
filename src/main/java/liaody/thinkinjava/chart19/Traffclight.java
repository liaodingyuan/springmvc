/**
 * 
 */
package liaody.thinkinjava.chart19;

/**
 * <p>
 * Title:Traffclight
 * </p>
 * <p>
 * Description:在switch语句中使用enum
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017年11月11日
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