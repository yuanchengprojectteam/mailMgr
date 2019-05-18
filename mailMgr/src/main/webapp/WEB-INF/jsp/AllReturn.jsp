<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/default/easyui.css">
        <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/icon.css">
        <script type="text/javascript" src="https://www.jeasyui.com/easyui/jquery.min.js"></script>
        <script type="text/javascript" src="https://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
        <script type="text/javascript" src="https://www.jeasyui.com/easyui/datagrid-detailview.js"></script>
        
        <script type="text/javascript">
        	
        	function query1(){
        		$('#dg').datagrid('load',{
    				startdate:$("#startdate").textbox('getValue'),
    				enddate:$("#enddate").textbox('getValue'),
    				statu:$("#statu").textbox('getValue'),
    				sid:'${param.sid}',
    			});
        	}
        	function see(){
        		var row= $('#dg').datagrid('getSelected');
            	if(row == null){
            		alert("请选择要查看的记录！");
            		return;
            	}
        		$('#fm').form('load',row);
    			$('#p').attr('src',row.img);
    			$('#w').window('open');
        	}
        	
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
        	
        </script>
</head>
<body>
	<table id="dg" class="easyui-datagrid" title="DataGrid Complex Toolbar" style="width:700px;height:250px"
			data-options="rownumbers:true,
			singleSelect:true,
			url:'query1?sid=${param.sid }',
			method:'post',
			toolbar:'#tb',
			pagination:'true',
			fit:'true'">
		<thead>
			<tr>
				<th data-options="field:'rid',width:100">售后编号</th>
				<th data-options="field:'oid',width:100">订单编号</th>
				<th data-options="field:'price',width:100,align:'left'">订单金额</th>
				<th data-options="field:'statu',width:100,align:'left'">售后状态</th>
				<th data-options="field:'uname',width:100">买家</th>
				<th data-options="field:'phone',width:240,align:'left'">买家电话</th>
			</tr>
		</thead>
	</table>
	<div id="tb" style="padding:5px;height:auto">
		<div style="margin-bottom:5px">
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" onclick="see()"   plain="true">查看</a>
		</div>
		<div>
			从: <input id="startdate" class="easyui-datebox" style="width:80px">
			到: <input id="enddate" class="easyui-datebox" style="width:80px">
			订单状态: 
			<select id="statu" class="easyui-combobox" panelHeight="auto" style="width:100px">
				<option value="已完成" >已完成</option>
				<option value="所有">所有</option>
				<option value="处理中">处理中</option>
				<option value="待处理">待处理</option>
				
			</select>
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="query1()" >查询</a>
		</div>
	</div>
	
	<div id="w" class="easyui-window" title="Modal Window" data-options="modal:false,closed:true,iconCls:'icon-save'" style="width:300px;height:600px;padding:10px;">
		<div style="width:300px;height:400px;padding:10px;">
		<form id="fm" method="post" action="">
			<input type="hidden" name="rid"/>
			<b>订单编号:</b><input class="easyui-textbox" name="oid" disabled="disabled" /><br/><br/>
			<b>订单金额:</b><input class="easyui-textbox" name="price"  disabled="disabled"/><br/><br/>
			<b>退货原因:</b><br/> 
			<!-- 设置为了只读 -->
			<textarea rows="10" cols="27"  readonly="readonly"  name="reason"></textarea>
			
			
			<div style="width:75%;height:100px;folat:left;" >
				<img   src=img width="75%" height=100px id="p" >
			</div>
			<b>状态</b><input class="easyui-textbox" name="statu" disabled="disabled" />
		</form>	
		</div>
		
		</div>
</body>
</html>