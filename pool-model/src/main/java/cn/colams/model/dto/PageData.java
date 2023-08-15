package cn.colams.model.dto;

public class PageData {

    /**
     * 当前页码
     */
    private Integer currentPage = 1;
    /**
     * 页容量
     */
    private Integer pageSize = 500;
    /**
     * 总页数
     */
    private Integer totalPage = 0;
    /**
     * 总数量
     */
    private Integer totalCount = 0;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }
}
