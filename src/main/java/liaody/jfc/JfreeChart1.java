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
 * @date 2017��10��22��
 */
public class JfreeChart1 {
	public static void main(String[] args) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		// �������
		dataset.addValue(98, "��ѧ", "����");
		dataset.addValue(68, "��ѧ", "����");
		dataset.addValue(56, "��ѧ", "����");
		JFreeChart chart = ChartFactory.createLineChart("�û�ͳ�Ʊ���������λ��", // �����������
				"������λ����", // X��ı�ǩ
				"����", // Y��ı�ǩ
				dataset, // ͼ����ʾ�����ݼ���
				PlotOrientation.VERTICAL, // ͼ�����ʾ��ʽ��ˮƽ���ߴ�ֱ��
				true, // �Ƿ���ʾ�ӱ���
				true, // �Ƿ�������ʾ�ı�ǩ
				true); // �Ƿ�����URL����
		// ����ͼ���ϵ����� // ���������������
		chart.getTitle().setFont(new Font("����", Font.BOLD, 18));
		// �����ӱ�������
		chart.getLegend().setItemFont(new Font("����", Font.BOLD, 15));
		// ��ȡͼ���������
		CategoryPlot categoryPlot = (CategoryPlot) chart.getPlot();
		// ����ͼ������ı���ɫ
		categoryPlot.setBackgroundAlpha(0f);

		// ��ȡX��Ķ���
		CategoryAxis categoryAxis = (CategoryAxis) categoryPlot.getDomainAxis();
		// ��ȡY��Ķ���
		NumberAxis numberAxis = (NumberAxis) categoryPlot.getRangeAxis();
		// ����X���ϵ�����
		categoryAxis.setTickLabelFont(new Font("����", Font.BOLD, 15));
		// ����X���������
		categoryAxis.setLabelFont(new Font("����", Font.BOLD, 15));
		// ���ó߶���ʾ
		categoryAxis.setAxisLineVisible(true);
		// ���������Ƿ���ʾ
		categoryAxis.setTickMarksVisible(false); 
		
		// ����Y���ϵ�����
		numberAxis.setTickLabelFont(new Font("����", Font.BOLD, 15));
		numberAxis.setAxisLineVisible(true);
		numberAxis.setTickMarksVisible(false);
		
		// ����Y���������
		numberAxis.setLabelFont(new Font("����", Font.BOLD, 15));
		// ����Y������ʾ�Ŀ̶ȣ���10��Ϊ1��
		numberAxis.setAutoTickUnitSelection(false);
		NumberTickUnit unit = new NumberTickUnit(10);
		numberAxis.setTickUnit(unit);
		
		// ��ȡ��ͼ�������
		LineAndShapeRenderer lineAndShapeRenderer = (LineAndShapeRenderer) categoryPlot.getRenderer();
		// ��ͼ������ʾ����
		lineAndShapeRenderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		lineAndShapeRenderer.setBaseItemLabelsVisible(true);
		lineAndShapeRenderer.setBaseItemLabelFont(new Font("����", Font.BOLD, 15));
		// ��ͼ�������ת�۵㣨ʹ��С������ʾ��
		Rectangle shape = new Rectangle(10, 10);
		lineAndShapeRenderer.setSeriesShape(0, shape);
		lineAndShapeRenderer.setSeriesShapesVisible(0, true);
		// ��D��Ŀ¼������ͼƬ
		File file = new File("chart1.jpg");
		try {
			ChartUtilities.saveChartAsJPEG(file, chart, 800, 600);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// ʹ��ChartFrame������ʾͼ��
		ChartFrame frame = new ChartFrame("xyz", chart);
		frame.setVisible(true);
		frame.pack();
	}
}
