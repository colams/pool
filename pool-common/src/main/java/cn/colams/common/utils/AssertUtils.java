package cn.colams.common.utils;

import cn.colams.common.exception.CustomServiceException;
import cn.colams.model.IResult;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

public class AssertUtils {

    public static void notNull(Object object, IResult result) {
        if (Objects.isNull(object)) {
            throw new CustomServiceException(result);
        }
    }

    public static void notEmpty(List<Object> objectList, IResult result) {
        if (CollectionUtils.isEmpty(objectList)) {
            throw new CustomServiceException(result);
        }
    }

}
