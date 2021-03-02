package cn.yueqian.javabean;
/**
 * 封装�?个类：将分页查询�?要用的的信息用一个类封装起来
 * @author newuser
 *
 */
public class QueryInfo {
	private int currentpage = 1;  //用户当前看的�?
	private int pagesize = 10;     //记住用户想看的页面大�?
	private int startindex;     //记住用户看的页的数据在数据库的起始位�?
	
	
	public int getCurrentpage() {
		return currentpage;
	}
	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getStartindex() {
		//确定查询数据的起始位置：公式：当前页-1*每页显示的条�?
		this.startindex = (this.currentpage-1)*this.pagesize;
		return startindex;
	}
}
