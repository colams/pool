package cn.colams.dal.mapper.auto;

import cn.colams.dal.entity.Airbnb;
import cn.colams.dal.entity.AirbnbExample.Criteria;
import cn.colams.dal.entity.AirbnbExample.Criterion;
import cn.colams.dal.entity.AirbnbExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class AirbnbSqlProvider {

    public String countByExample(AirbnbExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("airbnb");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(AirbnbExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("airbnb");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(Airbnb record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("airbnb");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getRoomId() != null) {
            sql.VALUES("room_id", "#{roomId,jdbcType=VARCHAR}");
        }
        
        if (record.getRoomName() != null) {
            sql.VALUES("room_name", "#{roomName,jdbcType=VARCHAR}");
        }
        
        if (record.getRoomUrl() != null) {
            sql.VALUES("room_url", "#{roomUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getLordId() != null) {
            sql.VALUES("lord_id", "#{lordId,jdbcType=VARCHAR}");
        }
        
        if (record.getPrice() != null) {
            sql.VALUES("price", "#{price,jdbcType=VARCHAR}");
        }
        
        if (record.getRoomLocation() != null) {
            sql.VALUES("room_location", "#{roomLocation,jdbcType=VARCHAR}");
        }
        
        if (record.getDealStatus() != null) {
            sql.VALUES("deal_status", "#{dealStatus,jdbcType=INTEGER}");
        }
        
        if (record.getrSrouce() != null) {
            sql.VALUES("r_srouce", "#{rSrouce,jdbcType=INTEGER}");
        }
        
        if (record.getPage() != null) {
            sql.VALUES("page", "#{page,jdbcType=INTEGER}");
        }
        
        if (record.getOrgUrl() != null) {
            sql.VALUES("org_url", "#{orgUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getPictureCount() != null) {
            sql.VALUES("picture_count", "#{pictureCount,jdbcType=INTEGER}");
        }
        
        if (record.getrState() != null) {
            sql.VALUES("r_state", "#{rState,jdbcType=VARCHAR}");
        }
        
        if (record.getDatechangeLasttime() != null) {
            sql.VALUES("datechange_lasttime", "#{datechangeLasttime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getExtra() != null) {
            sql.VALUES("extra", "#{extra,jdbcType=LONGVARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExampleWithBLOBs(AirbnbExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("room_id");
        sql.SELECT("room_name");
        sql.SELECT("room_url");
        sql.SELECT("lord_id");
        sql.SELECT("price");
        sql.SELECT("room_location");
        sql.SELECT("deal_status");
        sql.SELECT("r_srouce");
        sql.SELECT("page");
        sql.SELECT("org_url");
        sql.SELECT("picture_count");
        sql.SELECT("r_state");
        sql.SELECT("datechange_lasttime");
        sql.SELECT("create_time");
        sql.SELECT("extra");
        sql.FROM("airbnb");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String selectByExample(AirbnbExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("room_id");
        sql.SELECT("room_name");
        sql.SELECT("room_url");
        sql.SELECT("lord_id");
        sql.SELECT("price");
        sql.SELECT("room_location");
        sql.SELECT("deal_status");
        sql.SELECT("r_srouce");
        sql.SELECT("page");
        sql.SELECT("org_url");
        sql.SELECT("picture_count");
        sql.SELECT("r_state");
        sql.SELECT("datechange_lasttime");
        sql.SELECT("create_time");
        sql.FROM("airbnb");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Airbnb record = (Airbnb) parameter.get("record");
        AirbnbExample example = (AirbnbExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("airbnb");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getRoomId() != null) {
            sql.SET("room_id = #{record.roomId,jdbcType=VARCHAR}");
        }
        
        if (record.getRoomName() != null) {
            sql.SET("room_name = #{record.roomName,jdbcType=VARCHAR}");
        }
        
        if (record.getRoomUrl() != null) {
            sql.SET("room_url = #{record.roomUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getLordId() != null) {
            sql.SET("lord_id = #{record.lordId,jdbcType=VARCHAR}");
        }
        
        if (record.getPrice() != null) {
            sql.SET("price = #{record.price,jdbcType=VARCHAR}");
        }
        
        if (record.getRoomLocation() != null) {
            sql.SET("room_location = #{record.roomLocation,jdbcType=VARCHAR}");
        }
        
        if (record.getDealStatus() != null) {
            sql.SET("deal_status = #{record.dealStatus,jdbcType=INTEGER}");
        }
        
        if (record.getrSrouce() != null) {
            sql.SET("r_srouce = #{record.rSrouce,jdbcType=INTEGER}");
        }
        
        if (record.getPage() != null) {
            sql.SET("page = #{record.page,jdbcType=INTEGER}");
        }
        
        if (record.getOrgUrl() != null) {
            sql.SET("org_url = #{record.orgUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getPictureCount() != null) {
            sql.SET("picture_count = #{record.pictureCount,jdbcType=INTEGER}");
        }
        
        if (record.getrState() != null) {
            sql.SET("r_state = #{record.rState,jdbcType=VARCHAR}");
        }
        
        if (record.getDatechangeLasttime() != null) {
            sql.SET("datechange_lasttime = #{record.datechangeLasttime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getExtra() != null) {
            sql.SET("extra = #{record.extra,jdbcType=LONGVARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("airbnb");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("room_id = #{record.roomId,jdbcType=VARCHAR}");
        sql.SET("room_name = #{record.roomName,jdbcType=VARCHAR}");
        sql.SET("room_url = #{record.roomUrl,jdbcType=VARCHAR}");
        sql.SET("lord_id = #{record.lordId,jdbcType=VARCHAR}");
        sql.SET("price = #{record.price,jdbcType=VARCHAR}");
        sql.SET("room_location = #{record.roomLocation,jdbcType=VARCHAR}");
        sql.SET("deal_status = #{record.dealStatus,jdbcType=INTEGER}");
        sql.SET("r_srouce = #{record.rSrouce,jdbcType=INTEGER}");
        sql.SET("page = #{record.page,jdbcType=INTEGER}");
        sql.SET("org_url = #{record.orgUrl,jdbcType=VARCHAR}");
        sql.SET("picture_count = #{record.pictureCount,jdbcType=INTEGER}");
        sql.SET("r_state = #{record.rState,jdbcType=VARCHAR}");
        sql.SET("datechange_lasttime = #{record.datechangeLasttime,jdbcType=TIMESTAMP}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("extra = #{record.extra,jdbcType=LONGVARCHAR}");
        
        AirbnbExample example = (AirbnbExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("airbnb");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("room_id = #{record.roomId,jdbcType=VARCHAR}");
        sql.SET("room_name = #{record.roomName,jdbcType=VARCHAR}");
        sql.SET("room_url = #{record.roomUrl,jdbcType=VARCHAR}");
        sql.SET("lord_id = #{record.lordId,jdbcType=VARCHAR}");
        sql.SET("price = #{record.price,jdbcType=VARCHAR}");
        sql.SET("room_location = #{record.roomLocation,jdbcType=VARCHAR}");
        sql.SET("deal_status = #{record.dealStatus,jdbcType=INTEGER}");
        sql.SET("r_srouce = #{record.rSrouce,jdbcType=INTEGER}");
        sql.SET("page = #{record.page,jdbcType=INTEGER}");
        sql.SET("org_url = #{record.orgUrl,jdbcType=VARCHAR}");
        sql.SET("picture_count = #{record.pictureCount,jdbcType=INTEGER}");
        sql.SET("r_state = #{record.rState,jdbcType=VARCHAR}");
        sql.SET("datechange_lasttime = #{record.datechangeLasttime,jdbcType=TIMESTAMP}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        
        AirbnbExample example = (AirbnbExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Airbnb record) {
        SQL sql = new SQL();
        sql.UPDATE("airbnb");
        
        if (record.getRoomId() != null) {
            sql.SET("room_id = #{roomId,jdbcType=VARCHAR}");
        }
        
        if (record.getRoomName() != null) {
            sql.SET("room_name = #{roomName,jdbcType=VARCHAR}");
        }
        
        if (record.getRoomUrl() != null) {
            sql.SET("room_url = #{roomUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getLordId() != null) {
            sql.SET("lord_id = #{lordId,jdbcType=VARCHAR}");
        }
        
        if (record.getPrice() != null) {
            sql.SET("price = #{price,jdbcType=VARCHAR}");
        }
        
        if (record.getRoomLocation() != null) {
            sql.SET("room_location = #{roomLocation,jdbcType=VARCHAR}");
        }
        
        if (record.getDealStatus() != null) {
            sql.SET("deal_status = #{dealStatus,jdbcType=INTEGER}");
        }
        
        if (record.getrSrouce() != null) {
            sql.SET("r_srouce = #{rSrouce,jdbcType=INTEGER}");
        }
        
        if (record.getPage() != null) {
            sql.SET("page = #{page,jdbcType=INTEGER}");
        }
        
        if (record.getOrgUrl() != null) {
            sql.SET("org_url = #{orgUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getPictureCount() != null) {
            sql.SET("picture_count = #{pictureCount,jdbcType=INTEGER}");
        }
        
        if (record.getrState() != null) {
            sql.SET("r_state = #{rState,jdbcType=VARCHAR}");
        }
        
        if (record.getDatechangeLasttime() != null) {
            sql.SET("datechange_lasttime = #{datechangeLasttime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getExtra() != null) {
            sql.SET("extra = #{extra,jdbcType=LONGVARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, AirbnbExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}