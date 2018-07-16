package cn.colams.biz.ticks;

import cn.colams.dal.entity.TicksEntity;
import cn.colams.dal.entity.TicksEntityExample;
import cn.colams.dal.extension.TicksEntityExtensionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * Created by zhangzt on 2018/2/9.
 */
@Component
public class TicksBiz {
    @Autowired
    TicksEntityExtensionDao ticksEntityExtensionDao;


    public List<TicksEntity> list() throws Exception {

        TicksEntityExample example = new TicksEntityExample();
        List<TicksEntity> ticksList = ticksEntityExtensionDao.selectByExample(example);


        return ticksList;
    }

    public Object add() throws Exception {
        TicksEntity ticksEntity = new TicksEntity();
        ticksEntity.setTick(new Date());
        boolean result = ticksEntityExtensionDao.insertSelective(ticksEntity) > 0;
        return result;
    }
}
