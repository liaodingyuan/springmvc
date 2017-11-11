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
 * @date 2017��10��25��
 */
public class ArrowRingChart {
	// �����εĿ�ʼ
	static final String ARROW_DIRECTION_L = "1";
	// �����εĽ���
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

		// ��ͼ��������
		RingPlot plot = (RingPlot) jfreechart.getPlot();
		// ����ͼ��Ϊ
		plot.setCircular(true);
		// ����Բ���Ĵ�С����ֵԽ����ɫ����ռ�ı�����Խ��
		plot.setSectionDepth(0.1);
		RectangleInsets insets = new RectangleInsets(-36, -35, -35, -35);
		plot.setInsets(insets);
		plot.setBackgroundAlpha(0.0f);
		plot.setBackgroundPaint(null);

		// ���ñ�Ե��
		for (String key : dataList.keySet()) {
			plot.setSectionOutlineStroke(key, new BasicStroke(17.0f));
			plot.setSectionOutlinePaint(key, Color.WHITE);
			plot.setSectionPaint(key, ChartColor.get(key));
		}

		// ����Բ�ε���������ָ��߲��ɼ�
		plot.setSeparatorsVisible(false);
		Graphics2D g2 = (Graphics2D) g;
		// ����ͼ��
		jfreechart.draw(g2, new Rectangle(0, 0, 800, 800));

		// ���ð���ɫ
		g2.setColor(new Color(150, 150, 150));
		// ����X���꼯���̶������ͷ
		int[][] arrowCoordination = getArrowCoordinate(0d, ARROW_DIRECTION_L);
		// ���Ƶ�һ����ͷ���̶�
		g2.fillPolygon(arrowCoordination[0], arrowCoordination[1], 3);

		// ���Ƶڶ�����ͷ�ɱ�
		arrowCoordination = getArrowCoordinate(dataList.get("title1"), ARROW_DIRECTION_R);
		g2.fillPolygon(arrowCoordination[0], arrowCoordination[1], 3);

		g2.setColor(new Color(200, 200, 200));
		// ���Ƶ�������ͷ�ɱ�
		arrowCoordination = getArrowCoordinate(dataList.get("title1"), ARROW_DIRECTION_L);
		g2.fillPolygon(arrowCoordination[0], arrowCoordination[1], 3);

		// ���Ƶ��ĸ���ͷ�̶�
		arrowCoordination = getArrowCoordinate(0d, ARROW_DIRECTION_R);
		g2.fillPolygon(arrowCoordination[0], arrowCoordination[1], 3);

	}

	/**
	 * @param argProportion
	 * @param arrowDirection
	 * @return
	 */
	private int[][] getArrowCoordinate(final double argProportion, final String arrowDirection) {

		// ��ͷλ�������Ƕ�
		double diffNg = 0d;
		// ͼ�İ뾶
		final double circleRadius = 202d;
		// �����ͷ�Ĵ�С
		final double arrowRadius = 7d;
		// ͼ������X����
		final double centerX = 401d;
		// ͼ������Y����
		final double centerY = 401d;
		// ��ͷ�Ŀ�ʼλ�úͽ���λ�õ�����
		double adjustmentL = 0d;
		// ���������ε�λ�ã�������Բ�ǵĽǶȣ�
		double angle = argProportion * 3.6d - 90;

		// ʹ��ͷ��ת180�ȵ�����ֵ
		if (ARROW_DIRECTION_R.equals(arrowDirection)) {
			diffNg = -2.3d;
		} else {
			diffNg = 2.4d;
			adjustmentL = 180d;
		}

		// ���������ε�λ��
		int xCoordinate = (int) (centerX + circleRadius * Math.cos((angle + diffNg) * Math.PI / 180));
		int yCoordinate = (int) (centerY + circleRadius * Math.sin((angle + diffNg) * Math.PI / 180));

		// ���������ֵ��ֱ��ʹ��������ֵ�滭��������
		int[][] rtCoordinate = new int[2][3];
		// ��һ�������
		rtCoordinate[0][0] = (int) (xCoordinate + arrowRadius * Math.cos((angle + 90d + adjustmentL) * Math.PI / 180));
		rtCoordinate[1][0] = (int) (yCoordinate + arrowRadius * Math.sin((angle + 90d + adjustmentL) * Math.PI / 180));
		// �ڶ��������
		rtCoordinate[0][1] = (int) (xCoordinate + arrowRadius * Math.cos((angle + 210d + adjustmentL) * Math.PI / 180));
		rtCoordinate[1][1] = (int) (yCoordinate + arrowRadius * Math.sin((angle + 210d + adjustmentL) * Math.PI / 180));

		// �����������
		rtCoordinate[0][2] = (int) (xCoordinate + arrowRadius * Math.cos((angle + 330d + adjustmentL) * Math.PI / 180));
		rtCoordinate[1][2] = (int) (yCoordinate + arrowRadius * Math.sin((angle + 330d + adjustmentL) * Math.PI / 180));

		return rtCoordinate;
	}

	/**
	 * ������ͼ�õ�����
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
