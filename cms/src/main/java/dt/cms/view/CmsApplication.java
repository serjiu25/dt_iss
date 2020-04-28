package dt.cms.view;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class CmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CmsApplication.class, args);

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("dt.cms.config");

        System.out.println("SALUT!");

    }

}

