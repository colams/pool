package cn.colams.web.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

@ControllerAdvice(basePackages = "cn.colams.web")
public class JSONPConfiguration  extends AbstractJsonpResponseBodyAdvice {

    public JSONPConfiguration(){
        super("callback", "jsonp");
    }

}
