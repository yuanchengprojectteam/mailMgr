package com.yc.mailMgr.bean;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="address",catalog="tcmail")
@JsonIgnoreProperties(value = { "handler" })
public class Address implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer uid;
	//@NotEmpty(message="收货人不能为空!!!")
	private String name;
	//@NotEmpty(message="收货人电话不能为空!!!")
	private String phone;
	private String level;
	//@NotEmpty(message="请选择收货地址!!!")
	private String recvaddr;
	//@NotEmpty(message="请填写详细地址!!!")
	private  String  detailaddr;
	
	private String province;
	private String city;
	private String district;
	
	
	
	@Transient
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	@Transient
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Transient
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id",unique=true,nullable=false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="uid",length=11)
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	@Column(name="name",length=20)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="phone",length=20)
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Column(name="recvaddr",length=50)
	public String getRecvaddr() {
		return recvaddr;
	}

	public void setRecvaddr(String recvaddr) {
		this.recvaddr = recvaddr;
	}

	
	@Column(name="detailaddr",length=50)
	public String getDetailaddr() {
		return detailaddr;
	}
	
	
	public void setDetailaddr(String detailaddr) {
		this.detailaddr = detailaddr;
	}
	
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", uid=" + uid + ", name=" + name + ", phone=" + phone + ", level=" + level
				+ ", recvaddr=" + recvaddr + ", detailaddr=" + detailaddr + "]";
	}
	
	
	
}
