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
 * @date 2017��7��20��
 */
public class AuthorizationInterceptor implements HandlerInterceptor {

	// ������loginForm��login������
	private static final String[] IGNORE_URL = { "/loginForm", "login","register","/registerForm" };
	private static final Log logger = LogFactory.getLog(AuthorizationInterceptor.class);

	public AuthorizationInterceptor() {

	}

	/**
	 * 	�÷����ǽ��д������������õģ���Controller����֮ǰ���е��á�
	 * �÷�������true��������������Ż��������ִ�У�����÷�������false��ʱ����������ͽ����ˡ�
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		logger.info("AuthorizationInterceptor preHandler -->");
		
	// �����ж��û��Ƿ��¼��Ĭ��Ϊfalse
		boolean passFlag = false;
		
		// ��ȡ����·�������ж�
		String servletPath = request.getServletPath();
		
		for(String ss:IGNORE_URL) {
			if(servletPath.contains(ss)) {
				passFlag = true;
				break;
			}
		}
		
		// ��������
		if(!passFlag) {
			// ��ȡ�û�session�е��û�
			UserInfo userInfo = (UserInfo) request.getSession().getAttribute("userInfo");
			// �ж��û��Ƿ��¼
			if(userInfo==null) {
				// �û�û�е�¼����ת����¼ҳ��
				logger.info("AuthorizationInterceptork��������");
				request.setAttribute("message", "δ��¼�ο��޷����ر�վ��Դ�������ȵ�¼��");
				request.getRequestDispatcher("/loginOrRegister/login").forward(request, response);
				
			}else {
				logger.info("�û��Ѿ���¼��AuthorizationInterceptor��������");
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
