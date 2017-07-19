/**
 * 
 */
package liaody.controller;

import org.springframework.stereotype.Controller;
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
public class ModelAttributeController {

	/**
	 * default controller
	 */
	public ModelAttributeController() {

	}

	/**
	 * ʹ��@ModelAttributeע�͵�value���ԣ���ָ��model���Ե����ƣ�model���Ե�ֵ���Ƿ����ķ���ֵ
	 * 
	 * @param loginname
	 * @return
	 */
	@ModelAttribute("loginname")
	public String userModel1(@RequestParam("loginname") String loginname) {
		// ��Model�з���keyΪloginname��valueΪ��������ֵ��һ������ֵ
		return loginname;
	}

	@RequestMapping("login1")
	public String login1() {
		return "result1";
	}
}
