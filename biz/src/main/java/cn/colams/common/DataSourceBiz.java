package cn.colams.common;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DataSourceBiz {

    @Value("${spring.datasource.url}")
    private String dbUrl;

    private HikariDataSource hikariDataSource;

    public HikariDataSource getHikariDataSource() throws Exception {

        if (hikariDataSource != null) {
            return hikariDataSource;
        }

        if (dbUrl == null || dbUrl.isEmpty()) {
            throw new Exception("未读取到数据库配置文件信息");
        } else {
            HikariConfig config = new HikariConfig();
            config.setJdbcUrl(dbUrl);
            hikariDataSource = new HikariDataSource(config);
        }
        return hikariDataSource;
    }
}
