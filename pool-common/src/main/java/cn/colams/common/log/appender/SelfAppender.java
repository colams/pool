package cn.colams.common.log.appender;


import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.plugins.Plugin;

import java.io.Serializable;

@Plugin(name = "SelfAppender", elementType = Appender.ELEMENT_TYPE, category = "core")
public class SelfAppender extends AbstractAppender {

    protected SelfAppender(String name, Filter filter, Layout<? extends Serializable> layout) {
        super(name, filter, layout);
    }

    protected SelfAppender(String name, Filter filter, Layout<? extends Serializable> layout, boolean ignoreExceptions) {
        super(name, filter, layout, ignoreExceptions);
    }

    @Override
    public void append(LogEvent logEvent) {
        System.out.println("selfAppender:");
    }
}
