package cn.colams.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JacksonSerializerUtil {
    private static final Logger logger = LoggerFactory.getLogger(JacksonSerializerUtil.class);

    private static final ObjectMapper mapper = new ObjectMapper();

    public JacksonSerializerUtil() {
    }

    public static String serialize(Object value) {
        try {
            return mapper.writeValueAsString(value);
        } catch (JsonProcessingException var2) {
            logger.warn("jackson序列化异常", var2);
            return "";
        }
    }

    public static <T> T deserialize(String jsonString, Class<T> cls) {
        try {
            return mapper.readValue(jsonString, cls);
        } catch (Exception var3) {
            logger.warn("jackson反序列化异常", var3);
            return null;
        }
    }

    public static <T> T deserialize(String jsonString, Class mainClazz, Class... parameterClazz) {
        try {
            JavaType javaType = mapper.getTypeFactory().constructParametricType(mainClazz, parameterClazz);
            return mapper.readValue(jsonString, javaType);
        } catch (Exception var4) {
            logger.warn("jackson反序列化异常", var4);
            return null;
        }
    }

    public static JavaType getCollectionType(Class<?> collectionClass, Class... elementClasses) {
        return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }


    static {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.registerModule(new ParameterNamesModule()).registerModule(new Jdk8Module()).registerModule(new JavaTimeModule());
    }
}
