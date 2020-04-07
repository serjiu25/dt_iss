package dt.cms.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
/*
import ro.ubb.donation.core.service.RoleService;
import ro.ubb.donation.core.service.RoleServiceImpl;
import ro.ubb.donation.core.service.UserService;
import ro.ubb.donation.core.service.UserServiceImpl;

 */

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;


/*
@Configuration
@EnableJpaRepositories({"dt.cms.repository"})
@EnableTransactionManagement
@EnableCaching

 */
public class JpaConfig {
    //@Value("${db.jdbcUrl}")
    private String jdbcUrl =  "jdbc:postgresql://localhost:5432/cms";

    //@Value("${db.username}")
    private String username = "postgres";

    //@Value("${db.password}")
    private String password = "1234";

    //@Value("${db.generateDDL}")
    private Boolean generateDDL=true;


    /**
     * http://www.baeldung.com/hikaricp
     *
     * @return
     */

    //@Bean
    public DataSource datasource() {
        return DataSourceBuilder.create()
                .driverClassName("org.postgresql.Driver")
                .url("jdbc:postgresql://localhost:5432/cms")
                .username("postgres")
                .password("1234")
                .build();
    }



    public EntityManagerFactory entityManagerFactory() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabase(Database.POSTGRESQL);
        vendorAdapter.setShowSql(true);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("dt.cms.domain");
        factory.setDataSource(datasource());
        factory.afterPropertiesSet();
        return factory.getObject();
    }


    public EntityManager entityManager() {
        return entityManagerFactory().createEntityManager();
    }


    PlatformTransactionManager transactionManager() {
        JpaTransactionManager manager = new JpaTransactionManager();
        manager.setEntityManagerFactory(entityManagerFactory());
        return manager;
    }


    public HibernateExceptionTranslator hibernateExceptionTranslator() {
        return new HibernateExceptionTranslator();
    }
}