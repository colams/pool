package cn.colams.dal.mapper.auto;

import cn.colams.dal.entity.AirbnbRoomOwner;
import cn.colams.dal.entity.AirbnbRoomOwnerExample;
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
public interface AirbnbRoomOwnerMapper {
    @SelectProvider(type=AirbnbRoomOwnerSqlProvider.class, method="countByExample")
    long countByExample(AirbnbRoomOwnerExample example);

    @DeleteProvider(type=AirbnbRoomOwnerSqlProvider.class, method="deleteByExample")
    int deleteByExample(AirbnbRoomOwnerExample example);

    @Delete({
        "delete from airbnb_room_owner",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into airbnb_room_owner (id, loard_id, ",
        "lord_name, lord_page, ",
        "rooms, airbnb_id, ",
        "process_status, create_time)",
        "values (#{id,jdbcType=BIGINT}, #{loardId,jdbcType=VARCHAR}, ",
        "#{lordName,jdbcType=VARCHAR}, #{lordPage,jdbcType=VARCHAR}, ",
        "#{rooms,jdbcType=INTEGER}, #{airbnbId,jdbcType=BIGINT}, ",
        "#{processStatus,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP})"
    })
    int insert(AirbnbRoomOwner record);

    @InsertProvider(type=AirbnbRoomOwnerSqlProvider.class, method="insertSelective")
    int insertSelective(AirbnbRoomOwner record);

    @SelectProvider(type=AirbnbRoomOwnerSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="loard_id", property="loardId", jdbcType=JdbcType.VARCHAR),
        @Result(column="lord_name", property="lordName", jdbcType=JdbcType.VARCHAR),
        @Result(column="lord_page", property="lordPage", jdbcType=JdbcType.VARCHAR),
        @Result(column="rooms", property="rooms", jdbcType=JdbcType.INTEGER),
        @Result(column="airbnb_id", property="airbnbId", jdbcType=JdbcType.BIGINT),
        @Result(column="process_status", property="processStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<AirbnbRoomOwner> selectByExampleWithRowbounds(AirbnbRoomOwnerExample example, RowBounds rowBounds);

    @SelectProvider(type=AirbnbRoomOwnerSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="loard_id", property="loardId", jdbcType=JdbcType.VARCHAR),
        @Result(column="lord_name", property="lordName", jdbcType=JdbcType.VARCHAR),
        @Result(column="lord_page", property="lordPage", jdbcType=JdbcType.VARCHAR),
        @Result(column="rooms", property="rooms", jdbcType=JdbcType.INTEGER),
        @Result(column="airbnb_id", property="airbnbId", jdbcType=JdbcType.BIGINT),
        @Result(column="process_status", property="processStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<AirbnbRoomOwner> selectByExample(AirbnbRoomOwnerExample example);

    @Select({
        "select",
        "id, loard_id, lord_name, lord_page, rooms, airbnb_id, process_status, create_time",
        "from airbnb_room_owner",
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
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    AirbnbRoomOwner selectByPrimaryKey(Long id);

    @UpdateProvider(type=AirbnbRoomOwnerSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") AirbnbRoomOwner record, @Param("example") AirbnbRoomOwnerExample example);

    @UpdateProvider(type=AirbnbRoomOwnerSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") AirbnbRoomOwner record, @Param("example") AirbnbRoomOwnerExample example);

    @UpdateProvider(type=AirbnbRoomOwnerSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(AirbnbRoomOwner record);

    @Update({
        "update airbnb_room_owner",
        "set loard_id = #{loardId,jdbcType=VARCHAR},",
          "lord_name = #{lordName,jdbcType=VARCHAR},",
          "lord_page = #{lordPage,jdbcType=VARCHAR},",
          "rooms = #{rooms,jdbcType=INTEGER},",
          "airbnb_id = #{airbnbId,jdbcType=BIGINT},",
          "process_status = #{processStatus,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(AirbnbRoomOwner record);
}