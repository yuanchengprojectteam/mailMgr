<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>热门商品</title>
	<link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/default/easyui.css">
	        <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/icon.css">
	        <script type="text/javascript" src="https://www.jeasyui.com/easyui/jquery.min.js"></script>
	        <script type="text/javascript" src="https://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
	        <script type="text/javascript" src="https://www.jeasyui.com/easyui/datagrid-detailview.js"></script>
	</head>
<body>
	<table class="easyui-datagrid" title="Basic DataGrid" style="width:700px;height:250px"
			data-options="singleSelect:true,collapsible:true,url:'datagrid_data1.json',method:'get'">
		<thead>
			<tr>
				<th data-options="field:'itemid',width:80">商品名</th>
				<th data-options="field:'listprice',width:80,align:'right'">商品价格</th>
				<th data-options="field:'productid',width:100">商品购买次数</th>
			</tr>
		</thead>
	</table>
</body>
</html>