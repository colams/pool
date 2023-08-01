package cn.colams.dal.mapper.auto;

import cn.colams.dal.entity.AirbnbLord;
import cn.colams.dal.entity.AirbnbLordExample;
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
public interface AirbnbLordMapper {
    @SelectProvider(type=AirbnbLordSqlProvider.class, method="countByExample")
    long countByExample(AirbnbLordExample example);

    @DeleteProvider(type=AirbnbLordSqlProvider.class, method="deleteByExample")
    int deleteByExample(AirbnbLordExample example);

    @Delete({
        "delete from airbnb_lord",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into airbnb_lord (id, loard_id, ",
        "lord_name, lord_page, ",
        "rooms, airbnb_id, ",
        "process_status, evaluate, ",
        "brief, create_time)",
        "values (#{id,jdbcType=BIGINT}, #{loardId,jdbcType=VARCHAR}, ",
        "#{lordName,jdbcType=VARCHAR}, #{lordPage,jdbcType=VARCHAR}, ",
        "#{rooms,jdbcType=INTEGER}, #{airbnbId,jdbcType=BIGINT}, ",
        "#{processStatus,jdbcType=INTEGER}, #{evaluate,jdbcType=VARCHAR}, ",
        "#{brief,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP})"
    })
    int insert(AirbnbLord record);

    @InsertProvider(type=AirbnbLordSqlProvider.class, method="insertSelective")
    int insertSelective(AirbnbLord record);

    @SelectProvider(type=AirbnbLordSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="loard_id", property="loardId", jdbcType=JdbcType.VARCHAR),
        @Result(column="lord_name", property="lordName", jdbcType=JdbcType.VARCHAR),
        @Result(column="lord_page", property="lordPage", jdbcType=JdbcType.VARCHAR),
        @Result(column="rooms", property="rooms", jdbcType=JdbcType.INTEGER),
        @Result(column="airbnb_id", property="airbnbId", jdbcType=JdbcType.BIGINT),
        @Result(column="process_status", property="processStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="evaluate", property="evaluate", jdbcType=JdbcType.VARCHAR),
        @Result(column="brief", property="brief", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<AirbnbLord> selectByExampleWithRowbounds(AirbnbLordExample example, RowBounds rowBounds);

    @SelectProvider(type=AirbnbLordSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="loard_id", property="loardId", jdbcType=JdbcType.VARCHAR),
        @Result(column="lord_name", property="lordName", jdbcType=JdbcType.VARCHAR),
        @Result(column="lord_page", property="lordPage", jdbcType=JdbcType.VARCHAR),
        @Result(column="rooms", property="rooms", jdbcType=JdbcType.INTEGER),
        @Result(column="airbnb_id", property="airbnbId", jdbcType=JdbcType.BIGINT),
        @Result(column="process_status", property="processStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="evaluate", property="evaluate", jdbcType=JdbcType.VARCHAR),
        @Result(column="brief", property="brief", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<AirbnbLord> selectByExample(AirbnbLordExample example);

    @Select({
        "select",
        "id, loard_id, lord_name, lord_page, rooms, airbnb_id, process_status, evaluate, ",
        "brief, create_time",
        "from airbnb_lord",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="loard_id", property="loardId", jdbcType=JdbcType.VARCHAR),
        @Result(column="lord_name", property="lordName", jdbcType=JdbcType.VARCHAR),
        @Result(column="lord_page", property="lordPage", jdbcType=JdbcType.VARCHAR),
        @Result(column="rooms", property="rooms", jdbcType=JdbcType.INTEGER),
        @Result(column="airbnb_id", property="airbnbId", jdbcType=JdbcType.BIGINT),
        @Result(column="process_status", property="processStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="evaluate", property="evaluate", jdbcType=JdbcType.VARCHAR),
        @Result(column="brief", property="brief", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    AirbnbLord selectByPrimaryKey(Long id);

    @UpdateProvider(type=AirbnbLordSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") AirbnbLord record, @Param("example") AirbnbLordExample example);

    @UpdateProvider(type=AirbnbLordSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") AirbnbLord record, @Param("example") AirbnbLordExample example);

    @UpdateProvider(type=AirbnbLordSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(AirbnbLord record);

    @Update({
        "update airbnb_lord",
        "set loard_id = #{loardId,jdbcType=VARCHAR},",
          "lord_name = #{lordName,jdbcType=VARCHAR},",
          "lord_page = #{lordPage,jdbcType=VARCHAR},",
          "rooms = #{rooms,jdbcType=INTEGER},",
          "airbnb_id = #{airbnbId,jdbcType=BIGINT},",
          "process_status = #{processStatus,jdbcType=INTEGER},",
          "evaluate = #{evaluate,jdbcType=VARCHAR},",
          "brief = #{brief,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(AirbnbLord record);
}