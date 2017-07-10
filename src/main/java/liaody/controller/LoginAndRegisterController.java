/**
 * 
 */
package liaody.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import liaody.entity.UserInfo;

/**
 * <p>
 * Title:LoginAndRegisterController
 * </p>
 * <p>
 * Description:用户登录与注册的控制器
 * </p>
 * <p>
 * Company: hyron
 * </p>
 * 
 * @author liaody
 * @date 2017年7月10日
 */
@RequestMapping(value = "LoginOrRegister")
@Controller
public class LoginAndRegisterController {

	@Autowired
	private UserInfo userInfo;

	private final static Log logger = LogFactory.getLog(LoginAndRegisterController.class);

	/**
	 * default constructor
	 */
	public LoginAndRegisterController() {

	}

	/**
	 * 使用该注解的方法先于login和register方法调用。 做成数据模型loginorregisteruser方便以后使用。 这一步是需要验证参数的
	 * 
	 * @param loginname
	 *            接收传入的用户名
	 * @param password
	 *            接收传入的用户密码
	 * @param model
	 *            模型数据，存储用户的让输入
	 */
	@ModelAttribute
	public void userModel(@RequestParam("loginname") String loginname, @RequestParam("password") String password,
			@RequestParam(value = "email", required = false) String userEmail, Model model) {
		// 使用RequestParam注解的时候要注意required属性默认为true，如果没有对应的参数会抛异常
		// 如果不是必须的属性，可以将required属性设置为false。defaultValue属性较少用也不推荐使用。
		userInfo.setUsername(loginname);
		userInfo.setPassword(password);
		userInfo.setUserEmail(userEmail);
		model.addAttribute("userinfo", userInfo);
	}

	/**
	 * 处理用户登录
	 * 
	 * @return
	 */
	@RequestMapping(value = "login")
	public ModelAndView login(@CookieValue(value = "JSESSIONID", defaultValue = "") String seesionId) {
		logger.info("user login action");

		// 如果有sessionid，用户可以直接登录，否则需要进行验证		
		ModelAndView mv = new ModelAndView();
		return mv;
	}
}
