package cn.colams.dal.mapper.extension;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface DatabaseMapper {


    @Update("${sql}")
    int executeUpdateSql(@Param("sql") String sql);

    @Select("${sql}")
    List<Map<String, Object>> executeSelectSql(@Param("sql") String sql);

}
