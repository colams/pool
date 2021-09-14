package cn.colams.dal.mapper;

import cn.colams.dal.entity.WeightHistory;
import cn.colams.dal.entity.WeightHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface WeightHistoryMapper {
    @SelectProvider(type=WeightHistorySqlProvider.class, method="countByExample")
    long countByExample(WeightHistoryExample example);

    @DeleteProvider(type=WeightHistorySqlProvider.class, method="deleteByExample")
    int deleteByExample(WeightHistoryExample example);

    @Delete({
        "delete from weight_history",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into weight_history (id, weight, ",
        "create_date)",
        "values (#{id,jdbcType=INTEGER}, #{weight,jdbcType=DOUBLE}, ",
        "#{createDate,jdbcType=TIMESTAMP})"
    })
    int insert(WeightHistory record);

    @InsertProvider(type=WeightHistorySqlProvider.class, method="insertSelective")
    int insertSelective(WeightHistory record);

    @SelectProvider(type=WeightHistorySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="weight", property="weight", jdbcType=JdbcType.DOUBLE),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<WeightHistory> selectByExampleWithRowbounds(WeightHistoryExample example, RowBounds rowBounds);

    @SelectProvider(type=WeightHistorySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="weight", property="weight", jdbcType=JdbcType.DOUBLE),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<WeightHistory> selectByExample(WeightHistoryExample example);

    @Select({
        "select",
        "id, weight, create_date",
        "from weight_history",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="weight", property="weight", jdbcType=JdbcType.DOUBLE),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.TIMESTAMP)
    })
    WeightHistory selectByPrimaryKey(Integer id);

    @UpdateProvider(type=WeightHistorySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") WeightHistory record, @Param("example") WeightHistoryExample example);

    @UpdateProvider(type=WeightHistorySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") WeightHistory record, @Param("example") WeightHistoryExample example);

    @UpdateProvider(type=WeightHistorySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(WeightHistory record);

    @Update({
        "update weight_history",
        "set weight = #{weight,jdbcType=DOUBLE},",
          "create_date = #{createDate,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(WeightHistory record);
}