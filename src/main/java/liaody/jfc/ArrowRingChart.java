/**
 * 
 */
package liaody.jfc;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.RingPlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.RectangleInsets;

/**
 * <p>
 * Title:ArrowRingChart
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017年10月25日
 */
public class ArrowRingChart {
	// 三角形的开始
	static final String ARROW_DIRECTION_L = "1";
	// 三角形的结束
	static final String ARROW_DIRECTION_R = "2";

	Map<String, Color> ChartColor = new HashMap<String, Color>() {
		{
			put("title1", new Color(150, 150, 150));
			put("title2", new Color(200, 200, 200));
		}
	};
	static Map<String, Double> dataList = new HashMap<String, Double>();
	static {
		dataList.put("title1", 40d);
		dataList.put("title2", 60d);
	}

	public void paintLocal(Graphics g) {

		PieDataset dataset = createDataset(dataList);
		JFreeChart jfreechart = ChartFactory.createRingChart("", dataset, false, false, false);
		jfreechart.setBackgroundPaint(null);
		jfreechart.setBackgroundImageAlpha(0.0f);

		// 绘图区的设置
		RingPlot plot = (RingPlot) jfreechart.getPlot();
		// 设置图形为
		plot.setCircular(true);
		// 设置圆环的大小（数值越大有色部分占的比例就越大）
		plot.setSectionDepth(0.1);
		RectangleInsets insets = new RectangleInsets(-36, -35, -35, -35);
		plot.setInsets(insets);
		plot.setBackgroundAlpha(0.0f);
		plot.setBackgroundPaint(null);

		// 设置边缘线
		for (String key : dataList.keySet()) {
			plot.setSectionOutlineStroke(key, new BasicStroke(17.0f));
			plot.setSectionOutlinePaint(key, Color.WHITE);
			plot.setSectionPaint(key, ChartColor.get(key));
		}

		// 设置圆形的扇形区域分割线不可见
		plot.setSeparatorsVisible(false);
		Graphics2D g2 = (Graphics2D) g;
		// 绘制图形
		jfreechart.draw(g2, new Rectangle(0, 0, 800, 800));

		// 设置暗灰色
		g2.setColor(new Color(150, 150, 150));
		// 定义X坐标集，固定的左箭头
		int[][] arrowCoordination = getArrowCoordinate(0d, ARROW_DIRECTION_L);
		// 绘制第一个箭头，固定
		g2.fillPolygon(arrowCoordination[0], arrowCoordination[1], 3);

		// 绘制第二个箭头可变
		arrowCoordination = getArrowCoordinate(dataList.get("title1"), ARROW_DIRECTION_R);
		g2.fillPolygon(arrowCoordination[0], arrowCoordination[1], 3);

		g2.setColor(new Color(200, 200, 200));
		// 绘制第三个箭头可变
		arrowCoordination = getArrowCoordinate(dataList.get("title1"), ARROW_DIRECTION_L);
		g2.fillPolygon(arrowCoordination[0], arrowCoordination[1], 3);

		// 绘制第四个箭头固定
		arrowCoordination = getArrowCoordinate(0d, ARROW_DIRECTION_R);
		g2.fillPolygon(arrowCoordination[0], arrowCoordination[1], 3);

	}

	/**
	 * @param argProportion
	 * @param arrowDirection
	 * @return
	 */
	private int[][] getArrowCoordinate(final double argProportion, final String arrowDirection) {

		// 箭头位置修正角度
		double diffNg = 0d;
		// 图的半径
		final double circleRadius = 202d;
		// 定义箭头的大小
		final double arrowRadius = 7d;
		// 图的中心X坐标
		final double centerX = 401d;
		// 图的中心Y坐标
		final double centerY = 401d;
		// 箭头的开始位置和结束位置的修正
		double adjustmentL = 0d;
		// 绘制三角形的位置（从中心圆角的角度）
		double angle = argProportion * 3.6d - 90;

		// 使箭头翻转180度的修正值
		if (ARROW_DIRECTION_R.equals(arrowDirection)) {
			diffNg = -2.3d;
		} else {
			diffNg = 2.4d;
			adjustmentL = 180d;
		}

		// 计算三角形的位置
		int xCoordinate = (int) (centerX + circleRadius * Math.cos((angle + diffNg) * Math.PI / 180));
		int yCoordinate = (int) (centerY + circleRadius * Math.sin((angle + diffNg) * Math.PI / 180));

		// 具体的坐标值，直接使用者三个值绘画出三角形
		int[][] rtCoordinate = new int[2][3];
		// 第一个坐标点
		rtCoordinate[0][0] = (int) (xCoordinate + arrowRadius * Math.cos((angle + 90d + adjustmentL) * Math.PI / 180));
		rtCoordinate[1][0] = (int) (yCoordinate + arrowRadius * Math.sin((angle + 90d + adjustmentL) * Math.PI / 180));
		// 第二个坐标点
		rtCoordinate[0][1] = (int) (xCoordinate + arrowRadius * Math.cos((angle + 210d + adjustmentL) * Math.PI / 180));
		rtCoordinate[1][1] = (int) (yCoordinate + arrowRadius * Math.sin((angle + 210d + adjustmentL) * Math.PI / 180));

		// 第三个坐标点
		rtCoordinate[0][2] = (int) (xCoordinate + arrowRadius * Math.cos((angle + 330d + adjustmentL) * Math.PI / 180));
		rtCoordinate[1][2] = (int) (yCoordinate + arrowRadius * Math.sin((angle + 330d + adjustmentL) * Math.PI / 180));

		return rtCoordinate;
	}

	/**
	 * 制作饼图用的数据
	 * 
	 * @param dataList
	 * @return
	 */
	private PieDataset createDataset(Map<String, Double> dataList) {
		DefaultPieDataset dataset = new DefaultPieDataset();
		for (String key : dataList.keySet()) {
			dataset.setValue(key, dataList.get(key));
		}
		return dataset;
	}

	public static void main(String[] args) {

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(3);
		frame.setSize(800, 800);
		frame.setBackground(Color.WHITE);
		frame.setContentPane(new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
			public void paint(Graphics g) {
				super.paint(g);
				setBackground(Color.WHITE);
				new ArrowRingChart().paintLocal(g);
			}
		});
		frame.setVisible(true);
	}

}
