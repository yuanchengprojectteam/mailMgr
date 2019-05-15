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
	<table class="easyui-datagrid" title="DataGrid Complex Toolbar" style="width:700px;height:250px"
			data-options="rownumbers:true,singleSelect:true,url:'datagrid_data1.json',method:'get',toolbar:'#tb',fit:'true'">
		<thead>
			<tr>
				<th data-options="field:'itemid',width:80">商品编号</th>
				<th data-options="field:'productid',width:100">商品名</th>
				<th data-options="field:'listprice',width:80,align:'right'">用户名</th>
				<th data-options="field:'unitcost',width:80,align:'right'">评价内容</th>
			</tr>
		</thead>
	</table>
	<div id="tb" style="padding:5px;height:auto">
		<div style="margin-bottom:5px">
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit"  plain="true">查看状态</a>
		</div>
		<div>
			从: <input class="easyui-datebox" style="width:80px">
			到: <input class="easyui-datebox" style="width:80px">
			
			<a href="#" class="easyui-linkbutton" iconCls="icon-search">搜索</a>
		</div>
	</div>
	
	 <div id="w" class="easyui-window" title="订单信息" data-options="modal:true,closed:false,iconCls:'icon-save'" style="width:400px;height:480px;padding:10px;">
		<textarea rows="15" cols="40" readonly="readonly" ></textarea>
		<div style="width:100%;height:90px;">
			<img alt="评价图片" src="" width="100%" height=70px >
		</div>
        <div style="text-align:center;padding:5px 0">
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" style="width:80px">确认</a>
             <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" style="width:80px">关闭</a>
        </div>
	</div>

</body>
</html>