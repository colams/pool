package cn.colams.dal.mapper.extension;

import cn.colams.dal.entity.Airbnb;
import cn.colams.dal.mapper.auto.AirbnbMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

@Repository
public interface AirbnbExtensionMapper extends AirbnbMapper {

    @Select({
            "select",
            "id, room_id, room_name, room_url, lord_id, price, room_location, deal_status, ",
            "r_srouce, page, org_url, picture_count, area, datechange_lasttime, create_time, ",
            "extra",
            "from airbnb",
            "where room_id = #{roomId,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "room_id", property = "roomId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "room_name", property = "roomName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "room_url", property = "roomUrl", jdbcType = JdbcType.VARCHAR),
            @Result(column = "lord_id", property = "lordId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "price", property = "price", jdbcType = JdbcType.VARCHAR),
            @Result(column = "room_location", property = "roomLocation", jdbcType = JdbcType.VARCHAR),
            @Result(column = "deal_status", property = "dealStatus", jdbcType = JdbcType.INTEGER),
            @Result(column = "r_srouce", property = "rSrouce", jdbcType = JdbcType.INTEGER),
            @Result(column = "page", property = "page", jdbcType = JdbcType.INTEGER),
            @Result(column = "org_url", property = "orgUrl", jdbcType = JdbcType.VARCHAR),
            @Result(column = "picture_count", property = "pictureCount", jdbcType = JdbcType.INTEGER),
            @Result(column = "area", property = "area", jdbcType = JdbcType.VARCHAR),
            @Result(column = "datechange_lasttime", property = "datechangeLasttime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "extra", property = "extra", jdbcType = JdbcType.LONGVARCHAR)
    })
    Airbnb selectByRoomId(String roomId);

    @Insert({
            "insert into airbnb (id, room_id, ",
            "room_name, room_url, ",
            "lord_id, price, room_location, ",
            "deal_status, r_srouce, ",
            "page, org_url, picture_count, ",
            "area, datechange_lasttime, ",
            "create_time, extra)",
            "values (#{id,jdbcType=BIGINT}, #{roomId,jdbcType=VARCHAR}, ",
            "#{roomName,jdbcType=VARCHAR}, #{roomUrl,jdbcType=VARCHAR}, ",
            "#{lordId,jdbcType=VARCHAR}, #{price,jdbcType=VARCHAR}, #{roomLocation,jdbcType=VARCHAR}, ",
            "#{dealStatus,jdbcType=INTEGER}, #{rSrouce,jdbcType=INTEGER}, ",
            "#{page,jdbcType=INTEGER}, #{orgUrl,jdbcType=VARCHAR}, #{pictureCount,jdbcType=INTEGER}, ",
            "#{area,jdbcType=VARCHAR}, #{datechangeLasttime,jdbcType=TIMESTAMP}, ",
            "#{createTime,jdbcType=TIMESTAMP}, #{extra,jdbcType=LONGVARCHAR})",
            "on duplicate key update",
            "lord_id = values(lord_id),",
            "deal_status = values(deal_status)",
    })
    int insertOrUpdate(Airbnb record);


}
