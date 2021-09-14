package cn.colams.biz.weight;

import cn.colams.dal.entity.WeightHistory;
import cn.colams.dal.entity.WeightHistoryExample;
import cn.colams.dal.mapper.WeightHistoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by zhangzt on 2018/7/4.
 */
@Component
public class WeightBiz {

    @Autowired
    WeightHistoryMapper weightHistoryMapper;

    public List<WeightHistory> list() {
        WeightHistoryExample example = new WeightHistoryExample();
        List<WeightHistory> list = weightHistoryMapper.selectByExample(example);
        return list;
    }

    public boolean insert(WeightHistory weightHistory) {
        if (weightHistory.getWeight() == null) {
            return false;
        }
        boolean result = weightHistoryMapper.insertSelective(weightHistory) > 0;
        return result;
    }

    public boolean update(WeightHistory weightHistory) {
        if (weightHistory.getWeight() == null) {
            return false;
        }
        boolean result = weightHistoryMapper.updateByPrimaryKeySelective(weightHistory) > 0;
        return result;
    }
}
