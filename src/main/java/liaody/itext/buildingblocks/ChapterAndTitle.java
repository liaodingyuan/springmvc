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
 * @date 2017��8��8��
 */
public class ChapterAndTitle {

	public static final String DEST = "results/object/charter_title.pdf";

	public static void main(String[] args) throws FileNotFoundException, DocumentException {

		File file = new File(DEST);
		file.getParentFile().mkdirs();
		new ChapterAndTitle().createPdf(DEST);

	}

	public void createPdf(String dest) throws FileNotFoundException, DocumentException {
		// ���ȴ����ĵ�
		Document doc = new Document();
		// ���ĵ�д�뵽pdf��
		PdfWriter.getInstance(doc, new FileOutputStream(dest));
		// ���ĵ�
		doc.open();
		// ��ȡ����
		Font chartFont = FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLDITALIC);
		Font paragraghFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL);

		// Chunk��������pdf�ĵ�����������Сԭ��Ԫ�أ�Phrase�����Chunk�ļ��ϡ�Paragraph����һ�������Paragraph
		Chunk chunk = new Chunk("This is the title", chartFont);
		// ����chapter��chapter����paragraph
		Chapter chapter = new Chapter(new Paragraph(chunk), 1);
		chapter.setNumberDepth(0);
		chapter.add(new Paragraph("This is paragraph", paragraghFont));
		doc.add(chapter);
		doc.close();

	}

}
