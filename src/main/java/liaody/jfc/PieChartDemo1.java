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
 * @date 2017��10��22��
 */
public class PieChartDemo1 {

	public static void main(String[] agrs) {
		// ������ݼ�
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(110, "��ѧ", "����");
		dataset.addValue(87, "����", "����");
		dataset.addValue(68, "��ѧ", "����");
		dataset.addValue(89, "����", "����");
		dataset.addValue(56, "��ѧ", "����");
		dataset.addValue(96, "����", "����");

		JFreeChart chart = ChartFactory.createBarChart3D("�ɼ�ͳ�Ʊ�", "ѧ������", // X��ı�ǩ
				"����", // Y��ı�ǩ
				dataset, // ͼ����ʾ�����ݼ���
				PlotOrientation.VERTICAL, // ͼ�����ʾ��ʽ��ˮƽ���ߴ�ֱ��
				true, // �Ƿ���ʾ�ӱ���
				true, // �Ƿ�������ʾ�ı�ǩ
				true); // �Ƿ�����URL����
		// ����ͼ���ϵ�����
		// ���������������
		chart.getTitle().setFont(new Font("����", Font.BOLD, 18));
		// �����ӱ�������
		chart.getLegend().setItemFont(new Font("����", Font.BOLD, 15));
		// ��ȡͼ���������
		CategoryPlot categoryPlot = (CategoryPlot) chart.getPlot();
		// ��ȡX��Ķ���
		CategoryAxis3D categoryAxis3D = (CategoryAxis3D) categoryPlot.getDomainAxis();
		// ��ȡY��Ķ���
		NumberAxis3D numberAxis3D = (NumberAxis3D) categoryPlot.getRangeAxis();
		// ����X���ϵ�����
		categoryAxis3D.setTickLabelFont(new Font("����", Font.BOLD, 15));
		// ����X���������
		categoryAxis3D.setLabelFont(new Font("����", Font.BOLD, 15));
		// ����Y���ϵ�����
		numberAxis3D.setTickLabelFont(new Font("����", Font.BOLD, 15));
		// ����Y���������
		numberAxis3D.setLabelFont(new Font("����", Font.BOLD, 15));
		// ����Y������ʾ�Ŀ̶ȣ���10��Ϊ1��ͼ�ε���������Զ���������ֵ���������Ŀ̶���10����ô������������
		// ��103�Ļ������������߶���110
		numberAxis3D.setAutoTickUnitSelection(false);
		NumberTickUnit unit = new NumberTickUnit(10);
		numberAxis3D.setTickUnit(unit);
		// ��ȡ��ͼ�������
		BarRenderer3D barRenderer3D = (BarRenderer3D) categoryPlot.getRenderer();
		// ��������ͼ�Ŀ��
		barRenderer3D.setMaximumBarWidth(0.07);
		// ��ͼ������ʾ����
		barRenderer3D.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		barRenderer3D.setBaseItemLabelsVisible(true);
		barRenderer3D.setBaseItemLabelFont(new Font("����", Font.BOLD, 15));

		// ��D��Ŀ¼������ͼƬ
		File file = new File("chart.jpeg");
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
