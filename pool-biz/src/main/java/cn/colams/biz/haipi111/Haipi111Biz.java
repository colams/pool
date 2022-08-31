package cn.colams.biz.haipi111;

import cn.colams.common.haipi111.HaipiAction;
import cn.colams.common.utils.HttpUtils;
import cn.colams.common.utils.JacksonSerializerUtil;
import cn.colams.dal.entity.Haipi111Log;
import cn.colams.dal.mapper.extension.Haipi111LogExtensionMapper;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class Haipi111Biz {

    @Autowired
    Haipi111LogExtensionMapper haipi111LogExtensionMapper;

    public String getHaipi111(String uid, String infoID) throws IOException {
        List<NameValuePair> formParams = new ArrayList<>();
        formParams.add(new BasicNameValuePair("uid", "100"));
        formParams.add(new BasicNameValuePair("infoid", "501836"));
        formParams.add(new BasicNameValuePair("action", HaipiAction.ckinfo.getAction()));
        formParams.add(new BasicNameValuePair("t", "0.013940201448949585"));

        String request = JacksonSerializerUtil.serialize(formParams);

        String result = HttpUtils.postForm(formParams);
        insert(request, result);
        return result;
    }

    private boolean insert(Haipi111Log haipi111Log) {
        return haipi111LogExtensionMapper.insertSelective(haipi111Log) > 0;
    }

    private boolean insert(String request, String response) {
        Haipi111Log haipi111Log = new Haipi111Log();
        haipi111Log.setRequestdata(request);
        haipi111Log.setResponsedata(response);
        return insert(haipi111Log);
    }

}
