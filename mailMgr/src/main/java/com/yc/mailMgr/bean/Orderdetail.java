package com.yc.mailMgr.bean;

import javax.persistence.*;

@Entity
@Table(name="orderdetail",catalog="tcmail")
public class Orderdetail {
	private Integer id;
	private Integer orderid;
	private  Integer gid;
	private Integer num;
	
	//临时 退款金额
	private Integer retPrice;
	
	
	
	@Transient
	public Integer getRetPrice() {
		return retPrice;
	}
	public void setRetPrice(Integer retPrice) {
		this.retPrice = retPrice;
	}
	private Goods goods;
	
	private Uorder uorder;
	
	
	
	@Transient
	public Uorder getUorder() {
		return uorder;
	}
	public void setUorder(Uorder uorder) {
		this.uorder = uorder;
	}
	@Id
	@Column(name="id",nullable=false,unique=true)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getOrderid() {
		return orderid;
	}
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
	}
	
	@Transient
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	@Column(name="num",length=11)
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	@Override
	public String toString() {
		return "Orderdetail [id=" + id + ", orderid=" + orderid + ", gid=" + gid + ", num=" + num + ", goods=" + goods
				+ "]";
	}
	
	
	
	
	
}
