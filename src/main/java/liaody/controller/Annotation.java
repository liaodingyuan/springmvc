/**
 * 
 */
package liaody.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import liaody.entity.UserInfo;

/**
* <p>Title:Annotation </p>
* <p>Description: ����springmvc�и�ע���ʹ��</p>
* <p>Company: huawei</p>
* @author liaody
* @date 2017��7��9��
*/
/**
 * ʹ��@Controllerע���������spring mvc�����ļ�������spring-context��ʹ��<context:component-scan
 * base-package> ������ɨ�蹦��
 */
@Controller
@RequestMapping(value = "/Annotation")
public class Annotation {

	private static final Log logger = LogFactory.getLog(Annotation.class);
	@Autowired
	private UserInfo userInfo;
	/**
	 * default constructor
	 */
	public Annotation() {

	}

	/**
	 * @RequestMappingע�����ԣ� Ĭ�ϵ�value��name��ӳ���ַ��һ��������consumes�ύ���ݣ�Content-Type��
	 * produces��Accept����paramsָ��������headersƥ��http����ͷ
	 * 
	 * @return
	 */
	@RequestMapping(value = "/register")
	public String register() {
		return "register";
	}

	/**
	 * ���󷽷��п��Գ��ֶ����������ͱ��� HttpServletRequest HttpServletResponse HttpSession
	 * ʹ��springԭ��̬��WebRequest����NativeWebRequest Local InputStream/Reader
	 * OutputStream/Wtiter java.security.Princpal HttpEntity<?> Map Model������Ҫ��һ����������
	 * ModelMap RedirectAttributes Errors BindingResult SessionStatus
	 * Ҳ���Գ���ע�⣺@PathVariable @MaxtrixVariable @RequestParam @RequestHead
	 * 
	 * @RequestBody @RequestPart ModelAndView����������Ҳ��������������
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/login")
	public String login(HttpServletRequest request) {
		return "login";
	}

	/**
	 * Model���ڴ洢ģ�����ݣ�ʵ����Map�ӿ� ��Ҫ��spring�ڵ��ô�������֮ǰ�ᴴ��һ�����ص�ģ�Ͷ�����Ϊģ�����ݴ洢������
	 * ������������Ĳ���ΪModel����ModelMap���ͣ�springmvc�Ὣ���ص�ģ�͵����ô��ݸ�
	 * ��Щ��������Щ���趼���Զ��ġ������߿���ͨ����������������ģ���е��������ݣ�Ҳ������ģ���� �����µ��������ݡ�ֱ��ʹ��addObject����
	 * 
	 * @return
	 */
	@RequestMapping(value = "/model1")
	public ModelAndView model1() {
		

		ModelAndView mv = new ModelAndView();
		return mv;
	}

	/**
	 * ʹ��ModelAttributeע��ķ��������ڴ����������� ��Ҫ��spring�ڵ��ô�������֮ǰ�ᴴ��һ�����ص�ģ�Ͷ�����Ϊģ�����ݴ洢������
	 * ������������Ĳ���ΪModel����ModelMap���ͣ�springmvc�Ὣ���ص�ģ�͵����ô��ݸ�
	 * ��Щ��������Щ���趼���Զ��ġ������߿���ͨ����������������ģ���е��������ݣ�Ҳ������ģ���� �����µ��������ݡ�ֱ��ʹ��addObject����
	 * 
	 * @param loginname
	 * @param password
	 * @param model
	 */
	@ModelAttribute
	public void userModel(String loginname, String password, Model model) {

		logger.info("userModel");
		// ����UserInfo����洢jspҳ�洫��Ĳ���
		userInfo.setUsername(loginname);
		userInfo.setPassword(password);
		// ��user���뵽model������ط�ʹ��Model/ModelMap�Ϳ���ȥ�õ����user��
		model.addAttribute("user1",userInfo);
	}
}