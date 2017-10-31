/**
 * 
 */
package liaody.jfc;

import java.awt.Color;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.DateTickMarkPosition;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.RectangleInsets;

/**
 * <p>
 * Title:XYLine
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017��10��28��
 */
public class XYLine {
	private void createXYLine() {
		XYSplineRenderer renderer = new XYSplineRenderer();
		renderer.setBaseShapesVisible(false); // ���Ƶ������ϲ���ʾͼ���������ʾ�Ļ�����ʹͼƬ��úܳ�ª
		renderer.setSeriesPaint(0, Color.GREEN); // ����0�����ݵ���ɫ�������ֹ�����������ɫ�ķ���
		renderer.setPrecision(5); // ���þ��ȣ������˼����Դ����������֮�����5��������ϳ�һ��ƽ������

		// create plot
		NumberAxis xAxis = new NumberAxis("Time(ns)");
		xAxis.setAutoRangeIncludesZero(false);
		NumberAxis yAxis = new NumberAxis("Voltage(mv)");
		yAxis.setAutoRangeIncludesZero(false);

		XYPlot plot = new XYPlot(createDataset("D:/V.dat"), xAxis, yAxis, renderer);
		plot.setBackgroundPaint(Color.black);
		plot.setDomainGridlinePaint(Color.white);
		plot.setRangeGridlinePaint(Color.white);
		plot.setAxisOffset(new RectangleInsets(4, 4, 4, 4)); // �������������ͼ����ľ���

		JFreeChart chart = new JFreeChart("ϸ����ѹͼ", // ����
				JFreeChart.DEFAULT_TITLE_FONT, // ��������壬�����Ϳ��Խ���������������
				plot, false // ����ͼƬ�ײ���ʾͼ��
		);

		// ����X�����ʾ��ʽ
		XYPlot xyplot = chart.getXYPlot();
		xyplot.setForegroundAlpha(0.5f);
		XYItemRenderer renderer1 = xyplot.getRenderer();
		renderer1.setToolTipGenerator(new StandardXYToolTipGenerator(StandardXYToolTipGenerator.DEFAULT_TOOL_TIP_FORMAT,
				new SimpleDateFormat("yyyy-MM"), new DecimalFormat("0 ")));
		DateAxis dateAxis = new DateAxis("ʱ�� ");
		dateAxis.setDateFormatOverride(new SimpleDateFormat("yyyy-MM "));
		dateAxis.setAutoRange(true);
		dateAxis.setTickMarkPosition(DateTickMarkPosition.MIDDLE);
		xyplot.setDomainAxis(dateAxis);

		// ChartUtilities.writeChartAsPNG(response.getOutputStream(), chart, 1024, 768,
		// null);
	}

	/**
	 * @param string
	 * @return
	 */
	private XYDataset createDataset(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {

	}
}
