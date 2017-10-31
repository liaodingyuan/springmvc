/**
 * 
 */
package liaody.jfc;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;

/**
 * <p>
 * Title:DrawPanel
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017年10月30日
 */
public class DrawPanel {
	
	private static final String ARROW_DIRECTION_L = "1";
	private static final String ARROW_DIRECTION_R = "2";
	
	/**
	 * 绘制三角箭头
	 * @param g
	 */
	private void drawArrow(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.BLACK);
		
//		JFreeChart jfreechart = ChartFactory.createRingChart("", dataset, false, false, false);
		
		
		// 定义X坐标集
		int[][] arrowCoordination = getArrowCoordinate(0d,ARROW_DIRECTION_L);
	}
	
	/**
	 * @param d
	 * @param arrowDirectionL
	 * @return
	 */
	private int[][] getArrowCoordinate(double d, String arrowDirectionL) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(3);
		frame.setSize(500, 500);
		frame.setContentPane(new JPanel() {
			@Override
			public void paint(Graphics g) {
				super.paint(g);
				Graphics2D g2d = (Graphics2D) g;
				GeneralPath path = new GeneralPath();
				path.moveTo(200, 10);
				path.lineTo(10, 200);
				path.lineTo(400, 200);
				path.lineTo(200, 10);				
				g2d.draw(path);
				int x[]={50,100,150,};
				int y[]={100,50,100,};
//				g2d.setPaint(Color.RED);
//				g2d.setColor(Color.RED);
				g2d.setColor(Color.RED);
//				g.setColor(Color.RED);
//				g2d.setBackground(Color.RED);
				g2d.fillPolygon(x, y, 3);
//				g2d.drawPolygon(x,y,3);
			}
		});
		frame.setVisible(true);
	}
}
