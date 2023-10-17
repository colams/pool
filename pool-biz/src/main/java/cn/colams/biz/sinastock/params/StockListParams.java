package cn.colams.biz.sinastock.params;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

public class StockListParams {
    /**
     * jQuery112405104072080083242_1697094834211
     */
    private String cb;
    /**
     * 页码
     */
    private int pn;
    /**
     * 条数
     */
    private int pz;
    /**
     * ？
     */
    private int po;
    /**
     * ?
     */
    private int np;
    /**
     * ?
     */
    private String ut;
    /**
     * ?
     */
    private int fltt;
    /**
     * ?
     */
    private int invt;
    /**
     * ?
     */
    private String wbp2u;
    /**
     * ?
     */
    private String fid;
    /**
     * ?
     */
    private String fs;
    /**
     * StockFieldEnum
     * f1,
     * f2,
     * f3,
     * f4,
     * f5,
     * f6,
     * f7,
     * f8,
     * f9,
     * f10,
     * f12,-股票代码
     * f13,
     * f14,-股票名
     * f15,
     * f16,
     * f17,
     * f18,
     * f20,
     * f21,
     * f23,
     * f24,
     * f25,
     * f22,
     * f11,
     * f62,
     * f128,
     * f136,
     * f115,
     * f152
     */
    private String fields;
    /**
     * 时间戳
     */
    private long _;

    public String getCb() {
        return cb;
    }

    /**
     * 页码
     */
    public int getPn() {
        return pn;
    }

    /**
     * 页码
     */
    public void setPn(int pn) {
        this.pn = pn;
    }

    /**
     * 条数
     */
    public int getPz() {
        return pz;
    }

    /**
     * 条数
     */
    public void setPz(int pz) {
        this.pz = pz;
    }

    public int getPo() {
        return po;
    }

    public void setPo(int po) {
        this.po = po;
    }

    public int getNp() {
        return np;
    }

    public void setNp(int np) {
        this.np = np;
    }

    public String getUt() {
        return ut;
    }

    public void setUt(String ut) {
        this.ut = ut;
    }

    public int getFltt() {
        return fltt;
    }

    public void setFltt(int fltt) {
        this.fltt = fltt;
    }

    public int getInvt() {
        return invt;
    }

    public void setInvt(int invt) {
        this.invt = invt;
    }

    public String getWbp2u() {
        return wbp2u;
    }

    public void setWbp2u(String wbp2u) {
        this.wbp2u = wbp2u;
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public String getFs() {
        return fs;
    }

    public void setFs(String fs) {
        this.fs = fs;
    }

    public String getFields() {
        return fields;
    }

    public void setFields(String fields) {
        this.fields = fields;
    }

    public long get_() {
        return _;
    }

    private StockListParams() {
        this.cb = "jQuery112405104072080083242_1697094834211";
        this._ = System.currentTimeMillis();
    }

    public static String getParams() {
        StockListParams listParams = new StockListParams();
        listParams.setPn(1);
        listParams.setPz(2000);
        listParams.setPo(1);
        listParams.setNp(1);
        listParams.setUt("bd1d9ddb04089700cf9c27f6f7426281");
        listParams.setFltt(2);
        listParams.setInvt(2);
        listParams.setWbp2u("|0|0|0|web");
        listParams.setFid("f3");
        listParams.setFs("m:0+t:6,m:0+t:80,m:1+t:2,m:1+t:23,m:0+t:81+s:2048");
        listParams.setFields("f3,f12,f14");
        return "cb=" + listParams.getCb() +
                "&pn=" + listParams.getPn() +
                "&pz=" + listParams.getPz() +
                "&po=" + listParams.getPo() +
                "&np=" + listParams.getNp() +
                "&ut=" + listParams.getUt() +
                "&fltt=" + listParams.getFltt() +
                "&invt=" + listParams.getInvt() +
                "&wbp2u=" + listParams.getWbp2u() +
                "&fid=" + listParams.getFid() +
                "&fs=" + listParams.getFs() +
                "&fields=" + listParams.getFields() +
                "&_=" + listParams.get_();
    }

    public static List<NameValuePair> getParams2() {
        StockListParams listParams = new StockListParams();
        listParams.setPn(1);
        listParams.setPz(2000);
        listParams.setPo(1);
        listParams.setNp(1);
        listParams.setUt("bd1d9ddb04089700cf9c27f6f7426281");
        listParams.setFltt(2);
        listParams.setInvt(2);
        listParams.setWbp2u("|0|0|0|web");
        listParams.setFid("f3");
        listParams.setFs("m:0+t:6,m:0+t:80,m:1+t:2,m:1+t:23,m:0+t:81+s:2048");
        listParams.setFields("f3,f12,f14");
        List<NameValuePair> nameValuePairList = new ArrayList<>();
        nameValuePairList.add(new BasicNameValuePair("cb", listParams.getCb()));
        nameValuePairList.add(new BasicNameValuePair("pn", String.valueOf(listParams.getPn())));
        nameValuePairList.add(new BasicNameValuePair("pz", String.valueOf(listParams.getPz())));
        nameValuePairList.add(new BasicNameValuePair("po", String.valueOf(listParams.getPo())));
        nameValuePairList.add(new BasicNameValuePair("np", String.valueOf(listParams.getNp())));
        nameValuePairList.add(new BasicNameValuePair("ut", listParams.getUt()));
        nameValuePairList.add(new BasicNameValuePair("fltt", String.valueOf(listParams.getFltt())));
        nameValuePairList.add(new BasicNameValuePair("invt", String.valueOf(listParams.getInvt())));
        nameValuePairList.add(new BasicNameValuePair("wbp2u", listParams.getWbp2u()));
        nameValuePairList.add(new BasicNameValuePair("fid", listParams.getFid()));
        nameValuePairList.add(new BasicNameValuePair("fs", listParams.getFs()));
        nameValuePairList.add(new BasicNameValuePair("fields", listParams.getFields()));
        nameValuePairList.add(new BasicNameValuePair("_", String.valueOf(listParams.get_())));
        return nameValuePairList;
    }
}