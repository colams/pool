package cn.colams.dal.mapper.extension;

import cn.colams.dal.entity.WeightHistory;
import cn.colams.dal.mapper.auto.WeightHistoryMapper;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

@Repository
public interface WeightHistoryExtensionMapper extends WeightHistoryMapper {

    @Insert({
            "insert into weight_history (id, weight, ",
            "create_date)",
            "values (#{id,jdbcType=BIGINT}, #{weight,jdbcType=DOUBLE}, ",
            "#{createDate,jdbcType=TIMESTAMP})",
            "on duplicate key update",
            "weight = values(weight)"
    })
    int insertOrUpdate(WeightHistory record);
}
