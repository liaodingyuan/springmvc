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
 * Description:�û���¼��ע��Ŀ�����
 * </p>
 * <p>
 * Company: hyron
 * </p>
 * 
 * @author liaody
 * @date 2017��7��10��
 */
@RequestMapping(value = "LoginOrRegister")
@Controller
public class LoginAndRegisterController {

	/** ע��spring��ܵ���֤���� */
	@Autowired
	@Qualifier("userValidator")
	private UserValidartor userValidator;
	/** logger ����*/
	private final static Log logger = LogFactory.getLog(LoginAndRegisterController.class);

	/**
	 * default constructor
	 */
	public LoginAndRegisterController() {

	}

	/**
	 * ʹ�ø�ע��ķ�������login��register�������á� ��������ģ��loginorregisteruser�����Ժ�ʹ�á� ��һ������Ҫ��֤������
	 * 
	 * @param loginname
	 *            ���մ�����û���
	 * @param password
	 *            ���մ�����û�����
	 * @param model
	 *            ģ�����ݣ��洢�û���������
	 */
	// @ModelAttribute
	// public void userModel(@RequestParam("loginname") String loginname,
	// @RequestParam("password") String password,
	// @RequestParam(value = "email", required = false) String userEmail, Model
	// model) {
	// // ʹ��RequestParamע���ʱ��Ҫע��required����Ĭ��Ϊtrue�����û�ж�Ӧ�Ĳ��������쳣
	// // ������Ǳ�������ԣ����Խ�required��������Ϊfalse��defaultValue���Խ�����Ҳ���Ƽ�ʹ�á�
	// userInfo.setUsername(loginname);
	// userInfo.setPassword(password);
	// userInfo.setUserEmail(userEmail);
	// model.addAttribute("userinfo", userInfo);
	// }

	/**
	 * �û���ĳ���ط����ע�ᣬʹ������������õ���/WEB-INF���ܱ�����registerForm.jsp���������á�
	 * 
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerForm() {
		logger.info("register get����������");
		// ��ת��ע�ử��
		return "registerForm";
	}

	// @RequestMapping(value = "/register", method = RequestMethod.POST)
	// public String register(@RequestParam("loginname") String loginname,
	// @RequestParam("password") String password,
	// @RequestParam(value = "email", required = false) String email) {
	//
	// logger.info("register post����������");
	// return null;
	// }
	/**
	 * ����Ҫ����������д����ֱ��ʹ��Model��userModel�����Ѿ����ڸ÷������á� model���Ѿ����û��������ˡ�
	 * 
	 * @param loginname
	 * @param password
	 * @param email
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(Model model) {

		logger.info("register post����������");
		// ������֤
		// �������ݿ�

		// ���ݳɹ�����ת����¼ҳ��loginForm.jsp
		return "loginForm";
	}

	/**
	 * �����û���¼
	 * 
	 * @return
	 */
	@RequestMapping(value = "login")
	public ModelAndView login(@CookieValue(value = "JSESSIONID", defaultValue = "") String seesionId,
			@RequestParam("loginname") String loginname, @RequestParam("password") String password) {
		logger.info("user login action");

		// �����sessionid���û�����ֱ�ӵ�¼��������Ҫ������֤
		ModelAndView mv = new ModelAndView();
		return mv;
	}

	/**
	 * ʹ��spring�Դ�����֤��ܼ�����������֤��
	 * ��֤�Ľ���Զ��󶨵�Errors������
	 * @param user
	 * @param model
	 * @param errors ��֤������Զ��󶨵�Errors������
	 * @return
	 */
	@RequestMapping(value="login2",method=RequestMethod.POST)
	public String login2(@ModelAttribute User user ,Model model,Errors errors) {
		logger.info(user);
		userValidator.validate(user, errors);
		// ע��һ���ǣ���֤��������Զ�����Errors������
		if(errors.hasErrors()) {
			return "loginForm";
		}
		
		return "success";
	}
	
	/**
	 * ʹ�ø÷�����Ӧҳ��Ķ�̬��ת
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
