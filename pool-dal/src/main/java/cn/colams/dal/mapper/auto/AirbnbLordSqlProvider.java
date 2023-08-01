package cn.colams.dal.mapper.auto;

import cn.colams.dal.entity.AirbnbLord;
import cn.colams.dal.entity.AirbnbLordExample.Criteria;
import cn.colams.dal.entity.AirbnbLordExample.Criterion;
import cn.colams.dal.entity.AirbnbLordExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class AirbnbLordSqlProvider {

    public String countByExample(AirbnbLordExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("airbnb_lord");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(AirbnbLordExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("airbnb_lord");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(AirbnbLord record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("airbnb_lord");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getLoardId() != null) {
            sql.VALUES("loard_id", "#{loardId,jdbcType=VARCHAR}");
        }
        
        if (record.getLordName() != null) {
            sql.VALUES("lord_name", "#{lordName,jdbcType=VARCHAR}");
        }
        
        if (record.getLordPage() != null) {
            sql.VALUES("lord_page", "#{lordPage,jdbcType=VARCHAR}");
        }
        
        if (record.getRooms() != null) {
            sql.VALUES("rooms", "#{rooms,jdbcType=INTEGER}");
        }
        
        if (record.getAirbnbId() != null) {
            sql.VALUES("airbnb_id", "#{airbnbId,jdbcType=BIGINT}");
        }
        
        if (record.getProcessStatus() != null) {
            sql.VALUES("process_status", "#{processStatus,jdbcType=INTEGER}");
        }
        
        if (record.getEvaluate() != null) {
            sql.VALUES("evaluate", "#{evaluate,jdbcType=VARCHAR}");
        }
        
        if (record.getBrief() != null) {
            sql.VALUES("brief", "#{brief,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String selectByExample(AirbnbLordExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("loard_id");
        sql.SELECT("lord_name");
        sql.SELECT("lord_page");
        sql.SELECT("rooms");
        sql.SELECT("airbnb_id");
        sql.SELECT("process_status");
        sql.SELECT("evaluate");
        sql.SELECT("brief");
        sql.SELECT("create_time");
        sql.FROM("airbnb_lord");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        AirbnbLord record = (AirbnbLord) parameter.get("record");
        AirbnbLordExample example = (AirbnbLordExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("airbnb_lord");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getLoardId() != null) {
            sql.SET("loard_id = #{record.loardId,jdbcType=VARCHAR}");
        }
        
        if (record.getLordName() != null) {
            sql.SET("lord_name = #{record.lordName,jdbcType=VARCHAR}");
        }
        
        if (record.getLordPage() != null) {
            sql.SET("lord_page = #{record.lordPage,jdbcType=VARCHAR}");
        }
        
        if (record.getRooms() != null) {
            sql.SET("rooms = #{record.rooms,jdbcType=INTEGER}");
        }
        
        if (record.getAirbnbId() != null) {
            sql.SET("airbnb_id = #{record.airbnbId,jdbcType=BIGINT}");
        }
        
        if (record.getProcessStatus() != null) {
            sql.SET("process_status = #{record.processStatus,jdbcType=INTEGER}");
        }
        
        if (record.getEvaluate() != null) {
            sql.SET("evaluate = #{record.evaluate,jdbcType=VARCHAR}");
        }
        
        if (record.getBrief() != null) {
            sql.SET("brief = #{record.brief,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("airbnb_lord");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("loard_id = #{record.loardId,jdbcType=VARCHAR}");
        sql.SET("lord_name = #{record.lordName,jdbcType=VARCHAR}");
        sql.SET("lord_page = #{record.lordPage,jdbcType=VARCHAR}");
        sql.SET("rooms = #{record.rooms,jdbcType=INTEGER}");
        sql.SET("airbnb_id = #{record.airbnbId,jdbcType=BIGINT}");
        sql.SET("process_status = #{record.processStatus,jdbcType=INTEGER}");
        sql.SET("evaluate = #{record.evaluate,jdbcType=VARCHAR}");
        sql.SET("brief = #{record.brief,jdbcType=VARCHAR}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        
        AirbnbLordExample example = (AirbnbLordExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(AirbnbLord record) {
        SQL sql = new SQL();
        sql.UPDATE("airbnb_lord");
        
        if (record.getLoardId() != null) {
            sql.SET("loard_id = #{loardId,jdbcType=VARCHAR}");
        }
        
        if (record.getLordName() != null) {
            sql.SET("lord_name = #{lordName,jdbcType=VARCHAR}");
        }
        
        if (record.getLordPage() != null) {
            sql.SET("lord_page = #{lordPage,jdbcType=VARCHAR}");
        }
        
        if (record.getRooms() != null) {
            sql.SET("rooms = #{rooms,jdbcType=INTEGER}");
        }
        
        if (record.getAirbnbId() != null) {
            sql.SET("airbnb_id = #{airbnbId,jdbcType=BIGINT}");
        }
        
        if (record.getProcessStatus() != null) {
            sql.SET("process_status = #{processStatus,jdbcType=INTEGER}");
        }
        
        if (record.getEvaluate() != null) {
            sql.SET("evaluate = #{evaluate,jdbcType=VARCHAR}");
        }
        
        if (record.getBrief() != null) {
            sql.SET("brief = #{brief,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, AirbnbLordExample example, boolean includeExamplePhrase) {
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