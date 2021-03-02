package cn.yueqian.javabean;

import java.util.List;

/**
 * PageBean:将页面要显示�?要用到的全部变量封装到这个类�?
 * 
 * 目的�? 直接将数据填充好过后，放到request域中，jsp页面直接获取就行
 * 
 * @author newuser
 *
 */
public class PageBean {
	private List<?> list;// 表格中显示的list集合--》数据库查询出来�?
	private int totalrecord;// 总记录数�?---》数据库查询出来�?
	private int pagesize;// �?页显示多少条数据---》用户输入的
	private int totalpage;// �?共有多少�?---》计算出来的
	private int currentpage;// 当前�?---�?
	private int previouspage;// 上一�?--->计算出来�?
	private int nextpage;// 下一�?
	private int[] pagebar;// 页码�?

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}

	public int getTotalrecord() {
		return totalrecord;
	}

	public void setTotalrecord(int totalrecord) {
		this.totalrecord = totalrecord;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	// 总页数是计算出来�?
	public int getTotalpage() {
		// 总页�?=总记录数/每页显示条数
		// 注意要判断是否可以除尽，如果有余数，则要多一�?
		if (this.totalrecord % this.pagesize == 0) {// 说明可以除得尽，没有余数
			this.totalpage = this.totalrecord / this.pagesize;
		} else {
			// 如果有余数，就要多加�?�?
			this.totalpage = this.totalrecord / this.pagesize + 1;
		}
		return totalpage;
	}

	public int getCurrentpage() {
		return currentpage;
	}

	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}

	// 上一页，计算出来的：上一�?=当前�?-1
	// 注意：要判断是否是第�?�?
	public int getPreviouspage() {
		if (this.currentpage - 1 < 1) {
			// 如果是第�?页，直接设置�?1
			this.previouspage = 1;
		} else {
			// 当前�?-1
			this.previouspage = this.currentpage - 1;
		}
		return previouspage;
	}

	// 上一页，计算出来的：上一�?=当前�?+1
	// 注意：要判断是否是最后一�?
	public int getNextpage() {
		// 判断是否是最后一�?
		if (this.currentpage + 1 >= this.totalpage) {
			this.nextpage = this.totalpage;
		} else {
			// 否则当前�?+1
			this.nextpage = this.currentpage + 1;
		}
		return nextpage;
	}

	// 页码�?
	public int[] getPagebar() {
		int startpage;// �?始页
		int endpage;// 结束�?
		int pagebar[] = null;
		// 如果总页数小�?10,pagebar的大小是多少：�?�页�?
		if (this.totalpage <= 10) {
			pagebar = new int[this.totalpage];
			// 设置�?始页�?1�?
			startpage = 1;
			// 设置结束�?===总页�?
			endpage = this.totalpage;
		} else {
			// 只显�?10页其他不显示
			pagebar = new int[10];

			// 设置�?始页：当前页-4�?
			startpage = this.currentpage - 5;
			// 设置结束页：当前�?+5
			endpage = this.currentpage + 4;

			// 总页�?=30 3 -1
			// 总页�?=30 29 34 21 30

			// 判断是否是第�?�?
			if (startpage < 1) {
				startpage = 1;
				endpage = 10;
			}
			// 判断是否是最后一�?
			if (endpage > this.totalpage) {
				endpage = this.totalpage;
				startpage = this.totalpage - 9;
			}
		}

		int index = 0;
		for (int i = startpage; i <= endpage; i++) {
			//设置数组的�??
			pagebar[index++] = i;
		}

		this.pagebar = pagebar;
		return this.pagebar;

	}

}
