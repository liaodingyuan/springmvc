/**
 * 
 */
package liaody.jfc;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.ui.RectangleInsets;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.*;
import org.jfree.ui.*;
import java.awt.*;
import java.text.*;
import javax.swing.JPanel;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.axis.NumberAxis;

/**
 * <p>
 * Title:LineChart
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017��10��23��
 */
public class LineChart extends ApplicationFrame {

	private static final long serialVersionUID = 1L;

	// ���Ե�main��������ʾ����JPanel�������ʽ��ʾ��
	public static void main(String[] args) {
		LineChart LineChart = new LineChart("����ͼ");
		LineChart.pack();
		RefineryUtilities.centerFrameOnScreen(LineChart);
		LineChart.setVisible(true);
	}

	public LineChart(String s) {
		super(s);
		setContentPane(createDemoLine());
	}

	// ������ʾͼ������
	public static JPanel createDemoLine() {
		JFreeChart jfreechart = createChart(createDataset());
		return new ChartPanel(jfreechart);
	}

	// ����ͼ��������JFreeChart
	public static JFreeChart createChart(TimeSeriesCollection linedataset) {

		JFreeChart chart = ChartFactory.createTimeSeriesChart("������ͳ��ʱ����", "�·�", "������", linedataset, true, true, true);
		// ������������ľ����Ⱦ(�����������)
		chart.getRenderingHints().put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
		// ����������
		chart.setTitle(new TextTitle("blog������ͳ��", new Font("����", Font.ITALIC, 20)));
		chart.setAntiAlias(true);
		// �����ӱ���
		TextTitle subtitle = new TextTitle("2010/2011��ȷ������Ա�", new Font("����", Font.BOLD, 12));
		chart.addSubtitle(subtitle);

		XYPlot plot = (XYPlot) chart.getPlot();
		XYLineAndShapeRenderer xylineandshaperenderer = (XYLineAndShapeRenderer) plot.getRenderer();
		// �������񱳾���ɫ
		plot.setBackgroundPaint(Color.white);
		// ��������������ɫ
		// plot.setDomainGridlinePaint(Color.pink);
		// �����Ͻ��ߺ��ҽ��߲���ʾ
		plot.setOutlineVisible(false);

		// �������������ɫ
		plot.setRangeGridlinePaint(Color.pink);
		// ����������xy��ľ���
		plot.setAxisOffset(new RectangleInsets(0D, 0D, 0D, 10D));
		// ���������Ƿ���ʾ���ݵ�
		xylineandshaperenderer.setBaseShapesVisible(true);
		// ����������ʾ�������ݵ��ֵ
		XYItemRenderer xyitem = plot.getRenderer();
		xyitem.setBaseItemLabelsVisible(true);
		xyitem.setBasePositiveItemLabelPosition(
				new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_LEFT));
		xyitem.setBaseItemLabelGenerator(new StandardXYItemLabelGenerator());
		xyitem.setBaseItemLabelFont(new Font("Dialog", 1, 14));
		plot.setRenderer(xyitem);

		// ����X��������ʾ�ĸ�ʽ
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM");
		DateAxis axis = (DateAxis) plot.getDomainAxis();
		axis.setDateFormatOverride(format);// ����x�����ݵ�λ�ԡ�����·�ʽ��ʾ

		ValueAxis valueAxis = plot.getDomainAxis();
		// ���� ���������Ƿ���ʾ (������Ӧ��Ҫ������)
		valueAxis.setTickMarksVisible(false);
		// ����x�����������
		valueAxis.setTickLabelFont(new Font("����", Font.ITALIC, 12));
		// ����X��ı�������
		valueAxis.setLabelFont(new Font("����", Font.ITALIC, 12));

		NumberAxis numberAxis = (NumberAxis) plot.getRangeAxis();
		// ���� ���������Ƿ���ʾ (������Ӧ��Ҫ������)
		numberAxis.setTickMarksVisible(false);
		// ����y���ϵ�����
		numberAxis.setTickLabelFont(new Font("����", Font.PLAIN, 13));
		// ����y���ϵı�������
		numberAxis.setLabelFont(new Font("����", Font.PLAIN, 13));
		// ���õײ�������
		chart.getLegend().setItemFont(new Font("����", Font.PLAIN, 12));
		return chart;
	}

	// ��������
	public static TimeSeriesCollection createDataset() {
		// ������ͳ��ʱ����
		TimeSeries timeSeries1 = new TimeSeries("2010���", Month.class);
		TimeSeries timeSeries2 = new TimeSeries("2011���", Month.class);

		// ʱ���������ݼ���
		TimeSeriesCollection lineDataset = new TimeSeriesCollection();

		// �������ݼ���
		timeSeries1.add(new Month(1, 2011), 7200);
		timeSeries1.add(new Month(2, 2011), 7000);
		timeSeries1.add(new Month(3, 2011), 4200);
		timeSeries1.add(new Month(4, 2011), 8200);
		timeSeries1.add(new Month(5, 2011), 7300);
		timeSeries1.add(new Month(6, 2011), 8200);
		timeSeries1.add(new Month(7, 2011), 9200);
		timeSeries1.add(new Month(8, 2011), 7300);
		timeSeries1.add(new Month(9, 2011), 9400);
		timeSeries1.add(new Month(10, 2011), 7500);
		timeSeries1.add(new Month(11, 2011), 6600);
		timeSeries1.add(new Month(12, 2011), 3500);
		timeSeries2.add(new Month(1, 2011), 10200);
		timeSeries2.add(new Month(2, 2011), 9000);
		timeSeries2.add(new Month(3, 2011), 6200);
		timeSeries2.add(new Month(4, 2011), 8200);
		timeSeries2.add(new Month(5, 2011), 8200);
		timeSeries2.add(new Month(6, 2011), 11200);
		timeSeries2.add(new Month(7, 2011), 13200);
		timeSeries2.add(new Month(8, 2011), 8300);
		timeSeries2.add(new Month(9, 2011), 10400);
		timeSeries2.add(new Month(10, 2011), 12500);
		timeSeries2.add(new Month(11, 2011), 10600);
		timeSeries2.add(new Month(12, 2011), 10500);

		lineDataset.addSeries(timeSeries1);
		lineDataset.addSeries(timeSeries2);

		return lineDataset;
	}

}