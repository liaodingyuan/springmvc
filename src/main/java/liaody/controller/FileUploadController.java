/**
 * 
 */
package liaody.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * Title:FileUploadController
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017��7��18��
 */
@Controller
public class FileUploadController {

	// ��־
	private static final Log logger = LogFactory.getLog(FileUploadController.class);

	// default constructor
	public FileUploadController() {

	}

	/**
	 * �����ļ��ϴ�
	 * 
	 * @param request
	 * @param decription
	 * @param uploadFile
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upload(HttpServletRequest request, @RequestParam("description") String decription,
			@RequestParam("file") MultipartFile uploadFile) throws IllegalStateException, IOException {

		request.setCharacterEncoding("UTF-8");
		logger.info(decription);
		if (!uploadFile.isEmpty()) {// ע�����׳���bug��ʹ�ø÷��������ļ�Ϊ0�ֽڵ�ʱ���ܹ��ϴ����ж��ļ�Ϊ���ˡ�
			// �ϴ��ļ�·��
			String path = "D:\\images\\";
			String fileName = uploadFile.getOriginalFilename();
			File targetFile = new File(path, fileName);
			logger.info(uploadFile.getContentType());
			logger.info(uploadFile.getName());
			// ��ȡ�ϴ��ļ���ԭ��
			logger.info(uploadFile.getOriginalFilename());
			// �ж�·���Ƿ���ڣ���������ڵĻ��ʹ���һ��
			if (!targetFile.getParentFile().exists()) {
				targetFile.getParentFile().mkdir();
			}
			// ���ϴ��ļ����浽һ��Ŀ���ļ�����
			uploadFile.transferTo(new File(path, fileName));
			return "success";
		} else {
			return "error";
		}
	}
}
