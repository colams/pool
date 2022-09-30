package cn.colams.biz.haipi111;

import cn.colams.common.aspects.LogParam;
import cn.colams.common.aspects.Metric;
import cn.colams.common.utils.HttpUtils;
import cn.colams.dal.mapper.extension.Haipi111DetailLogExtensionMapper;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class YueryouBiz {

    private static final Logger logger = LoggerFactory.getLogger(HttpUtils.class);

    private static String url = "http://www.yueryou.shop/?password-protected=login";

    @Autowired
    Haipi111DetailLogExtensionMapper haipi111DetailLogExtensionMapper;

    @Metric
    @LogParam
    public String postYueryou(String pwd) {
        List<NameValuePair> formParams = new ArrayList<>();
        formParams.add(new BasicNameValuePair("password_protected_pwd", pwd));
        formParams.add(new BasicNameValuePair("wp-submit", "登录"));
        formParams.add(new BasicNameValuePair("password_protected_cookie_test", "1"));
        formParams.add(new BasicNameValuePair("password-protected", "login"));

        String result = null;
        try {
            result = HttpUtils.postForm(url, formParams);
        } catch (IOException e) {
            logger.info("exception:", e);
        }

        if (result.contains("密码不正确")) {
            return "error";
        }
        return "success";
    }
}
