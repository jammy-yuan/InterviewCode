package cn.yueqian.javabean;

public class Department {
	private int ID;
	private String name;
	private String remark;
	public Department() {
		super();
	}
	public Department(int iD, String name, String remark) {
		super();
		ID = iD;
		this.name = name;
		this.remark = remark;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Department [ID=" + ID + ", name=" + name + ", remark=" + remark + "]";
	}

}
