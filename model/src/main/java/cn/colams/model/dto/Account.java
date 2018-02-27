package cn.colams.model.dto;

public class Account {

    /**
     *
     */
    private String uuid;
    /**
     *
     */
    private String userName;
    /**
     *
     */
    private int level;



    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
