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
 * Description:处理文件下载
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017年7月19日
 */
@Controller
public class FileDownloadController {

	/**
	 * 
	 */
	public FileDownloadController() {

	}

	/**
	 * 直接给出超链接，href属性等于要下载的文件名即可实现文件下载功能。在早期的浏览器中如果文件名是中文会导致下载失败
	 * ，在最新的浏览器中可以实现中文名称的文件下载了，无需对文件名进行转码，但是为了兼容就版本的浏览器，需要静静转码操作。 Spring
	 * mvc提供可一个responseEntity类型，可以很方便金的定义HttpHeaders和HttpStatus
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

		// 获取下载文件的路径
		String path = "D:\\images\\";
		// 如果文件不存在
		File file = new File(path + File.separator + filename);
		// 设置HttpHeaders
		HttpHeaders headers = new HttpHeaders();
		// 解决下载文件名是中文导致乱码下载失败的问题
		String downloadFileName = new String(filename.getBytes("UTF-8"), "ISO-8859-1");
		// 通知浏览器以attachment下载的方式打开
		headers.setContentDispositionFormData("arttachment", downloadFileName);
		// 二进制数据（最常见的文件下载）
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		// 设置返回的状态码为201
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
	}

}
