package cn.colams.dal.mapper.auto;

import cn.colams.dal.entity.Airbnb;
import cn.colams.dal.entity.AirbnbExample;
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
public interface AirbnbMapper {
    @SelectProvider(type=AirbnbSqlProvider.class, method="countByExample")
    long countByExample(AirbnbExample example);

    @DeleteProvider(type=AirbnbSqlProvider.class, method="deleteByExample")
    int deleteByExample(AirbnbExample example);

    @Delete({
        "delete from airbnb",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into airbnb (id, room_id, ",
        "room_name, room_url, ",
        "lord_id, price, room_location, ",
        "status, r_srouce, ",
        "page, org_url, picture_count, ",
        "state, datechange_lasttime, ",
        "create_time, extra)",
        "values (#{id,jdbcType=BIGINT}, #{roomId,jdbcType=VARCHAR}, ",
        "#{roomName,jdbcType=VARCHAR}, #{roomUrl,jdbcType=VARCHAR}, ",
        "#{lordId,jdbcType=VARCHAR}, #{price,jdbcType=VARCHAR}, #{roomLocation,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=INTEGER}, #{rSrouce,jdbcType=INTEGER}, ",
        "#{page,jdbcType=INTEGER}, #{orgUrl,jdbcType=VARCHAR}, #{pictureCount,jdbcType=INTEGER}, ",
        "#{state,jdbcType=VARCHAR}, #{datechangeLasttime,jdbcType=TIMESTAMP}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{extra,jdbcType=LONGVARCHAR})"
    })
    int insert(Airbnb record);

    @InsertProvider(type=AirbnbSqlProvider.class, method="insertSelective")
    int insertSelective(Airbnb record);

    @SelectProvider(type=AirbnbSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="room_id", property="roomId", jdbcType=JdbcType.VARCHAR),
        @Result(column="room_name", property="roomName", jdbcType=JdbcType.VARCHAR),
        @Result(column="room_url", property="roomUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="lord_id", property="lordId", jdbcType=JdbcType.VARCHAR),
        @Result(column="price", property="price", jdbcType=JdbcType.VARCHAR),
        @Result(column="room_location", property="roomLocation", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="r_srouce", property="rSrouce", jdbcType=JdbcType.INTEGER),
        @Result(column="page", property="page", jdbcType=JdbcType.INTEGER),
        @Result(column="org_url", property="orgUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="picture_count", property="pictureCount", jdbcType=JdbcType.INTEGER),
        @Result(column="state", property="state", jdbcType=JdbcType.VARCHAR),
        @Result(column="datechange_lasttime", property="datechangeLasttime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="extra", property="extra", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<Airbnb> selectByExampleWithBLOBsWithRowbounds(AirbnbExample example, RowBounds rowBounds);

    @SelectProvider(type=AirbnbSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="room_id", property="roomId", jdbcType=JdbcType.VARCHAR),
        @Result(column="room_name", property="roomName", jdbcType=JdbcType.VARCHAR),
        @Result(column="room_url", property="roomUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="lord_id", property="lordId", jdbcType=JdbcType.VARCHAR),
        @Result(column="price", property="price", jdbcType=JdbcType.VARCHAR),
        @Result(column="room_location", property="roomLocation", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="r_srouce", property="rSrouce", jdbcType=JdbcType.INTEGER),
        @Result(column="page", property="page", jdbcType=JdbcType.INTEGER),
        @Result(column="org_url", property="orgUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="picture_count", property="pictureCount", jdbcType=JdbcType.INTEGER),
        @Result(column="state", property="state", jdbcType=JdbcType.VARCHAR),
        @Result(column="datechange_lasttime", property="datechangeLasttime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="extra", property="extra", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<Airbnb> selectByExampleWithBLOBs(AirbnbExample example);

    @SelectProvider(type=AirbnbSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="room_id", property="roomId", jdbcType=JdbcType.VARCHAR),
        @Result(column="room_name", property="roomName", jdbcType=JdbcType.VARCHAR),
        @Result(column="room_url", property="roomUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="lord_id", property="lordId", jdbcType=JdbcType.VARCHAR),
        @Result(column="price", property="price", jdbcType=JdbcType.VARCHAR),
        @Result(column="room_location", property="roomLocation", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="r_srouce", property="rSrouce", jdbcType=JdbcType.INTEGER),
        @Result(column="page", property="page", jdbcType=JdbcType.INTEGER),
        @Result(column="org_url", property="orgUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="picture_count", property="pictureCount", jdbcType=JdbcType.INTEGER),
        @Result(column="state", property="state", jdbcType=JdbcType.VARCHAR),
        @Result(column="datechange_lasttime", property="datechangeLasttime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Airbnb> selectByExampleWithRowbounds(AirbnbExample example, RowBounds rowBounds);

    @SelectProvider(type=AirbnbSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="room_id", property="roomId", jdbcType=JdbcType.VARCHAR),
        @Result(column="room_name", property="roomName", jdbcType=JdbcType.VARCHAR),
        @Result(column="room_url", property="roomUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="lord_id", property="lordId", jdbcType=JdbcType.VARCHAR),
        @Result(column="price", property="price", jdbcType=JdbcType.VARCHAR),
        @Result(column="room_location", property="roomLocation", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="r_srouce", property="rSrouce", jdbcType=JdbcType.INTEGER),
        @Result(column="page", property="page", jdbcType=JdbcType.INTEGER),
        @Result(column="org_url", property="orgUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="picture_count", property="pictureCount", jdbcType=JdbcType.INTEGER),
        @Result(column="state", property="state", jdbcType=JdbcType.VARCHAR),
        @Result(column="datechange_lasttime", property="datechangeLasttime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Airbnb> selectByExample(AirbnbExample example);

    @Select({
        "select",
        "id, room_id, room_name, room_url, lord_id, price, room_location, status, r_srouce, ",
        "page, org_url, picture_count, state, datechange_lasttime, create_time, extra",
        "from airbnb",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="room_id", property="roomId", jdbcType=JdbcType.VARCHAR),
        @Result(column="room_name", property="roomName", jdbcType=JdbcType.VARCHAR),
        @Result(column="room_url", property="roomUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="lord_id", property="lordId", jdbcType=JdbcType.VARCHAR),
        @Result(column="price", property="price", jdbcType=JdbcType.VARCHAR),
        @Result(column="room_location", property="roomLocation", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="r_srouce", property="rSrouce", jdbcType=JdbcType.INTEGER),
        @Result(column="page", property="page", jdbcType=JdbcType.INTEGER),
        @Result(column="org_url", property="orgUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="picture_count", property="pictureCount", jdbcType=JdbcType.INTEGER),
        @Result(column="state", property="state", jdbcType=JdbcType.VARCHAR),
        @Result(column="datechange_lasttime", property="datechangeLasttime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="extra", property="extra", jdbcType=JdbcType.LONGVARCHAR)
    })
    Airbnb selectByPrimaryKey(Long id);

    @UpdateProvider(type=AirbnbSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Airbnb record, @Param("example") AirbnbExample example);

    @UpdateProvider(type=AirbnbSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") Airbnb record, @Param("example") AirbnbExample example);

    @UpdateProvider(type=AirbnbSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Airbnb record, @Param("example") AirbnbExample example);

    @UpdateProvider(type=AirbnbSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Airbnb record);

    @Update({
        "update airbnb",
        "set room_id = #{roomId,jdbcType=VARCHAR},",
          "room_name = #{roomName,jdbcType=VARCHAR},",
          "room_url = #{roomUrl,jdbcType=VARCHAR},",
          "lord_id = #{lordId,jdbcType=VARCHAR},",
          "price = #{price,jdbcType=VARCHAR},",
          "room_location = #{roomLocation,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=INTEGER},",
          "r_srouce = #{rSrouce,jdbcType=INTEGER},",
          "page = #{page,jdbcType=INTEGER},",
          "org_url = #{orgUrl,jdbcType=VARCHAR},",
          "picture_count = #{pictureCount,jdbcType=INTEGER},",
          "state = #{state,jdbcType=VARCHAR},",
          "datechange_lasttime = #{datechangeLasttime,jdbcType=TIMESTAMP},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "extra = #{extra,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(Airbnb record);

    @Update({
        "update airbnb",
        "set room_id = #{roomId,jdbcType=VARCHAR},",
          "room_name = #{roomName,jdbcType=VARCHAR},",
          "room_url = #{roomUrl,jdbcType=VARCHAR},",
          "lord_id = #{lordId,jdbcType=VARCHAR},",
          "price = #{price,jdbcType=VARCHAR},",
          "room_location = #{roomLocation,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=INTEGER},",
          "r_srouce = #{rSrouce,jdbcType=INTEGER},",
          "page = #{page,jdbcType=INTEGER},",
          "org_url = #{orgUrl,jdbcType=VARCHAR},",
          "picture_count = #{pictureCount,jdbcType=INTEGER},",
          "state = #{state,jdbcType=VARCHAR},",
          "datechange_lasttime = #{datechangeLasttime,jdbcType=TIMESTAMP},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Airbnb record);
}