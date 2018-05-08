/**
 * 
 */
package liaody.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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

import liaody.entity.UserInfo;
import liaody.validation.spring.UserValidartor;

/**
 * <p>
 * Title:LoginAndRegisterController
 * </p>
 * <p>
 * Description:�û���¼��ע��Ŀ�����
 * </p>
 * <p>
 * Company: hyron
 * </p>
 * 
 * @author liaody
 * @date 2017��7��10��
 */
@RequestMapping(value = "/loginOrRegister")
@Controller
public class LoginAndRegisterController {

	/** ע��spring��ܵ���֤���� */
	@Autowired
	@Qualifier("userValidator")
	private UserValidartor userValidator;
	/** logger ���� */
	private final static Log logger = LogFactory.getLog(LoginAndRegisterController.class);

	/**
	 * default constructor
	 */
	public LoginAndRegisterController() {

	}

	/**
	 * �û���ĳ���ط����ע�ᣬʹ������������õ���/WEB-INF���ܱ�����registerForm.jsp���������á�
	 * 
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerForm(Model model) {
		logger.info("register get����������");
		UserInfo userInfo = new UserInfo();
		model.addAttribute("userInfo", userInfo);
		// ��ת��ע�ử��
		return "registerForm";
	}
	/**
	 * �û��ӵ����¼��ʹ������������õ���/WEB-INF���ܱ�����loginForm.jsp���������á�
	 * 
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm() {
		logger.info("login get����������");
		// ��ת��ע�ử��
		return "loginForm";
	}
	
	/**
	 * ʹ�ø÷�����Ӧҳ��Ķ�̬��ת�ļ��ϴ�����
	 * 
	 * @param loginOrFrom
	 * @return
	 */
	@RequestMapping(value = "/uploadForm", method = RequestMethod.GET)
	public String loginAndRegisterForm() {
	
//		��ת���û��ϴ��ļ�����
		return "uploadForm";
	}


	/**
	 * ����Ҫ����������д����ֱ��ʹ��Model��userModel�����Ѿ����ڸ÷������á� model���Ѿ����û��������ˡ� �ϴ��ļ���Ϊ��������ԡ�
	 * ֱ��ʹ��@ModelAttribute��form�еĲ����󶨵�user�����С�Springmvc��ܻὫ��������������ƥ�䣬���������õ�user������ȥ��
	 * 
	 * @param loginname
	 * @param password
	 * @param email
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@Valid @ModelAttribute UserInfo userInfo,  Errors errors,Model model) {

		logger.info("register post����������");
		logger.info(userInfo.getUsername() + "����ע��");
		// Spring ������֤
		// userValidator.validate(user, errors);
		// ������֤ʧ��ֱ�ӷ���ע��ҳ��
		if (errors.hasErrors()) {
			return "registerForm";
		}
		model.addAttribute(userInfo.getUsername(), userInfo);
		// ���ݳɹ�����ת����¼ҳ��loginForm.jsp
		return "loginForm";
	}

	/**
	 * �����û���¼ ʹ��session�ж�
	 * 
	 * @return
	 */
	@RequestMapping(value = "login")
	public ModelAndView login(@CookieValue(value = "JSESSIONID", defaultValue = "") String seesionId,
			HttpSession session, @RequestParam("loginname") String loginname,
			@RequestParam("password") String password) {
		logger.info("user login action");
		ModelAndView mv = new ModelAndView();
		if (!StringUtils.isEmpty(loginname) && !StringUtils.isEmpty(password) && loginname.equals("liaody")
				&& password.equals("123")) {
			UserInfo userInfo = new UserInfo();
			userInfo.setUsername(loginname);
			userInfo.setPassword(password);
			userInfo.setUserEmail("Adminisrtator");
			session.setAttribute("userInfo", userInfo);
			mv.setViewName("redirect:/main");
			
			// 
			
			
			
		} else {
			mv.addObject("message", "��¼����������������������룡");
			mv.setViewName("loginForm");
		}
		return mv;
	}



}
