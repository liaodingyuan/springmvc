/**
 * 
 */
package liaody.jfc;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.jboss.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.data.time.Minute;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.RectangleInsets;

/**
 * <p>
 * Title:CreateChart
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017年10月22日
 */
public class CreateChart {
	// 日志记录
	private static Logger logger = Logger.getLogger(CreateChart.class);

	// 备用颜色
	private static final Color color1 = new Color(127, 127, 127);
	private static final Color color2 = new Color(136, 0, 21);
	private static final Color color3 = new Color(237, 28, 36);
	private static final Color color4 = new Color(255, 127, 39);
	private static final Color color5 = new Color(255, 242, 0);
	private static final Color color6 = new Color(34, 177, 76);

	/**
     * 图片生成
     */
    public boolean createChart() {
        try {
            // 解决中文乱码问题 -- begin
            StandardChartTheme standardChartTheme = new StandardChartTheme("CN");// 创建主题样式
            standardChartTheme.setExtraLargeFont(new Font("黑体", Font.BOLD, 20));// 设置标题字体
            standardChartTheme.setRegularFont(new Font("黑体", Font.PLAIN, 15));// 设置图例的字体
            standardChartTheme.setLargeFont(new Font("黑体", Font.PLAIN, 15));// 设置(时间)轴向的字体
            ChartFactory.setChartTheme(standardChartTheme);// 应用主题样式
            // 解决中文乱码问题 -- end

            String title = "jfreeChart数据曲线图";// 标题名称

            Map<String, XYDataset> map = createDataset(); // 生成需要格式的数据集

            JFreeChart jfreechart = ChartFactory.createTimeSeriesChart( // 创建chart对象
                    title, // 图标标题
                    null, // 横轴标题
                    null, // 纵轴标题
                    null, // 数据集
                    true, // 是否显示图例标识
                    true, // 是否显示toolTips
                    false // 是否支持超链接
                    );
            jfreechart.setBackgroundPaint(Color.white); // 设置画布背景色

            // 获取绘图区对象
            XYPlot plot = (XYPlot) jfreechart.getPlot();

            // 给绘图区对象设置属性
            plot.setOrientation(PlotOrientation.VERTICAL); // 数据区的方向
            plot.setBackgroundPaint(Color.lightGray); // 背景色
            plot.setDomainGridlinePaint(Color.white); // 分类轴网格线条颜色
            plot.setRangeGridlinePaint(Color.white); // 数据轴网格线条颜色
            plot.setAxisOffset(new RectangleInsets(5D, 5D, 5D, 5D)); // 坐标轴到数据区的间距
            plot.getRangeAxis().setFixedDimension(40D); // 坐标轴距左边距离

            // 设置轴1--数据匹配
            NumberAxis axis0 = new NumberAxis("多轴-轴1");
            axis0.setLabelFont(new Font("黑体", Font.PLAIN, 12));// y轴字体
            plot.setRangeAxis(0, axis0);
            plot.setDataset(0, map.get("dataSet1"));
            plot.mapDatasetToRangeAxis(0, 0);

            // 设置轴2--数据匹配
            NumberAxis axis1 = new NumberAxis("多轴-轴2");
            axis1.setLabelFont(new Font("黑体", Font.PLAIN, 12));// y轴字体
            plot.setRangeAxis(1, axis1);
            plot.setDataset(1, map.get("dataSet2"));
            plot.mapDatasetToRangeAxis(1, 1);

            // 设置轴3--数据匹配
            NumberAxis axis2 = new NumberAxis("多轴-轴3");
            axis2.setLabelFont(new Font("黑体", Font.PLAIN, 12));// y轴字体
            plot.setRangeAxis(2, axis2);
            plot.setDataset(2, map.get("dataSet3"));
            plot.mapDatasetToRangeAxis(2, 2);

            // 坐标轴1--曲线颜色
            StandardXYItemRenderer renderer0 = new StandardXYItemRenderer();
            renderer0.setSeriesPaint(0, color1);
            renderer0.setLegendTextPaint(0, color1);// 设置对应图例字体颜色

            renderer0.setSeriesPaint(1, color2);
            renderer0.setLegendTextPaint(1, color2);// 设置对应图例字体颜色

            plot.setRenderer(0, renderer0);

            // 坐标轴2--曲线颜色
            StandardXYItemRenderer renderer1 = new StandardXYItemRenderer();
            renderer1.setSeriesPaint(0, color3);
            renderer1.setLegendTextPaint(0, color3);// 设置对应图例字体颜色

            renderer1.setSeriesPaint(1, color4);
            renderer1.setLegendTextPaint(1, color4);// 设置对应图例字体颜色

            plot.setRenderer(1, renderer1);

            // 坐标轴3--曲线颜色
            StandardXYItemRenderer renderer2 = new StandardXYItemRenderer();
            renderer2.setSeriesPaint(0, color5);
            renderer2.setLegendTextPaint(0, color5);// 设置对应图例字体颜色

            renderer2.setSeriesPaint(1, color6);
            renderer2.setLegendTextPaint(1, color6);// 设置对应图例字体颜色

            plot.setRenderer(2, renderer2);

            // 3. 保存chart图标
            String filePath = "D:\\Chart";// 图片保存地址
            String fileName = "testJFreeChart";
            File fos_jpg = new File(filePath + "/" + fileName + ".jpg "); // 需要保存到的文件地址和名称
            if (!fos_jpg.getParentFile().exists()) {
                fos_jpg.getParentFile().mkdirs();
            }
            ChartUtilities.saveChartAsJPEG( //
                    fos_jpg, // 需要保存到的文件对象
                    jfreechart, // 统计图表对象
                    1000, // 宽
                    800// 高
                    );
            logger.info("绘图完成！");
        } catch (Exception e) {
            logger.error(e);
        }
        return true;
    }

