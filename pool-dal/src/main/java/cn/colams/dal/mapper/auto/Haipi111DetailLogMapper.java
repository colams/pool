package cn.colams.dal.mapper.auto;

import cn.colams.dal.entity.Haipi111DetailLog;
import cn.colams.dal.entity.Haipi111DetailLogExample;
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
public interface Haipi111DetailLogMapper {
    @SelectProvider(type=Haipi111DetailLogSqlProvider.class, method="countByExample")
    long countByExample(Haipi111DetailLogExample example);

    @DeleteProvider(type=Haipi111DetailLogSqlProvider.class, method="deleteByExample")
    int deleteByExample(Haipi111DetailLogExample example);

    @Delete({
        "delete from haipi111_detail_log",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into haipi111_detail_log (id, \"uid\", ",
        "infoid, \"action\", ",
        "requestdata, responsedata, ",
        "create_date)",
        "values (#{id,jdbcType=INTEGER}, #{uid,jdbcType=VARCHAR}, ",
        "#{infoid,jdbcType=VARCHAR}, #{action,jdbcType=VARCHAR}, ",
        "#{requestdata,jdbcType=VARCHAR}, #{responsedata,jdbcType=VARCHAR}, ",
        "#{createDate,jdbcType=TIMESTAMP})"
    })
    int insert(Haipi111DetailLog record);

    @InsertProvider(type=Haipi111DetailLogSqlProvider.class, method="insertSelective")
    int insertSelective(Haipi111DetailLog record);

    @SelectProvider(type=Haipi111DetailLogSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="uid", property="uid", jdbcType=JdbcType.VARCHAR),
        @Result(column="infoid", property="infoid", jdbcType=JdbcType.VARCHAR),
        @Result(column="action", property="action", jdbcType=JdbcType.VARCHAR),
        @Result(column="requestdata", property="requestdata", jdbcType=JdbcType.VARCHAR),
        @Result(column="responsedata", property="responsedata", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Haipi111DetailLog> selectByExampleWithRowbounds(Haipi111DetailLogExample example, RowBounds rowBounds);

    @SelectProvider(type=Haipi111DetailLogSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="uid", property="uid", jdbcType=JdbcType.VARCHAR),
        @Result(column="infoid", property="infoid", jdbcType=JdbcType.VARCHAR),
        @Result(column="action", property="action", jdbcType=JdbcType.VARCHAR),
        @Result(column="requestdata", property="requestdata", jdbcType=JdbcType.VARCHAR),
        @Result(column="responsedata", property="responsedata", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Haipi111DetailLog> selectByExample(Haipi111DetailLogExample example);

    @Select({
        "select",
        "id, \"uid\", infoid, \"action\", requestdata, responsedata, create_date",
        "from haipi111_detail_log",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="uid", property="uid", jdbcType=JdbcType.VARCHAR),
        @Result(column="infoid", property="infoid", jdbcType=JdbcType.VARCHAR),
        @Result(column="action", property="action", jdbcType=JdbcType.VARCHAR),
        @Result(column="requestdata", property="requestdata", jdbcType=JdbcType.VARCHAR),
        @Result(column="responsedata", property="responsedata", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.TIMESTAMP)
    })
    Haipi111DetailLog selectByPrimaryKey(Integer id);

    @UpdateProvider(type=Haipi111DetailLogSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Haipi111DetailLog record, @Param("example") Haipi111DetailLogExample example);

    @UpdateProvider(type=Haipi111DetailLogSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Haipi111DetailLog record, @Param("example") Haipi111DetailLogExample example);

    @UpdateProvider(type=Haipi111DetailLogSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Haipi111DetailLog record);

    @Update({
        "update haipi111_detail_log",
        "set \"uid\" = #{uid,jdbcType=VARCHAR},",
          "infoid = #{infoid,jdbcType=VARCHAR},",
          "\"action\" = #{action,jdbcType=VARCHAR},",
          "requestdata = #{requestdata,jdbcType=VARCHAR},",
          "responsedata = #{responsedata,jdbcType=VARCHAR},",
          "create_date = #{createDate,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Haipi111DetailLog record);
}