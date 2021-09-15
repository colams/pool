package cn.colams.biz.ticks;

import cn.colams.dal.entity.Ticks;
import cn.colams.dal.entity.TicksExample;
import cn.colams.dal.mapper.extension.TicksExtensionMapper;
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
    TicksExtensionMapper ticksExtensionMapper;


    public List<Ticks> list() throws Exception {
        TicksExample example = new TicksExample();
        example.setOrderByClause("id");
        List<Ticks> ticksList = ticksExtensionMapper.selectByExample(example);
        return ticksList;
    }

    public Object add() throws Exception {
        Ticks ticksEntity = new Ticks();
        ticksEntity.setTick(new Date());
        boolean result = ticksExtensionMapper.insertSelective(ticksEntity) > 0;
        return result;
    }

    public Object update(Ticks data) {
        boolean result = ticksExtensionMapper.updateByPrimaryKeySelective(data) > 0;
        return result;
    }
}