	@SuppressWarnings("deprecation")
	private Map<String, XYDataset> createDataset() {
		// 定义返回结果集
		Map<String, XYDataset> map = new HashMap<String, XYDataset>();

		// 轴1数据
		TimeSeries axis0_data1 = new TimeSeries("axis0_data1", org.jfree.data.time.Minute.class);
		TimeSeries axis0_data2 = new TimeSeries("axis0_data2", org.jfree.data.time.Minute.class);
		// 轴2数据
		TimeSeries axis1_data1 = new TimeSeries("axis1_data1", org.jfree.data.time.Minute.class);
		TimeSeries axis1_data2 = new TimeSeries("axis1_data2", org.jfree.data.time.Minute.class);
		// 轴3数据
		TimeSeries axis2_data1 = new TimeSeries("axis2_data1", org.jfree.data.time.Minute.class);
		TimeSeries axis2_data2 = new TimeSeries("axis2_data2", org.jfree.data.time.Minute.class);

		for (int i = 0; i < 168; i++) {
			// 轴1数据
			axis0_data1.add(new Minute(getDate(i)), Math.random() * 10 + 30);
			axis0_data2.add(new Minute(getDate(i)), Math.random() * 10 + 30);
			// 轴2数据
			axis1_data1.add(new Minute(getDate(i)), Math.random() * 100 + 200);
			axis1_data2.add(new Minute(getDate(i)), Math.random() * 100 + 200);
			// 轴3数据
			axis2_data1.add(new Minute(getDate(i)), Math.random() * 1000 + 1000);
			axis2_data2.add(new Minute(getDate(i)), Math.random() * 1000 + 1000);
		}
		TimeSeriesCollection dataSet1 = new TimeSeriesCollection();
		TimeSeriesCollection dataSet2 = new TimeSeriesCollection();
		TimeSeriesCollection dataSet3 = new TimeSeriesCollection();
		// 轴1数据
		dataSet1.addSeries(axis0_data1);
		// dataSet1.addSeries(axis0_data2);
		// 轴2数据
		dataSet2.addSeries(axis1_data1);
		// dataSet2.addSeries(axis1_data2);
		// 轴3数据
		dataSet3.addSeries(axis2_data1);
		// dataSet3.addSeries(axis2_data2);

		map.put("dataSet1", dataSet1);
		map.put("dataSet2", dataSet2);
		map.put("dataSet3", dataSet3);

		return map;
	}

	/**
	 * 模拟时间
	 */
	public Date getDate(int i) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MINUTE, -i);
		return calendar.getTime();
	}

	/**
	 * test Main
	 */
	public static void main(String[] args) {
		new CreateChart().createChart();
	}
}
