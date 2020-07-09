package com.example.entity;

import java.util.List;

/**
 * 分页实体(里面包含分页信息，显示list数据)
 * @author Administrator
 *
 */
public class Page {
	private List list;
	
	private Integer currPage;//当前页
	private Integer totalPage;//总共多少页
	private Integer pageSize=6;//每页显示多少条数据
	private Integer totalCount;//总共多少条数据
	
	
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public Integer getCurrPage() {
		return currPage;
	}
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	/**
	 * 获取当前页在数据库product表中开始查找的索引
	 * @return
	 */
	public Integer getBeginRows(){
		return (this.getCurrPage()-1)*this.pageSize;
	}

	public Integer getTotalPage() {
		Double d = (double)totalCount/(double)pageSize;
		totalPage=(int) Math.ceil(d);
		
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	
	
	
}
