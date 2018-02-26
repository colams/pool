package cn.colams.common.setting;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Configuration
@ConfigurationProperties
@PropertySource(value = "classpath:config/db.properties")
public class DbSQLConfig {

    // public String

}
