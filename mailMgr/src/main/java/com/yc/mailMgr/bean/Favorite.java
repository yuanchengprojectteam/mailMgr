package com.yc.mailMgr.bean;

import javax.persistence.*;

@Entity
@Table(name="favorite",catalog="tcmail")
public class Favorite {
	private Integer id;
	private Integer uid;
	private Integer shopid;
	private Integer goodsid;
	private String ftime;
	
	private Goods good;
	private Shop shop;
	
	
	@Transient
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	@Transient
	public Goods getGood() {
		return good;
	}
	public void setGoods(Goods good) {
		this.good = good;
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
	@Column(name="shopid",length=11)
	public Integer getShopid() {
		return shopid;
	}
	public void setShopid(Integer shopid) {
		this.shopid = shopid;
	}
	@Column(name="goodsid",length=11)
	public Integer getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(Integer goodsid) {
		this.goodsid = goodsid;
	}
	
	
	@Column(name="ftime",length=20)
	public String getFtime() {
		return ftime;
	}
	public void setFtime(String ftime) {
		this.ftime = ftime;
	}
	@Override
	public String toString() {
		return "Favorite [id=" + id + ", uid=" + uid + ", shopid=" + shopid + ", goodsid=" + goodsid + ", ftime="
				+ ftime + ", good=" + good + "]";
	}
	
	
	
	
}
