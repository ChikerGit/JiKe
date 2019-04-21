package com.drq.dto;


public class PageBean {

	
	private static final  Integer PAGE_SIZE = 5;
	
	//当前页
	private Integer pageIndex;
	//每页显示数量
	private Integer pageSize;
	//总条数
	private Integer recordCount;
	
	public Integer getPageIndex() {
		return pageIndex!=null?pageIndex:1;
	}
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}
	public Integer getPageSize() {
		
		return pageSize!=null?pageSize:PAGE_SIZE;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(Integer recordCount) {
		this.recordCount = recordCount;
	}
	
	//获取总页数
	public Integer getCount(){
		return (recordCount-1)/getPageSize()+1;
	}
	
	//limit #{page.startIndex},#{page.pageSize}
	public Integer getStartIndex(){
		return (getPageIndex()-1) * getPageSize();
	}
	
	@Override
	public String toString() {
		return "PageModel [pageIndex=" + pageIndex + ", pageSize=" + pageSize
				+ ", recordCount=" + recordCount + "]";
	}
	
	
	
	
}
