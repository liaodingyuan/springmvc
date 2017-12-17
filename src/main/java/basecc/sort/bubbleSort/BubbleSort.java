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
 * @date 2017年12月11日
 */
public class BubbleSort {

	/**
	 * 冒泡排序：从小到大排序 若文件的初始状态是正序的，一趟扫描即可完成排序。 所以，冒泡排序最好的时间复杂度为
	 * O(n)。最坏要两个for循环彻底，时间复杂度为O(n的平方)，所以平均时间复杂度为O(n的平方)
	 * 
	 * 下沉式
	 * 
	 * @param array
	 */
	public static void simpleAscBubbleSort(int[] array) {
		final int arrayLength = array.length;
		if (array == null || 0 == arrayLength)
			return;
		int cmpTimsOuter = 0;
		int cmpTimeInner = 0;
		// 用于交换数据的临时值
		int tmp = 0;
		// 一共要循环列表长度次
		for (int outIndex = 0; outIndex < arrayLength; outIndex++) {
			cmpTimsOuter++;
			// 内循环是一个元素的一趟比较。第一次循环之后，最大的元素会沉到底部。
			for (int innerIndex = 0; innerIndex < arrayLength - 1 - outIndex; innerIndex++) {
				cmpTimeInner++;
				// 如果前面一个数比后面一个数大，就交换它们的位置。
				if (array[innerIndex] > array[innerIndex + 1]) {
					tmp = array[innerIndex + 1];
					array[innerIndex + 1] = array[innerIndex];
					array[innerIndex] = tmp;
				}
			}
		}
		System.out.println("内比较次数：" + cmpTimeInner + " 外循环比较次数：" + cmpTimsOuter + " " + Arrays.toString(array));
	}

	/**
	 * 冒泡排序：从大到小排序 只要看到一个循环嵌套在另一个循环之中，外层循环执行N次，内层循环就执行N次，所以会有N的次方次
	 * 
	 * @param array
	 */
	public static void simpleDescBubbleSort(int[] array) {
		final int arrayLength = array.length;
		if (array == null || 0 == arrayLength)
			return;
		int cmpTime = 0;
		// 用于交换数据的临时值
		int tmp = 0;
		// 一点点微小的改进
		boolean status = true; // 记录是否发生交换信息。如果已经有序，则退出排序算法
		// 一共要循环列表长度次
		for (int outIndex = arrayLength - 1; outIndex > 0 && status; outIndex--) {
			status = false;
			// 内循环是一个元素的一趟比较。第一次循环之后，最小的元素会沉到底部。下标大于outIndex已经排序好了
			for (int innerIndex = 0; innerIndex < outIndex; innerIndex++) {
				// 如果后面一个数比前面一个数大，就交换它们的位置
				if (array[innerIndex] < array[innerIndex + 1]) {
					tmp = array[innerIndex + 1];
					array[innerIndex + 1] = array[innerIndex];
					array[innerIndex] = tmp;
					status = true;
				}
			}
		}
		System.out.println("比较次数：" + cmpTime + " " + Arrays.toString(array));
	}

	/**
	 * 双向冒泡排序
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
