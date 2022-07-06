package spring5.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author Agiroy
 * @date 2022/5/26 19:38
 * @effect
 */

@Configuration
@ComponentScan(basePackages = "spring5.pojo")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SpringConfig {
}
