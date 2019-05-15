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
	    <table class="easyui-datagrid" title="DataGrid Complex Toolbar" style="width:700px;height:250px"
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
                <th data-options="field:'name',width:300,align:'left'">商品</th>
                <th data-options="field:'totalprice',width:80,align:'left'">订单金额</th>
                <th data-options="field:'ordertime',width:80,align:'left'">下单时间</th>
                <th data-options="field:'address',width:350,align:'left'">配送地址</th>
                <th data-options="field:'maijia',width:80,align:'left'">买家 </th>
                <th data-options="field:'phone',width:180,align:'left'">联系方式 </th>
                <th data-options="field:'statu',width:80,align:'left'">订单状态</th>
            </tr>
        </thead>
    </table>
    <div id="tb" style="padding:2px 5px;">
        从: <input class="easyui-datebox" style="width:110px">
        到: <input class="easyui-datebox" style="width:110px">
        订单编号:<input class="easyui-TextBox" style="width:110px">
        状态: 
        <select class="easyui-combobox" panelHeight="auto" style="width:110px">
        	<option value=""></option>
            <option value="all">全部</option>
            <option value="dfh">待发货</option>
            <option value="psz">配送中</option>
            <option value="ysh">已收货</option>
            <option value="wpj">未评价</option>
            <option value="ypj">已评价</option>
        </select>
        <a href="#" class="easyui-linkbutton" iconCls="icon-search">查询</a>
    </div>
    <div id="ft" style="padding:2px 5px;">
        <a href="#" class="easyui-linkbutton" iconCls="icon-edit" onclick="$('#w').window('open')" plain="true">处理订单</a>
    </div>
   
    
    
    <!-- 模态窗口 -->
    <div id="w" class="easyui-window" title="订单信息" data-options="modal:true,closed:true,iconCls:'icon-save'" style="width:300px;height:320px;padding:10px;">
		<b>订单编号:</b><em>123</em>
		<br/><br/>
		<b>商品:</b><em></em>
		<br/><br/>
		<b>配送地址:</b><em></em>
		<br/><br/>
		<b>买家:</b><em></em>
		<br/><br/>
		<b>联系方式:</b><em></em>
		<br/><br/>
		<b>订单状态:</b><em></em>
		<br/><br/>
        <div style="text-align:center;padding:5px 0">
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width:80px">发货</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" style="width:80px">拒绝订单</a>
             <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" style="width:80px">关闭</a>
        </div>
	</div>
    
    
</body>
</html>