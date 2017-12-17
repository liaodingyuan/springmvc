/**
 * 
 */
package basecc.sort.bubbleSort;

import java.util.Arrays;

/**
 * <p>
 * Title:BubbleSort
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017��12��11��
 */
public class BubbleSort {

	/**
	 * ð�����򣺴�С�������� ���ļ��ĳ�ʼ״̬������ģ�һ��ɨ�輴��������� ���ԣ�ð��������õ�ʱ�临�Ӷ�Ϊ
	 * O(n)���Ҫ����forѭ�����ף�ʱ�临�Ӷ�ΪO(n��ƽ��)������ƽ��ʱ�临�Ӷ�ΪO(n��ƽ��)
	 * 
	 * �³�ʽ
	 * 
	 * @param array
	 */
	public static void simpleAscBubbleSort(int[] array) {
		final int arrayLength = array.length;
		if (array == null || 0 == arrayLength)
			return;
		int cmpTimsOuter = 0;
		int cmpTimeInner = 0;
		// ���ڽ������ݵ���ʱֵ
		int tmp = 0;
		// һ��Ҫѭ���б��ȴ�
		for (int outIndex = 0; outIndex < arrayLength; outIndex++) {
			cmpTimsOuter++;
			// ��ѭ����һ��Ԫ�ص�һ�˱Ƚϡ���һ��ѭ��֮������Ԫ�ػ�����ײ���
			for (int innerIndex = 0; innerIndex < arrayLength - 1 - outIndex; innerIndex++) {
				cmpTimeInner++;
				// ���ǰ��һ�����Ⱥ���һ�����󣬾ͽ������ǵ�λ�á�
				if (array[innerIndex] > array[innerIndex + 1]) {
					tmp = array[innerIndex + 1];
					array[innerIndex + 1] = array[innerIndex];
					array[innerIndex] = tmp;
				}
			}
		}
		System.out.println("�ڱȽϴ�����" + cmpTimeInner + " ��ѭ���Ƚϴ�����" + cmpTimsOuter + " " + Arrays.toString(array));
	}

	/**
	 * ð�����򣺴Ӵ�С���� ֻҪ����һ��ѭ��Ƕ������һ��ѭ��֮�У����ѭ��ִ��N�Σ��ڲ�ѭ����ִ��N�Σ����Ի���N�Ĵη���
	 * 
	 * @param array
	 */
	public static void simpleDescBubbleSort(int[] array) {
		final int arrayLength = array.length;
		if (array == null || 0 == arrayLength)
			return;
		int cmpTime = 0;
		// ���ڽ������ݵ���ʱֵ
		int tmp = 0;
		// һ���΢С�ĸĽ�
		boolean status = true; // ��¼�Ƿ���������Ϣ������Ѿ��������˳������㷨
		// һ��Ҫѭ���б��ȴ�
		for (int outIndex = arrayLength - 1; outIndex > 0 && status; outIndex--) {
			status = false;
			// ��ѭ����һ��Ԫ�ص�һ�˱Ƚϡ���һ��ѭ��֮����С��Ԫ�ػ�����ײ����±����outIndex�Ѿ��������
			for (int innerIndex = 0; innerIndex < outIndex; innerIndex++) {
				// �������һ������ǰ��һ�����󣬾ͽ������ǵ�λ��
				if (array[innerIndex] < array[innerIndex + 1]) {
					tmp = array[innerIndex + 1];
					array[innerIndex + 1] = array[innerIndex];
					array[innerIndex] = tmp;
					status = true;
				}
			}
		}
		System.out.println("�Ƚϴ�����" + cmpTime + " " + Arrays.toString(array));
	}

	/**
	 * ˫��ð������
	 * 
	 * @param array
	 */
	public static void simpleBubbleSort(int[] array) {

	}

	public static void main(String[] args) {

		int[] array = { 1, 6, 3, 2, 0, 4, 3, 25, 4, 78, 3, 45, 12, 9, 7, 6, 90, 33, 55, 3, 0, -6 };
		simpleAscBubbleSort(array);
		simpleDescBubbleSort(array);

	}
}
