<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        
        <script type="text/javascript">
        	
        	function query(){
        		$('#dg').datagrid('load',{
    				startdate:$("#startdate").textbox('getValue'),
    				enddate:$("#enddate").textbox('getValue'),
    				statu:$("#statu").textbox('getValue'),
    				sid:'${param.sid}',
    			});
        	}
        	function edit(){
    			var row= $('#dg').datagrid('getSelected');
    			if(row == null){
    				alert("请选择要修改的记录！");
    				return;
    			}
    			if(row.statu == '处理中' || row.statu=='已完成'){
    				alert("不能处理正在处理中的订单");
    				return;
    			}
    			//将行对象的值填写到表单中
    			$('#fm').form('load',row);
    			$('#p').attr('src',row.img);
    			$('#w').window('open');
    		}
        	function confirm(){
    			var row= $('#dg').datagrid('getSelected');
    			if(row == null){
    				alert("请选择要确认的记录！");
    				return;
    			}
    			if(row.statu=='待处理'){
    				alert("不能确认还未处理的订单");
    				return;
    			}
    			if(row.statu=='已完成'){
    				alert("该订单已确认处理完成");
    				return;
    			}
    			//将行对象的值填写到表单中
    			$('#fo').form('load',row);
    			$('#pi').attr('src',row.img);
    			$('#ww').window('open');
    		}
        	function  deal(){
    			$('#fm').form('submit',{
    				success:function(data){
    					$('#w').window('close');
    					$('#dg').datagrid('reload');
    				}
    			});
    		}
        	function  deal1(){
    			$('#fo').form('submit',{
    				success:function(data){
    					$('#ww').window('close');
    					$('#dg').datagrid('reload');
    				}
    			});
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
			url:'query?sid=${param.sid }',
			method:'post',
			toolbar:'#tb',
			pagination:'true',
			fit:'true'">
		<thead>
			<tr>
			<th data-options="field:'rid',width:60,align:'center'">退货单号</th>
				<th data-options="field:'oid',width:80">订单编号</th>
				<th data-options="field:'gname',width:100">商品名</th>
				<th data-options="field:'uname',width:80,align:'right'">买家</th>
				<th data-options="field:'phone',width:80,align:'right'">联系方式</th>
				<th data-options="field:'statu',width:240">处理状态</th>
			</tr>
		</thead>
	</table>
	<div id="tb" style="padding:5px;height:auto">
		<div style="margin-bottom:5px">
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" onclick="edit()"   plain="true">处理</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" onclick="confirm()"   plain="true">确认完成</a>
		</div>
		<div>
			从: <input id="startdate"  class="easyui-datebox" style="width:80px">
			到: <input id="enddate" class="easyui-datebox" style="width:80px">
			状态: 
			<select id="statu" class="easyui-combobox" panelHeight="auto" style="width:100px">
				<option value="待处理" >待处理</option>
				<option value="处理中">处理中</option>
			</select>
			<a href="#" onclick="query()" class="easyui-linkbutton" iconCls="icon-search">搜索</a>
		</div>
	</div>
        
        
    <!-- 模态窗口 -->    
    	<div id="w" class="easyui-window" title="Modal Window" data-options="modal:false,closed:true,iconCls:'icon-save'" style="width:300px;height:550px;padding:10px;">
		<div style="width:300px;height:400px;padding:10px;">
		<form id="fm" method="post" action="deal">
			<input type="hidden" name="rid"/>
			<b>订单编号:</b><input class="easyui-textbox" name="oid" disabled="disabled" /><br/><br/>
			<b>订单金额:</b><input class="easyui-textbox" name="price"  disabled="disabled"/><br/><br/>
			<b>退货原因:</b><br/> 
			<!-- 设置为了只读 -->
			<textarea rows="10" cols="27"  readonly="readonly"  name="reason"></textarea>
			
			
			<div style="width:75%;height:100px;folat:left;" >
				<img   src=img width="75%" height=100px id="p" >
			</div>
		</form>	
		</div>
		<div style="text-align:center;padding:5px 0">
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="deal()" style="width:80px">同意售后</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" style="width:80px">拒绝售后</a>
             <a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#w').window('close')" style="width:80px">关闭</a>
        </div>
		</div>
        
        <div id="ww" class="easyui-window" title="Modal Window" data-options="modal:false,closed:true,iconCls:'icon-save'" style="width:300px;height:550px;padding:10px;">
		<div style="width:300px;height:400px;padding:10px;">
		<form id="fo" method="post" action="deal1">
			<input type="hidden" name="rid"/>
			<b>订单编号:</b><input class="easyui-textbox" name="oid" disabled="disabled" /><br/><br/>
			<b>订单金额:</b><input class="easyui-textbox" name="price"  disabled="disabled"/><br/><br/>
			<b>退货原因:</b><br/> 
			<!-- 设置为了只读 -->
			<textarea rows="10" cols="27"  readonly="readonly"  name="reason"></textarea>
			
			
			<div style="width:75%;height:100px;folat:left;" >
				<img   src=img width="75%" height=100px id="pi" >
			</div>
		</form>	
		</div>
		<div style="text-align:center;padding:5px 0">
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="deal1()" style="width:80px">确认完成</a>
             <a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#ww').window('close')" style="width:80px">关闭</a>
        </div>
		</div>
        
    </body>
    </html>