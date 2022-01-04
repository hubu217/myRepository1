/*
 * package sy.demo;
 * 
 * 
 * 
 * 
 * 
 * import java.util.HashMap;
 * 
 * import java.util.Map;
 * 
 * 
 * 
 * import javax.servlet.http.HttpServletRequest;
 * 
 * 
 * 
 * import org.apache.commons.lang3.StringUtils;
 * 
 * import org.aspectj.lang.ProceedingJoinPoint;
 * 
 * import org.aspectj.lang.annotation.Around;
 * 
 * import org.aspectj.lang.annotation.Aspect;
 * 
 * import org.springframework.beans.factory.annotation.Value;
 * 
 * import org.springframework.stereotype.Component;
 * 
 * import org.springframework.web.context.request.RequestContextHolder;
 * 
 * import org.springframework.web.context.request.ServletRequestAttributes;
 * 
 * 
 * 
 * import com.alibaba.fastjson.JSON;
 * 
 * 
 * 
 * import lombok.extern.slf4j.Slf4j;
 * 
 * 
 * 
 * @Aspect
 * 
 * @Component
 * 
 * @Slf4j
 * 
 * public class CacheOprAop {
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * @Value("${cacheOprSign:pwd123456}")
 * 
 * private String cacheOprSign;
 * 
 * 
 * 
 * @Around("execution(* com.pingan.heb.smt.domain.auth.controller.CacheOperationController.*(..))"
 * )
 * 
 * public Object configValid(ProceedingJoinPoint joinPoint) {
 * 
 * 
 * 
 * Map<String,String> map = new HashMap<String,String>();
 * 
 * try {
 * 
 * HttpServletRequest request = ((ServletRequestAttributes)
 * RequestContextHolder.getRequestAttributes()).getRequest();
 * 
 * String headerSign = request.getHeader("sign");
 * 
 * if (StringUtils.isBlank(headerSign) || !headerSign.equals(cacheOprSign)) {
 * 
 * map.put("fail", "sign签名不对");
 * 
 * return JSON.toJSONString(map);
 * 
 * }
 * 
 * return joinPoint.proceed(joinPoint.getArgs());
 * 
 * } catch (Throwable throwable) {
 * 
 * log.error("设置配置报错：", throwable);
 * 
 * map.put("fail", "设置配置报错");
 * 
 * 
 * 
 * return JSON.toJSONString(map);
 * 
 * }
 * 
 * }
 * 
 * }
 * 
 * 
 * 
 */