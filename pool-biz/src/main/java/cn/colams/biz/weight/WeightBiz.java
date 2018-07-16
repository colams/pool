package cn.colams.biz.weight;

import cn.colams.dal.entity.TicksEntity;
import cn.colams.dal.entity.TicksEntityExample;
import cn.colams.dal.entity.WeightHistory;
import cn.colams.dal.entity.WeightHistoryExample;
import cn.colams.dal.extension.TicksEntityExtensionDao;
import cn.colams.dal.extension.WeightHistoryExtensionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * Created by zhangzt on 2018/7/4.
 */
@Component
public class WeightBiz {

    @Autowired
    WeightHistoryExtensionDao weightHistoryExtensionDao;

    public List<WeightHistory> list() {
        WeightHistoryExample example = new WeightHistoryExample();
        List<WeightHistory> list = weightHistoryExtensionDao.selectByExample(example);
        return list;
    }

    public boolean insert() {
        WeightHistory weightHistory = new WeightHistory();
        weightHistory.setWeight(50D);
        weightHistory.setCreatedate(new Date());
        boolean result = weightHistoryExtensionDao.insertSelective(weightHistory) > 0;
        return result;
    }
}
