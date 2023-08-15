package cn.colams.dal.mapper.extension;

import cn.colams.common.utils.CommonUtils;
import cn.colams.dal.entity.Airbnb;
import cn.colams.dal.entity.AirbnbExample;
import cn.colams.dal.mapper.auto.AirbnbMapper;
import cn.colams.model.dto.airbnb.SearchAirbnbRoomsParams;
import cn.colams.model.dto.airbnb.SearchResultWithPage;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.text.ParseException;
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
     * 获取
     *
     * @param data
     * @return
     */
    default SearchResultWithPage<List<Airbnb>> searchAirbnbRooms(SearchAirbnbRoomsParams data) throws ParseException {
        AirbnbExample airbnbExample = new AirbnbExample();
        airbnbExample.setOrderByClause(" id ");
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

        RowBounds rowBounds = new RowBounds(data.getCurrentPage() * data.getPageSize(), data.getPageSize());

        long totalCount = countByExample(airbnbExample);
        List<Airbnb> airbnbs = selectByExampleWithBLOBsWithRowbounds(airbnbExample, rowBounds);
        SearchResultWithPage<List<Airbnb>> searchResult = new SearchResultWithPage<>();
        searchResult.setData(airbnbs);
        searchResult.setTotalCount(totalCount);
        searchResult.setTotalPages(CommonUtils.aggregationInter(totalCount, data.getPageSize()));
        return searchResult;
    }
}
