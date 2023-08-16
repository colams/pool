package cn.colams.biz.business.airbnb;

import cn.colams.dal.entity.AirbnbLord;
import cn.colams.dal.entity.AirbnbLordExample;
import cn.colams.dal.mapper.extension.AirbnbLordExtensionMapper;
import cn.colams.model.dto.airbnb.SearchAirbnbLordParams;
import cn.colams.model.dto.airbnb.SearchResultWithPage;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.List;

@Component
public class SearchAirbnbLordBusiness {

    @Autowired
    private AirbnbLordExtensionMapper lordExtensionMapper;


    public SearchResultWithPage<List<AirbnbLord>> searchAirbnbLord(SearchAirbnbLordParams params) throws ParseException {
        AirbnbLordExample example = buildAirbnbLordExample(params);
        RowBounds rowBounds = new RowBounds(params.getCurrentPage() * params.getPageSize(), params.getPageSize());
        SearchResultWithPage<List<AirbnbLord>> result = lordExtensionMapper.searchAirbnbLords(example, rowBounds);
        return result;
    }

    private AirbnbLordExample buildAirbnbLordExample(SearchAirbnbLordParams data) throws ParseException {
        AirbnbLordExample airbnbLordExample = new AirbnbLordExample();
        airbnbLordExample.setOrderByClause(" id ");
        AirbnbLordExample.Criteria criteria = airbnbLordExample.createCriteria();

        if (StringUtils.isNotBlank(data.getState())) {
            criteria.andCityEqualTo(data.getState());
        }

        if (StringUtils.isNotBlank(data.getCreateTimeStart())) {
            criteria.andCreateTimeGreaterThan(DateUtils.parseDate(data.getCreateTimeStart(), "yyyy-MM-dd HH:mm:ss"));
        }

        if (StringUtils.isNotBlank(data.getCreateTimeEnd())) {
            criteria.andCreateTimeLessThan(DateUtils.parseDate(data.getCreateTimeEnd(), "yyyy-MM-dd HH:mm:ss"));
        }

        if (StringUtils.isNotBlank(data.getLord())) {
            criteria.andLoardIdEqualTo(data.getLord());
        }

        return airbnbLordExample;
    }

}
