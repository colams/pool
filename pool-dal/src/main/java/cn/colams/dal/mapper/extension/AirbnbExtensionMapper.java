package cn.colams.dal.mapper.extension;

import cn.colams.dal.entity.Airbnb;
import cn.colams.dal.entity.AirbnbExample;
import cn.colams.dal.mapper.auto.AirbnbMapper;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Repository
public interface AirbnbExtensionMapper extends AirbnbMapper {
    default Airbnb selectByRoomId(String roomId) {
        AirbnbExample example = new AirbnbExample();
        AirbnbExample.Criteria criteria = example.createCriteria();
        criteria.andRoomIdEqualTo(roomId);
        List<Airbnb> airbnbs = selectByExample(example);
        return CollectionUtils.isEmpty(airbnbs) ? null : airbnbs.get(0);
    }

    @Insert({
            "insert into airbnb (id, room_id, ",
            "room_name, room_url, ",
            "lord_id, price, room_location, ",
            "deal_status, r_srouce, ",
            "page, org_url, picture_count, ",
            "r_state, datechange_lasttime, ",
            "create_time, extra)",
            "values (#{id,jdbcType=BIGINT}, #{roomId,jdbcType=VARCHAR}, ",
            "#{roomName,jdbcType=VARCHAR}, #{roomUrl,jdbcType=VARCHAR}, ",
            "#{lordId,jdbcType=VARCHAR}, #{price,jdbcType=VARCHAR}, #{roomLocation,jdbcType=VARCHAR}, ",
            "#{dealStatus,jdbcType=INTEGER}, #{rSrouce,jdbcType=INTEGER}, ",
            "#{page,jdbcType=INTEGER}, #{orgUrl,jdbcType=VARCHAR}, #{pictureCount,jdbcType=INTEGER}, ",
            "#{rState,jdbcType=VARCHAR}, #{datechangeLasttime,jdbcType=TIMESTAMP}, ",
            "#{createTime,jdbcType=TIMESTAMP}, #{extra,jdbcType=LONGVARCHAR})",
            "on duplicate key update",
            "lord_id = values(lord_id),",
            "deal_status = values(deal_status)",
    })
    int insertOrUpdate(Airbnb record);


}
