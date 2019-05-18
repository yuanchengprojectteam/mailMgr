package com.yc.mailMgr.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.yc.mailMgr.bean.ShopReturnGoods;

public interface ShopReturnG {

	@Select("select  r.id as rid,uo.id as oid,g.name as gname,u.name as uname,u.phone,r.statu, uo.totalprice as price,r.reason,r.rimage as img from retgoods r inner join orderdetail o on r.odetailid=o.id \r\n" + 
			"inner join goods g on o.gid=g.id \r\n" + 
			"inner join uorder uo on uo.id=o.orderid \r\n" + 
			"inner join `user` u on u.id=uo.uid \r\n" + 
			"where g.sid=${val} ")
	List<ShopReturnGoods>  selectBySid(@Param("val")int val);
	
	
	@Select("select  r.id as rid,uo.id as oid,g.name as gname,u.name as uname,u.phone,r.statu, uo.totalprice as price,r.reason,r.rimage as img from retgoods r inner join orderdetail o on r.odetailid=o.id \r\n" + 
			"inner join goods g on o.gid=g.id \r\n" + 
			"inner join uorder uo on uo.id=o.orderid \r\n" + 
			"inner join `user` u on u.id=uo.uid \r\n" + 
			"where g.sid=${val} and r.date BETWEEN '${start}' and '${end}' and r.statu='${statu}'")
	List<ShopReturnGoods>   selectToDeal(@Param("val")int val,@Param("start")String start,@Param("end")String end,@Param("statu")String statu);
	
	@Select("select  r.id as rid,uo.id as oid,g.name as gname,u.name as uname,u.phone,r.statu, uo.totalprice as price,r.reason,r.rimage as img from retgoods r inner join orderdetail o on r.odetailid=o.id \r\n" + 
			"inner join goods g on o.gid=g.id \r\n" + 
			"inner join uorder uo on uo.id=o.orderid \r\n" + 
			"inner join `user` u on u.id=uo.uid \r\n" + 
			"where g.sid=${val} and r.date BETWEEN '${start}' and '${now}' and r.statu='${statu}'")
	List<ShopReturnGoods>   selectToDeal1(@Param("val")int val,@Param("start")String start,@Param("now")String now,@Param("statu")String statu);
	
	@Select("select  r.id as rid,uo.id as oid,g.name as gname,u.name as uname,u.phone,r.statu, uo.totalprice as price,r.reason,r.rimage as img from retgoods r inner join orderdetail o on r.odetailid=o.id \r\n" + 
			"inner join goods g on o.gid=g.id \r\n" + 
			"inner join uorder uo on uo.id=o.orderid \r\n" + 
			"inner join `user` u on u.id=uo.uid \r\n" + 
			"where g.sid=${val} and  r.date<='${end}' and r.statu='${statu}'")
	List<ShopReturnGoods>   selectToDeal2(@Param("val")int val,@Param("end")String end,@Param("statu")String statu);
	
	@Select("select  r.id as rid,uo.id as oid,g.name as gname,u.name as uname,u.phone,r.statu, uo.totalprice as price,r.reason,r.rimage as img from retgoods r inner join orderdetail o on r.odetailid=o.id \r\n" + 
			"inner join goods g on o.gid=g.id \r\n" + 
			"inner join uorder uo on uo.id=o.orderid \r\n" + 
			"inner join `user` u on u.id=uo.uid \r\n" + 
			"where g.sid=${val} and r.date BETWEEN '${start}' and '${end}' ")
	List<ShopReturnGoods>   selectToDeal3(@Param("val")int val,@Param("start")String start,@Param("end")String end);

	@Select("select  r.id as rid,uo.id as oid,g.name as gname,u.name as uname,u.phone,r.statu, uo.totalprice as price,r.reason,r.rimage as img from retgoods r inner join orderdetail o on r.odetailid=o.id \r\n" + 
			"inner join goods g on o.gid=g.id \r\n" + 
			"inner join uorder uo on uo.id=o.orderid \r\n" + 
			"inner join `user` u on u.id=uo.uid \r\n" + 
			"where g.sid=${val} and  r.statu='${statu}' ")
	List<ShopReturnGoods> selectToDeal4(@Param("val")int val,@Param("statu")String statu);

	@Select("select  r.id as rid,uo.id as oid,g.name as gname,u.name as uname,u.phone,r.statu, uo.totalprice as price,r.reason,r.rimage as img from retgoods r inner join orderdetail o on r.odetailid=o.id \r\n" + 
			"inner join goods g on o.gid=g.id \r\n" + 
			"inner join uorder uo on uo.id=o.orderid \r\n" + 
			"inner join `user` u on u.id=uo.uid \r\n" + 
			"where g.sid=${val} and r.date BETWEEN '${start}'  and '${now}'")
	List<ShopReturnGoods> selectToDeal5(@Param("val")int val,@Param("start")String start,@Param("now")String now);
	
	@Select("select  r.id as rid,uo.id as oid,g.name as gname,u.name as uname,u.phone,r.statu, uo.totalprice as price,r.reason,r.rimage as img from retgoods r inner join orderdetail o on r.odetailid=o.id \r\n" + 
			"inner join goods g on o.gid=g.id \r\n" + 
			"inner join uorder uo on uo.id=o.orderid \r\n" + 
			"inner join `user` u on u.id=uo.uid \r\n" + 
			"where g.sid=${val} and r.date<='${end}'  ")
	List<ShopReturnGoods> selectToDeal6(@Param("val")int val,@Param("end")String end);
	
	@Select("select  r.id as rid,uo.id as oid,g.name as gname,u.name as uname,u.phone,r.statu, uo.totalprice as price,r.reason,r.rimage as img from retgoods r inner join orderdetail o on r.odetailid=o.id \r\n" + 
			"inner join goods g on o.gid=g.id \r\n" + 
			"inner join uorder uo on uo.id=o.orderid \r\n" + 
			"inner join `user` u on u.id=uo.uid \r\n" + 
			"where g.sid=${val}  ")
	List<ShopReturnGoods> selectToDeal7(@Param("val")int val);
}
