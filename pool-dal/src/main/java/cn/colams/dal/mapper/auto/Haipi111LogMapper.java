package cn.colams.dal.mapper.auto;

import cn.colams.dal.entity.Haipi111Log;
import cn.colams.dal.entity.Haipi111LogExample;
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
public interface Haipi111LogMapper {
    @SelectProvider(type=Haipi111LogSqlProvider.class, method="countByExample")
    long countByExample(Haipi111LogExample example);

    @DeleteProvider(type=Haipi111LogSqlProvider.class, method="deleteByExample")
    int deleteByExample(Haipi111LogExample example);

    @Delete({
        "delete from haipi111_log",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into haipi111_log (id, requestdata, ",
        "responsedata, create_date)",
        "values (#{id,jdbcType=INTEGER}, #{requestdata,jdbcType=VARCHAR}, ",
        "#{responsedata,jdbcType=VARCHAR}, #{createDate,jdbcType=TIMESTAMP})"
    })
    int insert(Haipi111Log record);

    @InsertProvider(type=Haipi111LogSqlProvider.class, method="insertSelective")
    int insertSelective(Haipi111Log record);

    @SelectProvider(type=Haipi111LogSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="requestdata", property="requestdata", jdbcType=JdbcType.VARCHAR),
        @Result(column="responsedata", property="responsedata", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Haipi111Log> selectByExampleWithRowbounds(Haipi111LogExample example, RowBounds rowBounds);

    @SelectProvider(type=Haipi111LogSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="requestdata", property="requestdata", jdbcType=JdbcType.VARCHAR),
        @Result(column="responsedata", property="responsedata", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Haipi111Log> selectByExample(Haipi111LogExample example);

    @Select({
        "select",
        "id, requestdata, responsedata, create_date",
        "from haipi111_log",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="requestdata", property="requestdata", jdbcType=JdbcType.VARCHAR),
        @Result(column="responsedata", property="responsedata", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.TIMESTAMP)
    })
    Haipi111Log selectByPrimaryKey(Integer id);

    @UpdateProvider(type=Haipi111LogSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Haipi111Log record, @Param("example") Haipi111LogExample example);

    @UpdateProvider(type=Haipi111LogSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Haipi111Log record, @Param("example") Haipi111LogExample example);

    @UpdateProvider(type=Haipi111LogSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Haipi111Log record);

    @Update({
        "update haipi111_log",
        "set requestdata = #{requestdata,jdbcType=VARCHAR},",
          "responsedata = #{responsedata,jdbcType=VARCHAR},",
          "create_date = #{createDate,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Haipi111Log record);
}