<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" type="text/css" href="js/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="js/easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="js/easyui/demo/demo.css">
	<script type="text/javascript" src="js/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="js/easyui/jquery.easyui.min.js"></script>
</head>
<body>
<script type="text/javascript">
	function open(){
		$("#w").window('open');
	}

</script>
	    <table class="easyui-datagrid" title="DataGrid Complex Toolbar" style="width:700px;height:250px" id="dg"
            data-options="rownumbers:true,
            singleSelect:true,
            url:'AllOrder',
            method:'post',
            toolbar:'#tb',
            footer:'#ft',
           	pagination: 'true',
            fit:'true'
           ">
        <thead>
            <tr>
               <th data-options="field:'id',width:80,align:'left'">订单编号</th>
                <th data-options="field:'goodsName',width:250,align:'left' ,formatter: goodsData ">商品</th>
                <th data-options="field:'totalprice',width:80,align:'left'">订单金额</th>
                <th data-options="field:'ordertime',width:100,align:'left'">下单时间</th>
                <th data-options="field:'addrName',width:350,align:'left' ,formatter: function(val,row){
                	if(row.addr.recvaddr && row.addr.detailaddr){
                	return row.addr.recvaddr+row.addr.detailaddr;
                	}
                }">配送地址</th>
                <th data-options="field:'account',width:80,align:'left' ,formatter:function(val,row){
                if (row.user.account){
               return   row.user.account;
           		}}">买家 </th>
                <th data-options="field:'phone',width:180,align:'left',formatter:  function(val,row){
                	if(row.addr.phone && row.addr.phone){
                	return row.addr.phone;
                	}
                }">联系方式 </th>
                <th data-options="field:'orderstatu',width:80,align:'left'">订单状态</th>
                <th data-options="field:'paystatu',width:80,align:'left'">支付状态</th>  
                <th data-options="field:'ID',width:80,align:'left' ,formatter:formatOper">操作</th>
            </tr>
        </thead>
    </table>
    <div id="tb" style="padding:2px 5px;">
        从: <input class="easyui-datebox" style="width:110px" id="otime" name="ordertime" >
        到: <input class="easyui-datebox" style="width:110px" id="etime" name="endtime">
        订单编号:<input class="easyui-TextBox" style="width:110px" id="oid" name="id">
        状态: 
        <select class="easyui-combobox" panelHeight="auto" style="width:110px" id="select" name="orderstatu">
            <option value="全部" selected="selected">全部</option>
            <option value="待发货">待发货</option>
            <option value="待收货">待收货</option>
            <option value="待评价">待评价</option>
            <option value="已评价">已评价</option>
        </select>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" onclick="doSearch()">查询</a>
    </div>
    <div id="ft" style="padding:2px 5px;">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" onclick="$('#w').window('open')" plain="true">处理订单</a>
    </div>
   
    
    
    <!-- 模态窗口 -->
    <div id="w" class="easyui-window" title="订单信息" data-options="modal:true,closed:true,iconCls:'icon-save'" style="width:300px;height:320px;padding:10px;">
		<b>订单编号:</b><em id="orderid"></em>
		<br/><br/>
		<b>商品:</b><em id="goodsName"></em>
		<br/><br/>
		<b>配送地址:</b><em id="address"></em>
		<br/><br/>
		<b>买家:</b><em id="uaccount"></em>
		<br/><br/>
		<b>联系方式:</b><em id="phone"></em>
		<br/><br/>
		<b>订单状态:</b><em id="statu"></em>
		<br/><br/>
        <div style="text-align:center;padding:5px 0">
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width:80px">发货</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" style="width:80px">拒绝订单</a>
             <a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#w').window('close')" style="width:80px">关闭</a>
        </div>
	</div>
    
    
</body>
<script type="text/javascript">

$.fn.datebox.defaults.formatter = function(date){
	var y = date.getFullYear();
	var m = date.getMonth()+1;
	var d = date.getDate();
	return y+'/'+m+'/'+d;
}
$.fn.datebox.defaults.parser = function(s){
	var t = Date.parse(s);
	if (!isNaN(t)){
		return new Date(t);
	} else {
		return new Date();
	}
}

function doSearch(){
	
	$("#dg").datagrid('load',{
		endtime : $("#etime").val(),
		id : $("#oid").val(),
		ordertime : $("#otime").val(),
		orderstatu :  $("#select").combobox("getValue"),
	})
	/* var ordertime = $("#otime").val();
	var endtime = $("#etime").val();
	var id = $("#oid").val();
	var orderstatu = $("#select").combobox("getValue");
	var data = {
		ordertime : ordertime,
		endtime : endtime,
		id : id,
		orderstatu : orderstatu
	}
	$.post("doSearch",data,function(data){
		
	}) */
	
}

function formatOper(val,row,index){
	return '<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" onclick="deal('+row.id+')" plain="true">处理订单</a>';
}
function submitForm(){
	var id = $("#orderid").html();
	$.post("sendOrder?id="+id,function(data){
		if(data.code == 1 ){
			$("#w").window("close");
			alert(data.msg);
			$("#dg").datagrid('reload');
		}else{
			alert(data.msg);
		}
	})
}
function goodsData(val,row,index){
	var goodsName = "";
	for(var i=0;i<row.details.length;i++){
		if(goodsName == ""){
			goodsName = row.details[i].goods.name+row.details[i].goods.color+row.details[i].goods.size;
		}else{
			goodsName = goodsName + "," +row.details[i].goods.name+row.details[i].goods.color+row.details[i].goods.size;
		}
		
	}
    return goodsName;
    	
}
function deal(id){
	$.post("dealOrder?id="+id,function(data){
		$("#orderid").html(data.id);
		var goodsName = "";
		for(var i=0;i<data.details.length;i++){
			if(goodsName == ""){
				goodsName = data.details[i].goods.name;
			}else{
				goodsName = goodsName + "," +data.details[i].goods.name;
			}
		}
		$("#goodsName").html(goodsName);
		$("#address").html(data.addr.recvaddr+data.addr.detailaddr);
		$("#uaccount").html(data.user.account);
		$("#phone").html(data.addr.phone);
		if(data.orderstatu == null){
			alert();
			$("#statu").html(data.paystatu); 
		}else{
			$("#statu").html(data.orderstatu); 
		}
		
		$("#w").window('open');
	})
	
}
</script>
</html>