package cn.colams.dal.mapper.auto;

import cn.colams.dal.entity.BasicConfig;
import cn.colams.dal.entity.BasicConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface BasicConfigMapper {
    @SelectProvider(type=BasicConfigSqlProvider.class, method="countByExample")
    long countByExample(BasicConfigExample example);

    @DeleteProvider(type=BasicConfigSqlProvider.class, method="deleteByExample")
    int deleteByExample(BasicConfigExample example);

    @Delete({
        "delete from basic_config",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into basic_config (id, config_key, ",
        "config_value, datechange_lasttime, ",
        "create_time)",
        "values (#{id,jdbcType=BIGINT}, #{configKey,jdbcType=VARCHAR}, ",
        "#{configValue,jdbcType=VARCHAR}, #{datechangeLasttime,jdbcType=TIMESTAMP}, ",
        "#{createTime,jdbcType=TIMESTAMP})"
    })
    int insert(BasicConfig record);

    @InsertProvider(type=BasicConfigSqlProvider.class, method="insertSelective")
    int insertSelective(BasicConfig record);

    @SelectProvider(type=BasicConfigSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="config_key", property="configKey", jdbcType=JdbcType.VARCHAR),
        @Result(column="config_value", property="configValue", jdbcType=JdbcType.VARCHAR),
        @Result(column="datechange_lasttime", property="datechangeLasttime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<BasicConfig> selectByExampleWithRowbounds(BasicConfigExample example, RowBounds rowBounds);

    @SelectProvider(type=BasicConfigSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="config_key", property="configKey", jdbcType=JdbcType.VARCHAR),
        @Result(column="config_value", property="configValue", jdbcType=JdbcType.VARCHAR),
        @Result(column="datechange_lasttime", property="datechangeLasttime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<BasicConfig> selectByExample(BasicConfigExample example);

    @Select({
        "select",
        "id, config_key, config_value, datechange_lasttime, create_time",
        "from basic_config",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="config_key", property="configKey", jdbcType=JdbcType.VARCHAR),
        @Result(column="config_value", property="configValue", jdbcType=JdbcType.VARCHAR),
        @Result(column="datechange_lasttime", property="datechangeLasttime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    BasicConfig selectByPrimaryKey(Long id);

    @UpdateProvider(type=BasicConfigSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") BasicConfig record, @Param("example") BasicConfigExample example);

    @UpdateProvider(type=BasicConfigSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") BasicConfig record, @Param("example") BasicConfigExample example);

    @UpdateProvider(type=BasicConfigSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(BasicConfig record);

    @Update({
        "update basic_config",
        "set config_key = #{configKey,jdbcType=VARCHAR},",
          "config_value = #{configValue,jdbcType=VARCHAR},",
          "datechange_lasttime = #{datechangeLasttime,jdbcType=TIMESTAMP},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(BasicConfig record);
}