package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
//import org.thymeleaf.spring5.SpringTemplateEngine;
//import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
//import org.thymeleaf.spring5.view.ThymeleafViewResolver;
//import org.thymeleaf.templatemode.TemplateMode;
//import org.thymeleaf.templateresolver.ITemplateResolver;
//
/**
 * WebConfig配置
 * 切记：
 *  1. 方式一：
 *     使用@EnableWEbMvc就不能继承自WebMvcConfigurationSupport，因为这个标注
 *     就相当于继承自WebMvcConfigurationSupport类
 *  2. 方式二：
 *     继承自WebMvcConfigurationSupport类就去掉@EnableWebMvc这个标注，之所以继承自
 *     这个类，就是为了处理静态资源
 * @author RanJi
 *
 */
@Configuration
//@EnableWebMvc		
public class WebConfig extends WebMvcConfigurationSupport {
	/**
     * jsp视图解析器的bean
     * @return
     */
    @Bean
    public UrlBasedViewResolver setupViewResolver() {
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        resolver.setPrefix("/WEB-INF/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        //-- 以下两行代码是为了jsp和thymeleaf共存而设置
        resolver.setViewNames("jsp/*");
        resolver.setOrder(1);
        return resolver;
    }
    
    /**
     * STEP 1 - 创建模版解析器
     */
//    @Bean
//    public ITemplateResolver templateResolver() {
//        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
//        templateResolver.setPrefix("/WEB-INF/");
//        templateResolver.setSuffix(".html");
//        templateResolver.setCharacterEncoding("UTF-8");
//        templateResolver.setTemplateMode(TemplateMode.HTML);	//-- thymeleaf3.0配置为html
//        templateResolver.setCacheable(false);	//-- 开发完后记得关闭
//        return templateResolver;
//    }
    
    //-- 以下代码是配置thymeleaf模板引擎
    /**
     * STEP 2 - 创建模版引擎
     * 并为模板引擎注入模板解析器
     */
//    @Bean
//    public SpringTemplateEngine templateEngine() {
//        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//        templateEngine.setTemplateResolver(templateResolver());
//        templateEngine.setEnableSpringELCompiler(true);
//        return templateEngine;
//    }

    /**
     * STEP 3 - 注册 Thymeleaf 视图解析器
     * 并为解析器注入模板引擎
     */
//    @Bean
//    public ThymeleafViewResolver viewResolver(SpringTemplateEngine springTemplateEngine) {
//        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
//        viewResolver.setTemplateEngine(springTemplateEngine);
//        viewResolver.setCharacterEncoding("UTF-8");  
//        //-- 以下两行代码就是为了jsp和thymeleaf共存而设置
//        viewResolver.setViewNames(new String[]{"html/*"});
//        viewResolver.setOrder(2);
//        return viewResolver;
//    }
    //-- 以上代码是配置thymeleaf模板引擎
    
    /**
     * 配置处理静态资源
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
    	registry.addResourceHandler("/assets/**").addResourceLocations("/assets/");
    	super.addResourceHandlers(registry);
    }
    
    /**
     * 解决跨域访问的问题
     */
    @Override
    protected void addCorsMappings(CorsRegistry registry) {
    	registry.addMapping("/**") 		//-- 允许跨域访问的路径
        .allowedOrigins("*")	//-- 允许跨域访问的源
        .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")		//-- 允许请求方法
        .maxAge(168000)	//--  预检间隔时间
        .allowCredentials(true);	//--  是否发送cookie
    	super.addCorsMappings(registry);
    }
}
