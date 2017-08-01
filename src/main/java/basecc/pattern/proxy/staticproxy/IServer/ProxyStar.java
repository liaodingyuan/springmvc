/**
 * 
 */
package basecc.pattern.proxy.staticproxy.IServer;

/**
 * <p>
 * Title:ProxyStar
 * </p>
 * <p>
 * Description: ������
 * 
 * ��ͳһ�����̿��ƶ��ŵ������ɫ�д���
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017��8��1��
 */
public class ProxyStar implements Star {
	// 0.ʵ������ʵ��ʵ�ֵ�ͬһ���ӿ�
	/** 1. ��ʵ��������á���������Ҫ������ʵ��������ã���Ȼ��ô���� */
	private Star star;
	// 2.ͨ������������ʵ�Ľ�ɫ��ֵ
	public ProxyStar(Star star) {

		this.star = star;
	}

	@Override
	public void bookTicket() {
		System.out.println("�����Ǵ�����Ķ�Ʊ����");

	}

	@Override
	public void confer() {
		System.out.println("�����Ǵ������confer����");

	}

	@Override
	public void sing() {
		// ��ʵ��ֻ���𳪸裬�����Ķ������˴�����
		star.sing();

	}

	@Override
	public void clloectMoney() {
		System.out.println("�����Ǵ������collectMoney����");

	}

	@Override
	public void signConstract() {
		System.out.println("�����Ǵ������signConstract����");

	}

}
