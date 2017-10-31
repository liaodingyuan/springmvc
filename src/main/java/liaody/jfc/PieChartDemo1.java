/**
 * 
 */
package liaody.jfc;

import java.awt.Font;
import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis3D;
import org.jfree.chart.axis.NumberAxis3D;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * <p>
 * Title:PieChartDemo1
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
public class PieChartDemo1 {

	public static void main(String[] agrs) {
		// 添加数据集
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(110, "数学", "张三");
		dataset.addValue(87, "语文", "张三");
		dataset.addValue(68, "数学", "李四");
		dataset.addValue(89, "语文", "李四");
		dataset.addValue(56, "数学", "王五");
		dataset.addValue(96, "语文", "王五");

		JFreeChart chart = ChartFactory.createBarChart3D("成绩统计表", "学生姓名", // X轴的标签
				"分数", // Y轴的标签
				dataset, // 图标显示的数据集合
				PlotOrientation.VERTICAL, // 图像的显示形式（水平或者垂直）
				true, // 是否显示子标题
				true, // 是否生成提示的标签
				true); // 是否生成URL链接
		// 处理图形上的乱码
		// 处理主标题的乱码
		chart.getTitle().setFont(new Font("宋体", Font.BOLD, 18));
		// 处理子标题乱码
		chart.getLegend().setItemFont(new Font("宋体", Font.BOLD, 15));
		// 获取图表区域对象
		CategoryPlot categoryPlot = (CategoryPlot) chart.getPlot();
		// 获取X轴的对象
		CategoryAxis3D categoryAxis3D = (CategoryAxis3D) categoryPlot.getDomainAxis();
		// 获取Y轴的对象
		NumberAxis3D numberAxis3D = (NumberAxis3D) categoryPlot.getRangeAxis();
		// 处理X轴上的乱码
		categoryAxis3D.setTickLabelFont(new Font("宋体", Font.BOLD, 15));
		// 处理X轴外的乱码
		categoryAxis3D.setLabelFont(new Font("宋体", Font.BOLD, 15));
		// 处理Y轴上的乱码
		numberAxis3D.setTickLabelFont(new Font("宋体", Font.BOLD, 15));
		// 处理Y轴外的乱码
		numberAxis3D.setLabelFont(new Font("宋体", Font.BOLD, 15));
		// 处理Y轴上显示的刻度，以10作为1格，图形的纵坐标会自动计算出最大值。比如间隔的刻度是10，那么传入的最大数据
		// 是103的话，纵坐标最大高度是110
		numberAxis3D.setAutoTickUnitSelection(false);
		NumberTickUnit unit = new NumberTickUnit(10);
		numberAxis3D.setTickUnit(unit);
		// 获取绘图区域对象
		BarRenderer3D barRenderer3D = (BarRenderer3D) categoryPlot.getRenderer();
		// 设置柱形图的宽度
		barRenderer3D.setMaximumBarWidth(0.07);
		// 在图形上显示数字
		barRenderer3D.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		barRenderer3D.setBaseItemLabelsVisible(true);
		barRenderer3D.setBaseItemLabelFont(new Font("宋体", Font.BOLD, 15));

		// 在D盘目录下生成图片
		File file = new File("chart.jpeg");
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
