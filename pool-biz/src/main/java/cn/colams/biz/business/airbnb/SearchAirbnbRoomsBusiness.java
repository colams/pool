package cn.colams.biz.business.airbnb;

import cn.colams.common.utils.AssignUtils;
import cn.colams.dal.entity.Airbnb;
import cn.colams.dal.entity.AirbnbExample;
import cn.colams.dal.mapper.extension.AirbnbExtensionMapper;
import cn.colams.model.dto.airbnb.SearchAirbnbRoomsParams;
import cn.colams.model.dto.airbnb.SearchResultWithPage;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Consumer;

@Component
public class SearchAirbnbRoomsBusiness {

    @Autowired
    private AirbnbExtensionMapper airbnbExtensionMapper;

    public SearchResultWithPage<List<Airbnb>> searchAirbnbRooms(SearchAirbnbRoomsParams data) throws ParseException {
        AirbnbExample airbnbExample = buildAirbnbExample(data);
        RowBounds rowBounds = new RowBounds(data.getCurrentPage() * data.getPageSize(), data.getPageSize());
        SearchResultWithPage<List<Airbnb>> result = airbnbExtensionMapper.searchAirbnbRooms(airbnbExample, rowBounds);
        return result;
    }

    /**
     * build airbnb example
     *
     * @param data
     * @return
     * @throws ParseException
     */
    private AirbnbExample buildAirbnbExample(SearchAirbnbRoomsParams data) throws ParseException {
        AirbnbExample airbnbExample = new AirbnbExample();
        airbnbExample.setOrderByClause(" id ");
        AirbnbExample.Criteria criteria = airbnbExample.createCriteria();
        String patterns = "yyyy-MM-dd HH:mm:ss";

        if (StringUtils.isNotBlank(data.getCreateTimeStart())) {
            criteria.andCreateTimeGreaterThan(DateUtils.parseDate(data.getCreateTimeStart(), patterns));
        }

        if (StringUtils.isNotBlank(data.getCreateTimeEnd())) {
            criteria.andCreateTimeLessThan(DateUtils.parseDate(data.getCreateTimeEnd(), patterns));
        }
//        match(data.getCreateTimeStart(), patterns, DateUtils::parseDate, criteria::andCreateTimeGreaterThan);
//        match(data.getCreateTimeEnd(), patterns, DateUtils::parseDate, criteria::andCreateTimeLessThan);
        AssignUtils.stringNotBlankAssign(data.getState(), criteria::andStateEqualTo);
        AssignUtils.stringNotBlankAssign(data.getState(), criteria::andStateEqualTo);
        AssignUtils.stringNotBlankAssign(data.getLordId(), criteria::andLordIdEqualTo);
        AssignUtils.stringNotBlankAssign(data.getRoomId(), criteria::andRoomIdEqualTo);
        return airbnbExample;
    }


}
