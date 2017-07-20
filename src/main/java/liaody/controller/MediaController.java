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
 * @date 2017年7月20日
 */
@Controller
public class MediaController {
	// default controller
	public MediaController() {

	}

	/**
	 * 处理/main 请求
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/main")
	public String main(Model model) {
		// 模拟影视库中的视屏资料
		List<MyMedia> medisList = new ArrayList<MyMedia>();
		medisList.add(new MyMedia("美女.mp4", "mp4", 123));
		medisList.add(new MyMedia("image.jpg", "jpg", 123));
		medisList.add(new MyMedia("操你.jpg", "jpg", 123));
		medisList.add(new MyMedia("微博桌面.PNG", "png", 123));
		medisList.add(new MyMedia("韦宁.jpg", "png", 123));
		model.addAttribute("mediaList", medisList);
		// 跳转到main画面
		return "main";
	}

}
