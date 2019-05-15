package com.yc.mailMgr.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="totalreason",catalog="tcmail")
public class Totalreason {
	private  Integer  id;
	private  Integer  tid;
	private  String   reason;
	private  String  orderstatu;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id",unique=true,nullable=false)
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="tid",length=11)
	public Integer getTid() {
		return tid;
	}
	/**
	 * @param tid the tid to set
	 */
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	/**
	 * @return the reason
	 */
	@Column(name="reason",length=50)
	public String getReason() {
		return reason;
	}
	/**
	 * @param reason the reason to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}
	/**
	 * @return the orderstatu
	 */
	@Column(name="orderstatu",length=50)
	public String getOrderstatu() {
		return orderstatu;
	}
	/**
	 * @param orderstatu the orderstatu to set
	 */
	public void setOrderstatu(String orderstatu) {
		this.orderstatu = orderstatu;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Totalreason [id=" + id + ", tid=" + tid + ", reason=" + reason + ", orderstatu=" + orderstatu + "]";
	}
	
	
}
