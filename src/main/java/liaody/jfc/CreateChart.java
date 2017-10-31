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
 * @date 2017��10��22��
 */
public class CreateChart {
	// ��־��¼
	private static Logger logger = Logger.getLogger(CreateChart.class);

	// ������ɫ
	private static final Color color1 = new Color(127, 127, 127);
	private static final Color color2 = new Color(136, 0, 21);
	private static final Color color3 = new Color(237, 28, 36);
	private static final Color color4 = new Color(255, 127, 39);
	private static final Color color5 = new Color(255, 242, 0);
	private static final Color color6 = new Color(34, 177, 76);

	/**
     * ͼƬ����
     */
    public boolean createChart() {
        try {
            // ��������������� -- begin
            StandardChartTheme standardChartTheme = new StandardChartTheme("CN");// ����������ʽ
            standardChartTheme.setExtraLargeFont(new Font("����", Font.BOLD, 20));// ���ñ�������
            standardChartTheme.setRegularFont(new Font("����", Font.PLAIN, 15));// ����ͼ��������
            standardChartTheme.setLargeFont(new Font("����", Font.PLAIN, 15));// ����(ʱ��)���������
            ChartFactory.setChartTheme(standardChartTheme);// Ӧ��������ʽ
            // ��������������� -- end

            String title = "jfreeChart��������ͼ";// ��������

            Map<String, XYDataset> map = createDataset(); // ������Ҫ��ʽ�����ݼ�

            JFreeChart jfreechart = ChartFactory.createTimeSeriesChart( // ����chart����
                    title, // ͼ�����
                    null, // �������
                    null, // �������
                    null, // ���ݼ�
                    true, // �Ƿ���ʾͼ����ʶ
                    true, // �Ƿ���ʾtoolTips
                    false // �Ƿ�֧�ֳ�����
                    );
            jfreechart.setBackgroundPaint(Color.white); // ���û�������ɫ

            // ��ȡ��ͼ������
            XYPlot plot = (XYPlot) jfreechart.getPlot();

            // ����ͼ��������������
            plot.setOrientation(PlotOrientation.VERTICAL); // �������ķ���
            plot.setBackgroundPaint(Color.lightGray); // ����ɫ
            plot.setDomainGridlinePaint(Color.white); // ����������������ɫ
            plot.setRangeGridlinePaint(Color.white); // ����������������ɫ
            plot.setAxisOffset(new RectangleInsets(5D, 5D, 5D, 5D)); // �����ᵽ�������ļ��
            plot.getRangeAxis().setFixedDimension(40D); // ���������߾���

            // ������1--����ƥ��
            NumberAxis axis0 = new NumberAxis("����-��1");
            axis0.setLabelFont(new Font("����", Font.PLAIN, 12));// y������
            plot.setRangeAxis(0, axis0);
            plot.setDataset(0, map.get("dataSet1"));
            plot.mapDatasetToRangeAxis(0, 0);

            // ������2--����ƥ��
            NumberAxis axis1 = new NumberAxis("����-��2");
            axis1.setLabelFont(new Font("����", Font.PLAIN, 12));// y������
            plot.setRangeAxis(1, axis1);
            plot.setDataset(1, map.get("dataSet2"));
            plot.mapDatasetToRangeAxis(1, 1);

            // ������3--����ƥ��
            NumberAxis axis2 = new NumberAxis("����-��3");
            axis2.setLabelFont(new Font("����", Font.PLAIN, 12));// y������
            plot.setRangeAxis(2, axis2);
            plot.setDataset(2, map.get("dataSet3"));
            plot.mapDatasetToRangeAxis(2, 2);

            // ������1--������ɫ
            StandardXYItemRenderer renderer0 = new StandardXYItemRenderer();
            renderer0.setSeriesPaint(0, color1);
            renderer0.setLegendTextPaint(0, color1);// ���ö�Ӧͼ��������ɫ

            renderer0.setSeriesPaint(1, color2);
            renderer0.setLegendTextPaint(1, color2);// ���ö�Ӧͼ��������ɫ

            plot.setRenderer(0, renderer0);

            // ������2--������ɫ
            StandardXYItemRenderer renderer1 = new StandardXYItemRenderer();
            renderer1.setSeriesPaint(0, color3);
            renderer1.setLegendTextPaint(0, color3);// ���ö�Ӧͼ��������ɫ

            renderer1.setSeriesPaint(1, color4);
            renderer1.setLegendTextPaint(1, color4);// ���ö�Ӧͼ��������ɫ

            plot.setRenderer(1, renderer1);

            // ������3--������ɫ
            StandardXYItemRenderer renderer2 = new StandardXYItemRenderer();
            renderer2.setSeriesPaint(0, color5);
            renderer2.setLegendTextPaint(0, color5);// ���ö�Ӧͼ��������ɫ

            renderer2.setSeriesPaint(1, color6);
            renderer2.setLegendTextPaint(1, color6);// ���ö�Ӧͼ��������ɫ

            plot.setRenderer(2, renderer2);

            // 3. ����chartͼ��
            String filePath = "D:\\Chart";// ͼƬ�����ַ
            String fileName = "testJFreeChart";
            File fos_jpg = new File(filePath + "/" + fileName + ".jpg "); // ��Ҫ���浽���ļ���ַ������
            if (!fos_jpg.getParentFile().exists()) {
                fos_jpg.getParentFile().mkdirs();
            }
            ChartUtilities.saveChartAsJPEG( //
                    fos_jpg, // ��Ҫ���浽���ļ�����
                    jfreechart, // ͳ��ͼ�����
                    1000, // ��
                    800// ��
                    );
            logger.info("��ͼ��ɣ�");
        } catch (Exception e) {
            logger.error(e);
        }
        return true;
    }

