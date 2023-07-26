package cn.colams.dal.mapper.auto;

import cn.colams.dal.entity.Airbnb;
import cn.colams.dal.entity.AirbnbExample;
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
public interface AirbnbMapper {
    @SelectProvider(type=AirbnbSqlProvider.class, method="countByExample")
    long countByExample(AirbnbExample example);

    @DeleteProvider(type=AirbnbSqlProvider.class, method="deleteByExample")
    int deleteByExample(AirbnbExample example);

    @Delete({
        "delete from airbnb",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into airbnb (id, detail_url, ",
        "create_time)",
        "values (#{id,jdbcType=BIGINT}, #{detailUrl,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP})"
    })
    int insert(Airbnb record);

    @InsertProvider(type=AirbnbSqlProvider.class, method="insertSelective")
    int insertSelective(Airbnb record);

    @SelectProvider(type=AirbnbSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="detail_url", property="detailUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Airbnb> selectByExampleWithRowbounds(AirbnbExample example, RowBounds rowBounds);

    @SelectProvider(type=AirbnbSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="detail_url", property="detailUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Airbnb> selectByExample(AirbnbExample example);

    @Select({
        "select",
        "id, detail_url, create_time",
        "from airbnb",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="detail_url", property="detailUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    Airbnb selectByPrimaryKey(Long id);

    @UpdateProvider(type=AirbnbSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Airbnb record, @Param("example") AirbnbExample example);

    @UpdateProvider(type=AirbnbSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Airbnb record, @Param("example") AirbnbExample example);

    @UpdateProvider(type=AirbnbSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Airbnb record);

    @Update({
        "update airbnb",
        "set detail_url = #{detailUrl,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Airbnb record);
}