package com.backend.template.dto.response;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.backend.template.paging.PagingInfo;

public class PageResponseBuilder {

	public static PagingInfo buildPagingData(List data, Pageable pageable, Page page){
		PagingInfo pagingInfo = new PagingInfo();
		pagingInfo.setContents(data);
		pagingInfo.loadFromPageable(pageable);
        pagingInfo.loadFromPage(page);
        return pagingInfo;
	}
	
	public static PagingInfo buildPagingData(Page page, Pageable pageable){
		PagingInfo pagingInfo = new PagingInfo();
		pagingInfo.setContents(page.getContent());
		pagingInfo.loadFromPageable(pageable);
        pagingInfo.loadFromPage(page);
        return pagingInfo;
	}
}
