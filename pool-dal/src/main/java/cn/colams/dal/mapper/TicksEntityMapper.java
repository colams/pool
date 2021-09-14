package cn.colams.dal.mapper;

import cn.colams.dal.entity.TicksEntity;
import cn.colams.dal.entity.TicksEntityExample;
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
public interface TicksEntityMapper {
    @SelectProvider(type=TicksEntitySqlProvider.class, method="countByExample")
    long countByExample(TicksEntityExample example);

    @DeleteProvider(type=TicksEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(TicksEntityExample example);

    @Delete({
        "delete from ticks",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into ticks (id, tick)",
        "values (#{id,jdbcType=INTEGER}, #{tick,jdbcType=TIMESTAMP})"
    })
    int insert(TicksEntity record);

    @InsertProvider(type=TicksEntitySqlProvider.class, method="insertSelective")
    int insertSelective(TicksEntity record);

    @SelectProvider(type=TicksEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="tick", property="tick", jdbcType=JdbcType.TIMESTAMP)
    })
    List<TicksEntity> selectByExampleWithRowbounds(TicksEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=TicksEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="tick", property="tick", jdbcType=JdbcType.TIMESTAMP)
    })
    List<TicksEntity> selectByExample(TicksEntityExample example);

    @Select({
        "select",
        "id, tick",
        "from ticks",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="tick", property="tick", jdbcType=JdbcType.TIMESTAMP)
    })
    TicksEntity selectByPrimaryKey(Integer id);

    @UpdateProvider(type=TicksEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TicksEntity record, @Param("example") TicksEntityExample example);

    @UpdateProvider(type=TicksEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TicksEntity record, @Param("example") TicksEntityExample example);

    @UpdateProvider(type=TicksEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TicksEntity record);

    @Update({
        "update ticks",
        "set tick = #{tick,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TicksEntity record);
}