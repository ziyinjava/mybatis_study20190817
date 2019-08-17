package config;


import service.AccountService;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;
import java.util.Set;

@HandlesTypes(value={AccountService.class})
public class MyServletContainerInitializer implements ServletContainerInitializer {
    /**
     * 应用启动的时候，会运行onStartup方法；
     *
     * Set<Class<?>> arg0：感兴趣的类型的所有子类型；
     * ServletContext arg1:代表当前Web应用的ServletContext；一个Web应用一个ServletContext；
     *
     * 1）、使用ServletContext注册Web组件（Servlet、Filter、Listener）
     * 2）、使用编码的方式，在项目启动的时候给ServletContext里面添加组件；
     *     必须在项目启动的时候来添加；
     *     1）、ServletContainerInitializer得到的ServletContext；
     *     2）、ServletContextListener得到的ServletContext；监听器里面注册web组件
     */
    @Override
    public void onStartup(Set<Class<?>> arg0, ServletContext sc) throws ServletException {
       // TODO Auto-generated method stub
       System.out.println("感兴趣的类型：");
       for (Class<?> claz : arg0) {
           System.out.println(claz);
       }

        //https://github.com/alibaba/druid/wiki/%E9%85%8D%E7%BD%AE_StatViewServlet%E9%85%8D%E7%BD%AE
       //注册组件  ServletRegistration
       //配置servlet的映射信息
       //注册Listener
      // sc.addListener(UserListener.class);
       //注册Filter  FilterRegistration
      // FilterRegistration.Dynamic filter = sc.addFilter("userFilter", UserFilter.class);
       //配置Filter的映射信息
     //  filter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
    }
}