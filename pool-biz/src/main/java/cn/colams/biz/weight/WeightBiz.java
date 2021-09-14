package cn.colams.biz.weight;

import cn.colams.dal.entity.WeightHistory;
import cn.colams.dal.entity.WeightHistoryExample;
import cn.colams.dal.mapper.WeightHistoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;
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

    public boolean insert() {
        WeightHistory weightHistory = new WeightHistory();
        weightHistory.setWeight(50D);
        weightHistory.setCreateDate(new Date());
        boolean result = weightHistoryMapper.insertSelective(weightHistory) > 0;
        return result;
    }
}
