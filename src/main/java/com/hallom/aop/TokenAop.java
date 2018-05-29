/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.hallom.aop;
import com.hallom.constant.RSAConstant;
import com.hallom.entity.Result;
import com.hallom.utils.AppRedisTemplate;
import com.hallom.utils.RSAUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/**
 *
 * @author wb-cb368615
 * @version $Id: TokenAop.java, v 0.1 2018年04月17日 17:07 wb-cb368615 Exp $
 */
@Component
@Aspect
@EnableAspectJAutoProxy
@ComponentScan
@Slf4j
public class TokenAop implements Serializable{
    private static final String[] passUrl={"login","register","captcha","/app/school/get","/app/image/save"};

    private static final long serialVersionUID = 2434819964990792888L;
    @Autowired
    private AppRedisTemplate redisTemplate;




    /**
     * <li>Before       : 在方法执行前进行切面</li>
     * <li>execution    : 定义切面表达式</li>
     * <p>public * com.eparty.ccp.*.impl..*.*(..)
     *      <li>public :匹配所有目标类的public方法，不写则匹配所有访问权限</li>
     *      <li>第一个* :方法返回值类型，*代表所有类型 </li>
     *      <li>第二个* :包路径的通配符</li>
     *      <li>第三个..* :表示impl这个目录下所有的类，包括子目录的类</li>
     *      <li>第四个*(..) : *表示所有任意方法名,..表示任意参数</li>
     * </p>
     * @param point 切面
     */
    @Around("execution(public * com.hallom.controller..*.*(..))")
    public Object before(ProceedingJoinPoint point) throws Throwable {

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String url=request.getRequestURL().toString();
        AtomicReference<Boolean> b= new AtomicReference<>(true);
        Arrays.stream(passUrl).forEach(s -> {if (url.contains(s)){b.set(false);}});
        if (b.get()) {
            String token = request.getHeader("token");
            if (StringUtils.isEmpty(token)) {
                return Result.fail("token不合法");
            }

            Object object = redisTemplate.get(token);

            if (null == object) {
                return Result.fail("token不合法");
            }
        }
        return point.proceed();

    }
}