/**
 * 
 */
package liaody.controller;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import liaody.entity.UserInfo;

/**
* <p>Title:Annotation </p>
* <p>Description: 测试springmvc中各注解的使用</p>
* <p>Company: huawei</p>
* @author liaody
* @date 2017年7月9日
*/
/**
 * 使用@Controller注解的条件：spring mvc配置文件中引入spring-context、使用<context:component-scan
 * base-package> 启动包扫描功能
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
	 * @RequestMapping注解属性： 默认的value、name给映射地址起一个别名、consumes提交内容（Content-Type）
	 * produces（Accept）、params指定参数，headers匹配http请求头
	 * 
	 * @return
	 */
	@RequestMapping(value = "/register")
	public String register() {
		return "register";
	}

	/**
	 * 请求方法中可以出现多种数据类型比如 HttpServletRequest HttpServletResponse HttpSession
	 * 使用spring原生态的WebRequest或者NativeWebRequest Local InputStream/Reader
	 * OutputStream/Wtiter java.security.Princpal HttpEntity<?> Map Model：最重要的一个数据类型
	 * ModelMap RedirectAttributes Errors BindingResult SessionStatus
	 * 也可以出现注解：@PathVariable @MaxtrixVariable @RequestParam @RequestHead
	 * 
	 * @RequestBody @RequestPart ModelAndView可以做参数也可以做返回类型
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/login")
	public String login(HttpServletRequest request) {
		return "login";
	}

	/**
	 * Model用于存储模型数据，实现了Map接口 重要：spring在调用处理方法之前会创建一个隐藏的模型对象，作为模型数据存储容器。
	 * 如果处理方法的参数为Model或者ModelMap类型，springmvc会将隐藏的模型的引用传递给
	 * 这些参数。这些步骤都是自动的。开发者可以通过这个参数对象访问模型中的所有数据，也可以像模型中 添加新的属性数据。直接使用addObject方法
	 * 
	 * @return
	 */
	@RequestMapping(value = "/model1")
	public ModelAndView model1(Model model) {
		// 直接从Model中获取模型数据
		UserInfo tmpUser = (UserInfo) model.asMap().get("user1");
		System.out.println(tmpUser.toString());
		// http://localhost:8080/spring4maven/Annotation/model1?loginname=liaody&password=123
		// 正如名字一样，既包含模型数据数据信息也包含视图信息
		ModelAndView mv = new ModelAndView();
		mv.setViewName("success");
		return mv;
	}

	/**
	 * 使用ModelAttribute注解的方法会先于处理方法调用 重要：spring在调用处理方法之前会创建一个隐藏的模型对象，作为模型数据存储容器。
	 * 如果处理方法的参数为Model或者ModelMap类型，springmvc会将隐藏的模型的引用传递给
	 * 这些参数。这些步骤都是自动的。开发者可以通过这个参数对象访问模型中的所有数据，也可以像模型中 添加新的属性数据。直接使用addObject方法
	 * 
	 * @param loginname
	 * @param password
	 * @param model
	 */
	@ModelAttribute
	public void userModel(String loginname, String password, Model model) {

		logger.info("userModel");
		// 创建UserInfo对象存储jsp页面传入的参数
		userInfo.setUsername(loginname);
		userInfo.setPassword(password);
		// 将user放入到model里，其它地方使用Model/ModelMap就可以去得到这个user了
		model.addAttribute("user1", userInfo);
	}

	@RequestMapping(value = "param1", method = RequestMethod.GET)
	public ModelAndView testParam(@RequestParam("loginname") String loginname, @RequestParam String password) {
		// 使用RequestParam自动绑定参数， 不在括号中写出具体的参数值则默认为传入的参数与形参一样
		System.out.println("loginnane:" + loginname);
		System.out.println("password:" + password);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("success");
		return mv;
		
	}

	@RequestMapping(value = "/requestHeadrTest")
	public void requestHeadrTest(@RequestHeader("User-Agent") Object[] userAgent,
			@RequestHeader("Accept") String[] accpt) {

		logger.info(userAgent);
		logger.info(Arrays.deepToString(userAgent));
	}
}
