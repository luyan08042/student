package entity;

import java.util.List;

public class Page<T> {
	private int pageSize=2;
	
	private int pageCurrent=1;
	
	private int pageCount;
	
	private int count;
	
	private List<T> list;

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageCurrent() {
		return pageCurrent;
	}

	public void setPageCurrent(int pageCurrent) {
		this.pageCurrent = pageCurrent;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = count % pageSize == 0 ? count/pageSize : count/pageSize+1 ;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
	
	public Page(List<T> list,int pageCurrent,int count){
		setList(list);
		setPageSize(this.pageSize);
		setPageCurrent(pageCurrent);
		setCount(count);
		setPageCount(this.pageCount);
	}
	

}
