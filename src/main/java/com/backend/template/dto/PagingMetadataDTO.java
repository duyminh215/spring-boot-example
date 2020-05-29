package com.backend.template.dto;

public class PagingMetadataDTO {
    private Integer size;
    private int totalElement;
    private Integer totalPage;
    private Integer currentPage;
    private String nextPageURL;
    private String previousPageURL;

    public PagingMetadataDTO(Integer size, int totalElement, Integer totalPage, Integer currentPage, String nextPageURL,
            String previousPageURL) {
        this.size = size;
        this.totalElement = totalElement;
        this.totalPage = totalPage;
        this.currentPage = currentPage;
        this.nextPageURL = nextPageURL;
        this.previousPageURL = previousPageURL;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public int getTotalElement() {
        return totalElement;
    }

    public void setTotalElement(int totalElement) {
        this.totalElement = totalElement;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public String getNextPageURL() {
        return nextPageURL;
    }

    public void setNextPageURL(String nextPageURL) {
        this.nextPageURL = nextPageURL;
    }

    public String getPreviousPageURL() {
        return previousPageURL;
    }

    public void setPreviousPageURL(String previousPageURL) {
        this.previousPageURL = previousPageURL;
    }
}
