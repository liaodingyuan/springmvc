/**
 * 
 */
package liaody.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* <p>Title:FormController </p>
* <p>Description: </p>
* <p>Company: </p>
* @author liaody
* @date 2017年7月16日
*/
@Controller
@RequestMapping("/denanric")
public class FormController {

	// default constructor
	public  FormController() {
		
	}
	@RequestMapping(value= "/{formName}")
	public String  loginForm(@PathVariable String formName) {
		
		// 动态跳转页面
		return formName;
	}
}
