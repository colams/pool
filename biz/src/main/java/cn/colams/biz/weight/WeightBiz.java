package cn.colams.biz.weight;

import cn.colams.dal.entity.WeightHistory;
import cn.colams.dal.entity.WeightHistoryExample;
import cn.colams.dal.extension.WeightHistoryExtensionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
        return weightHistoryExtensionDao.selectByExample(example);
    }

    public boolean insert() {
        WeightHistory weightHistory = new WeightHistory();
        weightHistory.setWeight(50D);
        return weightHistoryExtensionDao.insertSelective(weightHistory) > 0;
    }
}
