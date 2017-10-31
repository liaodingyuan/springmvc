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
 * @date 2017年10月23日
 */
public class LineChart extends ApplicationFrame {

	private static final long serialVersionUID = 1L;

	// 测试的main方法，显示是以JPanel窗体的形式显示的
	public static void main(String[] args) {
		LineChart LineChart = new LineChart("曲线图");
		LineChart.pack();
		RefineryUtilities.centerFrameOnScreen(LineChart);
		LineChart.setVisible(true);
	}

	public LineChart(String s) {
		super(s);
		setContentPane(createDemoLine());
	}

	// 生成显示图表的面板
	public static JPanel createDemoLine() {
		JFreeChart jfreechart = createChart(createDataset());
		return new ChartPanel(jfreechart);
	}

	// 生成图表主对象JFreeChart
	public static JFreeChart createChart(TimeSeriesCollection linedataset) {

		JFreeChart chart = ChartFactory.createTimeSeriesChart("访问量统计时间线", "月份", "访问量", linedataset, true, true, true);
		// 设置消除字体的锯齿渲染(解决中文问题)
		chart.getRenderingHints().put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
		// 设置主标题
		chart.setTitle(new TextTitle("blog访问量统计", new Font("楷书", Font.ITALIC, 20)));
		chart.setAntiAlias(true);
		// 设置子标题
		TextTitle subtitle = new TextTitle("2010/2011年度访问量对比", new Font("宋体", Font.BOLD, 12));
		chart.addSubtitle(subtitle);

		XYPlot plot = (XYPlot) chart.getPlot();
		XYLineAndShapeRenderer xylineandshaperenderer = (XYLineAndShapeRenderer) plot.getRenderer();
		// 设置网格背景颜色
		plot.setBackgroundPaint(Color.white);
		// 设置网格竖线颜色
		// plot.setDomainGridlinePaint(Color.pink);
		// 设置上届线和右届线不显示
		plot.setOutlineVisible(false);

		// 设置网格横线颜色
		plot.setRangeGridlinePaint(Color.pink);
		// 设置曲线与xy轴的距离
		plot.setAxisOffset(new RectangleInsets(0D, 0D, 0D, 10D));
		// 设置曲线是否显示数据点
		xylineandshaperenderer.setBaseShapesVisible(true);
		// 设置曲线显示各项数据点的值
		XYItemRenderer xyitem = plot.getRenderer();
		xyitem.setBaseItemLabelsVisible(true);
		xyitem.setBasePositiveItemLabelPosition(
				new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_LEFT));
		xyitem.setBaseItemLabelGenerator(new StandardXYItemLabelGenerator());
		xyitem.setBaseItemLabelFont(new Font("Dialog", 1, 14));
		plot.setRenderer(xyitem);

		// 设置X轴日期显示的格式
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM");
		DateAxis axis = (DateAxis) plot.getDomainAxis();
		axis.setDateFormatOverride(format);// 设置x轴数据单位以×年×月方式显示

		ValueAxis valueAxis = plot.getDomainAxis();
		// 设置 坐标轴标尺是否显示 (本例中应该要消除掉)
		valueAxis.setTickMarksVisible(false);
		// 设置x轴上面的字体
		valueAxis.setTickLabelFont(new Font("隶书", Font.ITALIC, 12));
		// 设置X轴的标题文字
		valueAxis.setLabelFont(new Font("隶书", Font.ITALIC, 12));

		NumberAxis numberAxis = (NumberAxis) plot.getRangeAxis();
		// 设置 坐标轴标尺是否显示 (本例中应该要消除掉)
		numberAxis.setTickMarksVisible(false);
		// 设置y轴上的字体
		numberAxis.setTickLabelFont(new Font("宋体", Font.PLAIN, 13));
		// 设置y轴上的标题字体
		numberAxis.setLabelFont(new Font("宋体", Font.PLAIN, 13));
		// 设置底部的字体
		chart.getLegend().setItemFont(new Font("宋体", Font.PLAIN, 12));
		return chart;
	}

	// 生成数据
	public static TimeSeriesCollection createDataset() {
		// 访问量统计时间线
		TimeSeries timeSeries1 = new TimeSeries("2010年度", Month.class);
		TimeSeries timeSeries2 = new TimeSeries("2011年度", Month.class);

		// 时间曲线数据集合
		TimeSeriesCollection lineDataset = new TimeSeriesCollection();

		// 构造数据集合
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