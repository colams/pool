package cn.colams.common.dto.airbnb.entity;

public class RequestExtensions {
    private PersistedQuery persistedQuery;

    public PersistedQuery getPersistedQuery() {
        return persistedQuery;
    }

    public void setPersistedQuery(PersistedQuery persistedQuery) {
        this.persistedQuery = persistedQuery;
    }
}
