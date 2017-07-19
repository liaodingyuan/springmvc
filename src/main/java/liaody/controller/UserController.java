/**
 * 
 */
package liaody.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import liaody.entity.User;

/**
 * <p>
 * Title:UserController
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
@RequestMapping(value="/usertest")
public class UserController {
	private static final Log logger = LogFactory.getLog(UserController.class);

	@RequestMapping("/{formName}")
	public String formName(@PathVariable String formName) {
		// 动态跳转页面
		return formName;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@ModelAttribute User user, Model model) {
		logger.info(user);
		model.addAttribute("user", user);
		return "success";
	}
}
