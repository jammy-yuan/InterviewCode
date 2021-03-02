package cn.yueqian.javabean;

public class Employee {
	private String name;
	private String card_id;
	private String address;
	private String post_code;
	private String tel;
	private String phone;
	private String QQ_num;
	private String email;
	private String sex;
	private String party;
	private String birthday;
	private String race;
	private String education;
	private String speciality;
	private String hobby;
	private int dept_id;
	private int job_id;
	
	public Employee() {
		super();
	}

	public Employee(String name, String card_id, String address, String post_code, String tel, String phone,
			String qQ_num, String email, String sex, String party, String birthday, String race, String education,
			String speciality, String hobby,int dept_id,int job_id) {
		super();
		this.name = name;
		this.card_id = card_id;
		this.address = address;
		this.post_code = post_code;
		this.tel = tel;
		this.phone = phone;
		QQ_num = qQ_num;
		this.email = email;
		this.sex = sex;
		this.party = party;
		this.birthday = birthday;
		this.race = race;
		this.education = education;
		this.speciality = speciality;
		this.hobby = hobby;
		this.job_id=job_id;
		this.dept_id=dept_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCard_id() {
		return card_id;
	}

	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPost_code() {
		return post_code;
	}

	public void setPost_code(String post_code) {
		this.post_code = post_code;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getQQ_num() {
		return QQ_num;
	}

	public void setQQ_num(String qQ_num) {
		QQ_num = qQ_num;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getParty() {
		return party;
	}

	public void setParty(String party) {
		this.party = party;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public int getDept_id() {
		return dept_id;
	}

	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}

	public int getJob_id() {
		return job_id;
	}

	public void setJob_id(int job_id) {
		this.job_id = job_id;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", card_id=" + card_id + ", address=" + address + ", post_code=" + post_code
				+ ", tel=" + tel + ", phone=" + phone + ", QQ_num=" + QQ_num + ", email=" + email + ", sex=" + sex
				+ ", party=" + party + ", birthday=" + birthday + ", race=" + race + ", education=" + education
				+ ", speciality=" + speciality + ", hobby=" + hobby + ", dept_id=" + dept_id + ", job_id=" + job_id
				+ "]";
	}

}
