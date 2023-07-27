package cn.colams.common.utils;

import java.util.Optional;
import java.util.function.Function;

public class OptionalUtils {

    public static <T> String stringVal(Optional<T> optional, Function<? super T, String> mapper) {
        return optional.map(mapper).orElse("");
    }
}
