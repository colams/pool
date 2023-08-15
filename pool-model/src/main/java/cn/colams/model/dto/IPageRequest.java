package cn.colams.model.dto;

public class IPageRequest {

    /**
     * 当前页
     */
    private int currentPage = 0;
    /**
     * 页容量
     */
    private int pageSize = 20;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
