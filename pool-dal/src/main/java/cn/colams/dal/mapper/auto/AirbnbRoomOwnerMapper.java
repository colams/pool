package cn.colams.dal.mapper.auto;

import cn.colams.dal.entity.AirbnbRoomOwner;
import cn.colams.dal.entity.AirbnbRoomOwnerExample;
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
public interface AirbnbRoomOwnerMapper {
    @SelectProvider(type=AirbnbRoomOwnerSqlProvider.class, method="countByExample")
    long countByExample(AirbnbRoomOwnerExample example);

    @DeleteProvider(type=AirbnbRoomOwnerSqlProvider.class, method="deleteByExample")
    int deleteByExample(AirbnbRoomOwnerExample example);

    @Delete({
        "delete from airbnb_room_owner",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into airbnb_room_owner (id, \"name\", ",
        "landlord_id, rooms, ",
        "create_time)",
        "values (#{id,jdbcType=BIGINT}, #{name,jdbcType=VARCHAR}, ",
        "#{landlordId,jdbcType=VARCHAR}, #{rooms,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP})"
    })
    int insert(AirbnbRoomOwner record);

    @InsertProvider(type=AirbnbRoomOwnerSqlProvider.class, method="insertSelective")
    int insertSelective(AirbnbRoomOwner record);

    @SelectProvider(type=AirbnbRoomOwnerSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="landlord_id", property="landlordId", jdbcType=JdbcType.VARCHAR),
        @Result(column="rooms", property="rooms", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<AirbnbRoomOwner> selectByExampleWithRowbounds(AirbnbRoomOwnerExample example, RowBounds rowBounds);

    @SelectProvider(type=AirbnbRoomOwnerSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="landlord_id", property="landlordId", jdbcType=JdbcType.VARCHAR),
        @Result(column="rooms", property="rooms", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<AirbnbRoomOwner> selectByExample(AirbnbRoomOwnerExample example);

    @Select({
        "select",
        "id, \"name\", landlord_id, rooms, create_time",
        "from airbnb_room_owner",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="landlord_id", property="landlordId", jdbcType=JdbcType.VARCHAR),
        @Result(column="rooms", property="rooms", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    AirbnbRoomOwner selectByPrimaryKey(Long id);

    @UpdateProvider(type=AirbnbRoomOwnerSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") AirbnbRoomOwner record, @Param("example") AirbnbRoomOwnerExample example);

    @UpdateProvider(type=AirbnbRoomOwnerSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") AirbnbRoomOwner record, @Param("example") AirbnbRoomOwnerExample example);

    @UpdateProvider(type=AirbnbRoomOwnerSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(AirbnbRoomOwner record);

    @Update({
        "update airbnb_room_owner",
        "set \"name\" = #{name,jdbcType=VARCHAR},",
          "landlord_id = #{landlordId,jdbcType=VARCHAR},",
          "rooms = #{rooms,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(AirbnbRoomOwner record);
}