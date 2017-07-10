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

	@Autowired
	private UserInfo userInfo;

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
	@ModelAttribute
	public void userModel(@RequestParam("loginname") String loginname, @RequestParam("password") String password,
			@RequestParam(value = "email", required = false) String userEmail, Model model) {
		// ʹ��RequestParamע���ʱ��Ҫע��required����Ĭ��Ϊtrue�����û�ж�Ӧ�Ĳ��������쳣
		// ������Ǳ�������ԣ����Խ�required��������Ϊfalse��defaultValue���Խ�����Ҳ���Ƽ�ʹ�á�
		userInfo.setUsername(loginname);
		userInfo.setPassword(password);
		userInfo.setUserEmail(userEmail);
		model.addAttribute("userinfo", userInfo);
	}

	/**
	 * �����û���¼
	 * 
	 * @return
	 */
	@RequestMapping(value = "login")
	public ModelAndView login(@CookieValue(value = "JSESSIONID", defaultValue = "") String seesionId) {
		logger.info("user login action");

		// �����sessionid���û�����ֱ�ӵ�¼��������Ҫ������֤		
		ModelAndView mv = new ModelAndView();
		return mv;
	}
}
