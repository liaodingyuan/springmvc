/**
 * 
 */
package liaody.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
* <p>Title:TestController1 </p>
* <p>Description: </p>
* <p>Company: </p>
* @author liaody
* @date 2018Äê3ÔÂ8ÈÕ
*/
@Controller
public class TestController1 {
	
	@RequestMapping("/beforeR")
	public String beforeR(Model model,RedirectAttributes attr) {
//		model.asMap().remove("param1");
//		model.addAttribute("param1","value1");

			attr.addFlashAttribute("status","999");
		attr.addFlashAttribute("message","µÇÂ¼Ê§°Ü");
		return "redirect:/afterR";
		
	}

}
