package cn.colams.biz.business.weight;

import cn.colams.dal.entity.WeightHistory;
import cn.colams.dal.entity.WeightHistoryExample;
import cn.colams.dal.mapper.extension.WeightHistoryExtensionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by zhangzt on 2018/7/4.
 */
@Component
public class WeightBiz {

    @Autowired
    WeightHistoryExtensionMapper weightHistoryExtensionMapper;

    public List<WeightHistory> list() {
        WeightHistoryExample example = new WeightHistoryExample();
        example.setOrderByClause("id");
        List<WeightHistory> list = weightHistoryExtensionMapper.selectByExample(example);
        return list;
    }

    public boolean insertOrUpdate(WeightHistory weightHistory) {
        if (weightHistory.getWeight() == null) {
            return false;
        }
        boolean result = weightHistoryExtensionMapper.insertOrUpdate(weightHistory) > 0;
        return result;
    }

    public boolean delete(long id) {
        boolean result = weightHistoryExtensionMapper.deleteByPrimaryKey(id) > 0;
        return result;
    }
}