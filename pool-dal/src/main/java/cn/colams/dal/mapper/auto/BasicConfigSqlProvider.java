package cn.colams.dal.mapper.auto;

import cn.colams.dal.entity.BasicConfig;
import cn.colams.dal.entity.BasicConfigExample.Criteria;
import cn.colams.dal.entity.BasicConfigExample.Criterion;
import cn.colams.dal.entity.BasicConfigExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class BasicConfigSqlProvider {

    public String countByExample(BasicConfigExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("basic_config");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(BasicConfigExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("basic_config");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(BasicConfig record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("basic_config");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getConfigKey() != null) {
            sql.VALUES("config_key", "#{configKey,jdbcType=VARCHAR}");
        }
        
        if (record.getConfigValue() != null) {
            sql.VALUES("config_value", "#{configValue,jdbcType=VARCHAR}");
        }
        
        if (record.getDatechangeLasttime() != null) {
            sql.VALUES("datechange_lasttime", "#{datechangeLasttime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String selectByExample(BasicConfigExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("config_key");
        sql.SELECT("config_value");
        sql.SELECT("datechange_lasttime");
        sql.SELECT("create_time");
        sql.FROM("basic_config");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        BasicConfig record = (BasicConfig) parameter.get("record");
        BasicConfigExample example = (BasicConfigExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("basic_config");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getConfigKey() != null) {
            sql.SET("config_key = #{record.configKey,jdbcType=VARCHAR}");
        }
        
        if (record.getConfigValue() != null) {
            sql.SET("config_value = #{record.configValue,jdbcType=VARCHAR}");
        }
        
        if (record.getDatechangeLasttime() != null) {
            sql.SET("datechange_lasttime = #{record.datechangeLasttime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("basic_config");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("config_key = #{record.configKey,jdbcType=VARCHAR}");
        sql.SET("config_value = #{record.configValue,jdbcType=VARCHAR}");
        sql.SET("datechange_lasttime = #{record.datechangeLasttime,jdbcType=TIMESTAMP}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        
        BasicConfigExample example = (BasicConfigExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(BasicConfig record) {
        SQL sql = new SQL();
        sql.UPDATE("basic_config");
        
        if (record.getConfigKey() != null) {
            sql.SET("config_key = #{configKey,jdbcType=VARCHAR}");
        }
        
        if (record.getConfigValue() != null) {
            sql.SET("config_value = #{configValue,jdbcType=VARCHAR}");
        }
        
        if (record.getDatechangeLasttime() != null) {
            sql.SET("datechange_lasttime = #{datechangeLasttime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, BasicConfigExample example, boolean includeExamplePhrase) {
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