	@SuppressWarnings("deprecation")
	private Map<String, XYDataset> createDataset() {
		// ���巵�ؽ����
		Map<String, XYDataset> map = new HashMap<String, XYDataset>();

		// ��1����
		TimeSeries axis0_data1 = new TimeSeries("axis0_data1", org.jfree.data.time.Minute.class);
		TimeSeries axis0_data2 = new TimeSeries("axis0_data2", org.jfree.data.time.Minute.class);
		// ��2����
		TimeSeries axis1_data1 = new TimeSeries("axis1_data1", org.jfree.data.time.Minute.class);
		TimeSeries axis1_data2 = new TimeSeries("axis1_data2", org.jfree.data.time.Minute.class);
		// ��3����
		TimeSeries axis2_data1 = new TimeSeries("axis2_data1", org.jfree.data.time.Minute.class);
		TimeSeries axis2_data2 = new TimeSeries("axis2_data2", org.jfree.data.time.Minute.class);

		for (int i = 0; i < 168; i++) {
			// ��1����
			axis0_data1.add(new Minute(getDate(i)), Math.random() * 10 + 30);
			axis0_data2.add(new Minute(getDate(i)), Math.random() * 10 + 30);
			// ��2����
			axis1_data1.add(new Minute(getDate(i)), Math.random() * 100 + 200);
			axis1_data2.add(new Minute(getDate(i)), Math.random() * 100 + 200);
			// ��3����
			axis2_data1.add(new Minute(getDate(i)), Math.random() * 1000 + 1000);
			axis2_data2.add(new Minute(getDate(i)), Math.random() * 1000 + 1000);
		}
		TimeSeriesCollection dataSet1 = new TimeSeriesCollection();
		TimeSeriesCollection dataSet2 = new TimeSeriesCollection();
		TimeSeriesCollection dataSet3 = new TimeSeriesCollection();
		// ��1����
		dataSet1.addSeries(axis0_data1);
		// dataSet1.addSeries(axis0_data2);
		// ��2����
		dataSet2.addSeries(axis1_data1);
		// dataSet2.addSeries(axis1_data2);
		// ��3����
		dataSet3.addSeries(axis2_data1);
		// dataSet3.addSeries(axis2_data2);

		map.put("dataSet1", dataSet1);
		map.put("dataSet2", dataSet2);
		map.put("dataSet3", dataSet3);

		return map;
	}

	/**
	 * ģ��ʱ��
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
