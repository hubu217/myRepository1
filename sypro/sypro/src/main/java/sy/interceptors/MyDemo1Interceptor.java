package sy.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 拦截器: 我的拦截器实例1
 * 
 * @author hb
 * 
 */
public class MyDemo1Interceptor implements HandlerInterceptor {

	private static final Logger logger = Logger.getLogger(MyDemo1Interceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		logger.info("==========================preHandle方法=========================");
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

		logger.info("==========================postHandle方法=========================");

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

		logger.info("==========================afterCompletion方法=========================");

	}

	
	
	
	
	
	
	
	
}
