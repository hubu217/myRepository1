package sy.interceptors;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import sy.pageModel.SessionInfo;
import sy.util.ConfigUtil;

/**
 * 权限拦截器
 * 
 * @author 孙宇
 * 
 */
public class SecurityInterceptor implements HandlerInterceptor {

	private static final Logger logger = Logger.getLogger(SecurityInterceptor.class);

	private List<String> excludeUrls;// 不需要拦截的资源
	private List<String> excludeUrls2;// 不需要拦截的资源2 ; 测试 此 变量 是怎么来的  : 是从  mvc:interceptor 标签 中  子标签 property标签中读取的 name 属性值
	

	public List<String> getExcludeUrls2() {
		return excludeUrls2;
	}

	public void setExcludeUrls2(List<String> excludeUrls2) {
		this.excludeUrls2 = excludeUrls2;
	}

	public List<String> getExcludeUrls() {
		return excludeUrls;
	}

	public void setExcludeUrls(List<String> excludeUrls) {
		this.excludeUrls = excludeUrls;
	}

	/**
	 * 完成页面的render后调用
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception exception) throws Exception {
		
		logger.info("===============================afterCompletion方法===============================");

	}

	/**
	 * 在调用controller具体方法后拦截
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView modelAndView) throws Exception {
		
		logger.info("===============================postHandle方法===============================");

	}

	/**
	 * 在调用controller具体方法前拦截
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {

		logger.info("===============================preHandle方法=======start========================");
		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String url = requestUri.substring(contextPath.length());
		// logger.info(url);

		if (url.indexOf("/baseController/") > -1 || excludeUrls.contains(url)) {// 如果要访问的资源是不需要验证的
			return true;
		}

		SessionInfo sessionInfo = (SessionInfo) request.getSession().getAttribute(ConfigUtil.getSessionInfoName());
		if (sessionInfo == null || sessionInfo.getId().equalsIgnoreCase("")) {// 如果没有登录或登录超时
			request.setAttribute("msg", "您还没有登录或登录已超时，请重新登录，然后再刷新本功能！");
			request.getRequestDispatcher("/error/noSession.jsp").forward(request, response);
			return false;
		}

		if (!sessionInfo.getResourceList().contains(url)) {// 如果当前用户没有访问此资源的权限
			request.setAttribute("msg", "您没有访问此资源的权限！<br/>请联系超管赋予您<br/>[" + url + "]<br/>的资源访问权限！");
			request.getRequestDispatcher("/error/noSecurity.jsp").forward(request, response);
			return false;
		}
		logger.info("===============================preHandle方法=======end========================");

		return true;
	}
}
