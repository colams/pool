package cn.colams.dal.mapper.extension;

import cn.colams.dal.entity.Airbnb;
import cn.colams.dal.entity.AirbnbExample;
import cn.colams.dal.mapper.auto.AirbnbMapper;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

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

    default List<Airbnb> selectRoom2Process(String roomId) {
        AirbnbExample airbnbExample = new AirbnbExample();
        AirbnbExample.Criteria criteria = airbnbExample.createCriteria();
        if (!StringUtils.isEmpty(roomId)) {
            criteria.andRoomIdEqualTo(roomId);
        } else {
            criteria.andDealStatusIn(Lists.newArrayList(0, 2));
        }
        List<Airbnb> airbnbs = selectByExample(airbnbExample);
        return airbnbs;
    }
}
