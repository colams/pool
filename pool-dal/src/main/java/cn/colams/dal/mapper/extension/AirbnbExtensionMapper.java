package cn.colams.dal.mapper.extension;

import cn.colams.dal.entity.Airbnb;
import cn.colams.dal.entity.AirbnbExample;
import cn.colams.dal.mapper.auto.AirbnbMapper;
import cn.colams.model.dto.airbnb.SearchResultWithPage;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
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
     * @param airbnbExample
     * @param rowBounds
     * @return
     */
    default SearchResultWithPage<List<Airbnb>> searchAirbnbRooms(AirbnbExample airbnbExample, RowBounds rowBounds) {
        long totalCount = countByExample(airbnbExample);
        List<Airbnb> list = selectByExampleWithBLOBsWithRowbounds(airbnbExample, rowBounds);
        return SearchResultWithPage.buildEntity(list, totalCount, rowBounds.getLimit());
    }
}
