package dt.cms.view;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import dt.cms.domain.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class CmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CmsApplication.class, args);
        //AnnotationConfigApplicationContext context =
               // new AnnotationConfigApplicationContext("dt.cms");
        System.out.println("SALUT!");
        User user=User.builder().name("Tudor")
                                .admin(true)
                                .affiliation("MAFIA_ARAD")
                                .email("sefii.com")
                                .id(1)
                                .password("sefu")
                                .validated(true)
                                .build();
        System.out.println(user.toString());



    }

}

