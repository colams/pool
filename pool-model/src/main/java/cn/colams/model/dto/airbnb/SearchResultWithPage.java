package cn.colams.model.dto.airbnb;

public class SearchResultWithPage<T> {

    private T data;
    private long totalCount;
    private int totalPages;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public static <T> SearchResultWithPage buildEntity(T data, long totalCount, int totalPages) {
        SearchResultWithPage result = new SearchResultWithPage();
        result.setData(data);
        result.setTotalPages(totalPages);
        result.setTotalCount(totalCount);
        return result;
    }
}
