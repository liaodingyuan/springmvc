/**
 * 
 */
package basecc.pattern.strategy.demo;

/**
 * <p>
 * Title:MemberStrategy
 * </p>
 * <p>
 * Description: ���㲻ͬ��Ա��Ӧ���ۿ��ʡ�
 * 
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017��8��11��
 */
public interface MemberStrategy {

	/**
	 * ����ͼ��ļ۸�
	 * 
	 * @param booksPrice
	 * @return
	 */
	double calPrice(double booksPrice);
}
