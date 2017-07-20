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
 * @date 2017年7月18日
 */
@Controller
public class FileUploadController {

	// 日志
	private static final Log logger = LogFactory.getLog(FileUploadController.class);

	// default constructor
	public FileUploadController() {

	}

	/**
	 * 处理文件上传
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
		if (!uploadFile.isEmpty()) {// 注意容易出现bug，使用该方法，当文件为0字节的时候不能够上传，判断文件为空了。
			// 上传文件路径
			String path = "D:\\images\\";
			String fileName = uploadFile.getOriginalFilename();
			File targetFile = new File(path, fileName);
			logger.info(uploadFile.getContentType());
			logger.info(uploadFile.getName());
			// 获取上传文件的原名
			logger.info(uploadFile.getOriginalFilename());
			// 判断路径是否存在，如果不存在的话就创建一个
			if (!targetFile.getParentFile().exists()) {
				targetFile.getParentFile().mkdir();
			}
			// 将上传文件保存到一个目标文件夹中
			uploadFile.transferTo(new File(path, fileName));
			return "success";
		} else {
			return "error";
		}
	}
}
