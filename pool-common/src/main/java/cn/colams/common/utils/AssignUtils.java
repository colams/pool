package cn.colams.common.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * 赋值帮助类
 */
public class AssignUtils {

    /**
     * 字符串非空赋值
     *
     * @param parameter
     * @param consumer  赋值方法
     */
    public static void stringNotBlankAssign(String parameter, Consumer<String> consumer) {
        if (StringUtils.isNotBlank(parameter)) {
            consumer.accept(parameter);
        }
    }

    private <R> void stringNotBlankAssign(String parameter, Function<String, R> function, Consumer<R> consumer) {
        if (StringUtils.isNotBlank(parameter) && Objects.nonNull(function)) {
            consumer.accept(function.apply(parameter));
        }
    }

    private <R> void stringNotBlankAssign(String parameter, String patterns,
                                          BiFunction<String, String, R> function, Consumer<R> consumer) {
        if (StringUtils.isNotBlank(parameter) && Objects.nonNull(function)) {
            consumer.accept(function.apply(parameter, patterns));
        }
    }


}
