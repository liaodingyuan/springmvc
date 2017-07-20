/**
 * 
 */
package liaody.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
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
@RequestMapping(value = "/loginOrRegister")
@Controller
public class LoginAndRegisterController {

	/** 注入spring框架的验证对象 */
	@Autowired
	@Qualifier("userValidator")
	private UserValidartor userValidator;
	/** logger 对象 */
	private final static Log logger = LogFactory.getLog(LoginAndRegisterController.class);

	/**
	 * default constructor
	 */
	public LoginAndRegisterController() {

	}

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
	
	/**
	 * 用户从点击登录，使用这个方法调用到在/WEB-INF下受保护的loginForm.jsp。过度作用。
	 * 
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm() {
		logger.info("login get方法被调用");
		// 跳转到注册画面
		return "loginForm";
	}

	/**
	 * 不需要像上面那种写法，直接使用Model，userModel方法已经先于该方法调用。 model里已经有用户的数据了。 上传文件作为对象的属性。
	 * 直接使用@ModelAttribute将form中的参数绑定到user对象中。Springmvc框架会将参数按照属性名匹配，将参数设置到user属性中去。
	 * 
	 * @param loginname
	 * @param password
	 * @param email
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(HttpServletRequest request, @ModelAttribute User user, Model model, Errors errors) {

		logger.info("register post方法被调用");
		logger.info(user.getLoginname());
		// 数据验证
		userValidator.validate(user, errors);
		// 数据验证失败直接返回注册页面
		if (errors.hasErrors()) {
			logger.info(errors.toString());
			return "registerForm";
		}
		// 处理上传文件
		if (!user.getImage().isEmpty()) {
			// 上传路径
			String path = request.getServletContext().getRealPath("/images");
			// 上传文件名
			String filename = user.getImage().getOriginalFilename();
			File filePath = new File(path, filename);
			// 如果上传的路径不存在就创建一个
			if (!filePath.getParentFile().exists()) {
				filePath.getParentFile().mkdir();
			}
			// 将上传文件保存到一个目标文件夹中
			try {
				user.getImage().transferTo(filePath);
			} catch (IllegalStateException | IOException e) {
				logger.error("上传文件保存失败");
				e.printStackTrace();
				return "registerForm";
			}

		}
		model.addAttribute("registerUser", user);
		// 数据成功后跳转到登录页面loginForm.jsp
		return "loginForm";
	}

	/**
	 * 处理用户登录
	 * 使用session判断
	 * @return
	 */
	@RequestMapping(value = "login")
	public ModelAndView login(@CookieValue(value = "JSESSIONID", defaultValue = "") String seesionId,
			HttpSession session, @RequestParam("loginname") String loginname,
			@RequestParam("password") String password) {
		logger.info("user login action");
		ModelAndView mv = new ModelAndView();
		if (!StringUtils.isEmpty(loginname) && !StringUtils.isEmpty(password) && loginname.equals("liaody") && password.equals("123")) {
			UserInfo userInfo = new UserInfo();
			userInfo.setUsername(loginname);
			userInfo.setPassword(password);
			userInfo.setUserEmail("Adminisrtator");
			session.setAttribute("userInfo", userInfo);
			mv.setViewName("redirect:/main");
		} else {
			mv.addObject("message", "登录名或者密码错误，请重新输入！");
			mv.setViewName("loginForm");
		}
		return mv;
	}

	/**
	 * 使用spring自带的验证框架激进型数据验证。 验证的结果自动绑定的Errors对象中
	 * 
	 * @param user
	 * @param model
	 * @param errors
	 *            验证结果会自动绑定的Errors对象中
	 * @return
	 */
	@RequestMapping(value = "login2", method = RequestMethod.POST)
	public String login2(@ModelAttribute User user, Model model, Errors errors) {
		logger.info(user);
		userValidator.validate(user, errors);
		// 注意一点是，验证结果都会自动绑定在Errors对象中
		if (errors.hasErrors()) {
			return "loginForm";
		}

		return "success";
	}

	/**
	 * 使用该方法对应页面的动态跳转
	 * 
	 * @param loginOrFrom
	 * @return
	 */
	@RequestMapping(value = "/uploadForm", method = RequestMethod.GET)
	public String loginAndRegisterForm() {

		return "uploadForm";
	}

}
