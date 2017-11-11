/**
 * 
 */
package liaody.thinkinjava.chart10;

import javax.swing.text.AbstractDocument.Content;

import liaody.thinkinjava.chart10.Parce1.Contents;

/**
 * <p>
 * Title:Prace7
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017��10��29��
 */
public class Prace7 {

	/**
	 * ʹ�������ڲ��ֱࣨ�ӷ���ʵ��ĳ���ӿڵ��ࣩ ��˼�Ǵ���һ���̳У�ʵ����XX������һ���ӿڣ��������ڲ��ࣩ
	 * ���������Ҫһ���������Ĺ������������ڷ����������
	 * 
	 * @param xx
	 * @return
	 */
	public Selector getTmpC(String xx) {
		// ����һ���̳�Selector�ӿڵ����������
		// ͨ��new���ʽ���ص����ñ��Զ�ת��Ϊ��Selector������
		return new Selector() {
			private int ii = 90;

			// �������ܹ���ʹ���������Լ������ӵķ���
			// TODO
			public int value() {
				return ii;
			}

			public String param() {
				return xx;
			}

			@Override
			public boolean end() {
				System.out.println("���ǲ����õ�end����");
				return false;
			}

			@Override
			public Object current() {
				System.out.println("�����ǲ����õ�Current����");
				return null;
			}

			@Override
			public void next() {
				System.out.println("�����ǲ����õ�next����");
			}
		};
	}

	/**
	 * ����Ĳ�������Ҫʹ��final�ؼ��ֽ������Σ���Ϊ����û��ʹ�õ�x��λ�ڲ�����
	 * ����Ĳ���x������Ҫ��һ����final�ģ�ӦΪx���ݸ�������Ļ��๹���������������������ڲ�����
	 * ֱ�ӱ�ʹ�á��������ڲ����б�ʹ�õı���������ʹ��final��ʱ�ģ�JDK1.8�в�Ҫ��
	 * �����ڲ���û�й�������ӦΪ��������û������ѽ�����ǿ���ͨ��ʵ����ʼ���ﵽЧ��
	 * @param x
	 * @return
	 */
	public Wrapping wrapping(String x) {
		return new Wrapping(x) {
		};
	}

	/**
	 * �������һ�������ڲ��࣬����ϣ����ʹ�������ⲿ����Ķ�����ô��������Ҫ�������ʱfinal�� ����������� �ڲ��౻�����ھֲ�ʱ�� 1.
	 * �����Ա���Ա���η����Σ� 2. ����ֱ�ӷ����ⲿ���еĳ�Ա����Ϊ�������ⲿ���е����ã� 3.
	 * ���ǲ����Է��������ھֲ��еı�����ֻ�ܷ��ʱ�final���εľֲ�������
	 * ����֮����ֻ����final���εĲ������Ǳ����������ԭ����Ȼ�����ڲ��౻�����ڷ����ڲ���
	 * �������ڲ����ǵ����ĸ��壬����ʱ���ⲿ��һ�𱻱����ΪOuter$1.class�ļ��������Ƿ���������ʱ�Żᱻִ�С�
	 * �����еľֲ�����ֻ���ڷ���������ʱ��������ջ�ڴ��У�
	 * ������ϻ��Զ����ջ�����ԣ������ڲ���Ҫ��ʹ�÷����ڲ��ı�����ֻ�ܽ��ñ�����final���Σ�������Ϊ������ *
	 * 
	 * ���ǣ������ʹ�õ�JDKΪ1.8�汾������ֲ���������final���Σ�����Ҳ��ͨ�������ҿ����������С�
	 * ����������Ĭ�ϸñ���Ϊfinal���͡���Ҳ�����°汾��һ��bug�ɡ�
	 * 
	 * @param parameter
	 * @return
	 */
	// TODO JDK 1.8
	public DestinationME destination(String parameter) {
		return new DestinationME("justtest") {
			// TODO
			private String param = parameter;

			@Override
			public String value() {
				return param;
			}

		};
	}

	public static void main(String[] args) {
		Prace7 �� = new Prace7();
		Selector selector = ��.getTmpC("");
		selector.current();
		selector.end();
		selector.next();
		DestinationME destinationLocal = ��.destination("�Ƽ���");
		destinationLocal.value();
	}

}
