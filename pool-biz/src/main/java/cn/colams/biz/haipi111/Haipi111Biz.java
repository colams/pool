package cn.colams.biz.haipi111;

import cn.colams.common.aspects.LogParam;
import cn.colams.common.aspects.Metric;
import cn.colams.common.haipi111.HaipiAction;
import cn.colams.common.utils.HttpUtils;
import cn.colams.common.utils.JacksonSerializerUtil;
import cn.colams.dal.entity.Haipi111DetailLog;
import cn.colams.dal.entity.Haipi111DetailLogExample;
import cn.colams.dal.mapper.extension.Haipi111DetailLogExtensionMapper;
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
    Haipi111DetailLogExtensionMapper haipi111DetailLogExtensionMapper;

    @Metric
    @LogParam
    public String getHaipi111(String uid, String infoID) {
        List<NameValuePair> formParams = new ArrayList<>();
        formParams.add(new BasicNameValuePair("uid", uid));
        formParams.add(new BasicNameValuePair("infoid", infoID));
        formParams.add(new BasicNameValuePair("action", HaipiAction.ckinfo.getAction()));
        formParams.add(new BasicNameValuePair("t", "0.013940201448949585"));

        String request = JacksonSerializerUtil.serialize(formParams);
        String result = null;
        try {
            result = HttpUtils.postForm(formParams);
        } catch (IOException e) {
            e.printStackTrace();
        }
        insert(uid, infoID, request, result);

        if (result.contains("查看成功")) {
            return result;
        }
        return "error";
    }

    @Metric
    private boolean insert(Haipi111DetailLog haipi111Log) {
        return haipi111DetailLogExtensionMapper.insertSelective(haipi111Log) > 0;
    }

    private boolean insert(String uid, String infoid, String request, String response) {
        Haipi111DetailLog haipi111Log = new Haipi111DetailLog();
        haipi111Log.setUid(uid);
        haipi111Log.setInfoid(infoid);
        haipi111Log.setAction("ckinfo");
        haipi111Log.setRequestdata(request);
        haipi111Log.setResponsedata(response);
        return insert(haipi111Log);
    }

    public List<Haipi111DetailLog> list() throws Exception {
        Haipi111DetailLogExample example = new Haipi111DetailLogExample();
        example.setOrderByClause("id");
        List<Haipi111DetailLog> ticksList = haipi111DetailLogExtensionMapper.selectByExample(example);
        return ticksList;
    }

    public List<Haipi111DetailLog> getHaipiDetail(String infoid) {
        Haipi111DetailLogExample example = new Haipi111DetailLogExample();
        example.createCriteria().andInfoidLike("%" + infoid + "%");
        List<Haipi111DetailLog> ticksList = haipi111DetailLogExtensionMapper.selectByExample(example);
        return ticksList;
    }

    public String getHaipiDetailTask(String infoid) throws InterruptedException {

        for (int startSeed = 1; startSeed < 999999999; startSeed++) {
            String rs = getHaipi111(String.valueOf(startSeed), infoid);
            Thread.currentThread().sleep(2 * 1000);
            if (!rs.equalsIgnoreCase("error")) {
                return rs;
            }
        }
        return "error";
    }
}
