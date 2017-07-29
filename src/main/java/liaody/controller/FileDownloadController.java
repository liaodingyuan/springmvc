/**
 * 
 */
package liaody.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * Title:FileDownloadController
 * </p>
 * <p>
 * Description:�����ļ�����
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017��7��19��
 */
@Controller
public class FileDownloadController {

	/**
	 * 
	 */
	public FileDownloadController() {

	}

	/**
	 * ֱ�Ӹ��������ӣ�href���Ե���Ҫ���ص��ļ�������ʵ���ļ����ع��ܡ������ڵ������������ļ��������Ļᵼ������ʧ��
	 * �������µ�������п���ʵ���������Ƶ��ļ������ˣ�������ļ�������ת�룬����Ϊ�˼��ݾͰ汾�����������Ҫ����ת������� Spring
	 * mvc�ṩ��һ��responseEntity���ͣ����Ժܷ����Ķ���HttpHeaders��HttpStatus
	 * 
	 * @param request
	 * @param filename
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/fileDwonload")
	public ResponseEntity<byte[]> download(HttpServletRequest request, @RequestParam("filename") String filename,
			Model model) throws IOException {

		// ��ȡ�����ļ���·��
		String path = "D:\\images\\";
		// ����ļ�������
		File file = new File(path + File.separator + filename);
		// ����HttpHeaders
		HttpHeaders headers = new HttpHeaders();
		// ��������ļ��������ĵ�����������ʧ�ܵ�����
		String downloadFileName = new String(filename.getBytes("UTF-8"), "ISO-8859-1");
		// ֪ͨ�������attachment���صķ�ʽ��
		headers.setContentDispositionFormData("arttachment", downloadFileName);
		// ���������ݣ�������ļ����أ�
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		// ���÷��ص�״̬��Ϊ201
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
	}

}
