package cn.colams.biz.sinastock;

import cn.colams.biz.sinastock.params.StockListParams;
import cn.colams.common.RedisService;
import cn.colams.common.utils.HttpUtils;
import org.apache.http.NameValuePair;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/**
 * 1：主入口：http://quote.eastmoney.com/center/gridlist.html#hs_a_board 获取所有股票信息
 * <p>
 * 2：http://10.push2.eastmoney.com/api/qt/clist/get?cb=jQuery112405104072080083242_1697094834211&pn=1&pz=10&po=1&np=1&ut=bd1d9ddb04089700cf9c27f6f7426281&fltt=2&invt=2&wbp2u=|0|0|0|web&fid=f3&fs=m:0+t:6,m:0+t:80,m:1+t:2,m:1+t:23,m:0+t:81+s:2048&fields=f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f12,f13,f14,f15,f16,f17,f18,f20,f21,f23,f24,f25,f22,f11,f62,f128,f136,f115,f152&_=1697094834216
 * <p>
 * https://10.push2.eastmoney.com/api/qt/clist/get?pn=1&pz=20&po=1&np=1&ut=bd1d9ddb04089700cf9c27f6f7426281&fltt=2&invt=2&wbp2u=|0|0|0|web&fid=f3&fs=m:0+t:6,m:0+t:80,m:1+t:2,m:1+t:23,m:0+t:81+s:2048&fields=f14&_=1697094834216
 * <p>
 * https://10.push2.eastmoney.com/api/qt/clist/get?pn=1&pz=2000&po=1&np=1&ut=bd1d9ddb04089700cf9c27f6f7426281&fltt=2&invt=2&wbp2u=|0|0|0|web&fid=f3&fs=m:0+t:6,m:0+t:80,m:1+t:2,m:1+t:23,m:0+t:81+s:2048&fields=f12,f14&_=1697094834216
 */
@Component
public class StockTestBiz {

    RedisService redisService;

    public StockTestBiz(RedisService redisService) {
        this.redisService = redisService;
    }

    public String queryStockList() throws IOException, URISyntaxException {
        String params = StockListParams.getParams();
        List<NameValuePair> nameValuePairs = StockListParams.getParams2();
        String url = ConstConfig.host_url.concat(ConstConfig.method);
        String result = HttpUtils.doGet(url, nameValuePairs, null);
        System.out.println(result);
        redisService.set("stock.list", result);
        return result;
    }


    interface ConstConfig {
        String host_url = "https://10.push2.eastmoney.com/";

        String method = "api/qt/clist/get";

    }


}
