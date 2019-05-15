<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>待处理订单</title>
        <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/default/easyui.css">
        <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/icon.css">
        <script type="text/javascript" src="https://www.jeasyui.com/easyui/jquery.min.js"></script>
        <script type="text/javascript" src="https://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
        <script type="text/javascript" src="https://www.jeasyui.com/easyui/datagrid-detailview.js"></script>
    </head>
    <body>
       	<table class="easyui-datagrid" title="DataGrid Complex Toolbar" style="width:700px;height:250px"
			data-options="rownumbers:true,singleSelect:true,url:'datagrid_data1.json',method:'get',toolbar:'#tb',fit:'true'">
		<thead>
			<tr>
			<th data-options="field:'status',width:60,align:'center'">退货单号</th>
				<th data-options="field:'itemid',width:80">订单编号</th>
				<th data-options="field:'productid',width:100">商品名</th>
				<th data-options="field:'listprice',width:80,align:'right'">买家</th>
				<th data-options="field:'unitcost',width:80,align:'right'">联系方式</th>
				<th data-options="field:'attr1',width:240">处理状态</th>
			</tr>
		</thead>
	</table>
	<div id="tb" style="padding:5px;height:auto">
		<div style="margin-bottom:5px">
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit"   plain="true">处理</a>
		</div>
		<div>
			从: <input class="easyui-datebox" style="width:80px">
			到: <input class="easyui-datebox" style="width:80px">
			状态: 
			<select class="easyui-combobox" panelHeight="auto" style="width:100px">
				<option value="java">待处理</option>
				<option value="c">处理中</option>
			</select>
			<a href="#" class="easyui-linkbutton" iconCls="icon-search">搜索</a>
		</div>
	</div>
        
        
    <!-- 模态窗口 -->    
    	<div id="w" class="easyui-window" title="Modal Window" data-options="modal:true,closed:false,iconCls:'icon-save'" style="width:300px;height:600px;padding:10px;">
		<b>订单编号:</b><em></em><br/><br/>
		<b>订单金额:</b><em></em><br/><br/>
		<b>退货原因:</b><br/>
		<!-- 设置为了只读 -->
		<textarea rows="10" cols="27"  readonly="readonly" ></textarea>
		
		
		<div style="width:50%;height:50px;folat:left;" >
			<img alt="用户图片"  src="" width=70px height=50px>
		</div>
		<div style="width:50%;height:50px;folat:left;">
			<img alt="用户图片"  src="" width=70px height=50px>
		</div>
		<div style="width:50%;height:50px;folat:left;">
			<img alt="用户图片"  src="" width=70px height=50px>
		</div>
		<div style="width:50%;height:50px;folat:left;">
			<img alt="用户图片"  src="" width=70px height=50px>
		</div>
			
		<div style="text-align:center;padding:5px 0">
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width:80px">同意售后</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" style="width:80px">拒绝售后</a>
             <a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#w').window('close')" style="width:80px">关闭</a>
        </div>
		</div>
        
    </body>
    </html>