package com.yc.mailMgr.bean;

import java.util.List;

public class PageData {
	Object total;
	List<?> rows;
	public Object getTotal() {
		return total;
	}
	public void setTotal(Object object) {
		this.total = object;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
		
		
}
