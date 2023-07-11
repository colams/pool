package cn.colams.biz.openai;

import com.futu.openapi.FTAPI_Conn_Qot;
import com.futu.openapi.pb.GetGlobalState;
import com.google.protobuf.Message;
import org.springframework.stereotype.Component;

@Component
public class OpenAiService {

    public int getGlobalState() {
        int code = 0;
        FTAPI_Conn_Qot qot = new FTAPI_Conn_Qot();
//        GetGlobalState.C2S c2S = GetGlobalState.C2S.newBuilder().setUnknownFields(Un)
//        GetGlobalState.Request request = GetGlobalState.Request.newBuilder().setC2S(Message)
//        code = qot.getGlobalState(request);
        return code;
    }

}
