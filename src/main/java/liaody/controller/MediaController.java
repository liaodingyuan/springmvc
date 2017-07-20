/**
 * 
 */
package liaody.controller;

import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.Media;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 * Title:MediaController
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017��7��20��
 */
@Controller
public class MediaController {
	// default controller
	public MediaController() {

	}

	/**
	 * ����/main ����
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/main")
	public String main(Model model) {
		// ģ��Ӱ�ӿ��е���������
		List<MyMedia> medisList = new ArrayList<MyMedia>();
		medisList.add(new MyMedia("��Ů.mp4", "mp4", 123));
		medisList.add(new MyMedia("image.jpg", "jpg", 123));
		medisList.add(new MyMedia("����.jpg", "jpg", 123));
		medisList.add(new MyMedia("΢������.PNG", "png", 123));
		medisList.add(new MyMedia("Τ��.jpg", "png", 123));
		model.addAttribute("mediaList", medisList);
		// ��ת��main����
		return "main";
	}

}
