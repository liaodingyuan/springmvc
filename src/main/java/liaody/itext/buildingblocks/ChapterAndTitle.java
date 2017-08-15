/**
 * 
 */
package liaody.itext.buildingblocks;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * <p>
 * Title:ChapterAndTitle
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017年8月8日
 */
public class ChapterAndTitle {

	public static final String DEST = "results/object/charter_title.pdf";

	public static void main(String[] args) throws FileNotFoundException, DocumentException {

		File file = new File(DEST);
		file.getParentFile().mkdirs();
		new ChapterAndTitle().createPdf(DEST);

	}

	public void createPdf(String dest) throws FileNotFoundException, DocumentException {
		// 首先创建文档
		Document doc = new Document();
		// 将文档写入到pdf中
		PdfWriter.getInstance(doc, new FileOutputStream(dest));
		// 打开文档
		doc.open();
		// 获取字体
		Font chartFont = FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLDITALIC);
		Font paragraghFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL);

		// Chunk，块是是pdf文档中描述的最小原子元素，Phrase短语，是Chunk的集合。Paragraph，是一个有序的Paragraph
		Chunk chunk = new Chunk("This is the title", chartFont);
		// 创建chapter，chapter大于paragraph
		Chapter chapter = new Chapter(new Paragraph(chunk), 1);
		chapter.setNumberDepth(0);
		chapter.add(new Paragraph("This is paragraph", paragraghFont));
		doc.add(chapter);
		doc.close();

	}

}
