package com.yc.mailMgr.bean;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="user",catalog="tcmail")
public class User {
	private Integer id;
	private String name;
	private String account;
	private String realname;
	private String sex;
	private Integer age;
	private String pwd;
	private String email;
	private String phone;
	private String marry;
	private String image;
	private String type;
	private String job;
	private String edu;
	private String regtime;
	private Integer  familynum;
	private  String  favtypeid;
	
	
	private  String  income;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id",nullable=false,unique=true)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="name",length=20)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="account",length=18)
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}
	@Column(name="realname",length=50)
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	@Column(name="sex",length=2)
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Column(name="age",length=3)
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Column(name="pwd",length=18)
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Column(name="email",length=30)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name="phone",length=20)
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Column(name="marry",length=10)
	public String getMarry() {
		return marry;
	}
	public void setMarry(String marry) {
		this.marry = marry;
	}
	@Column(name="image",length=2000)
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Column(name="type",length=10)
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Column(name="job",length=20)
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	@Column(name="edu",length=10)
	public String getEdu() {
		return edu;
	}
	public void setEdu(String edu) {
		this.edu = edu;
	}
	@Column(name="regtime",length=20)
	public String getRegtime() {
		return regtime;
	}
	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}
	
	@Column(name="favtypeid",length=50)
	public String getFavtypeid() {
		return favtypeid;
	}
	public void setFavtypeid(String favTypeId) {
		favtypeid = favTypeId;
	}
	@Column(name="familynum",length=10)
	public Integer getFamilynum() {
		return familynum;
	}
	public void setFamilynum(Integer familynum) {
		this.familynum = familynum;
	}
	@Column(name="income",length=20)
	public String getIncome() {
		return income;
	}
	public void setIncome(String income) {
		this.income = income;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", account=" + account + ", realname=" + realname + ", sex=" + sex
				+ ", age=" + age + ", pwd=" + pwd + ", email=" + email + ", phone=" + phone + ", marry=" + marry
				+ ", image=" + image + ", type=" + type + ", job=" + job + ", edu=" + edu + ", regtime=" + regtime
				+ ", familynum=" + familynum + ", FavTypeId=" + favtypeid + ", income=" + income + "]";
	}
	
	
	
}
