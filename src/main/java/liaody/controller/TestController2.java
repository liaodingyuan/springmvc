/**
 * 
 */
package liaody.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

/**
* <p>Title:TestController2 </p>
* <p>Description: </p>
* <p>Company: </p>
* @author liaody
* @date 2018Äê3ÔÂ9ÈÕ
*/
@Controller
public class TestController2 {

	@RequestMapping("/afterR")
	public String beforeR(Model model,HttpServletRequest request,RedirectAttributes attr) {

		Map<String, String> map2=(Map<String, String>) RequestContextUtils.getInputFlashMap(request);
        System.out.println(map2.get("status"));
        System.out.println(map2.get("message"));

		return "redirect:/toLogin";		
	}
}
