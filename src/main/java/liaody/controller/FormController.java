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
* @date 2017��7��16��
*/
@Controller
@RequestMapping("/denanric")
public class FormController {

	// default constructor
	public  FormController() {
		
	}
	@RequestMapping(value= "/{formName}")
	public String  loginForm(@PathVariable String formName) {
		
		// ��̬��תҳ��
		return formName;
	}
}
