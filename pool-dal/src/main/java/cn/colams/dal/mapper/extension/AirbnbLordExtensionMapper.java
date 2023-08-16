package cn.colams.dal.mapper.extension;

import cn.colams.dal.entity.AirbnbLord;
import cn.colams.dal.entity.AirbnbLordExample;
import cn.colams.dal.mapper.auto.AirbnbLordMapper;
import cn.colams.model.dto.airbnb.SearchResultWithPage;
import com.google.common.collect.Lists;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

@Repository
public interface AirbnbLordExtensionMapper extends AirbnbLordMapper {

    /**
     * 获取待处理或和处理失败的房东信息
     *
     * @param lordId
     * @return
     */
    default List<AirbnbLord> selectAirbnbLordByStatus(String lordId) {
        AirbnbLordExample example = new AirbnbLordExample();
        AirbnbLordExample.Criteria criteria = example.createCriteria();
        criteria.andProcessStatusIn(Lists.newArrayList(0, 2));
        if (Objects.nonNull(lordId)) {
            criteria.andLoardIdEqualTo(lordId);
        }
        return selectByExample(example);
    }

    default AirbnbLord queryByLoardId(String lordId) {
        AirbnbLordExample example = new AirbnbLordExample();
        AirbnbLordExample.Criteria criteria = example.createCriteria();
        criteria.andLoardIdEqualTo(lordId);
        List<AirbnbLord> airbnbLords = selectByExample(example);
        return CollectionUtils.isEmpty(airbnbLords) ? null : airbnbLords.get(0);
    }

    default SearchResultWithPage<List<AirbnbLord>> searchAirbnbLords(AirbnbLordExample example, RowBounds rowBounds) {
        long totalCount = countByExample(example);
        List<AirbnbLord> list = selectByExampleWithRowbounds(example, rowBounds);
        return SearchResultWithPage.buildEntity(list, totalCount, rowBounds.getLimit());
    }
}
