/**
 * 
 */
package liaody.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import liaody.entity.User;
import liaody.entity.UserInfo;
import liaody.validation.spring.UserValidartor;

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

	/** 注入spring框架的验证对象 */
	@Autowired
	@Qualifier("userValidator")
	private UserValidartor userValidator;
	/** logger 对象*/
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
	// @ModelAttribute
	// public void userModel(@RequestParam("loginname") String loginname,
	// @RequestParam("password") String password,
	// @RequestParam(value = "email", required = false) String userEmail, Model
	// model) {
	// // 使用RequestParam注解的时候要注意required属性默认为true，如果没有对应的参数会抛异常
	// // 如果不是必须的属性，可以将required属性设置为false。defaultValue属性较少用也不推荐使用。
	// userInfo.setUsername(loginname);
	// userInfo.setPassword(password);
	// userInfo.setUserEmail(userEmail);
	// model.addAttribute("userinfo", userInfo);
	// }

	/**
	 * 用户从某个地方点击注册，使用这个方法调用到在/WEB-INF下受保护的registerForm.jsp。过度作用。
	 * 
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerForm() {
		logger.info("register get方法被调用");
		// 跳转到注册画面
		return "registerForm";
	}

	// @RequestMapping(value = "/register", method = RequestMethod.POST)
	// public String register(@RequestParam("loginname") String loginname,
	// @RequestParam("password") String password,
	// @RequestParam(value = "email", required = false) String email) {
	//
	// logger.info("register post方法被调用");
	// return null;
	// }
	/**
	 * 不需要像上面那种写法，直接使用Model，userModel方法已经先于该方法调用。 model里已经有用户的数据了。
	 * 
	 * @param loginname
	 * @param password
	 * @param email
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(Model model) {

		logger.info("register post方法被调用");
		// 数据验证
		// 存入数据库

		// 数据成功后跳转到登录页面loginForm.jsp
		return "loginForm";
	}

	/**
	 * 处理用户登录
	 * 
	 * @return
	 */
	@RequestMapping(value = "login")
	public ModelAndView login(@CookieValue(value = "JSESSIONID", defaultValue = "") String seesionId,
			@RequestParam("loginname") String loginname, @RequestParam("password") String password) {
		logger.info("user login action");

		// 如果有sessionid，用户可以直接登录，否则需要进行验证
		ModelAndView mv = new ModelAndView();
		return mv;
	}

	/**
	 * 使用spring自带的验证框架激进型数据验证。
	 * 验证的结果自动绑定的Errors对象中
	 * @param user
	 * @param model
	 * @param errors 验证结果会自动绑定的Errors对象中
	 * @return
	 */
	@RequestMapping(value="login2",method=RequestMethod.POST)
	public String login2(@ModelAttribute User user ,Model model,Errors errors) {
		logger.info(user);
		userValidator.validate(user, errors);
		// 注意一点是，验证结果都会自动绑定在Errors对象中
		if(errors.hasErrors()) {
			return "loginForm";
		}
		
		return "success";
	}
	
	/**
	 * 使用该方法对应页面的动态跳转
	 * @param loginOrFrom
	 * @return
	 */
	@RequestMapping(value="/{loginOrFrom}",method = RequestMethod.GET)
	public String loginAndRegisterForm(@PathVariable String loginOrFrom) {
	
		return loginOrFrom;
	}
	
	
	@RequestMapping(value="/userlogin")
	public ModelAndView userLogin() {
		
		
		ModelAndView mv = new ModelAndView();
		return mv;
	}
	
	
	
}
