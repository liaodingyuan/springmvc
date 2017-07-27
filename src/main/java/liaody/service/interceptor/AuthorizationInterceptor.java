/**
 * 
 */
package liaody.service.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import liaody.entity.UserInfo;

/**
 * <p>
 * Title:AuthorizationInterceptor
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017年7月20日
 */
public class AuthorizationInterceptor implements HandlerInterceptor {

	// 不拦截loginForm和login的请求
	private static final String[] IGNORE_URL = { "/loginForm", "login","register","/registerForm" };
	private static final Log logger = LogFactory.getLog(AuthorizationInterceptor.class);

	public AuthorizationInterceptor() {

	}

	/**
	 * 	该方法是进行处理器拦截器用的，在Controller处理之前进行调用。
	 * 该方法返回true的情况下拦截器才会继续往下执行，如果该方法返回false的时候整个请求就结束了。
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		logger.info("AuthorizationInterceptor preHandler -->");
		
	// 首先判断用户是否登录，默认为false
		boolean passFlag = false;
		
		// 获取请求路径进行判定
		String servletPath = request.getServletPath();
		
		for(String ss:IGNORE_URL) {
			if(servletPath.contains(ss)) {
				passFlag = true;
				break;
			}
		}
		
		// 拦截请求
		if(!passFlag) {
			// 获取用户session中的用户
			UserInfo userInfo = (UserInfo) request.getSession().getAttribute("userInfo");
			// 判断用户是否登录
			if(userInfo==null) {
				// 用户没有登录，跳转到登录页面
				logger.info("AuthorizationInterceptork拦截请求：");
				request.setAttribute("message", "未登录游客无法下载本站资源，请您先登录！");
				request.getRequestDispatcher("/loginOrRegister/login").forward(request, response);
				
			}else {
				logger.info("用户已经登录，AuthorizationInterceptor放行请求");
				passFlag = true;
			}
			
		}

		return passFlag;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		logger.info("AuthorizationInterceptor postHandle -->");

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		 logger.info("AuthorizationInterceptor afterCompletion-->");

	}

}
