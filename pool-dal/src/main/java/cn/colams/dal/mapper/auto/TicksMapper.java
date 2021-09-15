package cn.colams.dal.mapper.auto;

import cn.colams.dal.entity.Ticks;
import cn.colams.dal.entity.TicksExample;
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
public interface TicksMapper {
    @SelectProvider(type=TicksSqlProvider.class, method="countByExample")
    long countByExample(TicksExample example);

    @DeleteProvider(type=TicksSqlProvider.class, method="deleteByExample")
    int deleteByExample(TicksExample example);

    @Delete({
        "delete from ticks",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into ticks (id, tick)",
        "values (#{id,jdbcType=INTEGER}, #{tick,jdbcType=TIMESTAMP})"
    })
    int insert(Ticks record);

    @InsertProvider(type=TicksSqlProvider.class, method="insertSelective")
    int insertSelective(Ticks record);

    @SelectProvider(type=TicksSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="tick", property="tick", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Ticks> selectByExampleWithRowbounds(TicksExample example, RowBounds rowBounds);

    @SelectProvider(type=TicksSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="tick", property="tick", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Ticks> selectByExample(TicksExample example);

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
    Ticks selectByPrimaryKey(Integer id);

    @UpdateProvider(type=TicksSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Ticks record, @Param("example") TicksExample example);

    @UpdateProvider(type=TicksSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Ticks record, @Param("example") TicksExample example);

    @UpdateProvider(type=TicksSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Ticks record);

    @Update({
        "update ticks",
        "set tick = #{tick,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Ticks record);
}