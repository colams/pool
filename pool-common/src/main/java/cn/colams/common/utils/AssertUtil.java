package cn.colams.common.utils;

import cn.colams.common.exception.ServiceException;
import cn.colams.model.IResult;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

public class AssertUtil {

    public static void notNull(Object object, IResult result) {
        if (Objects.isNull(object)) {
            throw new ServiceException(result);
        }
    }

    public static void notEmpty(List<Object> objectList, IResult result) {
        if (CollectionUtils.isEmpty(objectList)) {
            throw new ServiceException(result);
        }
    }

}
