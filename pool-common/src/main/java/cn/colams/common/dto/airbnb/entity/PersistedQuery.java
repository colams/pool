package cn.colams.common.dto.airbnb.entity;

public class PersistedQuery {

    private String sha256Hash;
    private int version;

    public String getSha256Hash() {
        return sha256Hash;
    }

    public void setSha256Hash(String sha256Hash) {
        this.sha256Hash = sha256Hash;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
