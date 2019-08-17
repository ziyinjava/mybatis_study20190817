package com.ziyin.ssm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@ComponentScan(value="com.ziyin.ssm.web")
@EnableWebMvc
public class DispatcherConfig extends WebMvcConfigurationSupport   {

    @Autowired
    private PropertiesConfig propertiesConfig;

    @Bean
    public InternalResourceViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setViewClass(JstlView.class);
        internalResourceViewResolver.setPrefix(propertiesConfig.getWebViewPrefix());
        internalResourceViewResolver.setSuffix(propertiesConfig.getWebViewSuffix());
        return internalResourceViewResolver;
    }

    /**
     * 设置统一错误处理要跳转的视图
     *
     * @return
     */
//    @Bean
//    public SimpleMappingExceptionResolver simpleMappingExceptionResolver() {
//        SimpleMappingExceptionResolver simpleMappingExceptionResolver = new SimpleMappingExceptionResolver();
//        Properties properties = new Properties();
//        properties.getProperty("java.lang.Exception", "error");
//        simpleMappingExceptionResolver.setExceptionMappings(properties);
//        return simpleMappingExceptionResolver;
//    }


    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp(propertiesConfig.getWebViewPrefix(),propertiesConfig.getWebViewSuffix());
    }

    /**
     * 添加静态资源
     *
     * @param registry
     */
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler(propertiesConfig.getWebStaticHandler()).addResourceLocations(propertiesConfig.getWebStaticResource()).setCachePeriod(propertiesConfig.getWebStaticCachedPeriod());
//    }




    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /**
     * 添加拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
    }
}