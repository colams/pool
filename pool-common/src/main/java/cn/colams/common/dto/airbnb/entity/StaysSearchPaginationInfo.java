package cn.colams.common.dto.airbnb.entity;

import cn.colams.common.dto.airbnb.ITypeName;

import java.util.List;

public class StaysSearchPaginationInfo extends ITypeName {

    private List<String> pageCursors;

    private String nextPageCursor;

    public List<String> getPageCursors() {
        return pageCursors;
    }

    public void setPageCursors(List<String> pageCursors) {
        this.pageCursors = pageCursors;
    }

    public String getNextPageCursor() {
        return nextPageCursor;
    }

    public void setNextPageCursor(String nextPageCursor) {
        this.nextPageCursor = nextPageCursor;
    }
}
