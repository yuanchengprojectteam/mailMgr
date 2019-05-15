package  com.yc.mailMgr.bean;


import javax.persistence.*;

@Entity
@Table(name="comment",catalog="tcmail")
public class Comment {
	private Integer id;
	private Integer uid;
	private Integer gfit;
	private Integer atti;
	private Integer speed;
	private Integer watti;
	private Integer satisf;
	private String see;
	private String msg;
	private String commenttime;
	private String img;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id",nullable=false,unique=true)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="gfit",length=2)
	public Integer getGfit() {
		return gfit;
	}
	public void setGfit(Integer gfit) {
		this.gfit = gfit;
	}
	@Column(name="atti",length=2)
	public Integer getAtti() {
		return atti;
	}
	public void setAtti(Integer atti) {
		this.atti = atti;
	}
	@Column(name="speed",length=2)
	public Integer getSpeed() {
		return speed;
	}
	public void setSpeed(Integer speed) {
		this.speed = speed;
	}
	@Column(name="watti",length=2)
	public Integer getWatti() {
		return watti;
	}
	public void setWatti(Integer watti) {
		this.watti = watti;
	}
	@Column(name="satisf",length=2)
	public Integer getSatisf() {
		return satisf;
	}
	public void setSatisf(Integer satisf) {
		this.satisf = satisf;
	}
	@Column(name="msg",length=600)
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@Column(name="img",length=2000)
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	@Column(name="uid",length=11)
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	
	@Column(name="see",length=10)
	public String getSee() {
		return see;
	}
	public void setSee(String see) {
		this.see = see;
	}
	@Column(name="commenttime",length=20)
	public String getCommenttime() {
		return commenttime;
	}
	public void setCommenttime(String commenttime) {
		this.commenttime = commenttime;
	}
	
}
