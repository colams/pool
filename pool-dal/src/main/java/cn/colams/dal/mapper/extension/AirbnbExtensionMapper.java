package cn.colams.dal.mapper.extension;

import cn.colams.dal.entity.Airbnb;
import cn.colams.dal.entity.AirbnbExample;
import cn.colams.dal.mapper.auto.AirbnbMapper;
import cn.colams.model.dto.airbnb.SearchAirbnbRoomsParams;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.text.ParseException;
import java.util.List;
import java.util.Objects;

@Repository
public interface AirbnbExtensionMapper extends AirbnbMapper {
    default Airbnb selectByRoomId(String roomId) {
        AirbnbExample example = new AirbnbExample();
        AirbnbExample.Criteria criteria = example.createCriteria();
        criteria.andRoomIdEqualTo(roomId);
        List<Airbnb> airbnbs = selectByExample(example);
        return CollectionUtils.isEmpty(airbnbs) ? null : airbnbs.get(0);
    }

    default List<Airbnb> selectRoom2Process(String roomId) {
        AirbnbExample airbnbExample = new AirbnbExample();
        AirbnbExample.Criteria criteria = airbnbExample.createCriteria();
        if (!StringUtils.isEmpty(roomId)) {
            criteria.andRoomIdEqualTo(roomId);
        } else {
            criteria.andStatusIn(Lists.newArrayList(0, 2, 4));
        }
        List<Airbnb> airbnbs = selectByExample(airbnbExample);
        return airbnbs;
    }

    default List<Airbnb> selectAllRooms(String roomId) {
        AirbnbExample airbnbExample = new AirbnbExample();
        AirbnbExample.Criteria criteria = airbnbExample.createCriteria();
        if (!StringUtils.isEmpty(roomId)) {
            criteria.andRoomIdEqualTo(roomId);
        } else {
            criteria.andStatusNotEqualTo(3);
            criteria.andLordIdNotEqualTo("");
            criteria.andStateNotEqualTo("1");
        }
        List<Airbnb> airbnbs = selectByExample(airbnbExample);
        return airbnbs;
    }

    /**
     * 获取
     *
     * @param data
     * @return
     */
    default List<Airbnb> searchAirbnbRooms(SearchAirbnbRoomsParams data) throws ParseException {
        AirbnbExample airbnbExample = new AirbnbExample();
        AirbnbExample.Criteria criteria = airbnbExample.createCriteria();
        if (StringUtils.isNotBlank(data.getState())) {
            criteria.andStateEqualTo(data.getState());
        }

        if (StringUtils.isNotBlank(data.getCreateTimeStart())) {
            criteria.andCreateTimeGreaterThan(DateUtils.parseDate(data.getCreateTimeStart(), "yyyy-MM-dd HH:mm:ss"));
        }

        if (StringUtils.isNotBlank(data.getCreateTimeEnd())) {
            criteria.andCreateTimeLessThan(DateUtils.parseDate(data.getCreateTimeEnd(), "yyyy-MM-dd HH:mm:ss"));
        }

        if (StringUtils.isNotBlank(data.getLord())) {
            criteria.andLordIdEqualTo(data.getLord());
        }



        return selectByExampleWithBLOBs(airbnbExample);
    }
}
