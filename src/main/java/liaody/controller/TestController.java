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
 * Description: ���ڲ���spring mvc�Ƿ��ɹ�
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017��7��9��
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
