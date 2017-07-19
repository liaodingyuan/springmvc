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
 * @date 2017��7��16��
 */
@Controller
public class ModelAttributeController2 {

	/**
	 * default controller
	 */
	public ModelAttributeController2() {

	}

	/**
	 * �ڷ����м����һ��model��model���Ե����ƺ�ֵ��model��addAttribute����ʵ�֡�
	 * ��������������void
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
