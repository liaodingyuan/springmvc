/**
 * 
 */
package liaody.jfc;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RectangleInsets;

/**
 * <p>
 * Title:JfreeChart1
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
public class JfreeChart1 {
	public static void main(String[] args) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		// 添加数据
		dataset.addValue(98, "数学", "张三");
		dataset.addValue(68, "数学", "李四");
		dataset.addValue(56, "数学", "王五");
		JFreeChart chart = ChartFactory.createLineChart("用户统计报表（所属单位）", // 主标题的名称
				"所属单位名称", // X轴的标签
				"数量", // Y轴的标签
				dataset, // 图标显示的数据集合
				PlotOrientation.VERTICAL, // 图像的显示形式（水平或者垂直）
				true, // 是否显示子标题
				true, // 是否生成提示的标签
				true); // 是否生成URL链接
		// 处理图形上的乱码 // 处理主标题的乱码
		chart.getTitle().setFont(new Font("宋体", Font.BOLD, 18));
		// 处理子标题乱码
		chart.getLegend().setItemFont(new Font("宋体", Font.BOLD, 15));
		// 获取图表区域对象
		CategoryPlot categoryPlot = (CategoryPlot) chart.getPlot();
		// 设置图像区域的背景色
		categoryPlot.setBackgroundAlpha(0f);

		// 获取X轴的对象
		CategoryAxis categoryAxis = (CategoryAxis) categoryPlot.getDomainAxis();
		// 获取Y轴的对象
		NumberAxis numberAxis = (NumberAxis) categoryPlot.getRangeAxis();
		// 处理X轴上的乱码
		categoryAxis.setTickLabelFont(new Font("宋体", Font.BOLD, 15));
		// 处理X轴外的乱码
		categoryAxis.setLabelFont(new Font("宋体", Font.BOLD, 15));
		// 设置尺度显示
		categoryAxis.setAxisLineVisible(true);
		// 坐标轴标尺是否显示
		categoryAxis.setTickMarksVisible(false); 
		
		// 处理Y轴上的乱码
		numberAxis.setTickLabelFont(new Font("宋体", Font.BOLD, 15));
		numberAxis.setAxisLineVisible(true);
		numberAxis.setTickMarksVisible(false);
		
		// 处理Y轴外的乱码
		numberAxis.setLabelFont(new Font("宋体", Font.BOLD, 15));
		// 处理Y轴上显示的刻度，以10作为1格
		numberAxis.setAutoTickUnitSelection(false);
		NumberTickUnit unit = new NumberTickUnit(10);
		numberAxis.setTickUnit(unit);
		
		// 获取绘图区域对象
		LineAndShapeRenderer lineAndShapeRenderer = (LineAndShapeRenderer) categoryPlot.getRenderer();
		// 在图形上显示数字
		lineAndShapeRenderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		lineAndShapeRenderer.setBaseItemLabelsVisible(true);
		lineAndShapeRenderer.setBaseItemLabelFont(new Font("宋体", Font.BOLD, 15));
		// 在图形上添加转折点（使用小矩形显示）
		Rectangle shape = new Rectangle(10, 10);
		lineAndShapeRenderer.setSeriesShape(0, shape);
		lineAndShapeRenderer.setSeriesShapesVisible(0, true);
		// 在D盘目录下生成图片
		File file = new File("chart1.jpg");
		try {
			ChartUtilities.saveChartAsJPEG(file, chart, 800, 600);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 使用ChartFrame对象显示图像
		ChartFrame frame = new ChartFrame("xyz", chart);
		frame.setVisible(true);
		frame.pack();
	}
}
