package liaody.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import liaody.entity.UserInfo;

/**
 * 
 * <p>
 * Title:TestController
 * </p>
 * <p>
 * Description: 用于测试spring mvc是否搭建成功
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017年7月9日
 */
@Controller
public class TestController {
	
	@Autowired
	private UserInfo userInfo;

	// default constructor
	public TestController() {

	}

	@RequestMapping(value = "/test")
	public ModelAndView testMvc() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("success");
		mv.addObject("mgs", "Hello Spring Mvc!");
		return mv;
	}

}
