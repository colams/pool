package cn.colams.common.haipi111;

public enum HaipiAction {

    ckinfo("ckinfo"),

    ;
    private String action;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    HaipiAction(String action) {
        this.action = action;
    }
}
