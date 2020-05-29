package iss.dt.app.web.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;


public class Initializer implements WebApplicationInitializer {

    public void onStartup(ServletContext container) {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.scan("iss.dt.app.web.config");

        ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", new DispatcherServlet(context));
        MultipartConfigElement multipartConfig =  new MultipartConfigElement("C:\\Users\\sergi\\Projects\\Uni\\mpp\\apache-tomcat-9.0.34\\bin\\tmp");
        dispatcher.setMultipartConfig(multipartConfig);

        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/api/*");
    }
}
