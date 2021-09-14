package cn.colams.biz.ticks;

import cn.colams.dal.entity.TicksEntity;
import cn.colams.dal.entity.TicksEntityExample;
import cn.colams.dal.mapper.TicksEntityMapper;
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
    TicksEntityMapper ticksEntityMapper;


    public List<TicksEntity> list() throws Exception {

        TicksEntityExample example = new TicksEntityExample();
        List<TicksEntity> ticksList = ticksEntityMapper.selectByExample(example);
        return ticksList;
    }

    public Object add() throws Exception {
        TicksEntity ticksEntity = new TicksEntity();
        ticksEntity.setTick(new Date());
        boolean result = ticksEntityMapper.insertSelective(ticksEntity) > 0;
        return result;
    }

    public Object update(TicksEntity data) {
        boolean result = ticksEntityMapper.updateByPrimaryKeySelective(data) > 0;
        return result;
    }
}
