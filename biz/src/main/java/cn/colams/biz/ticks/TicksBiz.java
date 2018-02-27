package cn.colams.biz.ticks;

import cn.colams.common.utils.DataSourceBiz;
import cn.colams.model.model.Ticks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangzt on 2018/2/9.
 */
@Component
public class TicksBiz {

    @Autowired
    private DataSourceBiz dataSourceManager;

    public List<Ticks> list() throws Exception {
        DataSource dataSource = dataSourceManager.getHikariDataSource();
        List<Ticks> ticksList = new ArrayList<>();

        try (Connection connection = dataSource.getConnection()) {
            Statement stmt = connection.createStatement();
            // stmt.executeUpdate("INSERT INTO ticks(tick) VALUES (now())");
            ResultSet rs = stmt.executeQuery("SELECT * FROM ticks");


            while (rs.next()) {
                Ticks ticks = new Ticks();

                ticks.setId(rs.getInt("id"));
                ticks.setTick(rs.getTimestamp("tick"));

                ticksList.add(ticks);
            }

        } catch (Exception e) {
            throw e;
        }

        return ticksList;
    }

    public Object add() throws Exception {
        int count = 0;
        DataSource dataSource = dataSourceManager.getHikariDataSource();
        try (Connection connection = dataSource.getConnection()) {
            Statement stmt = connection.createStatement();

            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS ticks (id int PRIMARY KEY , tick TIMESTAMP NOT  NULL )");
            count = stmt.executeUpdate("INSERT INTO ticks(tick) VALUES (now())");


        } catch (Exception e) {
            throw e;
        }

        return count;
    }
}
