package cn.colams.web.controller.api;

import cn.colams.biz.weight.WeightBiz;
import cn.colams.dal.entity.WeightHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by zhangzt on 2018/7/4.
 */
@RestController
@RequestMapping("api/weight")
public class WeightController {


    @Autowired
    public WeightBiz weightBiz;

    @ResponseBody
    @GetMapping("list")
    public List<WeightHistory> list() throws Exception {
        return weightBiz.list();
    }

    @ResponseBody
    @PostMapping("addOrUpdate")
    public Object addOrUpdate(@RequestBody WeightHistory data) throws Exception {
        if (data == null || data.getWeight() == null) {
            return "parameter error";
        }
        if (data.getId() == null) {
            return weightBiz.insert(data);
        } else {
            return weightBiz.update(data);
        }
    }

    @ResponseBody
    @PostMapping("delete")
    public Object delete(@RequestBody WeightHistory data) throws Exception {
        if (data == null || data.getId() == null) {
            return "parameter error";
        }
        return weightBiz.delete(data.getId());
    }
}
