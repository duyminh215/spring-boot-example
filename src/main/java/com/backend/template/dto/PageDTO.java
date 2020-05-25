package com.backend.template.dto;

public class PageDTO {

  private Object content;
  private Integer currentPage;
  private Integer totalRecords;
  private Integer pageSize;
  private Integer totalPages;

  public PageDTO(Object content, Integer currentPage, Integer totalRecords,
      Integer pageSize, Integer totalPages) {
    this.content = content;
    this.currentPage = currentPage;
    this.totalRecords = totalRecords;
    this.pageSize = pageSize;
    this.totalPages = totalPages;
  }

  public PageDTO() {
  }

  public Object getContent() {
    return content;
  }

  public void setContent(Object content) {
    this.content = content;
  }

  public Integer getCurrentPage() {
    return currentPage;
  }

  public void setCurrentPage(Integer currentPage) {
    this.currentPage = currentPage;
  }

  public Integer getTotalRecords() {
    return totalRecords;
  }

  public void setTotalRecords(Integer totalRecords) {
    this.totalRecords = totalRecords;
  }

  public Integer getPageSize() {
    return pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  public Integer getTotalPages() {
    return totalPages;
  }

  public void setTotalPages(Integer totalPages) {
    this.totalPages = totalPages;
  }
}
