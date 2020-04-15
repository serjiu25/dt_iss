package dt.cms.view;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;



public class DatasourceConfig {

    public DataSource datasource() {
        return DataSourceBuilder.create()
                .driverClassName("org.postgresql.Driver")
                .url("jdbc:postgres://chlibsawfldjfk:fa6afd782998e6dd758793297950c5429ea35703eb8923e66926cae66787a71c@ec2-54-247-79-178.eu-west-1.compute.amazonaws.com:5432/dd1qsj7uonb0pb")
                .username("chlibsawfldjfk")
                .password("fa6afd782998e6dd758793297950c5429ea35703eb8923e66926cae66787a71c")
                .build();
    }
}