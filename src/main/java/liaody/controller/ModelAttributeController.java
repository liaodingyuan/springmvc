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
 * @date 2017年7月16日
 */
@Controller
public class ModelAttributeController {

	/**
	 * default controller
	 */
	public ModelAttributeController() {

	}

	/**
	 * 使用@ModelAttribute注释的value属性，来指定model属性的名称，model属性的值就是方法的返回值
	 * 
	 * @param loginname
	 * @return
	 */
	@ModelAttribute("loginname")
	public String userModel1(@RequestParam("loginname") String loginname) {
		// 向Model中放入key为loginname，value为方法返回值的一对属性值
		return loginname;
	}

	@RequestMapping("login1")
	public String login1() {
		return "result1";
	}
}
