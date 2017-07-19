/**
 * 
 */
package liaody.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * Title:ModelAttributeController
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017年7月16日
 */
@Controller
public class ModelAttributeController2 {

	/**
	 * default controller
	 */
	public ModelAttributeController2() {

	}

	/**
	 * 在方法中加入就一个model，model属性的名称和值由model的addAttribute方法实现。
	 * 方法返回类型是void
	 * 
	 * @param loginname
	 * @return
	 */
	@ModelAttribute
	public void userModel2(@RequestParam("loginname") String loginname, @RequestParam("password") String password,
			Model model) {

		model.addAttribute("loginname", loginname);
		model.addAttribute("password", password);

	}

	@RequestMapping("login2")
	public String login1() {
		return "result2";
	}
}
